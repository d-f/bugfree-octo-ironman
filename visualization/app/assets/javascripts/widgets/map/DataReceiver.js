/** Middleware layer for the Leaflet map widget. Decouples map logic 
 *  from the communication (=> Websockets, MySQL, ...). */
function DataReceiver () {

  // var dispatcher = new WebSocketRails ("localhost:3001/websocket");
  var sbsc_newpost = new Array ();
  
  
  
  /** Subscribes at the Rails websocket dispatcher and distributes the 
   *  callback events among the clients. */
  dispatcher.subscribe("tweets").bind ("new", function (data) {
    for (var i = 0; i < sbsc_newpost.length; i ++) sbsc_newpost[i] (data);
  });
  

  
  this.getCategories = function () {

    var categories = new Array ();
    dispatcher.trigger ('categories.get', {}, function (cats) {
      
      //for (var i = 0; i < cats.length; i ++) {
        //for (var cat in cats) alert (cat['name']);
        //cats[i]["name"]
      //}
    });
    
    
    alert (categories);
    //alert ("hey"+categories.length);
    //for (var i = 0; i < categories.length; i ++) alert (categories[i]);
    //[{id: 5, name: "some category"}]  
  }
  
  
  
  /** Registers a client for notification in case of a new post.
   * @param callback Callback function to execute. */
  this.registerForPosts = function (callback) {
    console.log ("[DataReceiver] Client subscribed for new-post-event.");
    sbsc_newpost.push (callback);
  }  
  
  
  
  this.categorySelectionChanged = function (data) {
    alert ("CSC: "+data);
    //mapControl.setLayer ();
    // 
    //dispatcher.trigger (...);
  }
  
  
  this.timeIntervalChanged = function () {
    // Parsing etc.
    //dispatcher.trigger (...);
  }
}


// Creates a DataReceiver object. 
// new DataReceiver ();




//**********************************************************************
// JSON object structure of a tweet:
/*  var tweet = {
      id:           394446832761597953,
      text:         "Die Welt geht runter! #sturm #wind #regen #chaos",
      hashtags:     ["sturm", "wind", "regen", "chaos"],
      author:       "Anna",
      retweets:     0,
      timestamp:    "1383672792",
      follower:     17,
      geolocation:  "50.41052487,8.13205296",
      place:        "Runkel, Limburg-Weilburg"
      category_id:  5,
      category_name:"Nonsense"
    };
*/

