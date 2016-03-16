/**
 * Created by lukas on 12.03.2016.
 */
document.getElementById("date").addEventListener("change", updateWeatherData);
var temperatureChart;
var cloudyChart;
var humidityChart;
var windSpeedChart;

$(document).ready(function() {
    $.ajax({
        url: "/weather"
    }).then(function(data) {
        var values = getWeatherData(data);

        temperatureChart = createChart(values.labels, values.temperature, "temperatureChart");
        cloudyChart = createChart(values.labels, values.cloudy, "cloudyChart");
        humidityChart = createChart(values.labels, values.humidity, "humidityChart");
        windSpeedChart = createChart(values.labels, values.windSpeed, "windSpeedChart");
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
        url: "/weather?date=" + date
    }).then(function(data) {
        if (data == "") {
            return;
        }

        var values = getWeatherData(data);

        if (values.labels.length != temperatureChart.datasets[0].points.length) {
            temperatureChart.destroy();
            cloudyChart.destroy();
            humidityChart.destroy();
            windSpeedChart.destroy();

            temperatureChart = createChart(values.labels, values.temperature, "temperatureChart");
            cloudyChart = createChart(values.labels, values.cloudy, "cloudyChart");
            humidityChart = createChart(values.labels, values.humidity, "humidityChart");
            windSpeedChart = createChart(values.labels, values.windSpeed, "windSpeedChart");
        } else {
            for (var v = 0; v < values.labels.length; ++v) {
                temperatureChart.datasets[0].points[v].value = values.temperature[v];
                cloudyChart.datasets[0].points[v].value = values.cloudy[v];
                humidityChart.datasets[0].points[v].value = values.humidity[v];
                windSpeedChart.datasets[0].points[v].value = values.windSpeed[v];

                temperatureChart.datasets[0].label = values.labels[v];
                cloudyChart.datasets[0].label = values.labels[v];
                humidityChart.datasets[0].label = values.labels[v];
                windSpeedChart.datasets[0].label = values.labels[v];
            }

            temperatureChart.update();
            humidityChart.update();
            cloudyChart.update();
            windSpeedChart.update();
        }
    });
}


function valueOrNull(x) {
    return x !== "" ? x : null;
}


function getWeatherData(data) {
    var labels = [];
    var temperatureData = [];
    var cloudyData = [];
    var humidityData = [];
    var windSpeedData = [];

    for (var i = 0; i < data.length; i++) {
        labels[i] = valueOrNull(data[i].godzina);
        temperatureData[i] = valueOrNull(data[i].temperatura);
        cloudyData[i] = valueOrNull(data[i].zachmurzenie);
        humidityData[i] = valueOrNull(data[i].wilgotnosc);
        windSpeedData[i] = valueOrNull(data[i].predkosc);
    }

    return {
        'labels': labels,
        'temperature': temperatureData,
        'cloudy': cloudyData,
        'humidity': humidityData,
        'windSpeed': windSpeedData
    };
}