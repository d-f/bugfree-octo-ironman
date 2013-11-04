<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="#"> 
    <title>Leaflet.JS - Tests</title>      

    <!-- JavaScript-Bibliotheken und eigene Module laden. -->
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <script src="Leaflet 0.64/leaflet.js"></script>
    <script src="LL_Dev/LinkedList.js"></script>
    <script src="MapControl.js"></script>
    <script src="DataManager.js"></script>
    <script src="ServerConnector.js"></script>    
    <script src="SettingsListener.js"></script>
    
    <!-- Bootstrap Standardaussehen, Leaflet's CSS und Breitenbegrenzung. -->
    <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css" media="screen" />
    <link rel="stylesheet" href="Leaflet 0.64/leaflet.css" />
    <link rel="stylesheet" href="css/design.css" />
    
    <!-- Abwärtskompatibilitäten zu älteren Browsern. -->
    <!--[if lt IE 9]>
      <script src="Bootstrap/assets/js/html5shiv.js"></script>
      <script src="Bootstrap/assets/js/respond.min.js"></script>
      <link rel="stylesheet" href="Leaflet 0.64/leaflet.ie.css" />
    <![endif]-->    
    
    

  	<link rel="stylesheet" href="JSlider/css/jslider.css" type="text/css">
  	<link rel="stylesheet" href="JSlider/css/jslider.round.plastic.css" type="text/css">  
  
  	<script src="JSlider/js/jshashtable-2.1_src.js"></script>
  	<script src="JSlider/js/tmpl.js"></script>
  	<script src="JSlider/js/jquery.dependClass-0.1.js"></script>
  	<script src="JSlider/js/draggable-0.1.js"></script>
  	<script src="JSlider/js/jquery.slider.js"></script>    
    
         
  </head>
  
  <body>  
    <div class="container">
      <span style="float:right" align="right"><a href="db_fake.php">Fix DB!</a></span>
      <h1 id="tmp">Leaflet Tests</h1>
      <hr />
      
      <!-- Linke Spalte: Enthält die Kategorienauswahl und die Zeiteinstellung. -->
      <div class="col-md-3">
        <h3>Optionen</h3>
        <div id="options"></div>
        <div id="dbg_Area"></div>
      </div>
       
      <!-- Hauptspalte, besteht lediglich aus der Karte. -->  
      <div class="col-md-9">
        <h3>Übersichtskarte</h3>
        <div id="map"></div>        
        <br />
        <div id="insertArea"></div>
      </div>   
         
    </div>
  </body>
  
  <!-- Lädt die JavaScript-Komponenten und läßt so die Auswahloptionen erzeugen. -->
  <script type="text/javascript">
          
    var dataManager = new DataManager (new ServerConnector ("dbcon.php"), 1, "0-38");
    var mapControl  = new MapControl ("51.501/-0.121", 14, dataManager);
    var setListener = new SettingsListener (dataManager, mapControl);     
    setListener.fillForms ("options");  
 
  </script> 
</html>




<!--

     ALTE QUELLTEXTE / FRAGMENTE:
   
     LEAFLET-KONFIGURATION MIT LAYER-AUSWAHL
   
   
      // create a map in the "map" div, set the view to a given place and zoom
      //var map = L.map('map').setView([51.501, -0.121], 14);

      
      // add an OpenStreetMap tile layer
      var backgroundLayer = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
      });
      
      var marker1 = L.marker([51.500, -0.120]);
      var marker2 = L.marker([51.501, -0.121]);
      var marker3 = L.marker([51.502, -0.123]);
      
      var layer1 = L.layerGroup();
      layer1.addLayer (marker1);
      layer1.addLayer (marker2);

      var marker4 = L.marker([51.510, -0.115]);
      var marker5 = L.marker([51.508, -0.113]);
      var marker6 = L.marker([51.507, -0.114]);
      
      var layer2 = L.layerGroup();
      layer2.addLayer (marker4);
      
      var map = L.map ('map', {
        center: new L.LatLng (51.501, -0.121),
        zoom  : 14, 
        layers: [backgroundLayer]
      });
      
      
      var baseLayer = {
        "Minimal": backgroundLayer
      };

      var overlays = {
        "L1": layer1,
        "L2": layer2
      }; 
      
      //layer1.addTo (map);
      //layer2.addTo (map);
      var control = L.control.layers(baseLayer, overlays).addTo(map);
      
      /*
      var circle = L.circle([51.508, -0.11], 500, {
        color: 'red',
        fillColor: '#f03',
        fillOpacity: 0.5
      }).addTo(map);
      
      var polygon = L.polygon([
        [51.509, -0.08],
        [51.503, -0.06],
        [51.51, -0.047]
      ]).addTo(map);

  
      
      marker.bindPopup("<b>Hello world!</b><br>I am a popup.").openPopup();
      circle.bindPopup("I am a circle.");
      polygon.bindPopup("I am a polygon.");  
  
      var popup = L.popup()
        .setLatLng([51.503, -0.087])
        .setContent("I am a standalone popup.")
        .openOn(map); */
             

    //date2 = date2.toISOString().replace("T", " ").substring(0, 19);
    //document.getElementById("tmp").innerHTML = date;

-->