/** A category selection element that notifies its listeners on selection change.
 * @param container ID of HTML container to use.
 * @param receiver The middleware to receive data from and send data to. */
function CategorySelection (container, receiver) {

  var subscribers = new Array ();  // Stores the attached listeners.
  var comboboxes  = new Array ();  // Array with available check boxes.


  /** Erzeugt die Auswahlobjekte und deren Beobachter. */
  function constr (selfRef) { 
 
    // Lädt die Kategorien und erstellt die Auswahlbox-Strukturen dafür.
    //var data = dataManager.registerAndLoad (selfRef);    // ???     
    var data = [{"name":"support_offer"    , "counter":12},
                {"name":"information_offer", "counter":26},
                {"name":"trashtalk"        , "counter":54}];

    
    
    
    for (var i = 0; i < data.length; i ++) {
      comboboxes[data[i]['name']] = {
        "category" : data[i]['name'],
        "counter"  : data[i]['counter'],
        "checked"  : false,           
        "update"   : function ($cnt) {
          this.counter = $cnt;
          document.getElementById('badge-'+this.category).innerHTML = $cnt;            
        },
      };    
    }
    
    
    // Creates the HTML code for the category check boxes and inserts them.
    var htmlcode = "<div id='comboboxes'>  <h4>Categories:</h4>";  
    for (var i in comboboxes) {
      var cat   = comboboxes[i]['category'];
      var count = comboboxes[i]['counter'];
      htmlcode += 
        "  <div class='input-group'>                                              "+
        "    <span class='input-group-addon'>                                     "+
        "      <input type='checkbox' name='cbs' value='"+cat+"' id='cb-"+cat+"'/>"+
        "    </span>                                                              "+
        "    <li class='list-group-item'>                                         "+
        "      <span class='badge' id='badge-"+cat+"'>"+count+"</span>"+cat+"     "+
        "    </li>                                                                "+ 
        "  </div>                                                                 "+
        "</div>                                                                   ";     
    }   
    document.getElementById(container).innerHTML = htmlcode;
   
   
    // Die Auswahl-Listener für die Kategorien setzen.
    for (var i in comboboxes) {
      document.getElementById("cb-"+comboboxes[i]['category']).onclick = function() {      
        notifyListeners (this.value, this.checked);
      };
    }
  }; constr (this);
  
  
  
  /** Registers a new listener for event callbacks.
   * @param callback The callback function to be executed. */
  this.registerCallback = function (callback) {
    subscribers.push (callback);
  }
  
  
  /** Notifies all attached listeners of a new event.
   * @param event Some data to be transmitted for client processing. */
  function notifyListeners (checkbox_id, checked) {
    comboboxes[checkbox_id]["checked"] = checked;
    
    alert (comboboxes[checkbox_id]["checked"]);
  
    var category_states = [
      { "changed"    : comboboxes[checkbox_id]["name"] }, 
      { "checkboxes" : boxarray}   
   ];
  
    for (var i = 0; i < subscribers.length;  i ++) subscribers[i] (statelist);
  }
  
  
  /** Ändert den Zählerwert für eine Kategorie.
   * @param $category Der Name der zu ändernden Kategorie.
   * @param $counter Der neue Zählerwert. */
  this.catCounterChanged = function ($category, $counter) { 
    comboboxes[$category].update ($counter);  
  }
}
