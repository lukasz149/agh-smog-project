/**
 * Created by lukas on 12.03.2016.
 */
//document.getElementById("date").addEventListener("change", updateWeatherData);
//document.getElementById("checkTemperature").addEventListener("change", updateTemperatureChart);
//document.getElementById("checkWind").addEventListener("change", updateWeatherData);

var weatherChart;
var datasets = [];

$(document).ready(function() {
    $.ajax({
        url: "/weather"
    }).then(function(data) {
        var values = getWeatherData(data);
        console.log("START");
        weatherChart = createChart(values.label, values, "weatherChart");
        updateAllWeatherCharts();
    });
});

function createChart(_labels, _values, _name) {
    var data = {
        labels: _labels,
        datasets: [{
            yAxisID: "y-axis-1",
            label: "Temperatura",
            borderColor: "rgba(230, 81, 0, 0.8)",
            backgroundColor: "rgba(230, 81, 0, 0.2)",
            pointBorderColor: "rgba(230, 81, 0, 1)",
            pointBackgroundColor: "rgba(230, 81, 0, 1)",
            pointBorderWidth: 1,
            data: _values.temp,
            hidden: true
        }, {
            yAxisID: "y-axis-2",
            label: "Prędkość wiatru",
            borderColor: "rgba(66, 66, 66, 0.8)",
            backgroundColor: "rgba(66, 66, 66, 0.2)",
            pointBorderColor: "rgba(66, 66, 66, 1)",
            pointBackgroundColor: "rgba(66, 66, 66, 1)",
            pointBorderWidth: 1,
            data: _values.wind,
            hidden: true
        }, {
            yAxisID: "y-axis-3",
            label: "Cisnienie",
            borderColor: "rgba(156, 39, 176, 0.8)",
            backgroundColor: "rgba(156, 39, 176, 0.2)",
            pointBorderColor: "rgba(156, 39, 176, 1)",
            pointBackgroundColor: "rgba(156, 39, 176, 1)",
            pointBorderWidth: 1,
            data: _values.pressure,
            hidden: true
        }, {
            yAxisID: "y-axis-4",
            label: "Opady",
            borderColor: "rgba(1, 87, 155, 0.8)",
            backgroundColor: "rgba(1, 87, 155, 0.2)",
            pointBorderColor: "rgba(1, 87, 155, 1)",
            pointBackgroundColor: "rgba(1, 87, 155, 1)",
            pointBorderWidth: 1,
            data: _values.rain,
            hidden: true
        }, {
            yAxisID: "y-axis-5",
            label: "Wilgotność",
            borderColor: "rgba(100, 181, 246, 0.8)",
            backgroundColor: "rgba(100, 181, 246, 0.2)",
            pointBorderColor: "rgba(100, 181, 246, 1)",
            pointBackgroundColor: "rgba(1, 181, 246, 1)",
            pointBorderWidth: 1,
            data: _values.humidity,
            hidden: true
        }]
    };
    var options = {
        responsive: false,
        hoverMode: 'label',
        stacked: true,
        scales: {
            xAxes: [{
                display: true,
                gridLines: {
                    offsetGridLines: false
                }
            }],
            yAxes: [{
                id: "y-axis-1",
                type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                display: true,
                position: "left",
                ticks: {
                    fontColor: "rgba(230, 81, 0, 1)"
                },
                gridLines: {
                    drawOnChartArea: true
                }
            }, {
                id: "y-axis-2",
                type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                display: true,
                position: "right",
                ticks: {
                    fontColor: "rgba(66, 66, 66, 1)"
                },
                gridLines: {
                    drawOnChartArea: true // only want the grid lines for one axis to show up
                }
            }, {
                id: "y-axis-3",
                type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                display: true,
                position: "left",
                ticks: {
                    fontColor: "rgba(156, 39, 176, 1)"
                },
                gridLines: {
                    drawOnChartArea: true // only want the grid lines for one axis to show up
                }
            },{
                id: "y-axis-4",
                type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                display: true,
                position: "right",
                ticks: {
                    fontColor: "rgba(1, 87, 155, 1)"
                },
                gridLines: {
                    drawOnChartArea: true // only want the grid lines for one axis to show up
                }
            },{
                id: "y-axis-5",
                type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                display: true,
                position: "left",
                ticks: {
                    fontColor: "rgba(1, 181, 246, 1)"
                },
                gridLines: {
                    drawOnChartArea: true // only want the grid lines for one axis to show up
                }
            }]
        }
    };
    var ctx = document.getElementById(_name).getContext("2d");
    return new Chart.Line(ctx, {
        data: data,
        options: options
    });
}
function  updateTemperatureChart() {
    if($("#checkTemperature").is(':checked')) {
        weatherChart.data.datasets[0].hidden = false;
        weatherChart.options.scales.yAxes[0].display = true;
    } else {
        weatherChart.data.datasets[0].hidden = true;
        weatherChart.options.scales.yAxes[0].display = false;
    }
    weatherChart.update();
}

function  updateWindSpeedChart() {
    if($("#checkWind").is(':checked')) {
        weatherChart.data.datasets[1].hidden = false;
        weatherChart.options.scales.yAxes[1].display = true;
    } else {
        weatherChart.data.datasets[1].hidden = true;
        weatherChart.options.scales.yAxes[1].display = false;
    }
    weatherChart.update();
}

function  updatePerssureChart() {
    if($("#checkPressure").is(':checked')) {
        weatherChart.data.datasets[2].hidden = false;
        weatherChart.options.scales.yAxes[2].display = true;
    } else {
        weatherChart.data.datasets[2].hidden = true;
        weatherChart.options.scales.yAxes[2].display = false;
    }
    weatherChart.update();
}

function  updateRainChart() {
    if($("#checkRain").is(':checked')) {
        weatherChart.data.datasets[3].hidden = false;
        weatherChart.options.scales.yAxes[3].display = true;
    } else {
        weatherChart.data.datasets[3].hidden = true;
        weatherChart.options.scales.yAxes[3].display = false;
    }
    weatherChart.update();
}

function  updateHumidityChart() {
    if($("#checkHumidity").is(':checked')) {
        weatherChart.data.datasets[4].hidden = false;
        weatherChart.options.scales.yAxes[4].display = true;
    } else {
        weatherChart.data.datasets[4].hidden = true;
        weatherChart.options.scales.yAxes[4].display = false;
    }
    weatherChart.update();
}

function updateWeatherData() {
    var fromdate = document.getElementById("from-date").innerHTML;
    var todate = document.getElementById("to-date").innerHTML;
    $.ajax({
        url: "/weather?from=" + fromdate + "&to=" + todate,
    }).then(function(data) {
        if (data == "") {
            Materialize.toast("Brak danych o pogodzie", 1000);
            return;
        }
        console.log("UPDATE");
        var values = getWeatherData(data);
        datasets = [];

        if (values.label.length != weatherChart.data.datasets[0].data.length) {
            weatherChart.destroy();

            weatherChart = createChart(values.label, values, "weatherChart");
            updateAllWeatherCharts();
        } else {
            weatherChart.data.labels = values.label.slice();
            weatherChart.data.datasets[0].data = values.temp.slice();
            weatherChart.data.datasets[1].data = values.wind.slice();
            weatherChart.data.datasets[2].data = values.pressure.slice();
            weatherChart.data.datasets[3].data = values.rain.slice();
            weatherChart.data.datasets[4].data = values.humidity.slice();

            weatherChart.update();
        }
    });
}

//function stringOrNull(x) {
//    return x === "" ? null : x;
//}

function getWeatherData(data) {
    console.log(data);
    var result = {
        label: [],
        temp: [],
        wind: [],
        pressure: [],
        rain: [],
        humidity: []
    };

    for (var i = 0; i < data.length; i++) {
        for (var field in result) {
            result[field].push(stringOrNull(data[i][field]));
        }
    }
    console.log("Result");
    console.log(result);
    return result;
}

function updateAllWeatherCharts() {
    updateTemperatureChart();
    updateWindSpeedChart();
    updatePerssureChart();
    updateRainChart();
    updateHumidityChart();
}