/**
 * Created by lukas on 15.03.2016.
 */
document.getElementById("date").addEventListener("change", updateSmogData);
document.getElementById("station").addEventListener("change", updateSmogData);

function Plot(title) {
    var div = document.createElement("div");
    var canvas = document.createElement("canvas");
    canvas.width = 1000;
    canvas.height = 200;

    var titleOfChart = document.createElement("h5");
    titleOfChart.innerHTML = title;

    div.appendChild(titleOfChart);
    div.appendChild(canvas);

    document.getElementById("smog").appendChild(div);

    return {
        'div': div,
        'canvas': canvas
    }
}

var chartsSet = {};

//var canvasSet = {};
//var idCount = 0;
$(document).ready(function() {
    $.ajax({
        url: "/smog"
    }).then(function(data) {
        var labels = createLabels(data);
        for (var name in data) {
            if (name != "CZAS") {
                var div = Plot(name);
                var chart = createChartSmog(labels, data[name], div.canvas);

                chartsSet[name] = {
                    'elem': div,
                    'chart': chart
                };
            }
        }
    });
});

function createLabels(data) {
    return data["CZAS"].slice();
}

function updateSmogData() {
    var dateValue = document.getElementById("date");
    var date = dateValue.value;

    var stationValue = document.getElementById("station");
    var station = stationValue.value;

    $.ajax({
        url: "/smog?date=" + date + "&station=" + station
    }).then(function(data) {
        if (data == "") {
            Materialize.toast("Brak danych o smogu", 1000);
            return;
        }
        console.log(data);
        console.log(chartsSet);

        for (var i in chartsSet) {
            if (!(i in data)) {
                chartsSet[i].chart.destroy();
                document.getElementById("smog").removeChild(chartsSet[i].elem.div);
                delete chartsSet[i];
            }
        }

        for (var i in data) {
            if (i == "CZAS") continue;
            if (i in chartsSet) {
                // update
                if (data[i].length != chartsSet[i].chart.datasets[0].points.length) {
                    chartsSet[i].chart.destroy();
                    chartsSet[i].chart = createChartSmog(data["CZAS"], data[i], chartsSet[i].elem.canvas);
                } else {
                    console.log('update');
                    updateChartSmog(chartsSet[i].chart, data["CZAS"], data[i])
                }
            } else {
                var div = Plot(i);
                var chart = createChartSmog(data["CZAS"], data[i], div.canvas);

                chartsSet[i] = {
                    'elem': div,
                    'chart': chart
                };
            }
        }
    });
}

// -----

function createChartSmog(_labels, _data, _element) {
    var data = {
        labels: _labels,
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(151,187,205,0.2)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(151,187,205,1)",
                data: _data
            }
        ]
    };
    var options = {
        ///Boolean - Whether grid lines are shown across the chart
        scaleShowGridLines: true,
        //String - Colour of the grid lines
        scaleGridLineColor: "rgba(0,0,0,.05)",
        //Number - Width of the grid lines
        scaleGridLineWidth: 1,
        //Boolean - Whether to show horizontal lines (except X axis)
        scaleShowHorizontalLines: true,
        //Boolean - Whether to show vertical lines (except Y axis)
        scaleShowVerticalLines: true,
        //Boolean - Whether the line is curved between points
        bezierCurve: true,
        //Number - Tension of the bezier curve between points
        bezierCurveTension: 0.4,
        //Boolean - Whether to show a dot for each point
        pointDot: true,
        //Number - Radius of each point dot in pixels
        pointDotRadius: 4,
        //Number - Pixel width of point dot stroke
        pointDotStrokeWidth: 1,
        //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
        pointHitDetectionRadius: 20,
        //Boolean - Whether to show a stroke for datasets
        datasetStroke: true,
        //Number - Pixel width of dataset stroke
        datasetStrokeWidth: 2,
        //Boolean - Whether to fill the dataset with a colour
        datasetFill: true,
        //String - A legend template
        legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
    };
    var ctx = _element.getContext("2d");
    return new Chart(ctx).Line(data, options);
}


function updateChartSmog(_chart, _labels, _data) {
    for (var v = 0; v < _labels.length; ++v) {
        _chart.datasets[0].points[v].value = _data[v];
        _chart.datasets[0].label = _labels[v];
    }

    _chart.update();
}