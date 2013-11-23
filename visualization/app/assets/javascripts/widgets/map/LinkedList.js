function LinkedList ($listID) {

  var listID = $listID;        // Der Name der Liste (optional).
  var headLE = null;           // Zeiger auf das erste Element.
  var tailLE = null;           // Das letzte Element der Liste.
  var itemMap = new Object (); // Zuordnung Schlüssel -> Listenelement.  
  var aiEnabled = true;        // Steuert die Verfügbarkeit vom automatischen Einfügen. 
  var self = this;
  
  
  /** Erzeugt ein neues Listenelement. 
   * @param $key Der Sortierschlüssel zur Einordnung des Elementes.
   * @param $data Das Datenobjekt, welches einzufügen ist.
   * @param $autoInsert Gibt an, ob das Element automatisch eingefügt werden soll.
   * @return Referenz auf das Element (nur wenn $autoInsert=false). */
  this.createElement = function ($key, $data, $autoInsert) {  
    var element = new ListElement ($key, $data); // Listenelement erzeugen.
    itemMap [$key] = element;                    // In die Zugriffstabelle eintragen. 
    
    if ($autoInsert) {
      if (aiEnabled) {
        autoInsertElement ($key);
        return true; 
      }
      else return false;
    }
    else return element;
  }  
  
  
  
  /** Fügt ein Element in die automatisch sortierte Liste ein.
   * ACHTUNG: Bisher sehr primitive und inperformante Vorwärts-Iteration !!   
   * @param $key Der Schlüssel des einzufügenden Elementes. */
  function autoInsertElement ($key) {
    if (headLE == null) insertElement ($key, "HEAD");
    else {
      var currentLE = headLE;
      while (currentLE.key < $key) {
        currentLE = currentLE.nextLE;
        if (currentLE == null) {
          insertElement ($key, "TAIL");
          return;
        }
      }
      insertElement ($key, "BEFORE", currentLE.key);
    }  
  }
  


  /** Löscht ein Element aus der Liste.
   * @param $key Der Schlüssel des zu löschenden Elementes. */
  this.deleteElement = function ($key) {   
    //alert ("Aufruf von deleteElement für "+$key);   
    var element = itemMap [$key];
    if (element == null) return;
    delete itemMap [$key];
    detachElement (element);
  }
  
  
  
  /** [Privat]: Löst ein Element aus der Listenstruktur heraus.
   * @param element Das zu lösende Listenelement. */
  function detachElement (element) {
    if (element.prevLE != null && element.nextLE != null) {
      element.prevLE.nextLE = element.nextLE;
      element.nextLE.prevLE = element.prevLE;
    }        
    else if (element.prevLE == null && element.nextLE != null) {
      element.nextLE.prevLE = null;
      headLE = element.nextLE;
    }    
    else if (element.prevLE != null && element.nextLE == null) {
      element.prevLE.nextLE = null;
      tailLE = element.prevLE;
    }    
    else {
      headLE = null;
      tailLE = null;
    }   
    element.prevLE = null;
    element.nextLE = null;
    element.inserted = false;
  }
  
  
  
  /** Fügt ein neues (aber schon existierendes) Element in die Liste ein.
   * @param $newElement Der Schlüssel des neu einzufügenden Elementes.
   * @param $position Einfügeposition: "HEAD" / "TAIL" / "BEFORE" / "AFTER"
   * @param $existingElement Schlüssel auf Referenzelement, bei BEFORE/AFTER nötig. */
  function insertElement ($newElement, $position, $existingElement) {
    //alert ("[insertElement]  "+$newElement+" - "+$position+" - "+$existingElement);
    
    $position = $position.toUpperCase ();
    var newLE  = itemMap [$newElement];
    var exstLE = itemMap [$existingElement]; 
    if (newLE == null) return;
    
    // Prüfen, ob Element schon eingefügt ist. Weil dann muß es erstmal weg ...
    if (newLE.inserted) detachElement (newLE);
    
    // Einfügen an oberster Position. HEAD-Zeiger neu setzen, ggf. Vorgänger anpassen.
    if ($position == "HEAD") {  
      var oldHead = headLE;
      headLE = newLE;
      headLE.nextLE = oldHead;
      newLE.inserted = true;
      if (oldHead != null) oldHead.prevLE = headLE;
      else                         tailLE = headLE;
    }
    
    // An das unterste Element anhängen. TAIL-Zeiger und ggf. Vorgänger ändern.
    else if ($position == "TAIL") {
      var oldTail = tailLE;
      tailLE = newLE;
      tailLE.prevLE = oldTail;
      newLE.inserted = true;
      if (oldTail != null) oldTail.nextLE = tailLE;
      else                         headLE = tailLE;
    }
    
    // Vor einem Element einfügen. Falls ganz vorne, Rekursion, sonst Zeiger anpassen.
    else if ($position == "BEFORE") {
      if (exstLE == null) return;
      if (exstLE == headLE) insertElement($newElement, "HEAD");
      else {
        exstLE.prevLE.nextLE = newLE;
        newLE.prevLE = exstLE.prevLE;
        newLE.nextLE = exstLE;        
        exstLE.prevLE = newLE;    
        newLE.inserted = true;    
      }
    }
    
    // Hinter einem Element einfügen. Sicherheitscheck auf TAIL, sonst Zeiger umbiegen.
    else if ($position == "AFTER") {
      if (exstLE == null) return;
      if (exstLE == tailLE) insertElement($newElement, "TAIL");
      else {
        exstLE.nextLE.prevLE = newLE;
        newLE.prevLE = exstLE;
        newLE.nextLE = exstLE.nextLE;        
        exstLE.nextLE = newLE;     
        newLE.inserted = true;   
      }      
    }    
  }
  
  
  
  /** Funktion für den externen Aufruf. Setzt das Automatik-Flag auf falsch. */
  this.insertElement = function ($newElement, $position, $existingElement) {
    aiEnabled = false;
    insertElement ($newElement, $position, $existingElement);
  }  
  
  
  
  /** Ruft die Daten zu einem Schlüssel ab.
   * @param $key Der Schlüsselwert. Alternativ "HEAD" oder "TAIL" möglich.
   * @param $content Die Art der Anfrage: "PREV" / "NEXT" / "DATA".   
   * @return Der angeforderte Datenwert oder "null", falls er nicht existiert. */
  this.getData = function ($key, $content) { 
  
    // Lokalisiert das Element.
    var element;
    if      ($key == "HEAD") element = headLE;
    else if ($key == "TAIL") element = tailLE;
    else                     element = itemMap [$key];
    
    // Rücksprung, falls das Element nicht existiert. Sonst Daten auslesen.
    if (element  == null) return null;    
    if ($content == null) return element.data;   
    else {
      var content = $content.toUpperCase ();
      if (content == "DATA")                           return element.data;
      if (content == "PREV" && element.prevLE != null) return element.prevLE.key;
      if (content == "NEXT" && element.nextLE != null) return element.nextLE.key; 
      return null;
    }
  }
  
    
  
  /** Leert die gesamte Liste. */
  this.clearList = function () {
    var curElement = headLE;  
    while (curElement != null) {           
      this.deleteElement (curElement.key);
      curElement = curElement.nextLE; 
    }    
  }
  
  
  
  /** Schreibt die komplette Liste als HTML-Tabelle in ein DOM-Element.
   * @param $domNode Die ID des DOM-Knotens, welcher die Tabelle bekommt. */
  this.printList = function ($domNode) {
    var htmlcode = "";   
    if (listID != null) htmlcode += "<h3>Ausgabe der DVKL '"+listID+"':</h3>";

    htmlcode += "<p><b>HEAD:</b> ";
    if (headLE != null) htmlcode += headLE.key+"<br />";
    else                htmlcode += "&lt;null&gt;<br />";
    
    htmlcode += "<b>TAIL:</b> ";
    if (tailLE != null) htmlcode += tailLE.key+"</p>";
    else                htmlcode += "&lt;null&gt;</p>";    
    
    htmlcode += "<table border='1' cellspacing='0' cellpadding='4' "+
                "  style='text-align:center'>"+
                "  <tr><th>Vorgänger</th>"+
                "      <th>Schlüssel</th>"+
                "      <th>Datenwert</th>"+
                "      <th>Nachfolger</th></tr>";
    var curElement = headLE;  
    while (curElement != null) {
      htmlcode += curElement.toHTMLString ();
      curElement = curElement.nextLE;
    }
    htmlcode += "</table>";       
    document.getElementById($domNode).innerHTML = htmlcode;
  }
  
  
  
  /** Ein Listenelement der doppelt-verketteten Liste. Nur für die Liste verfügbar.
   * @param $key Schlüsselwert, dient zur Einordnung und Sortierung der Elemente. 
   * @param $data Das Datum, welches in dem Listenelement "verpackt" wird. */
  function ListElement ($key, $data) {

    this.key      = $key;  // Kriterium für Sortierung und Direktzugriff.
    this.data     = $data; // Das Datenobjekt, das von dem LE ummantelt wird.
    this.prevLE   = null;  // Verweis auf das Vorgängerelement.
    this.nextLE   = null;  // Zeiger auf den Nachfolger.
    this.inserted = false; // Gibt die Einbindung dieses Elementes an.
    
    
    /** Gibt die Eigenschaften dieses Elementes (HTML-formatiert) aus.
     * @return Eine HTML-Tabellenzeile mit Schlüssel- und Zeigerwerten. */
    this.toHTMLString = function () {      
      var code = "<tr>";                              
      if (this.prevLE != null) code += "  <td>"+this.prevLE.key+"</td>"; 
      else                     code += "  <td>&lt;null&gt;</td>";   
                               code += "  <td><b>"+this.key+"</b></td>";
      if (typeof this.data.toHTMLString == 'function') 
                               code += "<td>"+this.data.toHTMLString()+"</td>";
      else                     code += "<td> - </td>";                          
      if (this.nextLE != null) code += "  <td>"+this.nextLE.key+"</td>"; 
      else                     code += "  <td>&lt;null&gt;</td>";         
      code += "</tr>";             
      return code;
    }
  }  
}



//TODO LÖSCHEN // Testobjektstruktur.
function Agent ($codename, $country) {
  var codename = $codename;
  var country = $country;
  
  this.toHTMLString = function () {
    return codename+" : "+country;
  } 
  
  this.sayHello = function () {
    return "My name is "+codename+" and I spy for "+country+".";
  } 
}

