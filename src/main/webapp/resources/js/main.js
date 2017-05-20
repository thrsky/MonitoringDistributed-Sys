var table = {
    ip: "127.0.0.1",
    now: +new Date(1997, 9, 3),
    fake_value: Math.random() * 1000,
    chart: null,
    data: [],
    stopId: null,
    //默认为50个数据
    dataLimitCount:50,
    getChart: function (divId) {
        table.chart = echarts.init(document.getElementById(divId));
        table.chart.showLoading();
        return table.chart
    },

    setIp: function (ip) {
        table.ip = ip;
    },
    url: {
        heartbeat: function (type, timetype, num) {
            return ["/api", table.ip, type, "info", timetype, num].join("/");
        },
        init: function (type, timetype) {
            return ["/api", table.ip, type, "init", timetype].join("/");
        }
    },
    stop: function () {
        console.log(table.stopId);
        if (table.stopId != null) {
            clearInterval(table.stopId);
        }
    },

    /**
     *自动get获取数据
     */
    start: function (time) {
        if(time==null){
            console.log('time is null');
            time=2000;
        }
        table.stopId = setInterval(function () {
            table.getData(1, 1, 1);
        }, time);
    },

    /**
     * 添加数据到table 中
     */
    addData: function (data) {
        console.log("add data to table");
        table.chart.setOption({
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
    getData: function (type, timetype, num) {
        $.get(table.url.heartbeat(type, timetype, num), {}, function (result) {
            for (var i = 0, l = result.length; i < l; i++) {
                // table.data.shift();
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
                while (table.data.length > table.dataLimitCount) {
                    console.log("data size:"+table.data.length);
                    table.data.shift();
                }
                table.data.push(tdata);
                console.log(table.data);
            }
        });
        console.log("try to add data log");
        table.addData(table.data);
    },

    /**
     * 获取初始化的数据
     * @param type
     * @param timetype
     */
    getInitData: function (type, timetype) {
        $.get(table.url.init(type, timetype), {}, function (result) {
            for (var i = 0, l = result.length; i < l; i++) {
                // table.data.shift();
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
                table.data.push(tdata);
                console.log(table.data);
            }
        });
        table.addData(table.data);
    },
    // //模拟数据
    // randomData: function () {
    //     var oneDay = 24 * 3600 * 1000;
    //     table.now = new Date(+table.now + oneDay);
    //     table.fake_value = table.fake_value + Math.random() * 21 - 10;
    //     return {
    //         //tag
    //         name: table.now.toString(),
    //         //x y
    //         value: [
    //             [table.now.getFullYear(), table.now.getMonth() + 1, table.now.getDate()].join('/') + " " + table.now.getHours() + ":" + table.now.getMinutes() + ":" + table.now.getSeconds(),
    //             // Math.round(table.fake_value)
    //             0.96
    //         ]
    //     }
    // },
    showTable: function (title) {
        table.stop();
        //重置data
        table.data = [];
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
                    show: true
                }
            },
            yAxis: {
                type: 'value',
                boundaryGap: [0, '100%'],
                splitLine: {
                    show: true
                }
            },
            series: [{
                name: '模拟数据',
                type: 'line',
                showSymbol: true,
                hoverAnimation: true,
                connectNulls: true,
                data: table.data
            }]
        };

        var myChart = table.getChart("chart");
        myChart.hideLoading();
        myChart.setOption(option);
        table.start();
    },
}
var view = {
    showCpuTable: function () {
        var title = "CPU运行状态";
        table.showTable(title);
    },
    showMemTable: function () {
        var title = "内存运行状态";
        table.showTable(title);
    },
    showDiskTable: function () {
        var title = "磁盘运行状态";
        table.showTable(title);
    },
    show: function () {
        $('#showCpu').click(function () {
            console.log(table.stopId);
            view.showCpuTable();
        });
        $('#showMem').click(function () {
            view.showMemTable();
        });
        $('#showDisk').click(function () {
            view.showDiskTable();
        });
        $('#stop_post').click(function () {
            table.stop();
        });
        $('#start_post').click(function () {
            table.start();
        });
    }
}