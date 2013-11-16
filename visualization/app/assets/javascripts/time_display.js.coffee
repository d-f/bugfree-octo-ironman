
simulated_time = null
real_time_set = null

time_container = $("#the_time")

update_time = ->
    elapsed = moment().diff(real_time_set)
    time = moment(simulated_time)
    time = time.add('milliseconds', elapsed)
    time_container.text(time.utc().format('dddd, MMMM Do YYYY, HH:mm:ss Z'))

dispatcher.trigger 'time.get', '', (response) ->
    simulated_time = moment(response[0])
    real_time_set = moment(response[1])
    setInterval(update_time, 1000)

dispatcher.subscribe('time').bind 'simulated_time_updated', (response) ->
    simulated_time = moment(response[0])
    real_time_set = moment(response[1])
