;(function() {

    // var data = {
    //     name: "Hashtags",
    //     children: [
    //         {name: "foo", value: 5.0},
    //         {name: "bar", value: 23.0},
    //         {name: "baz", value: 42.0}
    //     ]
    // }

    var diameter = 300,
        format = d3.format(",d"),
        color = d3.scale.category20c();

    var svg = d3.select("#hashCloud").append("svg")
        .attr("width", diameter)
        .attr("height", diameter)
        .attr("class", "bubble");

    var bubble = d3.layout.pack()
            .sort(null)
            .size([diameter, diameter])
            .padding(1.5);

    function update(data) {
        var nodes = bubble.nodes(data);
        var g = svg.selectAll('.node').data(nodes, function(d) {
            return d.name + d.value;
        });

        var node = g.enter()
                .append("g")
                .attr("class", "node")

        node.append("circle")

        node.append("text")
          .attr("dy", ".3em")
          .style("text-anchor", "middle")
          .text(function(d) {
                if(d.name.length * 4 > d.r) {
                    return "";
                }
                return d.name;
          });

        g.exit()
            .transition()
            .remove()
            .selectAll("circle")

        g.attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; })
            .selectAll('circle')
                .attr("r", function(d) { return d.r; })
                .style("fill", function(d) { return color(d.name); })

    }



    function updateDataObject(obj, hashtag) {
        var found = false;
        for(var i=0; i<obj.children.length; i++) {
            var tag = obj.children[i];
            if(tag.name == hashtag) {
                found = true;
                obj.children[i].value += 1;
            }
        }

        if(!found) {
            obj.children.push({
                name: hashtag,
                value: 1
            })
        }

        return obj;
    }

    var data = {
        name: "",
        children: [
        ]
    };


    tweets_channel = dispatcher.subscribe('tweets')
    tweets_channel.bind("new", function(tweets) {
        for(var i=0; i<tweets.length; i++) {
            for(var j=0; j<tweets[i].hashtags.length; j++) {
                data = updateDataObject(data, tweets[i].hashtags[j]);
            }

        }
        //console.log(data);
        update(data);
        //svg.datum(data).call(chart)
    });





})();
