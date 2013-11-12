container = $("#tweets")
container.html("")

appendTweet = (tweet) ->
    container.prepend("<div class='media'><div class='media-body'><h4 class='media-heading'>#{tweet.author}</h4>#{tweet.text}</div></div>");

tweets_channel = dispatcher.subscribe('tweets')
tweets_channel.bind "new", (tweets) ->
    #console.log(tweets)
    [appendTweet(tweet) for tweet in tweets]
