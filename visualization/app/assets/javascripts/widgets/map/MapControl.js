/** Map object control. Creates the map and shows/hides the layer groups.
 * @param receiver The middleware to receive data from and send data to.
 * @param $center The map's center coordinate, format is "lat/long".
 * @param $zoom The initial zoom level.
 * @param dataManager Reference at the data manager object for layer requests. */
function MapControl (receiver, $center, $zoom, dataManager) {
  
  var lat = $center.split ("/")[0];
  var lng = $center.split ("/")[1];
  var map = L.map ('map', {
    center : new L.LatLng (lat, lng),
    zoom   : $zoom, 
    layers : L.tileLayer ('http://{s}.tile.osm.org/{z}/{x}/{y}.png'),
  });
   
  receiver.subscribe_SelectionChange (displayLayer);
  

  
  /** Shows or hides a layer group.
   * @param layername The layer's name (string).
   * @param enabled Boolean, tells us whether the layer shall be displayed or not. */
  function displayLayer (layername, enabled) {
    var layer = dataManager.getLayer (layername);
    if (layer != null) {
      if (enabled) map.addLayer (layer);
      else         map.removeLayer (layer); 
    }     
  }
}




/* Custom Marker Definitions                                                   */
/*******************************************************************************/  
  
var CatIcon = L.Icon.extend ({
      options: {
        iconSize:     [25, 41],
        iconAnchor:   [12, 41],
        popupAnchor:  [0, -42],
        shadowUrl:    "/assets/leaflet/marker-shadow.png",       
        shadowSize:   [41, 41],
        shadowAnchor: [14, 38],
      }
});

var icon_help        = new CatIcon ({iconUrl: '/assets/marker-help.png'       });
var icon_information = new CatIcon ({iconUrl: '/assets/marker-information.png'});
var icon_request     = new CatIcon ({iconUrl: '/assets/marker-request.png'    });
var icon_other       = new CatIcon ({iconUrl: '/assets/marker-icon.png'       });

