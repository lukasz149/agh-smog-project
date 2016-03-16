/**
 * Created by lukas on 15.03.2016.
 */
document.getElementById("date").addEventListener("change", updateSmogData);
document.getElementById("station").addEventListener("change", updateSmogData);

var charts = [];
var canvas = [];
var titles = [];

var chartsSet = {
    'charts' : charts,
    'canvas' : canvas,
    'titles' : titles
};
//var canvasSet = {};
//var idCount = 0;
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
                canvas.id = "chart" + chartsSet.charts.length;

                var titleOfChart = document.createElement("h5");
                titleOfChart.id = "chartTitle" + chartsSet.charts.length;
                titleOfChart.innerHTML = name;

                var smogTab = document.getElementById("smog");
                smogTab.appendChild(titleOfChart);
                smogTab.appendChild(canvas);

                var chart = createChart(labels, stringOrNull(data[name]), canvas.id);
                //charts.push(chart);
                chartsSet.charts.push(chart);
                chartsSet.canvas.push(canvas.id);
                chartsSet.titles.push(titleOfChart.id);

                //canvasSet[canvas.id] = [chart, name];
                //idCount++;
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

function updateSmogData() {
    var dateValue = document.getElementById("date");
    var date = dateValue.value;

    var stationValue = document.getElementById("station");
    var station = stationValue.value;

    $.ajax({
        url: "/smog?date=" + date + "&station=" + station
    }).then(function(data) {
        if (data == "") {
            return;
        }

        for (var i=0; i<chartsSet.charts.length; i++) {
            chartsSet.charts[i].destroy();
        }
        chartsSet.charts = [].slice();
        //alert(chartsSet.charts.toString());

        for (var i=0; i<chartsSet.canvas.length; i++) {
            var canvasToDelete = document.getElementById(chartsSet.canvas[i]);
            var smogTab = document.getElementById("smog");
            smogTab.removeChild(canvasToDelete);
        }
        chartsSet.canvas = [].slice();
        //alert(chartsSet.canvas.toString());

        for (var i=0; i<chartsSet.titles.length; i++) {
            var titleToDelete = document.getElementById(chartsSet.titles[i]);
            var smogTab = document.getElementById("smog");
            smogTab.removeChild(titleToDelete);
        }
        chartsSet.titles = [].slice();
        //alert(chartsSet.titles.toString());
        var labels = createLabels(data);
        for (var name in data) {
            if (name != "CZAS") {
                var canvas = document.createElement("canvas");
                canvas.width = 1000;
                canvas.height = 200;
                canvas.id = "chart" + chartsSet.charts.length;

                var titleOfChart = document.createElement("h5");
                titleOfChart.id = "chartTitle" + chartsSet.charts.length;
                titleOfChart.innerHTML = name;

                var smogTab = document.getElementById("smog");
                smogTab.appendChild(titleOfChart);
                smogTab.appendChild(canvas);

                var chart = createChart(labels, stringOrNull(data[name]), canvas.id);
                //charts.push(chart);
                chartsSet.charts.push(chart);
                chartsSet.canvas.push(canvas.id);
                chartsSet.titles.push(titleOfChart.id);

                //canvasSet[canvas.id] = [chart, name];
                //idCount++;
            }
        }
    });
}

