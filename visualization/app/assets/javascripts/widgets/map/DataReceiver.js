/** Middleware layer for the Leaflet map widget. Decouples map logic
 *  from the communication (=> Websockets, MySQL, ...). */
function DataReceiver () {

  var sbsc_newpost      = new Array ();  // 'New Post Arrived' subscribers.
  var sbsc_catSelection = new Array ();  // 'Category Selection Change' subscr.
  var sbsc_catChange    = new Array ();  // 'Category Data Change' subscr.
  var sbsc_timerange    = new Array ();  // 'Time Range Change' subscribers.


  /* Server Connections                             (<== Rails WebSockets) */
  /*************************************************************************/

  // The dispatcher object is created externally, no need to do it here!
  // var dispatcher = new WebSocketRails ("localhost:3001/websocket");

  /** Binds to the new-tweet event. Sends complete data after interval change. */
  dispatcher.subscribe("tweets").bind ("new", function (data) {
    for (var i = 0; i < sbsc_newpost.length; i ++) sbsc_newpost[i] (data);
  });

  /** Subscribes to the time-range-update event. */
  dispatcher.subscribe("time").bind ("range_updated", function(range) {
    var minutesBack = (((new Date).getTime()/1E3|0) - range.start) / 60;
    console.log ("[DataReceiver] Time interval change event received: "+minutesBack);
    for (var i = 0; i < sbsc_timerange.length; i ++) sbsc_timerange[i] (minutesBack);
  });




  /* Client Side Connections                        (==> Rails WebSockets) */
  /*************************************************************************/

  /** This function is called by the category listener on selection change.
   * @param data Categories, consists of 'changed', 'checkboxes' (state/counter). */
  this.selectionChanged = function (data) {

    //TODO Websocket server has no receive / broadcast method! Local workaround only.
    for (var i = 0; i < sbsc_catSelection.length; i ++)
      sbsc_catSelection[i] (data.changed, data.checkboxes[data.changed]["state"]);
  }


  /** Calls back all listeners for the category data change event.
   * @param data Information object with category name and number of active posts. */
  this.categoryChanged = function (data) {
    var dataUpdate = {'category' : data.catName,
                      'counter'  : data.counter};

    // Notify all category data change listeners.
    for (var i = 0; i < sbsc_catChange.length; i ++) sbsc_catChange[i] (dataUpdate);
  }


  /** Send a time interval change event to the dispatcher.
   * @param data JSON containing the minimum and maximum interval values. */
  this.timeIntervalChanged = function (data) {
    console.log ("[DataReceiver] Time interval changed to "+
                 "["+data.minimum+" , "+data.maximum+"]");
    dispatcher.trigger ("time.set_range", {range: parseInt(data.maximum) * 60});
  }




  /* Register Functions For Subscribers            *(no unsubscribing yet) */
  /*************************************************************************/

  /** Registers a client for notification in case of a new post.
   * @param callback Callback function to execute. */
  this.subscribe_NewPosts = function (callback) {
    console.log ("[DataReceiver] Client subscribed for 'new post' event.");
    sbsc_newpost.push (callback);
  }

  /** Registration for category data change event.
   * @param callback Callback function to execute. */
  this.subscribe_CategoryChange = function (callback) {
    console.log ("[DataReceiver] Client subscribed for 'category change' event.");
    sbsc_catChange.push (callback);
  }

  /** Registration for category selection change event.
   * @param callback Callback function to execute. */
  this.subscribe_SelectionChange = function (callback) {
    console.log ("[DataReceiver] Client subscribed for 'selection change' event.");
    sbsc_catSelection.push (callback);
  }

  /** Registration for notification on time slider interval change.
   * @param callback Callback function to execute. */
  this.subscribe_IntervalChange = function (callback) {
    console.log ("[DataReceiver] Client subscribed for 'interval change' event.");
    sbsc_timerange.push (callback);
  }
}

