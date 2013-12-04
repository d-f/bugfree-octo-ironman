/** This class listens for new posts and creates the map markers and category entries.
 * @param receiver Middleware object, it sends us posts and receives our updates. */
function DataManager (receiver) {

  var data   = [];  // Data structure for post management.
  var layers = {};  // Associative array for category to layer group matching.

  // Subscribes to the new post event.
  receiver.subscribe_NewPosts (function (data) {
    for (var i = 0; i < data.length; i ++) newPost (data[i]);
  });

  // Subscription for the interval change event. Clears all data and categories.
  receiver.subscribe_IntervalChange (function (maximum) {
    for (var category in layers) {
      layers [category].clearLayers ();
      receiver.categoryChanged ({'catName' : category,
                                 'counter' : 0});
    }
    data   = [];    // Deletes the old array to free the unneeded markers.
  });



  /** Creates a new post.
   * @param post A JSON object with the post data. */
  function newPost (post) {

    // Determine the category. If it wasn't seen before, create a layer.
    var category = post['category_name'];
    //if (category == "trashtalk") return;    // Rücksprung bei Müll-Einträgen.
    if (layers [category] == null) {
      console.log ("[DataManager] Creating layer group for category '"+category+"'.");
      layers [category] = L.layerGroup ();
    }


    // A map cannot handle posts with no coordinates. Should be pretty obvious... ;-)
    if (post['geolocation'] != null) {

      // Reads the position from the JSON object.
      var lat = post['geolocation']['latitude'];
      var lng = post['geolocation']['longitude'];

      // Select the marker icon for that category.
      var icon;
      switch (category) {
        case "information_offer"  : icon = icon_information; break;
        case "information_request": icon = icon_request;     break;
        case "help_request"       : icon = icon_help;        break;
        default                   : icon = icon_other;       break;
      }

      // Create the marker and add it to the corresponding layer group.
      var marker = L.marker ([lat, lng], {'icon' : icon});
      layers [category].addLayer (marker);
      data.push ({'date'    : post['timestamp'],
                  'category': category,
                  'marker'  : marker });

      // Notifies the receiver of a category update.
      receiver.categoryChanged ({'catName' : category,
                                 'counter' : layers[category].getLayers().length });


      // Convert the SQL timestamp to a more readable (= German) format.
      var dtArr = post['timestamp'].split ("T");
      var dArr  = dtArr[0].split ("-");
      var tArr  = dtArr[1].substring(0, 8).split (":");
      var date  = dArr[2]+"."+dArr[1]+"."+dArr[0]+" "+tArr[0]+":"+tArr[1]+":"+tArr[2];

      // Also format the position. The user probably doesn't want 8 decimal places ...
      var accuracy = 4;
      var overlength_lat = lat.length - lat.indexOf (".") - 1 - accuracy;
      var overlength_lng = lng.length - lng.indexOf (".") - 1 - accuracy;
      if (overlength_lat > 0) lat = lat.substring (0, lat.length - overlength_lat);
      if (overlength_lng > 0) lng = lng.substring (0, lng.length - overlength_lng);
      var position = "lat: &nbsp;"+lat+",<br />lng: "+lng;


      // Create the tooltip information and bind it to the marker.
      marker.bindPopup (
        "<table class='map_popup'>                                           "+
        "  <tr><td><b>Category:   </b></td><td>"+category      +"</td></tr>  "+
        "  <tr><td><b>Date:       </b></td><td>"+date          +"</td></tr>  "+
        "  <tr><td><b>Author:     </b></td><td>"+post['author']+"</td></tr>  "+
        "  <tr><td><b>Message:    </b></td><td>"+post['text']  +"</td></tr>  "+
        "  <tr><td><b>Coordinates:</b></td><td>"+position      +"</td></tr>  "+
        "</table>                                                            "
      );

      // Console output for debug reasons.
      position = lat+" | "+lng;
      console.log ("[DataManager] Added map entry:"             +"\n"+
                   "               - Category: "+ category      +"\n"+
                   "               - Date    : "+ date          +"\n"+
                   "               - Position: "+ position      +"\n"+
                   "               - Author  : "+ post['author']+"\n"+
                   "               - Message : "+ post['text']       );
    }
  }



  /** Returns a layer group reference for a requested category. */
  this.getLayer = function (layername) {
    return layers[layername];
  }
}

