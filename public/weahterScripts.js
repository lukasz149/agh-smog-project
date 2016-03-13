/**
 * Created by lukas on 12.03.2016.
 */
document.getElementById("date").addEventListener("change", updateWeatherData);
var temperatureChart;
var cloudyChart;
var humidityChart;

$(document).ready(function() {
    $.ajax({
        url: "/weather"
    }).then(function(data) {
        var weatherData = getWeatherData(data);

        var temperatureData =  weatherData[0][0];
        var cloudyData = weatherData[1][0];
        var humidityData = weatherData[2][0];

        var labelsTemperature = weatherData[0][1];
        var labelsCloudy = weatherData[1][1];
        var labelsHumidity = weatherData[2][1];

        temperatureChart = createChart(labelsTemperature, temperatureData, "temperatureChart");
        cloudyChart = createChart(labelsCloudy, cloudyData, "cloudyChart");
        humidityChart = createChart(labelsHumidity, humidityData, "humidityChart");
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
        var weatherData = getWeatherData(data);

        var temperatureData =  weatherData[0][0];
        var cloudyData = weatherData[1][0];
        var humidityData = weatherData[2][0];

        var labelsTemperature = weatherData[0][1];
        var labelsCloudy = weatherData[1][1];
        var labelsHumidity = weatherData[2][1];

        temperatureChart.destroy();
        humidityChart.destroy();
        cloudyChart.destroy();

        temperatureChart = createChart(labelsTemperature, temperatureData, "temperatureChart");
        cloudyChart = createChart(labelsCloudy, cloudyData, "cloudyChart");
        humidityChart = createChart(labelsHumidity, humidityData, "humidityChart");
    });
}

function getWeatherData(data) {
    var temperatureData = [];
    var labelsTemperature = [];
    var countTemperatureData = 0;

    var cloudyData = [];
    var labelsCloudy = [];
    var countCloudyData = 0;

    var humidityData = [];
    var labelsHumidity = [];
    var countHumidityData = 0;

    for (var i = 0; i < data.length; i++) {
        if(!(data[i].temperature === "")) {
            temperatureData[countTemperatureData] = data[i].temperature;
            labelsTemperature[countTemperatureData] = data[i].time;
            countTemperatureData += 1;
        }

        if(!(data[i].cloudy === "")) {
            cloudyData[countCloudyData] = data[i].cloudy;
            labelsCloudy[countCloudyData] = data[i].time;
            countCloudyData += 1;
        }

        if(!(data[i].humidity === "")) {
            humidityData[countHumidityData] = data[i].humidity;
            labelsHumidity[countHumidityData] = data[i].time;
            countHumidityData += 1;
        }
    }
    return [[temperatureData, labelsTemperature],[cloudyData, labelsCloudy],[humidityData, labelsHumidity]]
}