var table = {
    ip: "127.0.0.1",
    now: +new Date(1997, 9, 3),
    fake_value: Math.random() * 1000,
    chart: null,
    data: [],
    getChart: function (divId) {
        table.chart = echarts.init(document.getElementById(divId));
        table.chart.showLoading();
        return table.chart
    },

    setIp: function (ip) {
        table.ip = ip;
    },
    url: function (type, timetype, num) {
        return ["/api", table.ip, type, "info", timetype, num].join("/");
    },
    getData: function (type, timetype, num) {
        $.get(table.url(type, timetype, num), {}, function (result) {
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
        table.chart.setOption({
            series: [{
                data: table.data
            }]
        });
    },

    //模拟数据
    randomData: function () {
        var oneDay = 24 * 3600 * 1000;
        table.now = new Date(+table.now + oneDay);
        table.fake_value = table.fake_value + Math.random() * 21 - 10;
        return {
            //tag
            name: table.now.toString(),
            //x y
            value: [
                [table.now.getFullYear(), table.now.getMonth() + 1, table.now.getDate()].join('/') + " " + table.now.getHours() + ":" + table.now.getMinutes() + ":" + table.now.getSeconds(),
                // Math.round(table.fake_value)
                0.96
            ]
        }
    },
    showTable: function (title) {
        // 指定图表的配置项和数据
        var anchor = [
            {name: '2017/5/14 20:17:00', value: ['2017/5/14 20:17:00', 0]},
            {name: '2017/5/14 20:18:00', value: ['2017/5/14 20:18:00', 0]}
        ];
        var option = {
            title: {
                text: title
            },
            // backgroundColor: '#000000',
            // textStyle: {
            //     color: 'rgba(255, 144, 125, 1)'
            // },
            // tooltip: {//显示提示框
            //     trigger: 'axis',
            //     formatter: function (params) {
            //         params = params[0];
            //         var date = new Date(params.value[0]);
            //         return date.getSeconds() + '/' + (date.getMinutes() + 1) + '/' + date.getHours() + ' : ' + params.value[1];
            //     },
            //     axisPointer: {
            //         animation: false
            //     }
            // },
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
                showSymbol: true,
                hoverAnimation: true,
                connectNulls:true,
                data: table.data
            }
                // ,
                //     {
                //         name: '.anchor',
                //         type: 'line',
                //         showSymbol: true,
                //         data: anchor,
                //         itemStyle: {normal: {opacity: 0}},
                //         lineStyle: {normal: {opacity: 0}}
                //     }
            ]
        };

        var myChart = table.getChart("chart");
        myChart.hideLoading();
        myChart.setOption(option);

        //每一秒调用一次，生成五个数据
        setInterval(function () {
            table.getData(1, 1, 1);
        }, 1000);
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
            view.showCpuTable();
        });
        $('#showMem').click(function () {
            view.showMemTable();
        });
        $('#showDisk').click(function () {
            view.showDiskTable();
        });
    }
}