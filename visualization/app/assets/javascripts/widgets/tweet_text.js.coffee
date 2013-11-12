container = $("#tweets")
container.html("")

appendTweet = (tweet) ->
    previous_height = container.height()
    previous_scroll_top = container.parent().scrollTop()
    container.prepend("<div class='media'><div class='media-body'><h4 class='media-heading'>#{tweet.author}</h4>#{tweet.text}</div></div>");
    if previous_scroll_top > 10
        added_height = container.height() - previous_height
        container.parent().scrollTop(previous_scroll_top + added_height)

tweets_channel = dispatcher.subscribe('tweets')
tweets_channel.bind "new", (tweets) ->
    [appendTweet(tweet) for tweet in tweets]
