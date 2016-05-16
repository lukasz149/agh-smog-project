/**
 * Created by lukas on 12.03.2016.
 */
//document.getElementById("date").addEventListener("change", updateSmogData);
//document.getElementById("station").addEventListener("change", updateSmogData);
document.getElementById("dwutlenekAzotuSwitch").addEventListener("change", updateAllCharts);
document.getElementById("tlenekAzotuSwitch").addEventListener("change", updateAllCharts);
document.getElementById("tlenkiAzotuSwitch").addEventListener("change", updateAllCharts);
document.getElementById("pylZawieszonyPm10Switch").addEventListener("change", updateAllCharts);
document.getElementById("pylZawieszonyPm25Switch").addEventListener("change", updateAllCharts);
document.getElementById("tlenekWeglaSwitch").addEventListener("change", updateAllCharts);
document.getElementById("tlenekWegla8HSwitch").addEventListener("change", updateAllCharts);
document.getElementById("ozonSwitch").addEventListener("change", updateAllCharts);
document.getElementById("ozon8HSwitch").addEventListener("change", updateAllCharts);
document.getElementById("benzenSwitch").addEventListener("change", updateAllCharts);
document.getElementById("dwutlenekSiarkiSwitch").addEventListener("change", updateAllCharts);


var smogChart;
var smogChartPrediction;

var datasets = [];

var dic = [{name: "dwutlenekAzotuSwitch", number:0},
    {name: "tlenekAzotuSwitch", number:1},
    {name: "tlenkiAzotuSwitch", number:2},
    {name: "pylZawieszonyPm10Switch", number:3},
    {name: "pylZawieszonyPm25Switch", number:4},
    {name: "tlenekWeglaSwitch", number:5},
    {name: "tlenekWegla8HSwitch", number:6},
    {name: "ozonSwitch", number:7},
    {name: "ozon8HSwitch", number:8},
    {name: "benzenSwitch", number:9},
    {name: "dwutlenekSiarkiSwitch", number:10}];

$(document).ready(function() {
    var valuesPrediction = [];
    var from = new Date('2016-04-06');
    var to = new Date('2016-04-06');
    from.setDate(from.getDate()-1);
    from = (from.getYear() + 1900) + "-" + zfill((from.getMonth() + 1).toString(), 2) + "-" + zfill(from.getDate().toString(), 2);
    to = (to.getYear() + 1900) + "-" + zfill((to.getMonth() + 1).toString(), 2) + "-" + zfill(to.getDate().toString(), 2);
    $.ajax({
        url: "/smog"
    }).then(function(data) {
        var values = getSmogData(data);
        console.log(values);
        console.log("START");
        smogChart = createSmogChart(values.labels, values, "smogChart", options);
        updateAllCharts();
    });
    $.ajax({
        url: "/smog?from="+from+"&to="+to
    }).then(function(data) {
        valuesPrediction = data;
        $.ajax({
            url: "/prediction"
        }).then(function(data) {
            var tmp = valuesPrediction.concat(data);
            var values = getSmogData(tmp);
            smogChartPrediction = createSmogChart(values.labels, values, "smogChartPrediction", optionsPrediction);
            // updateAllCharts();
        });
    });

});




function createSmogChart(_labels, _values, _name, _options) {
    var data = {
        labels: _labels,
        datasets: [
            {
            yAxisID: "y-axis-1",
            label: "dwutlenekAzotu",
            borderColor: "rgba(255, 23, 68, 0.8)",
            backgroundColor: "rgba(255, 23, 68, 0.2)",
            pointBorderColor: "rgba(255, 23, 68, 1)",
            pointBackgroundColor: "rgba(255, 23, 68, 1)",
            pointBorderWidth: 1,
            data: _values.dwutlenekAzotu,
            hidden: true
        }, {
            yAxisID: "y-axis-2",
            label: "tlenekAzotu",
            borderColor: "rgba(101, 31, 255, 0.8)",
            backgroundColor: "rgba(101, 31, 255, 0.2)",
            pointBorderColor: "rgba(101, 31, 255, 1)",
            pointBackgroundColor: "rgba(101, 31, 255, 1)",
            pointBorderWidth: 1,
            data: _values.tlenekAzotu,
            hidden: true
        }, {
            yAxisID: "y-axis-3",
            label: "tlenkiAzotu",
            borderColor: "rgba(0, 176, 255, 0.8)",
            backgroundColor: "rgba(0, 176, 255, 0.2)",
            pointBorderColor: "rgba(0, 176, 255, 1)",
            pointBackgroundColor: "rgba(0, 176, 255, 1)",
            pointBorderWidth: 1,
            data: _values.tlenkiAzotu,
            hidden: true
        }, {
            yAxisID: "y-axis-4",
            label: "pylZawieszonyPm10",
            borderColor: "rgba(0, 230, 118, 0.8)",
            backgroundColor: "rgba(0, 230, 118, 0.2)",
            pointBorderColor: "rgba(0, 230, 118, 1)",
            pointBackgroundColor: "rgba(0, 230, 118, 1)",
            pointBorderWidth: 1,
            data: _values.pylZawieszonyPm10,
            hidden: false
        }, {
            yAxisID: "y-axis-5",
            label: "pylZawieszonyPm25",
            borderColor: "rgba(255, 234, 0, 0.2)",
            backgroundColor: "rgba(255, 234, 0, 0.2)",
            pointBorderColor: "rgba(255, 234, 0, 1)",
            pointBackgroundColor: "rgba(255, 234, 0, 1)",
            pointBorderWidth: 1,
            data: _values.pylZawieszonyPm25,
            hidden: true
        }, {
            yAxisID: "y-axis-6",
            label: "tlenekWegla",
            borderColor: "rgba(255, 61, 0, 0.8)",
            backgroundColor: "rgba(255, 61, 0, 0.2)",
            pointBorderColor: "rgba(255, 61, 0, 1)",
            pointBackgroundColor: "rgba(255, 61, 0, 1)",
            pointBorderWidth: 1,
            data: _values.tlenekWegla,
            hidden: true
        }, {
            yAxisID: "y-axis-7",
            label: "tlenekWegla8H",
            borderColor: "rgba(78, 52, 46, 0.8)",
            backgroundColor: "rgba(78, 52, 46, 0.2)",
            pointBorderColor: "rgba(78, 52, 46, 1)",
            pointBackgroundColor: "rgba(78, 52, 46, 1)",
            pointBorderWidth: 1,
            data: _values.tlenekWegla8H,
            hidden: true
        }, {
            yAxisID: "y-axis-8",
            label: "ozon",
            borderColor: "rgba(236, 64, 122, 0.8)",
            backgroundColor: "rgba(236, 64, 122, 0.2)",
            pointBorderColor: "rgba(236, 64, 122, 1)",
            pointBackgroundColor: "rgba(236, 64, 122, 1)",
            pointBorderWidth: 1,
            data: _values.ozon,
            hidden: true
        }, {
            yAxisID: "y-axis-9",
            label: "ozon8H",
            borderColor: "rgba(213, 0, 249, 0.8)",
            backgroundColor: "rgba(213, 0, 249, 0.2)",
            pointBorderColor: "rgba(213, 0, 249, 1)",
            pointBackgroundColor: "rgba(213, 0, 249, 1)",
            pointBorderWidth: 1,
            data: _values.ozon8H,
            hidden: true
        }, {
            yAxisID: "y-axis-10",
            label: "benzen",
            borderColor: "rgba(66, 165, 245, 0.8)",
            backgroundColor: "rgba(66, 165, 245, 0.2)",
            pointBorderColor: "rgba(66, 165, 245, 1)",
            pointBackgroundColor: "rgba(66, 165, 245, 1)",
            pointBorderWidth: 1,
            data: _values.benzen,
            hidden: true
        }, {
            yAxisID: "y-axis-11",
            label: "dwutlenekSiarki",
            borderColor: "rgba(128, 203, 196, 0.8)",
            backgroundColor: "rgba(128, 203, 196, 0.2)",
            pointBorderColor: "rgba(128, 203, 196, 1)",
            pointBackgroundColor: "rgba(128, 203, 196, 1)",
            pointBorderWidth: 1,
            data: _values.dwutlenekSiarki,
            hidden: true
        }, {
            yAxisID: "y-axis-1",
            label: "dwutlenekAzotuNORMA",
            borderColor: "rgba(255, 23, 68, 1)",
            backgroundColor: "rgba(255, 23, 68, 0)",
            pointBorderColor: "rgba(255, 23, 68, 0)",
            pointBackgroundColor: "rgba(255, 23, 68, 0)",
            pointBorderWidth: 1,
            data: [40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40],
            hidden: true
        }, {
            yAxisID: "y-axis-2",
            label: "tlenekAzotuNORMA",
            borderColor: "rgba(101, 31, 255, 1)",
            backgroundColor: "rgba(101, 31, 255, 0)",
            pointBorderColor: "rgba(101, 31, 255, 0)",
            pointBackgroundColor: "rgba(101, 31, 255, 0)",
            pointBorderWidth: 1,
            data: [30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30],
            hidden: true
        }, {
            yAxisID: "y-axis-3",
            label: "tlenkiAzotuNORMA",
            borderColor: "rgba(0, 176, 255, 1)",
            backgroundColor: "rgba(0, 176, 255, 0)",
            pointBorderColor: "rgba(0, 176, 255, 0)",
            pointBackgroundColor: "rgba(0, 176, 255, 0)",
            pointBorderWidth: 1,
            data: [30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30],
            hidden: true
        }, {
            yAxisID: "y-axis-4",
            label: "pylZawieszonyPm10NORMA",
            borderColor: "rgba(0, 230, 118, 1)",
            backgroundColor: "rgba(0, 230, 118, 0)",
            pointBorderColor: "rgba(0, 230, 118, 0)",
            pointBackgroundColor: "rgba(0, 230, 118, 0)",
            pointBorderWidth: 1,
            data: [40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40],
            hidden: true
        }, {
            yAxisID: "y-axis-5",
            label: "pylZawieszonyPm25NORMA",
            borderColor: "rgba(255, 234, 0, 1)",
            backgroundColor: "rgba(255, 234, 0, 0)",
            pointBorderColor: "rgba(255, 234, 0, 0)",
            pointBackgroundColor: "rgba(255, 234, 0, 0)",
            pointBorderWidth: 1,
            data: [20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20],
            hidden: true
        }, {
            yAxisID: "y-axis-6",
            label: "tlenekWeglaNORMA",
            borderColor: "rgba(255, 61, 0, 1)",
            backgroundColor: "rgba(255, 61, 0, 0)",
            pointBorderColor: "rgba(255, 61, 0, 0)",
            pointBackgroundColor: "rgba(255, 61, 0, 0)",
            pointBorderWidth: 1,
            data: [10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000],
            hidden: true
        }, {
            yAxisID: "y-axis-7",
            label: "tlenekWegla8HNORMA",
            borderColor: "rgba(78, 52, 46, 1)",
            backgroundColor: "rgba(78, 52, 46, 0)",
            pointBorderColor: "rgba(78, 52, 46, 0)",
            pointBackgroundColor: "rgba(78, 52, 46, 0)",
            pointBorderWidth: 1,
            data: [10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000],
            hidden: true
        }, {
            yAxisID: "y-axis-8",
            label: "ozonNORMA",
            borderColor: "rgba(236, 64, 122, 1)",
            backgroundColor: "rgba(236, 64, 122, 0)",
            pointBorderColor: "rgba(236, 64, 122, 0)",
            pointBackgroundColor: "rgba(236, 64, 122, 0)",
            pointBorderWidth: 1,
            data: [120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120],
            hidden: true
        }, {
            yAxisID: "y-axis-9",
            label: "ozon8HNORMA",
            borderColor: "rgba(213, 0, 249, 1)",
            backgroundColor: "rgba(213, 0, 249, 0)",
            pointBorderColor: "rgba(213, 0, 249, 0)",
            pointBackgroundColor: "rgba(213, 0, 249, 0)",
            pointBorderWidth: 1,
            data: [120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120,120],
            hidden: true
        }, {
            yAxisID: "y-axis-10",
            label: "benzenNORMA",
            borderColor: "rgba(66, 165, 245, 1)",
            backgroundColor: "rgba(66, 165, 245, 0)",
            pointBorderColor: "rgba(66, 165, 245, 0)",
            pointBackgroundColor: "rgba(66, 165, 245, 0)",
            pointBorderWidth: 1,
            data: [5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5],
            hidden: true
        }, {
            yAxisID: "y-axis-11",
            label: "dwutlenekSiarki",
            borderColor: "rgba(128, 203, 196, 1)",
            backgroundColor: "rgba(128, 203, 196, 0)",
            pointBorderColor: "rgba(128, 203, 196, 0)",
            pointBackgroundColor: "rgba(128, 203, 196, 0)",
            pointBorderWidth: 1,
            data: [125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125,125],
            hidden: true
        }]
    };
    var options = _options;
    Chart.defaults.global.legend = false;
    var ctx = document.getElementById(_name).getContext("2d");

    var originalLineDraw = Chart.controllers.line.prototype.draw;
    Chart.helpers.extend(Chart.controllers.line.prototype, {
        draw: function() {
            originalLineDraw.apply(this, arguments);

            var chart = this.chart;
            var ctx = chart.chart.ctx;

            var index = 24;
            if (index) {
                var xaxis = chart.scales['x-axis-0'];
                var yaxis = chart.scales['y-axis-4'];

                ctx.save();
                ctx.beginPath();
                ctx.moveTo(xaxis.getPixelForValue(undefined, index), yaxis.top);
                ctx.strokeStyle = 'grey';
                ctx.lineTo(xaxis.getPixelForValue(undefined, index), yaxis.bottom);
                ctx.stroke();
                ctx.restore();
            }
        }
    });


    return new Chart.Line(ctx, {
        data: data,
        options: options
    });
}


function updateAllCharts(){
    for(var i in dic){
        console.log(i);
        if($("#" + dic[i].name).is(':checked')) {
            smogChart.data.datasets[dic[i].number].hidden = false;
            smogChart.options.scales.yAxes[dic[i].number].display = true;
            smogChart.data.datasets[dic[i].number+11].hidden = false;
        } else {
            smogChart.data.datasets[dic[i].number].hidden = true;
            smogChart.options.scales.yAxes[dic[i].number].display = false;
            smogChart.data.datasets[dic[i].number+11].hidden = true;
        }
        smogChart.update();
    }
}


function updateSmogData() {
    var fromdate = document.getElementById("from-date").innerHTML;
    var todate = document.getElementById("to-date").innerHTML;
    var station = document.getElementById("station").value;

    $.ajax({
        url: "/smog?from=" + fromdate + "&to=" + todate + "&station=" + station,
    }).then(function(data) {
        if (data == "") {
            Materialize.toast("Brak danych o smogu", 1000);
            return;
        }
        console.log("UPDATE");
        var values = getSmogData(data);
        datasets = [];

        if (values.labels.length != smogChart.data.datasets[0].data.length) {
            smogChart.destroy();
            smogChart = createSmogChart(values.labels, values, "smogChart", options);
            updateAllCharts();
        } else {
            smogChart.data.labels = values.labels.slice();
            for (var v = 0; v < values.labels.length; ++v) {
                //console.log(smogChart.data.datasets);
                smogChart.data.datasets[0].data[v] = values.dwutlenekAzotu[v];
                smogChart.data.datasets[1].data[v] = values.tlenekAzotu[v];
                smogChart.data.datasets[2].data[v] = values.tlenkiAzotu[v];
                smogChart.data.datasets[3].data[v] = values.pylZawieszonyPm10[v];
                smogChart.data.datasets[4].data[v] = values.pylZawieszonyPm25[v];
                smogChart.data.datasets[5].data[v] = values.tlenekWegla[v];
                smogChart.data.datasets[6].data[v] = values.tlenekWegla8H[v];
                smogChart.data.datasets[7].data[v] = values.ozon[v];
                smogChart.data.datasets[8].data[v] = values.ozon8H[v];
                smogChart.data.datasets[9].data[v] = values.benzen[v];
                smogChart.data.datasets[10].data[v] = values.dwutlenekSiarki[v];

            }
            smogChart.update();
        }
    });
}

function stringOrNull(x) {
    return x === "" ? null : x;
}

function getSmogData(data) {
    var labels = [];
    var pylZawieszonyPm10 = [];
    var tlenekWegla = [];
    var dwutlenekAzotu = [];
    var tlenekAzotu = [];
    var tlenkiAzotu = [];
    var pylZawieszonyPm25 = [];
    var tlenekWegla8H = [];
    var benzen = [];
    var dwutlenekSiarki = [];
    var ozon = [];
    var ozon8H = [];


    for (var i = 0; i < data.length; i++) {
        labels[i] = stringOrNull(data[i].label);
        pylZawieszonyPm10[i] = stringOrNull(data[i].pylZawieszonyPm10);
        tlenekWegla[i] = stringOrNull(data[i].tlenekWegla);
        dwutlenekAzotu[i] = stringOrNull(data[i].dwutlenekAzotu);
        tlenekAzotu[i] = stringOrNull(data[i].tlenekAzotu);
        tlenkiAzotu[i] = stringOrNull(data[i].tlenkiAzotu);
        pylZawieszonyPm25[i] = stringOrNull(data[i].pylZawieszonyPm25);
        tlenekWegla8H[i] = stringOrNull(data[i].tlenekWegla8H);
        benzen[i] = stringOrNull(data[i].benzen);
        dwutlenekSiarki[i] = stringOrNull(data[i].dwutlenekSiarki);
        ozon[i] = stringOrNull(data[i].ozon);
        ozon8H[i] = stringOrNull(data[i].ozon8H);

    }
    return {
        'labels': labels,
        'pylZawieszonyPm10': pylZawieszonyPm10,
        'tlenekWegla': tlenekWegla,
        'dwutlenekAzotu': dwutlenekAzotu,
        'tlenekAzotu': tlenekAzotu,
        'tlenkiAzotu': tlenkiAzotu,
        'pylZawieszonyPm25': pylZawieszonyPm25,
        'tlenekWegla8H': tlenekWegla8H,
        'benzen': benzen,
        'dwutlenekSiarki': dwutlenekSiarki,
        'ozon': ozon,
        'ozon8H': ozon8H
    };
}


var options = {
    responsive: false,
    hoverMode: 'label',
    stacked: true,
    lineAtIndex: 2,
    scales: {
        xAxes: [{
            id: "x-axis-0",
            display: true,
            gridLines: {
                offsetGridLines: false
            }
        }],
        yAxes: [{
            id: "y-axis-1",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "left",
            ticks: {
                fontColor: "rgba(255, 23, 68, 1)",
                beginAtZero: true
            },
            gridLines: {
                drawOnChartArea: true
            }
        }, {
            id: "y-axis-2",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "right",
            ticks: {
                fontColor: "rgba(101, 31, 255, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }, {
            id: "y-axis-3",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "left",
            ticks: {
                fontColor: "rgba(0, 176, 255, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }, {
            id: "y-axis-4",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: true,
            position: "right",
            ticks: {
                fontColor: "rgba(0, 230, 118, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }, {
            id: "y-axis-5",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "left",
            ticks: {
                fontColor: "rgba(255, 234, 0, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }, {
            id: "y-axis-6",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "right",
            ticks: {
                fontColor: "rgba(255, 61, 0, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }, {
            id: "y-axis-7",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "left",
            ticks: {
                fontColor: "rgba(78, 52, 46, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }, {
            id: "y-axis-8",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "right",
            ticks: {
                fontColor: "rgba(236, 64, 122, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }, {
            id: "y-axis-9",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "left",
            ticks: {
                fontColor: "rgba(213, 0, 249, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }, {
            id: "y-axis-10",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "right",
            ticks: {
                fontColor: "rgba(66, 165, 245, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }, {
            id: "y-axis-11",
            type: "linear", // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
            display: false,
            position: "left",
            ticks: {
                fontColor: "rgba(128, 203, 196, 1)"
            },
            gridLines: {
                drawOnChartArea: true // only want the grid lines for one axis to show up
            }
        }]
    }
};
var optionsPrediction = jQuery.extend(true, {}, options);

optionsPrediction.annotation = {
    annotations: [
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-1',
            value: '40',
            borderColor: 'rgba(255, 23, 68, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-2',
            value: '30',
            borderColor: 'rgba(101, 31, 255, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-3',
            value: '30',
            borderColor: 'rgba(0, 176, 255, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-4',
            value: '40',
            borderColor: 'rgba(0, 230, 118, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-5',
            value: '20',
            borderColor: 'rgba(255, 234, 0, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-6',
            value: '10000',
            borderColor: 'rgba(255, 61, 0, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-7',
            value: '10000',
            borderColor: 'rgba(78, 52, 46, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-8',
            value: '120',
            borderColor: 'rgba(236, 64, 122, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-9',
            value: '120',
            borderColor: 'rgba(213, 0, 249, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-10',
            value: '5',
            borderColor: 'rgba(66, 165, 245, 1)',
            borderWidth: 1
        },
        {
            type: 'line',
            mode: 'horizontal',
            scaleID: 'y-axis-11',
            value: '125',
            borderColor: 'rgba(128, 203, 196, 1)',
            borderWidth: 1
        }
    ]
};

