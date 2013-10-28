
class Timeline

    constructor: (containerSelector) ->
        @container = $(containerSelector)
        @width = @container.width()
        @height = 500;

        currentTime = new Date().getTime();

        # Start and end time 3 hours from now
        @startTime = currentTime - (3600 * 3 * 1000);
        @endTime = currentTime + (3600 * 3 * 1000);
        @bucketSize = 60 * 30 * 1000; # Thirty minute buckets


        #data = @getData(startTime, endTime, bucketSize, 1)
        #@nodes = data[0]
        #@buckets = data[1]


        @svg = d3.select(containerSelector).append('svg')
        @svg.attr
            width: @width
            height: @height


        @text_g = @svg.append('svg:g')
        @rect_g = @svg.append('svg:g')
        @circle_g = @svg.append('svg:g')

        @force = null;

        @update(@bucketSize, 1);


        resizeTimeout = null
        onResize = =>
            @width = @container.width()
            @svg.attr
                width: @width
            @update(@bucketSize, 1)

        $(window).resize =>
            if resizeTimeout != null
                clearTimeout(resizeTimeout)
            resizeTimeout = setTimeout(onResize, 250)




    update: (bucketSize, zoomFactor) ->
        color = d3.scale.category10()

        zoomFactor = 1
        data = @getData(@startTime, @endTime, bucketSize, zoomFactor)
        nodes = data[0]
        buckets = data[1]

        text = @text_g.selectAll('text').data(buckets);
        text
            .enter()
            .append("text")
            .attr('y', @height - 10)
            .attr('fill', 'grey')

        text.exit().remove()
        text
            .attr('x', (d) -> d.textOffset)
            .text (d) ->
                date = new Date(d.startTime)
                date.getHours() + ":" + date.getMinutes()

        rects = @rect_g.selectAll('rect').data(buckets)
        rects
            .enter()
            .append("rect")
            .attr('width', '1')
            .attr('height', @height)
            .attr('y', '0')
            .attr('fill', 'grey')

        # Remove lines that are not needed anymore
        rects.exit().remove()

        # Move all lines to correct position
        rects.attr 'x', (d) -> d.offset

        circles = @circle_g.selectAll('circle.node')
            .data(nodes)

        circles
            .enter()
            .append('circle')
            .attr('class', 'node')
            .attr('r', 5)
            .attr('cy', @height/2)

        circles.exit().remove()
        circles
            .style('fill', (d) -> color(d.group))


        if @force
            @force.stop()

        @force = d3.layout.force()
            .nodes(nodes)
            .links([])
            .gravity(0)
            .charge(-10)
            .size([@width, @height]);

        @force.on "tick", (e) =>
            # Push nodes toward their designated focus.
            k = .1 * e.alpha;
            nodes.forEach (d, i) =>
                d.x = d.offset;
                d.y += ((@height/2) - d.y) * k
                return

            @svg.selectAll("circle.node")
                .attr("cx", (d) -> d.x)
                .attr("cy", (d) -> d.y);

            return

        @force.start();





    sliderUpdate: (el) ->
        zoomFactor = parseInt(el.value) / 10.0
        newBucketSize = zoomFactor * @bucketSize
        @update(newBucketSize, zoomFactor)


    getData: (startTime, endTime, bucketSize, zoomFactor) ->
        timeRange = endTime - startTime
        bucketCount = timeRange / bucketSize

        buckets = d3.range(bucketCount).map (i) =>
            index: i
            startTime: (startTime + bucketSize * i),
            offset: (@width / bucketCount) * i + 18, # 18 = half the text width
            textOffset: (@width / bucketCount) * i

        amount = 500 * (1/zoomFactor)
        nodes = for i in [0...amount]
            value = startTime + Math.floor(Math.random() * timeRange);
            bucket = Math.floor((value - startTime) / bucketSize);
            offset = ((value - startTime) / timeRange) * @width;

            bucket: bucket
            time: value
            offset: offset
            # The group might be used later to identify certain groups
            # of tweets, e.g. containing a certain keyword.
            group: Math.floor(Math.random() * 3) + 1

        [nodes, buckets]




window.timeline = new Timeline("#timeline")
