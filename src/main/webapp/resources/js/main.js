var table = {
    ip: "115.159.206.169",
    //默认为50个数据
    dataLimitCount: 400,
    perTime: 30 * 1000,
    getChart: function (divId) {
        var mychart = echarts.init(document.getElementById(divId));
        mychart.showLoading();
        return mychart;
    },

    setIp: function (ip) {
        table.ip = ip;
    },
    url: {
        heartbeat: function (type) {
            return ["/api", table.ip, type, "info", "1m"].join("/");
        },
        init: function (type, timetype) {
            return ["/api", table.ip, type, "info", timetype].join("/");
        }
    },
    stop: function (stopId) {
        console.log(stopId);
        if (stopId != null) {
            clearInterval(stopId);
        }
    },

    /**
     *自动get获取数据
     */
    start: function (chart, data, type, timetype, data2) {
        console.log("start[]timetype=" + timetype);
        if (timetype == '1d') {
            console.log("it is 1d");
            table.getInitData(chart, data, type, timetype, data2);
            chart.hideLoading();
        } else {
            table.getInitData(chart, data, type, timetype, data2);
            chart.hideLoading();
            var stopId = setInterval(function () {
                table.getData(chart, data, type, timetype, data2);
            }, table.perTime);
            return stopId;
        }
    },

    /**
     * 添加数据到table 中
     */
    addData: function (chart, data) {
        console.log("add data to table");
        chart.setOption({
            series: [{
                data: data
            }]
        });
    },
    addDoubleData: function (chart, data1, data2) {
        console.log("add double data");
        chart.setOption({
            series: [
                {
                    name: '读入',
                    type: 'line',
                    showSymbol: false,
                    hoverAnimation: true,
                    connectNulls: true,
                    data: data1
                }, {
                    name: '读出',
                    type: 'line',
                    showSymbol: false,
                    hoverAnimation: true,
                    connectNulls: true,
                    data: data2
                }
            ]
        });
    },

    /**
     * get向指定api接口获取数据
     * @param type
     * @param timetype
     * @param num
     */
    getData: function (chart, data, type, timetype, data2) {
        console.log("heart beat get data")
        $.get(table.url.heartbeat(type, timetype), {}, function (result) {
            console.log(table.url.heartbeat(type, timetype));
            for (var i = 0, l = result.length; i < l; i++) {
                var time = new Date(result[i].time);
                var tdata = {
                    //tag
                    name: time.toString(),
                    //x y
                    value: [
                        [time.getFullYear(), time.getMonth() + 1, time.getDate()].join("/") + " " + time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds(),
                        result[i].usage
                    ]
                };
                while (data.length > table.dataLimitCount) {
                    console.log("data size:" + data.length);
                    data.shift();
                }
                data.push(tdata);
            }
            console.log(data);
            console.log("try to add data");
            table.addData(chart, data);
        });

    },

    /**
     * 获取初始化的数据
     * @param type
     * @param timetype
     */
    getInitData: function (chart, data, type, timetype, data2) {
        console.log("get init data");
        if (type == "disk" || type == "net") {
            $.get("/api/" + table.ip + "/" + type + "/info/read/" + timetype, {}, function (result) {
                console.log("/api/" + table.ip + "/" + type + "/info/read/");
                for (var i = 0, l = result.length; i < l; i++) {
                    var time = new Date(result[i].time);
                    var tdata = {
                        //tag
                        name: time.toString(),
                        //x y
                        value: [
                            [time.getFullYear(), time.getMonth() + 1, time.getDate()].join("/") + " " + time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds(),
                            table.jsonData(result[i],"r")
                        ]
                    };
                    data.push(tdata);
                }
                console.log(data);
                $.get("/api/" + table.ip + "/" + type + "/info/write/" + timetype, {}, function (result) {
                    console.log("/api/" + table.ip + "/" + type + "/info/write/");
                    for (var i = 0, l = result.length; i < l; i++) {
                        var time = new Date(result[i].time);
                        var tdata = {
                            //tag
                            name: time.toString(),
                            //x y
                            value: [
                                [time.getFullYear(), time.getMonth() + 1, time.getDate()].join("/") + " " + time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds(),
                                table.jsonData(result[i],"w")
                            ]
                        };
                        data2.push(tdata);
                    }
                    console.log(data2);
                    table.addDoubleData(chart, data, data2);
                });
            });
        } else {
            $.get(table.url.init(type, timetype), {}, function (result) {
                console.log("init-url:" + table.url.init(type, timetype));
                for (var i = 0, l = result.length; i < l; i++) {
                    var time = new Date(result[i].time);
                    var tdata = {
                        //tag
                        name: time.toString(),
                        //x y
                        value: [
                            [time.getFullYear(), time.getMonth() + 1, time.getDate()].join("/") + " " + time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds(),
                            table.jsonData(result[i])
                        ]
                    };
                    data.push(tdata);
                }
                console.log(data);
                table.addData(chart, data);
            });
        }

    },
    jsonData: function (jsonobj, type,rw) {
        if(type=="memory"){
            return jsonobj.rate;
        }
        if(type=="cpu"||type=="sysLoad"){
            return jsonobj.usage;
        }
        if(type=="net"||type=="disk"){
            if(rw="r")
                return jsonobj.read;
            else
                return jsonobj.write;
        }

    },
    showTable: function (title, chart, data, type, timetype, stopId, data2) {
        // table.stop(stopId);
        //重置data
        data = []
        // 指定图表的配置项和数据
        if (chart == null) {
            console.log("error: chart=null");
            return;
        }
        var option = table.getOption(title, type, data);
        chart.setOption(option);
        table.start(chart, data, type, timetype, data2);
    },
    getOption: function (title, type, data) {
        var option = null;
        if (type == "net" || type == "disk") {
            option = {
                title: {
                    text: title
                },
                tooltip: {//显示提示框
                    trigger: 'axis',
                    formatter: function (params) {
                        params = params[0];
                        var date = new Date(params.value[0]);
                        return date.getSeconds() + '/' + (date.getMinutes() + 1) + '/' + date.getHours() + ' : ' + params.value[1];
                    },
                    axisPointer: {
                        animation: false
                    }
                },
                xAxis: {
                    type: 'time',
                    splitLine: {
                        show: false
                    }
                },
                yAxis: {
                    type: 'value',
                    // boundaryGap: [0, '100%'],
                    splitLine: {
                        show: false
                    }
                },
                series: [{
                    name: '模拟数据',
                    type: 'line',
                    showSymbol: false,
                    hoverAnimation: true,
                    connectNulls: true,
                    data: data
                }]
            };
        } else {
            option = {
                title: {
                    text: title
                },
                tooltip: {//显示提示框
                    trigger: 'axis',
                    formatter: function (params) {
                        params = params[0];
                        var date = new Date(params.value[0]);
                        return date.getSeconds() + '/' + (date.getMinutes() + 1) + '/' + date.getHours() + ' : ' + params.value[1];
                    },
                    axisPointer: {
                        animation: false
                    }
                },
                xAxis: {
                    type: 'time',
                    splitLine: {
                        show: false
                    }
                },
                yAxis: {
                    type: 'value',
                    // boundaryGap: [0, '100%'],
                    splitLine: {
                        show: false
                    }
                },
                series: [
                    {
                        name: '读入',
                        type: 'line',
                        showSymbol: false,
                        hoverAnimation: true,
                        connectNulls: true,
                        data: data
                    }, {
                        name: '读出',
                        type: 'line',
                        showSymbol: false,
                        hoverAnimation: true,
                        connectNulls: true,
                        data: data
                    }
                ]
            };
        }
        return option;
    }
}
var view = {
    show: function (type, timetype) {
        var chart0 = table.getChart('chart');
        var data0 = [];
        var data1 = [];
        var stopId0 = -1;
        var title = '';
        if (type == "cpu") {
            title = "cpu运行状态";
        }
        if (type == "memory") {
            title = "内存运行状态";
        }
        if (type == "net") {
            title = "网络读写状态";
        }
        if (type == "sysLoad") {
            title = "系统负载状态";
        }
        if (type == "disk") {
            title = "磁盘运行状态";
        }
        if (type == "disk" || type == "net")
            table.showTable(title, chart0, data0, type, timetype, stopId0, data1);
        else
            table.showTable(title, chart0, data0, type, timetype, stopId0);
    },
    sleep: function sleep(n) { //n表示的毫秒数
        var start = new Date().getTime();
        while (true) if (new Date().getTime() - start > n) break;
    }
}
var text = {
    setMaxUsage: function (type) {
        $.get("url", {}, function (result) {
            $("#max_usage").text(result);
            $("#max_usage").text(result);
        })
    }
}