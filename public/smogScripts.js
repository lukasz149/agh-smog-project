/**
 * Created by lukas on 15.03.2016.
 */
//var charts = [];
var canvasSet = {};
var idCount = 0;
$(document).ready(function() {
    $.ajax({
        url: "/smog"
    }).then(function(data) {
        var labels = createLabels(data);
        for (var name in data) {
            if (name != "CZAS") {
                var canvas = document.createElement("canvas");
                canvas.width = 1000;
                canvas.height = 200;
                canvas.id = "chart" + idCount;

                var nameOfChart = document.createElement("h5");
                nameOfChart.id = "chartTitle" + idCount;
                nameOfChart.innerHTML = name;

                var smogTab = document.getElementById("smog");
                smogTab.appendChild(nameOfChart);
                smogTab.appendChild(canvas);

                var chart = createChart(labels, data[name], canvas.id);
                //charts.push(chart);
                canvasSet[canvas.id] = [chart, name];
                idCount++;
            }
        }
    });
});

function createLabels(data) {
    for (var name in data) {
        if (name == "CZAS") {
            return data[name].slice();
        }
    }
    return null;
}

function updateWeatherData() {

}

