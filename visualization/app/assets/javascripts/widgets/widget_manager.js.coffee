
window.dispatcher = new WebSocketRails('localhost:3001/websocket')

#channel = dispatcher.subscribe('tweets')
#channel.bind "new", (tweets) ->
#    [console.log(t) for t in tweets]

resizeTimeout = null
onResize = ->
    $(window).trigger('dashboard:resize')

$(window).resize =>
    if resizeTimeout != null
        clearTimeout(resizeTimeout)
    resizeTimeout = setTimeout(onResize, 250)
