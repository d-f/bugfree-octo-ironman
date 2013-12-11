/** Initializes the map widget. */

var receiver    = new DataReceiver ();
var dataManager = new DataManager (receiver);
var mapControl  = new MapControl (receiver, "53.554/10.004", 12, dataManager);
var catSelect   = new CategorySelection ("selection_category", receiver);
var slider      = new TimeSlider ("selection_timerange", 0, 0);


// The selection widgets are also publishers. Subscribe the receiver to them ...
catSelect.subscribe (receiver.selectionChanged);
slider.subscribe    (receiver.timeIntervalChanged);
