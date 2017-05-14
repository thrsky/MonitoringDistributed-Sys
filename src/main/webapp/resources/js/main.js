var table = {
    URL:{
        cpuUrl : function() {
            return '/api/ip/cpu/day/30'
        }
    },
    showCpuTable : function() {
        var title = "CPU运行状态";
        table.showTable(title);
    },
    showMemTable : function() {
        var title = "内存运行状态";
        table.showTable(title);
    },
    showDiskTable : function() {
        var title = "磁盘运行状态";
        table.showTable(title);
    },
    initTable : function(){
        var myChart = echarts.init(document.getElementById('cpu'));
        myChart.showLoading();
        return myChart;
    },
    showTable : function(title){
        // 指定图表的配置项和数据
        function randomData()    {
            now = new Date(+now + oneDay);
            value = value + Math.random() * 21 - 10;
            return {
                name: now.toString(),
                value: [
                [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
                Math.round(value)
                ]
            }
        }

        var data = [];
        var now = +new Date(1997, 9, 3);
        var oneDay = 24 * 3600 * 1000;
        var value = Math.random() * 1000;
        for (var i = 0; i < 1000; i++) {
            data.push(randomData());
        }

        var option = {
            title: {
                text: title
            },
            // backgroundColor: '#000000',
            // textStyle: {
            //     color: 'rgba(255, 144, 125, 1)'
            // },
            tooltip: {//显示提示框
                trigger: 'axis',
                formatter: function (params) {
                    params = params[0];
                    var date = new Date(params.name);
                    return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
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
                showSymbol: false,
                hoverAnimation: false,
                data: data
            }]
        };

        var myChart = table.initTable();
        myChart.hideLoading();
        myChart.setOption(option);
        setInterval(function () {

            for (var i = 0; i < 5; i++) {
                data.shift();
                data.push(randomData());
            }

            myChart.setOption({
                series: [{
                    data: data
                }]
            });
        }, 1000);
    },
    //
    show : function(){
        $('#showCpu').click(function(){
            table.showCpuTable();
        });
        $('#showMem').click(function(){
            table.showMemTable();
        });
        $('#showDisk').click(function(){
            table.showDiskTable();
        });
    },
    mklog : function(){
        console.log();
    }
}
var text = {
    load : function(serverInfo){
        $('#text_node_name').text(serverInfo.node_name);
        $('#text_ip_address').text(serverInfo.ip_address);
        $('#text_operation_system').text(serverInfo.operation_system);
        $('#text_description').text(serverInfo.description);
    }
}