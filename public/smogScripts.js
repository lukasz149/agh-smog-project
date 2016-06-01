/**
 * Created by lukas on 12.03.2016.
 */
//document.getElementById("date").addEventListener("change", updateSmogData);
//document.getElementById("station").addEventListener("change", updateSmogData);
document.getElementById("dwutlenekAzotuSwitch").addEventListener("change", updateSmogCharts);
document.getElementById("tlenekAzotuSwitch").addEventListener("change", updateSmogCharts);
document.getElementById("tlenkiAzotuSwitch").addEventListener("change", updateSmogCharts);
document.getElementById("pylZawieszonyPm10Switch").addEventListener("change", updateSmogCharts);
document.getElementById("pylZawieszonyPm25Switch").addEventListener("change", updateSmogCharts);
document.getElementById("tlenekWeglaSwitch").addEventListener("change", updateSmogCharts);
document.getElementById("tlenekWegla8HSwitch").addEventListener("change", updateSmogCharts);
document.getElementById("ozonSwitch").addEventListener("change", updateSmogCharts);
document.getElementById("ozon8HSwitch").addEventListener("change", updateSmogCharts);
document.getElementById("benzenSwitch").addEventListener("change", updateSmogCharts);
document.getElementById("dwutlenekSiarkiSwitch").addEventListener("change", updateSmogCharts);

document.getElementById("dwutlenekAzotuSwitch2").addEventListener("change", updatePredictionCharts);
document.getElementById("tlenekAzotuSwitch2").addEventListener("change", updatePredictionCharts);
document.getElementById("tlenkiAzotuSwitch2").addEventListener("change", updatePredictionCharts);
document.getElementById("pylZawieszonyPm10Switch2").addEventListener("change", updatePredictionCharts);
document.getElementById("pylZawieszonyPm25Switch2").addEventListener("change", updatePredictionCharts);
document.getElementById("tlenekWeglaSwitch2").addEventListener("change", updatePredictionCharts);
document.getElementById("tlenekWegla8HSwitch2").addEventListener("change", updatePredictionCharts);
document.getElementById("ozonSwitch2").addEventListener("change", updatePredictionCharts);
document.getElementById("ozon8HSwitch2").addEventListener("change", updatePredictionCharts);
document.getElementById("benzenSwitch2").addEventListener("change", updatePredictionCharts);
document.getElementById("dwutlenekSiarkiSwitch2").addEventListener("change", updatePredictionCharts);

var smogChart;
var smogChartPrediction;

var datasets = [];

var smogSwitches = [{name: "dwutlenekAzotuSwitch", number:0},
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

var smogPredictionSwtiches = [{name: "dwutlenekAzotuSwitch2", number:0},
    {name: "tlenekAzotuSwitch2", number:1},
    {name: "tlenkiAzotuSwitch2", number:2},
    {name: "pylZawieszonyPm10Switch2", number:3},
    {name: "pylZawieszonyPm25Switch2", number:4},
    {name: "tlenekWeglaSwitch2", number:5},
    {name: "tlenekWegla8HSwitch2", number:6},
    {name: "ozonSwitch2", number:7},
    {name: "ozon8HSwitch2", number:8},
    {name: "benzenSwitch2", number:9},
    {name: "dwutlenekSiarkiSwitch2", number:10}];

$(document).ready(function() {
    $.ajax({
        url: "/smog"
    }).then(function(data) {
        var values = getSmogData(data);
        console.log(values);
        console.log("START");
        smogChart = createSmogChart(values.label, values, "smogChart", optionsSmogChart);
        updateSmogCharts();
    });

    var from = new Date('2016-04-05');
    var to = new Date('2016-04-05');

    from.setDate(from.getDate()-1);

    from = (from.getYear() + 1900) + "-" + zfill((from.getMonth() + 1).toString(), 2) + "-" + zfill(from.getDate().toString(), 2);
    to = (to.getYear() + 1900) + "-" + zfill((to.getMonth() + 1).toString(), 2) + "-" + zfill(to.getDate().toString(), 2);

    $.ajax({
        url: "/smog?from="+from+"&to="+to
    }).then(function(data) {
        var valuesPrediction = data;
        $.ajax({
            url: "/prediction"
        }).then(function(data) {
            var tmp = valuesPrediction.concat(data);
            var values = getSmogData(tmp);
            smogChartPrediction = createSmogChart(values.label, values, "smogChartPrediction", optionsSmogChart);
            updatePredictionCharts();
        });
    });
});

function createSmogChart(_labels, _values, _name, _options) {
    var data = {
        labels: _labels,
        datasets: createSmogDatasets(_values)
    };

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
                var yaxis = chart.scales['y-axis-3'];

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
        options: _options
    });
}

function updateSmogCharts() {
    updateAllCharts(smogChart, smogSwitches)
}


function updatePredictionCharts() {
    updateAllCharts(smogChartPrediction, smogPredictionSwtiches)
}

function updateAllCharts(chart, switches){
    for(var i in switches){
        console.log(i);
        if($("#" + switches[i].name).is(':checked')) {
            chart.data.datasets[switches[i].number].hidden = false;
            chart.options.scales.yAxes[switches[i].number].display = true;
            //chart.data.datasets[switches[i].number+11].hidden = false;
        } else {
            chart.data.datasets[switches[i].number].hidden = true;
            chart.options.scales.yAxes[switches[i].number].display = false;
            //chart.data.datasets[switches[i].number+11].hidden = true;
        }
        chart.update();
    }
}


function updateSmogData() {
    var fromdate = document.getElementById("from-date").innerHTML;
    var todate = document.getElementById("to-date").innerHTML;
    var station = document.getElementById("station").value;

    $.ajax({
        url: "/smog?from=" + fromdate + "&to=" + todate + "&station=" + station
    }).then(function(data) {
        if (data == "") {
            Materialize.toast("Brak danych o smogu", 1000);
            return;
        }
        console.log("UPDATE");
        var values = getSmogData(data);
        datasets = [];

        if (values.label.length != smogChart.data.datasets[0].data.length) {
            smogChart.destroy();
            smogChart = createSmogChart(values.label, values, "smogChart", optionsSmogChart);
            updateSmogCharts();
        } else {
            smogChart.data.label = values.label.slice();

            for (var v = 0; v < values.label.length; ++v) {
                var i = 0;
                for (var key in values) {
                    if(values.hasOwnProperty(key) && key != 'label') {
                        //console.log(key + " "+ i);
                        smogChart.data.datasets[i].data[v] = values[key][v];
                        i++;
                    }
                }
                //smogChart.data.datasets[0].data[v] = values.dwutlenekAzotu[v];
                //smogChart.data.datasets[1].data[v] = values.tlenekAzotu[v];
                //smogChart.data.datasets[2].data[v] = values.tlenkiAzotu[v];
                //smogChart.data.datasets[3].data[v] = values.pylZawieszonyPm10[v];
                //smogChart.data.datasets[4].data[v] = values.pylZawieszonyPm25[v];
                //smogChart.data.datasets[5].data[v] = values.tlenekWegla[v];
                //smogChart.data.datasets[6].data[v] = values.tlenekWegla8H[v];
                //smogChart.data.datasets[7].data[v] = values.ozon[v];
                //smogChart.data.datasets[8].data[v] = values.ozon8H[v];
                //smogChart.data.datasets[9].data[v] = values.benzen[v];
                //smogChart.data.datasets[10].data[v] = values.dwutlenekSiarki[v];
            }
            smogChart.update();
        }
    });
}

function stringOrNull(x) {
    return x === "" ? null : x;
}

function getSmogValues(data, values) {
    for (var i = 0; i < data.length; i++) {
        for (var key in data[i]) {
            values[key][i] = stringOrNull(data[i][key]);
        }
    }
    return values;
}

function getSmogData(data) {
    var values = {
        "label": [],
        "dwutlenekAzotu": [],
        "tlenekAzotu": [],
        "tlenkiAzotu": [],
        "pylZawieszonyPm10": [],
        "pylZawieszonyPm25": [],
        "tlenekWegla": [],
        "tlenekWegla8H": [],
        "ozon": [],
        "ozon8H": [],
        "benzen": [],
        "dwutlenekSiarki": []
    };
    return getSmogValues(data, values);
}
    //var labels = [];
    //var pylZawieszonyPm10 = [];
    //var tlenekWegla = [];
    //var dwutlenekAzotu = [];
    //var tlenekAzotu = [];
    //var tlenkiAzotu = [];
    //var pylZawieszonyPm25 = [];
    //var tlenekWegla8H = [];
    //var benzen = [];
    //var dwutlenekSiarki = [];
    //var ozon = [];
    //var ozon8H = [];


    //for (var i = 0; i < data.length; i++) {
    //    labels[i] = stringOrNull(data[i].label);
    //    pylZawieszonyPm10[i] = stringOrNull(data[i].pylZawieszonyPm10);
    //    tlenekWegla[i] = stringOrNull(data[i].tlenekWegla);
    //    dwutlenekAzotu[i] = stringOrNull(data[i].dwutlenekAzotu);
    //    tlenekAzotu[i] = stringOrNull(data[i].tlenekAzotu);
    //    tlenkiAzotu[i] = stringOrNull(data[i].tlenkiAzotu);
    //    pylZawieszonyPm25[i] = stringOrNull(data[i].pylZawieszonyPm25);
    //    tlenekWegla8H[i] = stringOrNull(data[i].tlenekWegla8H);
    //    benzen[i] = stringOrNull(data[i].benzen);
    //    dwutlenekSiarki[i] = stringOrNull(data[i].dwutlenekSiarki);
    //    ozon[i] = stringOrNull(data[i].ozon);
    //    ozon8H[i] = stringOrNull(data[i].ozon8H);
    //
    //}
    //return {
    //    'labels': labels,
    //    'dwutlenekAzotu': dwutlenekAzotu,
    //    'tlenekAzotu': tlenekAzotu,
    //    'tlenkiAzotu': tlenkiAzotu,
    //    'pylZawieszonyPm10': pylZawieszonyPm10,
    //    'pylZawieszonyPm25': pylZawieszonyPm25,
    //    'tlenekWegla': tlenekWegla,
    //    'tlenekWegla8H': tlenekWegla8H,
    //    'ozon': ozon,
    //    'ozon8H': ozon8H,
    //    'benzen': benzen,
    //    'dwutlenekSiarki': dwutlenekSiarki
    //};

function createSmogDatasets(_values) {
    return [
        {
            yAxisID: "y-axis-0",
            label: "dwutlenekAzotu",
            borderColor: "rgba(255, 23, 68, 0.8)",
            backgroundColor: "rgba(255, 23, 68, 0.2)",
            pointBorderColor: "rgba(255, 23, 68, 1)",
            pointBackgroundColor: "rgba(255, 23, 68, 1)",
            pointBorderWidth: 1,
            data: _values.dwutlenekAzotu,
            hidden: true
        }, {
            yAxisID: "y-axis-1",
            label: "tlenekAzotu",
            borderColor: "rgba(101, 31, 255, 0.8)",
            backgroundColor: "rgba(101, 31, 255, 0.2)",
            pointBorderColor: "rgba(101, 31, 255, 1)",
            pointBackgroundColor: "rgba(101, 31, 255, 1)",
            pointBorderWidth: 1,
            data: _values.tlenekAzotu,
            hidden: true
        }, {
            yAxisID: "y-axis-2",
            label: "tlenkiAzotu",
            borderColor: "rgba(0, 176, 255, 0.8)",
            backgroundColor: "rgba(0, 176, 255, 0.2)",
            pointBorderColor: "rgba(0, 176, 255, 1)",
            pointBackgroundColor: "rgba(0, 176, 255, 1)",
            pointBorderWidth: 1,
            data: _values.tlenkiAzotu,
            hidden: true
        }, {
            yAxisID: "y-axis-3",
            label: "pylZawieszonyPm10",
            borderColor: "rgba(0, 230, 118, 0.8)",
            backgroundColor: "rgba(0, 230, 118, 0.2)",
            pointBorderColor: "rgba(0, 230, 118, 1)",
            pointBackgroundColor: "rgba(0, 230, 118, 1)",
            pointBorderWidth: 1,
            data: _values.pylZawieszonyPm10,
            hidden: false
        }, {
            yAxisID: "y-axis-4",
            label: "pylZawieszonyPm25",
            borderColor: "rgba(255, 234, 0, 0.2)",
            backgroundColor: "rgba(255, 234, 0, 0.2)",
            pointBorderColor: "rgba(255, 234, 0, 1)",
            pointBackgroundColor: "rgba(255, 234, 0, 1)",
            pointBorderWidth: 1,
            data: _values.pylZawieszonyPm25,
            hidden: true
        }, {
            yAxisID: "y-axis-5",
            label: "tlenekWegla",
            borderColor: "rgba(255, 61, 0, 0.8)",
            backgroundColor: "rgba(255, 61, 0, 0.2)",
            pointBorderColor: "rgba(255, 61, 0, 1)",
            pointBackgroundColor: "rgba(255, 61, 0, 1)",
            pointBorderWidth: 1,
            data: _values.tlenekWegla,
            hidden: true
        }, {
            yAxisID: "y-axis-6",
            label: "tlenekWegla8H",
            borderColor: "rgba(78, 52, 46, 0.8)",
            backgroundColor: "rgba(78, 52, 46, 0.2)",
            pointBorderColor: "rgba(78, 52, 46, 1)",
            pointBackgroundColor: "rgba(78, 52, 46, 1)",
            pointBorderWidth: 1,
            data: _values.tlenekWegla8H,
            hidden: true
        }, {
            yAxisID: "y-axis-7",
            label: "ozon",
            borderColor: "rgba(236, 64, 122, 0.8)",
            backgroundColor: "rgba(236, 64, 122, 0.2)",
            pointBorderColor: "rgba(236, 64, 122, 1)",
            pointBackgroundColor: "rgba(236, 64, 122, 1)",
            pointBorderWidth: 1,
            data: _values.ozon,
            hidden: true
        }, {
            yAxisID: "y-axis-8",
            label: "ozon8H",
            borderColor: "rgba(213, 0, 249, 0.8)",
            backgroundColor: "rgba(213, 0, 249, 0.2)",
            pointBorderColor: "rgba(213, 0, 249, 1)",
            pointBackgroundColor: "rgba(213, 0, 249, 1)",
            pointBorderWidth: 1,
            data: _values.ozon8H,
            hidden: true
        }, {
            yAxisID: "y-axis-9",
            label: "benzen",
            borderColor: "rgba(66, 165, 245, 0.8)",
            backgroundColor: "rgba(66, 165, 245, 0.2)",
            pointBorderColor: "rgba(66, 165, 245, 1)",
            pointBackgroundColor: "rgba(66, 165, 245, 1)",
            pointBorderWidth: 1,
            data: _values.benzen,
            hidden: true
        }, {
            yAxisID: "y-axis-10",
            label: "dwutlenekSiarki",
            borderColor: "rgba(128, 203, 196, 0.8)",
            backgroundColor: "rgba(128, 203, 196, 0.2)",
            pointBorderColor: "rgba(128, 203, 196, 1)",
            pointBackgroundColor: "rgba(128, 203, 196, 1)",
            pointBorderWidth: 1,
            data: _values.dwutlenekSiarki,
            hidden: true
        }];
}

var optionsSmogChart = {
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
            id: "y-axis-0",
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
            id: "y-axis-1",
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
            id: "y-axis-2",
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
            id: "y-axis-3",
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
            id: "y-axis-4",
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
            id: "y-axis-5",
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
            id: "y-axis-6",
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
            id: "y-axis-7",
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
            id: "y-axis-8",
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
            id: "y-axis-9",
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
            id: "y-axis-10",
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
    },
    annotation: {
        annotations: [
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-0',
                value: '40',
                borderColor: 'rgba(255, 23, 68, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-1',
                value: '30',
                borderColor: 'rgba(101, 31, 255, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-2',
                value: '30',
                borderColor: 'rgba(0, 176, 255, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-3',
                value: '40',
                borderColor: 'rgba(0, 230, 118, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-4',
                value: '20',
                borderColor: 'rgba(255, 234, 0, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-5',
                value: '10000',
                borderColor: 'rgba(255, 61, 0, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-6',
                value: '10000',
                borderColor: 'rgba(78, 52, 46, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-7',
                value: '120',
                borderColor: 'rgba(236, 64, 122, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-8',
                value: '120',
                borderColor: 'rgba(213, 0, 249, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-9',
                value: '5',
                borderColor: 'rgba(66, 165, 245, 1)',
                borderWidth: 1
            },
            {
                type: 'line',
                mode: 'horizontal',
                scaleID: 'y-axis-10',
                value: '125',
                borderColor: 'rgba(128, 203, 196, 1)',
                borderWidth: 1
            }
        ]
    }
};
//var optionsPrediction = jQuery.extend(true, {}, options);
//
//optionsPrediction.annotation = {
//
//};

