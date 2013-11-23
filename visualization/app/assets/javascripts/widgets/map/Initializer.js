/** Initialisiert die Karte. */

var receiver = new DataReceiver ();
var dataManager = new DataManager (receiver, 1, "0-38");
var mapControl  = new MapControl ("53.548/10.004", 12, dataManager);

//var setListener = new SettingsListener (dataManager, mapControl);     
//setListener.fillForms ("options"); 

setTimeout (function() {
  console.log ("[Initializer] Setting debug category 'dbg' as active layer!");
  mapControl.setLayer ("dbg", "true");
}, 3*1000); 
