<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="#"> 
    <title>Leaflet.JS - Tests</title>      

    <!-- JavaScript-Fremdmodule und eigene Skripte laden. -->
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="plugins/Bootstrap/js/bootstrap.min.js"></script>
    <script src="plugins/Leaflet 0.64/leaflet.js"></script>   
  	<script src="plugins/JSlider/js/jshashtable-2.1_src.js"></script>
  	<script src="plugins/JSlider/js/tmpl.js"></script>
  	<script src="plugins/JSlider/js/jquery.dependClass-0.1.js"></script>
  	<script src="plugins/JSlider/js/draggable-0.1.js"></script>
  	<script src="plugins/JSlider/js/jquery.slider.js"></script>      
    <script src="js/DataManager.js"></script>
    <script src="js/LinkedList.js"></script>
    <script src="js/MapControl.js"></script>  
    <script src="js/ServerConnector.js"></script>    
    <script src="js/SettingsListener.js"></script>
    
    <!-- CSS-Dateien der Plugins und eigenes Stylesheet laden. -->
    <link rel="stylesheet" href="plugins/Bootstrap/css/bootstrap.min.css" media="screen" />
    <link rel="stylesheet" href="plugins/Leaflet 0.64/leaflet.css" />
  	<link rel="stylesheet" href="plugins/JSlider/css/jslider.css" type="text/css">
  	<link rel="stylesheet" href="plugins/JSlider/css/jslider.round.plastic.css" type="text/css">     
    <link rel="stylesheet" href="css/design.css" />
    
    <!-- Abwärtskompatibilitäten zu älteren Browsern. -->
    <!--[if lt IE 9]>
      <script src="Bootstrap/assets/js/html5shiv.js"></script>
      <script src="Bootstrap/assets/js/respond.min.js"></script>
      <link rel="stylesheet" href="Leaflet 0.64/leaflet.ie.css" />
    <![endif]-->       
  </head>
  
  <body>  
    <div class="container">
      <span style="float:right" align="right"><a href="php/db_fake.php">Fix DB!</a></span>
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
          
    var dataManager = new DataManager (new ServerConnector ("php/dbcon.php"), 1, "0-38");
    var mapControl  = new MapControl ("51.501/-0.121", 14, dataManager);
    var setListener = new SettingsListener (dataManager, mapControl);     
    setListener.fillForms ("options");  
 
  </script> 
</html>
