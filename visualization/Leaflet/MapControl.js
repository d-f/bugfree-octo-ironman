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