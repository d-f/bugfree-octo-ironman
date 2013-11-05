class StreamGraph

    constructor: (containerSelector) ->
        @container = $(containerSelector)
        @svg = d3.select(containerSelector).append('svg')
        @width = @container.width()
        @height = 500

        @chart = @didInsertElement()

    didInsertElement: ->
        colors = d3.scale.category20()
        keyColor = (d, i) -> colors d.key

        chart = nv.models.stackedAreaChart()
                    #.width(1024).height(2000)
                    .useInteractiveGuideline(true)
                    .x((d) -> d[0])
                    .y((d) -> d[1])
                    .color(keyColor)
                    .transitionDuration(300)
                    .showControls(false)
                    #.clipEdge(true);

        chart.stacked.style('stream')

        # chart.stacked.scatter.clipVoronoi(false);

        chart.xAxis
            .tickFormat((d) -> d3.time.format('%H:%M')(new Date(d)) )

        chart.yAxis
            .tickFormat(d3.format(',.2f'))

        nv.addGraph =>
            chart = chart
            @svg.datum(@getData())
                .transition().duration(0)
                .call(chart)

            nv.utils.windowResize(chart.update)

            #chart.dispatch.on('stateChange', function(e) { nv.log('New State:', JSON.stringify(e)); });
            # chart
        # chart

    getData: ->
        starttime = new Date(2013, 9, 28, 0, 0).getTime()
        endtime = new Date(2013, 9, 29, 0, 0).getTime()
        categories = ['hilfegesuch', 'pressemitteilung', 'lorem ipsum']
        values = []

        stepsize = 60 * 60 * 1000
        for cat in categories
          values.push
            key: cat
            values: ([t, ~~(Math.random()*10)] for t in [starttime..endtime] by stepsize)

        values

window.streamgraph = new StreamGraph "#streamgraph"