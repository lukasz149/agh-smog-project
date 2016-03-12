/**
 * Created by lukas on 12.03.2016.
 */
document.getElementById("date").addEventListener("change", updateWeatherData);
var temperatureChart;
var cloudyChart;
var humidityChart;

$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/weather"
    }).then(function(data) {
        //$('.greeting-id').append(data[2].time);
        //$('.greeting-content').append(data[0].time);
        var labels = [];
        var temperatureData = [];
        var cloudyData = [];
        var humidityData = [];

        for (var i = 0; i < data.length; i++) {
            //$('.weather').append(data[i].time + " ");
            //$('.weather').append(data[i].temperature + " ");
            labels[i] = data[i].time;
            temperatureData[i] = data[i].temperature;
            cloudyData[i] = data[i].cloudy;
            humidityData[i] = data[i].humidity;
        }

        temperatureChart = createChart(labels, temperatureData, "temperatureChart");
        cloudyChart = createChart(labels, cloudyData, "cloudyChart");
        humidityChart = createChart(labels, humidityData, "humidityChart");
    });
});

function createChart(_labels, _data, _name) {
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
    var ctx = document.getElementById(_name).getContext("2d");
    return new Chart(ctx).Line(data, options);
}

function updateWeatherData() {
    var x = document.getElementById("date");
    var date = x.value;
    $.ajax({
        url: "http://localhost:8080/weather?date="+date
    }).then(function(data) {
        //$('.greeting-id').append(data[2].time);
        //$('.greeting-content').append(data[0].time);
        var labels = [];
        var cloudyData = [];
        var temperatureData = [];
        var humidityData = [];

        for (var i = 0; i < data.length; i++) {
            //$('.weather').append(data[i].time + " ");
            //$('.weather').append(data[i].temperature + " ");
            labels[i] = data[i].time;
            temperatureData[i] = data[i].temperature;
            cloudyData[i] = data[i].cloudy;
            humidityData[i] = data[i].humidity;

            temperatureChart.datasets[0].points[i].value = data[i].temperature;
            cloudyChart.datasets[0].points[i].value = data[i].cloudy;
            humidityChart.datasets[0].points[i].value = data[i].humidity;
        }
        temperatureChart.update();
        cloudyChart.update();
        humidityChart.update();
    });
}