/**
 * Created by ShittySushi on 06.04.2016.
 */

var heatmapChart = null;

$(document).ready(function() {
    updateHeatMap();
});

function updateSmogAndWeatherHeatMap(continuation) {
    var fromdate = document.getElementById("from-date").innerHTML;
    var todate = document.getElementById("to-date").innerHTML;
    var station = document.getElementById("station").value;

    $.ajax({
        url: "/weather?from=" + fromdate + "&to=" + todate,
    }).then(function(data) {
        var weatherData = getWeatherData(data);
        $.ajax({
            url: "/smog?from=" + fromdate + "&to=" + todate + "&station=" + station,
        }).then(function(data) {
            var smogData = getSmogData(data);
            console.log('works');
            continuation(weatherData, smogData);
        });
    });
}


$(function () {

    heatmapChart = {
        chart: {
            type: 'heatmap',
            marginTop: 40,
            marginBottom: 100
        },

        title: {
            text: ''
        },

        xAxis: {
            categories: []
        },

        yAxis: {
            categories: [],
            title: null
        },

        colorAxis: {
            min: 0,
            max: 1,
            minColor: '#00c853',
            maxColor: '#d50000'
        },

        legend: {
            align: 'right',
            layout: 'vertical',
            margin: 0,
            verticalAlign: 'top',
            y: 25,
            symbolHeight: 320
        },

        tooltip: {
            formatter: function () {
                return '<b>' + this.series.xAxis.categories[this.point.x] + '</b> value <br><b>' +
                    mulOrNull(this.point.value, scale_dict[rev_data_dict[this.series.yAxis.categories[this.point.y]]]) + '</b> of <br><b>' + this.series.yAxis.categories[this.point.y] + '</b>';
            }
        },

        series: [{
            name: 'Sales per employee',
            borderWidth: 1,
            data: [],
            dataLabels: {
                enabled: false,
                color: 'black',
                style: {
                    textShadow: 'none'
                }
            }
        }],

    };

    $('#heatmap').highcharts(heatmapChart);
});

function divOrNone(x, y) {
    if (x == null) return null;
    return x / y;
}

function mulOrNull(x, y) {
    if (x == null) return null;
    return x * y;
}

function addOrNull(x, y) {
    if (x == null) return null;
    return x + y;
}

function updateHeatMap() {
    updateSmogAndWeatherHeatMap(function(weatherData, smogData) {
        var alldata = $.extend({}, weatherData, smogData);
        heatmapChart.yAxis.categories = [];
        for (var name in alldata) {
            if (name == "label" || name == "labels") continue;
            heatmapChart.yAxis.categories.push(data_dict[name]);
        }
        heatmapChart.xAxis.categories = alldata.label.slice();

        var len = alldata.label.length;
        delete alldata.label;
        delete alldata.labels;

        heatmapChart.series[0].data = [];
        for (var x = 0; x < len; ++x) {
            var i = 0;
            for (var y in alldata) {
                heatmapChart.series[0].data.push([x, i, divOrNone(alldata[y][x], scale_dict[y])]);
                ++i;
            }
        }

        $('#heatmap').highcharts(heatmapChart);
        console.log("yup");
        console.log(heatmapChart.series[0].data);
    });
}


var data_dict = {
    "pylZawieszonyPm10":    "Pyl Zawieszony Pm 10",
    "tlenekWegla":          "Tlenek Wegla",
    "dwutlenekAzotu":       "Dwutlenek Azotu",
    "tlenekAzotu":          "Tlenek Azotu",
    "tlenkiAzotu":          "Tlenki Azotu",
    "pylZawieszonyPm25":    "Pyl Zawieszony Pm 2,5",
    "tlenekWegla8H":        "Tlenek Wegla 8H",
    "benzen":               "Benzen",
    "dwutlenekSiarki":      "Dwutlenek Siarki",
    "ozon":                 "Ozon",
    "ozon8H":               "Ozon 8H",
    "temp":                 "Temperatura",
    "wind":                 "Wiatr",
    "pressure":             "Ciśnienie",
    "rain":                 "opady",
    "humidity":             "Wilgotność"
};

var rev_data_dict = {};
for (var k in data_dict) {
    rev_data_dict[data_dict[k]] = k;
}

var scale_dict = {
    "pylZawieszonyPm10":    200,
    "tlenekWegla":          20000,
    "dwutlenekAzotu":       300,
    "tlenekAzotu":          300,
    "tlenkiAzotu":          300,
    "pylZawieszonyPm25":    120,
    "tlenekWegla8H":        20000,
    "benzen":               40,
    "dwutlenekSiarki":      400,
    "ozon":                 240,
    "ozon8H":               240,
    "temp":                 50,
    "wind":                 10,
    "pressure":             2000,
    "rain":                 50,
    "humidity":             100,
};