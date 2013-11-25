# Widget API

This document describes the way in which widgets should interact with the application. Important things to consider:

* Use the Websocket API to retrieve data. If there are API calls missing here, please say so in the Trello discussion.
* Make sure that your widgets adapts itself to the parent container's size. E.g. if your widget lives in 'div#my_widget', it should preferably be no larger than said container.


## Custom events

In order to avoid excessive resizing, the event is controlled by the dashboard JS. You should **not** subscribe to the `resize` event, but instead to the `dashboard:resize` event:

    $(window).on('dashboard:resize', function() {
        console.log("resize")
    });

Note that this will trigger less often than the actual resize event. For testing purpose, you can trigger the event too:

    $(window).trigger('dashboard:resize')




## Websocket API

The WebSockets implementation used will be [WebsocketRails](https://github.com/websocket-rails/websocket-rails). The `dispatcher` can be assumed to exist.

Generally, you should subscribe to the time-range event:

    var ui_channel = dispatcher.subscribe('ui');

    ui_channel.bind('time_range_updated', function(range) {
        console.log(range.start); // Unix timestamp (seconds)
        console.log(range.end); // Unix timestamp (seconds)
    });

Updating the time range (this will automatically result in a `time_range_updated` event as defined above:

    var range = 4 * 3600; // 4 hours in seconds
    dispatcher.trigger('ui.update_range', {range: range})

To be notified of new tweets, you can do this:

    var tweets_channel = dispatcher.subscribe('tweets');

    tweets_channel.bind('new', function(data) {
        // Data will contain an array of tweet objects
        // as defined below.
    });

Tweet objects have the following structure:

    var tweet = {
        id: 394446832761597953,
        text: "Die Welt geht runter! #sturm #wind #regen #chaos",
        hashtags: ["sturm", "wind", "regen", "chaos"],
        author: "Anna",
        retweets: 0,
        timestamp: "1383672792",
        follower: 17,

        // These will either be taken directly from the tweets table, or,
        // if no values have been supplied there, from the Information table.
        geolocation: "50.41052487,8.13205296",
        place: "Runkel, Limburg-Weilburg"

        category_id: 5,
        category_name: "Nonsense"
    }

All categories can be retrieved as follows:

    dispatcher.trigger('categories.get', {}, function(response) {
        console.log(response) # => [{id: 5, name: "some category"}]
    })
