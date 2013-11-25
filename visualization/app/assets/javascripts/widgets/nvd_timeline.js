nv.addGraph(function() {
    var chart = nv.models.scatterChart()
                .showDistX(true)
                .showDistY(true)
                .color(d3.scale.category10().range());
    chart.useVoronoi(false);

    chart.scatter.dispatch.on('elementClick', function(e) {
        console.log('element: ' + e.value);
        console.dir(e.point);
        console.dir(this);
    });

    chart.xAxis.tickFormat(function(d) { return moment(d.timestamp).format("DD.MM. HH:mm"); })
    chart.x(function(d) {
        return moment(d.x.timestamp);
    })
    chart.yAxis.tickFormat(d3.format('.02f'))

    var svg = d3.select('#timeline').append('svg')
    var container = $('#timeline');
    var width = container.width();
    svg.attr({width: width, height: 0.618*width});

    var data = [
        {key: "Help Request", values: []},
        {key: "Support Request", values: []},
        {key: "Support Offer", values: []},
        {key: "Information Request", values: []},
        {key: "Information Offer", values: []},
        {key: "Trashtalk", values: []}
    ];

    svg
        .datum(data)
        .transition().duration(500)
        .call(chart);

    var asd = 0;
    tweets_channel = dispatcher.subscribe('tweets')
    tweets_channel.bind("new", function(tweets) {
        for(var i=0; i<tweets.length; i++) {
            data[tweets[i].category_id].values.push({
                y: Math.random(),
                x: tweets[i],
                size: 10,
                series: 0
            })

        }

        svg.datum(data).call(chart)
    });

    nv.utils.windowResize(chart.update);

    return chart;
});


function randomData(groups, points) { //# groups,# points per group
    var data = [],
        shapes = ['circle', 'cross', 'triangle-up', 'triangle-down', 'diamond', 'square'],
        random = d3.random.normal();

    for (i = 0; i < groups; i++) {
      data.push({
        key: 'Group ' + i,
        values: []
      });

    for (j = 0; j < points; j++) {
      data[i].values.push({
        x: moment() * Math.random()
      , y: random()
      , size: Math.random()
      //, shape: shapes[j % 6]
      });
    }
  }

  return data;
}
