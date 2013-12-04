/** A category selection element that notifies its listeners on selection change.
 * @param container ID of HTML container to use.
 * @param receiver The middleware to receive data from and send data to. */
function CategorySelection (container, receiver) {

  var comboboxes  = new Array ();  // Array with available check boxes.

  // Builds the HTML checkbox div and registers for the category data change event.
  document.getElementById(container).innerHTML = "<div id='comboboxes'></div>";
  receiver.subscribe_CategoryChange (updateCategories);
  
  
  
  /** This function handles the creation and update of the category entries.
   * @param catUpdate A JSON object containing the category's name and its counter. */
  function updateCategories (catUpdate) {
    var category = catUpdate ['category'];
    var counter  = catUpdate ['counter'];    

  
    // If the category doesn't exist, create it!
    if (comboboxes[category] == null) {     
      
      // First of all, we create the HTML checkbox and insert it in the DOM.
      var html = 
        "<span class='input-group-addon'>                                          "+
        "  <input type='checkbox' name='cbs' value='"+category+"'                  "+
        "   id='cb-"+category+"' checked='checked'/>                               "+
        "</span>                                                                   "+
        "<li class='list-group-item'>                                              "+
        "  <span class='badge' id='badge-"+category+"'>"+counter+"</span>"+category +
        "</li>                                                                     ";        
      //TODO Maybe we should also add the category icon or some sort function.   
      var newEntry = document.createElement ("div");
      newEntry.innerHTML = html; 
      newEntry.className = "input-group"; 
      document.getElementById("comboboxes").appendChild (newEntry);

      // After that, we make an entry in our javascript structure.
      comboboxes[category] = {
        "category" : category,
        "counter"  : counter,
        "checked"  : false,
        "division" : newEntry,          
        "update"   : function ($cnt) {
          this.counter = $cnt;
          document.getElementById('badge-'+this.category).innerHTML = $cnt;            
        },
      };              
      
      // Then we link the HTML onclick handler to our notify function.
      document.getElementById("cb-"+category).onclick = function() {      
        notifyListeners (this.value, this.checked);
      };         
      
      // Check the checkbox per default. Ugly timeout needed. Don't ask, why ...
      setTimeout (function () {notifyListeners (category, true);}, 100);
 
    }

    
    // Otherwise, we have to change its counter (or delete it, if zero).  
    else {
      if (counter != 0) comboboxes[category].update (counter);
      else {
        var div = comboboxes[category]['division'];
        document.getElementById("comboboxes").removeChild (div);
        comboboxes[category] = null;
      }
    }
  }




  /* Subscribe and Callback Functions                                      */
  /*************************************************************************/  
  
  var subscribers = new Array ();  // Stores the attached listeners.
  
  
  /** Registers a new listener for event callbacks.
   * @param callback The callback function to be executed. */
  this.subscribe = function (callback) {
    subscribers.push (callback);
  }
  
  
  /** Notifies all attached listeners of a new event.
   * @param event Some data to be transmitted for client processing. */
  function notifyListeners (checkbox_id, checked) {
    comboboxes[checkbox_id]["checked"] = checked;

    // Creates an array of JSON object of all boxes.
    var boxarray = new Object ();
    for (var id in comboboxes) {
      boxarray [id] = {"state"   : comboboxes[id]["checked"],
                       "counter" : comboboxes[id]["counter"]};
    }
  
    // Return result array, contains name of changed box and complete box list. 
    var statelist = {"changed"    : checkbox_id, 
                     "checkboxes" : boxarray    };
  
    for (var i = 0; i < subscribers.length;  i ++) subscribers[i] (statelist);
  }
}
