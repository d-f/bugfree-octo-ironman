/** Erzeugt die Konfigurationskomponenten und leitet die Einstellungen weiter.
 * @param $dataManager Die Referenz auf die Datenverwaltung.
 * @param $mapControl Verweis auf das Kartenobjekt. */
function SettingsListener ($dataManager, $mapControl) {

  var dataManager = $dataManager;  // Verweis auf die Daten-Verwaltung.
  var mapControl  = $mapControl;   // Die verwendete Karte. 
  var comboboxes  = new Array ();  // Ein Array mit den Auswahlboxen für die Layer.
  var slider_oldest;
  var slider_newest;

  /** Erzeugt die Auswahlobjekte und deren Beobachter. */
  function constr (selfRef) { 
  
    // Lädt die Kategorien und erstellt die Auswahlbox-Strukturen dafür.
    var data = dataManager.registerAndLoad (selfRef);      
    for (var i = 1; i < data.length; i ++) {
      comboboxes[data[i]['name']] = {
        "category" : data[i]['name'],
        "counter"  : data[i]['counter'],           
        "update"   : function ($cnt) {
          this.counter = $cnt;
          document.getElementById('badge-'+this.category).innerHTML = $cnt;            
        },
      };    
    }
    
    // Liest die Startpositionen für den Schieberegler aus.  
    slider_oldest = data[0]['timespan_oldest'];
    slider_newest = data[0]['timespan_newest'];     
  }; constr (this);

  
  /** Generiert HTML-Code aus den Auswahlen und fügt diesen in den DOM-Baum ein. 
   * @param domElement. Das DOM-Objekt, welches die Komponenten beinhalten soll. */
  this.fillForms = function ($domElement) {

    var htmlcode = "<div id='comboboxes'>"+
                   "<h4>Kategorien:</h4>";
   
    for (var i in comboboxes) {
      var cat   = comboboxes[i]['category'];
      var count = comboboxes[i]['counter'];
      htmlcode += 
        "<div class='input-group'>                                               "+
        "  <span class='input-group-addon'>                                      "+
        "    <input type='checkbox' name='cbs' value='"+cat+"' id='cb-"+cat+"'/> "+
        "  </span>                                                               "+
        "  <li class='list-group-item'>                                          "+
        "    <span class='badge' id='badge-"+cat+"'>"+count+"</span>"+cat+"      "+
        "  </li>                                                                 "+ 
        "</div>                                                                  ";     
    }   
    htmlcode += "</div><br />"+
                "<h4>Anzeigeintervall:</h4>"+
                "<div class='layout-slider'>"+
                "  <input id='Slider' type='slider' name='area' value='"+
                   slider_newest+";"+slider_oldest+"' />"+
                "</div>";
   
    document.getElementById($domElement).innerHTML = htmlcode;
   
    // Die Auswahl-Listener für die Kategorien setzen.
    for (var i in comboboxes) {
      document.getElementById("cb-"+comboboxes[i]['category']).onclick = function() {
        mapControl.setLayer (this.value, this.checked);
      };
    }
    
    // Erzeugt den Zeit-Schieberegler.
    jQuery("#Slider").slider ({ 
      from         : 0, 
      to           : 240, 
      heterogeneity: ['20/15', '40/30', '60/60', '80/120'],
      scale: ['jetzt', '15min', '30min', '1&nbsp;Std.', '2&nbsp;Std.', '4&nbsp;Std.'],
      limits       : false, 
      smooth       : false,
      step         : 1, 
      dimension    : '&nbsp;min', 
      skin         : "round_plastic",
      callback     : function (valueStr) { 
                       var values = valueStr.split (";");
                       dataManager.setTimespan (values[1], values[0]); 
                     } 
    });     
  }
  
  
  
  /** Ändert den Zählerwert für eine Kategorie.
   * @param $category Der Name der zu ändernden Kategorie.
   * @param $counter Der neue Zählerwert. */
  this.catCounterChanged = function ($category, $counter) { 
    comboboxes[$category].update ($counter);  
  }
}