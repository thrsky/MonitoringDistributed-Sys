<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>控制台</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/datepicker3.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">

    <!--Icons-->
    <script src="js/lumino.glyphs.js"></script>

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <span>服务器</span>
                监控
            </a>
            <!-- <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <svg class="glyph stroked male-user">
                            <use xlink:href="#stroked-male-user"></use>
                        </svg>
                        User
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="#">
                                <svg class="glyph stroked male-user">
                                    <use xlink:href="#stroked-male-user"></use>
                                </svg>
                                Profile
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <svg class="glyph stroked gear">
                                    <use xlink:href="#stroked-gear"></use>
                                </svg>
                                Settings
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <svg class="glyph stroked cancel">
                                    <use xlink:href="#stroked-cancel"></use>
                                </svg>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul> -->
        </div>

    </div>
    <!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <form role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Search"></div>
    </form>
    <ul class="nav menu">
        <li>
            <a href="index.html">
                <svg class="glyph stroked dashboard-dial">
                    <use xlink:href="#stroked-dashboard-dial"></use>
                </svg>
                Dashboard
            </a>
        </li>
        <li class="active">
            <a href="charts.jsp">
                <svg class="glyph stroked line-graph">
                    <use xlink:href="#stroked-line-graph"></use>
                </svg>
                运行状态
            </a>
        </li>
        <li>
            <a href="serverList.jsp">
                <svg class="glyph stroked pencil">
                    <use xlink:href="#stroked-pencil"></use>
                </svg>
                服务器列表
            </a>
        </li>
    </ul>
</div>
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

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/easypiechart.js"></script>
<script src="js/easypiechart-data.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="https://cdn.bootcss.com/echarts/3.5.3/echarts.min.js"></script>
<script src="js/main.js"></script>
<script>
    !function ($) {
        $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
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