<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>控制台</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<%@include file="common/navbar.jsp"%>
<%@include file="common/sidebar.jsp"%>


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
                            <li class="list-group-item">节点名称: <span id="text_node_name"></span></li>
                            <li class="list-group-item">ip地址: <span id="text_ip_address"></span></li>
                            <li class="list-group-item">操作系统: <span id="text_operation_system"></span></li>
                        </ul>
                    </div>

                    <div class="col-lg-4">
                        <p>
                            描述: <span id="text_description"></span>
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
                                <td><a id="">网络流入</a></td>
                                <td><a id="">网络流出</a></td>
                                <td><a id="">平均负载</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>

        </div>

        <div class="clearfix"></div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading"></div>
                <div class="panel-body">
                    <div id="cpu" style="width: 1000px;height:400px;"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--/.row-->

<!--/.main-->
<%@include file="common/tail.jsp"%>
<script type="text/javascript">
    $(function () {
        var serverinfo = {
            "node_name": "node_1",
            "ip_address": "127.0.0.1",
            "operation_system": "windows10",
            "description": "这是一个描述"
        }
        text.load(serverinfo);
        table.showCpuTable();
    })
    $(function () {
        table.show();
    })
</script>

</body>

</html>