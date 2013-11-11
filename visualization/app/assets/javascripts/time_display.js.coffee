
simulated_time = moment()
real_time_set = moment()
time_container = $("#the_time")

update_time = ->
    elapsed = moment().diff(real_time_set)
    time = moment(simulated_time)
    time = time.add('milliseconds', elapsed)
    time_container.text(time.format('dddd, MMMM Do YYYY, hh:mm:ss'))

update_time()
setInterval(update_time, 1000)
