
window.dispatcher = new WebSocketRails('localhost:3001/websocket')

resizeTimeout = null
onResize = ->
    $(window).trigger('dashboard:resize')

$(window).resize =>
    if resizeTimeout != null
        clearTimeout(resizeTimeout)
    resizeTimeout = setTimeout(onResize, 250)
