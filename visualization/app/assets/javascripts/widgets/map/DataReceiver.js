/** An object capable of receiving stateful notifications through 
 *  a web socket and re-broadcasting them to subscribed clients. */
function DataReceiver () {

  // var dispatcher = new WebSocketRails ("localhost:3001/websocket");
  var sbsc_newpost = new Array ();
  
  
  /** Subscribes at the Rails websocket dispatcher and distributes the 
   *  callback events among the clients. */
  dispatcher.subscribe("tweets").bind ("new", function (data) {
    //console.log ("[DataReceiver] Received new post from WSR.");
    for (var i = 0; i < sbsc_newpost.length; i ++) sbsc_newpost[i] (data);
  });
  
  
  /** Registers a client for notification in case of a new post.
   * @param callback Callback function to execute. */
  this.registerForPosts = function (callback) {
    console.log ("[DataReceiver] Client subscribed for new-post-event.");
    sbsc_newpost.push (callback);
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

