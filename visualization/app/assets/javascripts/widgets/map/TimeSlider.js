/** Slider that allows to set a time range by selecting minimum and maximum offset.
 * @param container ID of HTML container to use.
 * @param initialMin Minimum value for slider initialization.
 * @param initialMax Initial maximum value. */
function TimeSlider (container, initialMin, initialMax) {
    
  // HTML insertion of headline and slider div in supplied container.
  var htmlcode = "<div class='layout-slider'>                           "+
                 "  <input id='Slider' type='slider' name='area' value='"+
                     initialMin+";"+initialMax+"' />                    "+
                 "</div>                                                ";   
  document.getElementById(container).innerHTML = htmlcode;  
    
    
  // Creates the slider and places it in the previous built div.
  jQuery("#Slider").slider ({
    from         : 0,
    to           : 10,
    //heterogeneity: ['100/1'],
    scale        : ['now', '10min'],
    limits       : false,
    smooth       : false,
    step         : 1, 
    dimension    : '&nbsp;min', 
    skin         : "round_plastic",
    callback     : function (valueStr) {notifyListeners (valueStr);}  
  });        




  /* Subscribe and Callback Functions                                      */
  /*************************************************************************/ 

  var subscribers = new Array ();  // Stores the attached listeners.
  
  
  /** Registers a new listener for event callbacks.
   * @param callback The callback function to be executed. */
  this.subscribe = function (callback) {
    subscribers.push (callback);
  }
  
  
  /** Notifies all attached listeners of a time range selection change.
   * @param valueStr The new interval selection. */
  function notifyListeners (valueStr) {
   var values = valueStr.split (";");
   var event = {
     "minimum" : values[0],
     "maximum" : values[1],
   };    
   for (var i = 0; i < subscribers.length;  i ++) subscribers[i] (event);
  }  
}
