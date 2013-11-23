/** Steuerung für das Kartenelement. Erstellt eine Karte und steuert die Layer-Einblendungen.
 * @param $center Der Zentrierpunkt der Karte im Format "Lat/Long".
 * @param $zoom Die anfängliche Vergrößerungsstufe.
 * @param $dataManager Verweis auf die Datenverwaltung zur Abfrage der Ebenen. */
function MapControl ($center, $zoom, $dataManager) {

  var dataManager = $dataManager;      // Verweis auf die Daten-Verwaltung.
  var map;                             // Das verwendete Kartenobjekt.


  /** Erzeugt eine neue Kartenanzeige. */
  function constr () {
    var lat = $center.split ("/")[0];
    var lng = $center.split ("/")[1];
    map = L.map ('map', {
      center : new L.LatLng (lat, lng),
      zoom   : $zoom, 
      layers : L.tileLayer ('http://{s}.tile.osm.org/{z}/{x}/{y}.png'),
    });
  }; constr();

  
  /** Blendet einen angegebenen Layer ein- oder aus. 
   * @param layername Der Name des Layers (String).
   * @param enabled Ein Wahrheitswert, der die Anzeige steuert. */
  this.setLayer = function (layername, enabled) {
    var layer = dataManager.getLayer (layername);
    if (layer != null) {
      if (enabled) map.addLayer (layer);
      else         map.removeLayer (layer); 
    }     
  }
}



// Hinweis: Hier folgen die Icondefinitionen, die in der DataManager-Klasse zugewiesen werden!


//TODO Noch nicht eingestellt, geplant sind außerdem eigene "Pins"!
var myIcon = L.icon({
    iconUrl:      '/assets/icon-help.png',
    //shadowUrl:    './plugins/Leaflet 0.64/images/marker-shadow.png',
    //iconSize:     [38, 95], // size of the icon
    shadowSize:   [50, 64], // size of the shadow
    //iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
    shadowAnchor: [-10, 25],  // the same for the shadow
    //popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
});
