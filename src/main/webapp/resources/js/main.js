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
    start: function (chart,data,type,timetype) {
        console.log("start[]timetype="+timetype);
        if(timetype=='1d'){
            console.log("it is 1d");
            table.getInitData(chart,data,type, timetype);
            chart.hideLoading();
        }else{
            table.getInitData(chart,data,type,timetype);
            chart.hideLoading();
            var stopId = setInterval(function () {
                table.getData(chart,data,type, timetype);
            }, table.perTime);
            return stopId;
        }
    },

    /**
     * 添加数据到table 中
     */
    addData: function (chart,data) {
        console.log("add data to table");
        chart.setOption({
            series: [{
                data: data
            }]
        });
    },

    /**
     * get向指定api接口获取数据
     * @param type
     * @param timetype
     * @param num
     */
    getData: function (chart,data,type, timetype) {
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
            table.addData(chart,data);
        });

    },

    /**
     * 获取初始化的数据
     * @param type
     * @param timetype
     */
    getInitData: function (chart,data,type, timetype) {
        console.log("get init data");
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
                        result[i].usage
                    ]
                };
                data.push(tdata);
            }
            console.log(data);
            table.addData(chart,data);
        });
    },
    showTable: function (title,chart,data,type,timetype,stopId) {
        table.stop(stopId);
        //重置data
        data=[]
        // 指定图表的配置项和数据
        var option = {
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
        if(chart==null){
            console.log("error: chart=null");
            return;
        }

        chart.hideLoading();
        chart.setOption(option);
        table.start(chart,data,type,timetype);
    }
}
var view = {
    show: function () {
        var chart0 = table.getChart('chart0');
        var data0 = [];
        var stopId = -1;
        table.showTable("CPU运行状态",chart0,data0,'cpu','1d',stopId);

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