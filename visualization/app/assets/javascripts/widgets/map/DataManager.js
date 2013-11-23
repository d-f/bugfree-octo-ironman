/** Die Daten-Verwaltung speichert den Datenbestand und führt Änderungen darauf aus.
 * @param $dbCon Verweis auf die Datenbank-Verbindung zum Abruf der fehlenden Daten.
 * @param $refreshInterval Zeitspanne für das Prüfintervall.
 * @param $initialTimespan Die ausgewählte Start-Zeitspanne (Format: "15-40"). */
function DataManager (recv, $refreshInterval, $initialTimespan) {

  var data;            // Array für die Datenverwaltung.
  var layers;          // Assoziatives Array für Kategorie -> Layer-Zuordnung.  
  var selListener;     // Beobachter für Auswahländerungen.
  var oldest;          // Untere Zeitschranke für den Datumsbereich.
  var newest;          // Obere Datums-Zeitschranke.

 
  /** Erzeugt die Datenverwaltung.       
   * @param $oldest Beginn des Anzeigeintervalls (<-- Vergangenheit).
   * @param $newest Ende des Anzeigeintervalls (--> Gegenwart). */
  function constr ($oldest, $newest) {     
  
    // Erstellt eine Liste für die Markierungen und ein Layergruppen-Array. 
    data = new LinkedList ("Datenmarkierungen");
    layers = new Object ();    

    recv.registerForPosts (function (data) {   
      for (var i = 0; i < data.length; i ++) newPost (data[i]);
    }); 
   
    // Setzt das Start-Anzeigeintervall und lädt damit initial die Datenstruktur.
    oldest = $newest;     // Lädt in Durchgang 1 exakt das Startintervall.
    newest = $newest;     // Deaktiviert Durchgang 2.   
//TODO    setTimespan ($oldest, $newest);    
     
    // Führt eine periodische Überprüfung aus, um zu alte Einträge zu entfernen.  
//TODO    setInterval (function() {checkInterval (false,false)}, $refreshInterval*1000);  
  
  } constr ($initialTimespan.split("-")[1], $initialTimespan.split("-")[0]);
  
  
  
  /** Setzt die auszugebende Zeitspanne.
   * @param $oldest Die hintere Zeitschranke.
   * @param $newest Die vordere Schranke. */
  this.setTimespan = function ($oldest, $newest) {setTimespan ($oldest, $newest);}
  function setTimespan ($oldest, $newest) { 
     
    var reference = new Date ();  // Aktuelles Datum als Referenz.      
    $oldest = parseInt ($oldest); // Nötig, da die Zahl als String ankommt.
    $newest = parseInt ($newest); // (s.o.)
                 
    for (var i = 0; i < 2; i ++) {      // Durchläuft den Vorgang für beide Grenzen.
      
      var date1 = new Date (reference); // Das untere Datum für die Einschränkung.
      var date2 = new Date (reference); // Das obere Datum für die Datenbankabfrage. 
           
      // Fall 1: Wurde das Anzeigeintervall nach unten hin vergrößert?
      if (i == 0) {
        if ($oldest > oldest) {
          date1.setMinutes (reference.getMinutes()-$oldest);
          date2.setMinutes (reference.getMinutes()-oldest);    
        } else continue;           
      }
      
      // Fall 2: Vergrößerung nach oben (neuere Posts anzeigen).
      else {
        if ($newest < newest) {
          date1.setMinutes (reference.getMinutes()-newest);
          date2.setMinutes (reference.getMinutes()-$newest);
        } else continue;       
      }    
      
      // Erzeugt ein SQL-konformes Datum aus der ISO-Ausgabe (Achtung: GMT fehlt).
      date1 = date1.toISOString().substring(0, 10)+" "+date1.toLocaleTimeString();
      date2 = date2.toISOString().substring(0, 10)+" "+date2.toLocaleTimeString();
      
      // Lädt die fehlenden Posts aus der DB und fügt sie der Datenstruktur hinzu.
//TODO var posts = dbCon.getData (date1, date2);    
      //posts = JSON.parse (posts);      
      //for (var j = 0; j < posts.length; j ++) newPost (posts[j]);                      
    }  
    
    // Verschiebung merken, Grenzen übernehmen und eine Neu-Überprüfung veranlassen.    
    var lsOldest = ($oldest > oldest);
    var lsNewest = ($newest > newest);
    oldest = $oldest;
    newest = $newest;
    checkInterval (lsOldest, lsNewest); 
    onEntryChange ();   // Zur Übernahme bei Hinzufüge-Operationen.
  }


  
  /** Überprüft, ob die geladenen Daten noch den Zeitschranken genügen.
   * @param $lsOldest Gibt eine Verschiebung der Untergrenze nach hinten (links) an.
   * @param $lsNewest Verschiebung der Intervall-Obergrenze nach hinten. */
  function checkInterval ($lsOldest, $lsNewest) {
    var hasChanges = false;
    
    // Ermittelt die Datumswerte der unteren und der oberen Zeitschranke.
    var ref = new Date ();
    var min = new Date(ref);   min.setMinutes (min.getMinutes() - oldest);
    var max = new Date(ref);   max.setMinutes (max.getMinutes() - newest);        
   
    document.getElementById('dbg_Area').innerHTML = 
      "<table> "+
      "  <tr><td>Ältestes:</td><td>&nbsp;"+min.toLocaleTimeString()+"</td></tr>"+
      "  <tr><td>Neuestes:</td><td>&nbsp;"+max.toLocaleTimeString()+"</td></tr>"+
      "  <tr><td>Aktuell:</td><td>&nbsp;"+ref.toLocaleTimeString()+"</td></tr>"+
      "</table>";
      
    min = min.toISOString().substring(0, 10)+" "+min.toLocaleTimeString();
    max = max.toISOString().substring(0, 10)+" "+max.toLocaleTimeString();
      

    // Die Ältest-Grenze wurde nicht vergrößert: Prüfen, ob Elemente herausfallen.
    if (! $lsOldest) {
      var entry = data.getData ("HEAD");
      while (entry != null) {
        if (entry.date < min) {
          var nextLE = data.getData (entry.date, "NEXT");
          removeEntry (entry);
          entry = data.getData (nextLE);         
        } else break;               
      }
    }
    
    // Das Intervall wurde mit der Neuest-Grenze verkleinert. Liste von unten prüfen.
    if ($lsNewest) {
      var entry = data.getData ("TAIL");
      while (entry != null) {
        if (entry.date > max) { 
          var prevLE = data.getData (entry.date, "PREV");
          removeEntry (entry); 
          entry = data.getData (prevLE);
        } else break;               
      }      
    }  
     
    // Aktualisiert die Oberfläche bei Änderungen. 
    if (hasChanges) onEntryChange (); 
    
    
    // Innere Funktion zum Löschen eines Eintrages.
    function removeEntry (entry) {
      layers [entry.category].removeLayer (entry.marker);
      entry.marker = null;
      data.deleteElement (entry.date);
      hasChanges = true;
    } 
  }
  
  
  /** Führt Updates der Oberfläche bei Eintragsänderungen aus. */
  function onEntryChange () {
    if (selListener != null) {
      for (var category in layers)
        selListener.catCounterChanged (category, layers[category].getLayers().length);      
    }
    //data.printList ("insertArea");    // Debug-Ausgabe der DVKL.
  }
  
  
  
  /** Fügt einen neuen Post in die Datenstruktur ein.
   * @param post Ein JSON-Array mit den Daten des neuen Posts. */
  function newPost (post) {
  
    // Die Kategorie bestimmen, für neue Kategorien eine Layergruppe erstellen.
    var category = "dbg"; //post['category_name'];
    if (category == "Trashtalk") return;    // Rücksprung bei Müll.
    if (layers [category] == null) {
      console.log ("Creating category '"+category+"' layergroup!");
      layers [category] = L.layerGroup (); 
    } 
  
    //TODO Einen absolut-Zähler einführen. 
  
    // Eine Karte kümmert sich sinnvollerweise nur um Einträge mit Positionsangaben ;-) 
    if (post['geolocation'] != "null") {

      // Position bestimmen und Markierung erstellen.
      var coords = post['geolocation'].split (", ");
      coords[0] = coords[0].substring (21);
      coords[1] = coords[1].substring (10, coords[1].length-1);
      var position = coords[0]+" | "+coords[1];
      var marker = L.marker ([coords[0], coords[1]], {icon: myIcon}); 

      // Die Markierung dem Layer hinzufügen und in die Datenstruktur eintragen.
      layers [category].addLayer (marker);    
      data.createElement (post['timestamp'], {"date"    : post['timestamp'],
                                              "category": category,
                                              "marker"  : marker }, true);                      
      
      // Erstellt die Detail-Informationen und bindet sie an die Markierung.
      marker.bindPopup (
        "<table cellspacing='0'>                                                "+
        "  <tr><td><b>Kategorie:  </b></td><td>"+category         +"</td></tr>  "+
        "  <tr><td><b>Gesendet:   </b></td><td>"+post['timestamp']+"</td></tr>  "+
        "  <tr><td><b>Absender:   </b></td><td>"+post['author']   +"</td></tr>  "+
        "  <tr><td><b>Nachricht:  </b></td><td>"+post['text']     +"</td></tr>  "+
        "  <tr><td><b>Koordinaten:</b></td><td>"+position         +"</td></tr>  "+
        "</table>                                                               "
      );  
      
      // Konsolenausgabe für Debug-Zwecke.
      console.log ("[DataManager] Added map entry:"                 +"\n"+
                   "               - Category: "+ category          +"\n"+
                   "               - Date    : "+ post['timestamp'] +"\n"+
                   "               - Position: "+ position          +"\n"+
                   "               - Author  : "+ post['author']    +"\n"+
                   "               - Message : "+ post['text']          );  
    }
  }  



  /** Gibt die Referenz auf einen Layer zurück.
   * @param layername Der Bezeichner des Layers. */
  this.getLayer = function (layername) {
    return layers[layername];
  }
  
  
  
  /** Meldet einen Auswahl-Listener an und übergibt ihm die verfügbaren Kategorien.
   * @param $settingsListener Die Referenz des Listeners für spätere Änderungen.
   * @return Ein JSON-Objekt mit den Reglerwerten, Kategorien und deren Anzahlen. */
  this.registerAndLoad = function ($settingsListener) {
    selListener = $settingsListener;             
    var listing = new Array ();
    listing.push ({
      "timespan_newest" : newest,
      "timespan_oldest" : oldest,
    }); 
    for (var category in layers) {
      listing.push({
        "name"    : category,
        "counter" : layers[category].getLayers().length,
      });
    }       
    return listing;
  }
}




/* C/V BEREICH: DUMPS */

  /*
    // Den SQL-Datumsstring auftrennen und in ein JavaScript-Datumsobjekt wandeln. 
    var dtArr = post['timestamp'].split ("T");
    var dArr  = dtArr[0].split ("-");
    var tArr  = dtArr[1].substring(0, 8).split (":");   
    var date  =  new Date (dArr[0], dArr[1], dArr[2], tArr[0], tArr[1], tArr[2]);
    
    //TODO Irgendwas stimmt hier mit dem Datum noch nicht !!
    //console.log (post.timestamp);
    //console.log (date.toISOString());
    //console.log (date.toLocaleString());

      console.log ("[DataManager] RCV: "+data.id+" | "+data.author+": "+data.text+"  --> "+data.category_name);

      id:           394446832761597953,
      text:         "Die Welt geht runter! #sturm #wind #regen #chaos",
      hashtags:     ["sturm", "wind", "regen", "chaos"],
      author:       "Anna",
      retweets:     0,
      timestamp:    "1383672792",
      follower:     17,
      geolocation:  "50.41052487,8.13205296",
      place:        "Runkel, Limburg-Weilburg"
      category_id:  5,
      category_name:"Nonsense"   
  */