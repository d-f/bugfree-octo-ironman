class Map
  constructor: (containerSelector) ->
    @container = $(containerSelector)
    @width = @container.width()
    @container.height(500);

    lat = 53.5348
    lng = 10.0648
    @map = L.map @container.get(0),
      center: L.latLng(lat, lng),
      zoom: 11,
      layers: L.tileLayer 'http://{s}.tile.osm.org/{z}/{x}/{y}.png'

window.map = new Map("#map")