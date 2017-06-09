<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>控制台</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/tag.jsp"%>
</head>

<body>
<%@include file="common/navbar.jsp" %>
<%@include file="common/sidebar.jsp" %>


<!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li>
                <a href="#">
                    <svg class="glyph stroked home">
                        <use xlink:href="#stroked-home"></use>
                    </svg>
                </a>
            </li>
            <li class="active">Icons</li>
        </ol>
    </div>
    <!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">详细信息</div>
                <div class="panel-body">

                    <div class="col-lg-3">
                        <ul class="list-group">
                            <li class="list-group-item">节点名称: ${server.name}</li>
                            <li class="list-group-item">ip地址: ${server.ip}</li>
                            <li class="list-group-item">操作系统: ${server.os}</li>
                        </ul>
                    </div>

                    <div class="col-lg-4">
                        <p>
                            描述: ${server.desc}
                        </p>
                    </div>

                    <div class="col-lg-5">
                        <table class="table table-condensed">
                            <tr>
                                <td><a id="showCpu">cpu</a></td>
                                <td><a id="showMem">内存</a></td>
                                <td><a id="showDisk">磁盘</a></td>
                            </tr>
                            <tr>
                                <td><a id="showNet">网络</a></td>
                                <td><a id="showSysLoad">平均负载</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>

        </div>

        <div class="clearfix"></div>
    </div>

    <c:forEach begin="0" end="4" varStatus="idx">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <button class="btn btn-warning" id="stop_post">stop</button>
                        <button class="btn btn-warning" id="start_post">start</button>
                    </div>
                    <div class="panel-body">
                        <div id="chart${idx}" style="width: 1000px;height:400px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>


    <div class="row">
        <div class="col-log-12">
            <div class="panel panel-default">
                <table class="table">
                    <tr>
                        <td>当前使用率</td>
                        <td>最高使用率</td>
                    </tr>
                    <tr>
                        <td><p id="current_usage">s</p></td>
                        <td><p id="max_usage">s</p></td>
                    </tr>
                </table>
            </div>

        </div>
    </div>
</div>
</div>

<!--/.row-->

<!--/.main-->
<%@include file="common/tail.jsp" %>
<script type="text/javascript">
    $(function () {
//        text.setMaxUsage("hello");
        table.setIp('${server.ip}');
//        table.setIp('115.159.206.169');
//        table.setTypeAndTimeType('cpu','OneDay');
        table.setTypeAndTimeType('cpu','15minutes');

        view.showCpuTable();
        view.show();
    })
</script>

</body>

</html>