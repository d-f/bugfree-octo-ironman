nv.addGraph(function() {
    var chart = nv.models.scatterChart()
                .showDistX(true)
                .showDistY(true)
                .color(d3.scale.category10().range());

    //chart.xAxis.tickFormat(d3.format('.02f'))
    chart.xAxis.tickFormat(function(d) { return moment(d).format("DD.MM. HH:mm"); })
    chart.yAxis.tickFormat(d3.format('.02f'))

    var svg = d3.select('#timeline').append('svg')
    var container = $('#timeline');
    var width = container.width();
    svg.attr({width: width, height: 0.618*width});

    var data = [{key: "Group 0", values: []}];

    svg
        .datum(data)
        .transition().duration(500)
        .call(chart);

    var asd = 0;
    tweets_channel = dispatcher.subscribe('tweets')
    tweets_channel.bind("new", function(tweets) {
        for(var i=0; i<tweets.length; i++) {

            data[0].values.push({
                y: 0,
                x: moment(tweets[i].timestamp),
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