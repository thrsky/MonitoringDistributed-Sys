<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>控制台-服务器总览</title>

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
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">
          <span>服务器</span>
          监控
        </a>
      </div>

    </div>
    <!-- /.container-fluid --> </nav>

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
          <li>
            <a href="charts.jsp">
              <svg class="glyph stroked line-graph">
                <use xlink:href="#stroked-line-graph"></use>
              </svg>
              运行状态
            </a>
          </li>
          <li class="active">
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

          <!-- 服务器列表 -->
          <div class="col-sm-12">
            <div class="panel panel-default">
              <div class="panel-heading" style="height: 50px">节点名称：<span id="#name">node1</span></div>
              <!-- <div class="panel-body">
            </div> -->
            <table class="table">
             <tr>
              <th></th>
              <th>查看</th>
              <th>ip地址</th>
              <th>cpu</th>
              <th>内存</th>
              <th>磁盘</th>
              <th>运行状态</th>
            </tr>
            <tr>
              <td><input type="checkbox" name=""></td>
              <td><a href="#">查看监控状态</a></td>
              <td>ip</td>
              <td>i3 1Ghz</td>
              <td>1G</td>
              <td>400G</td>
              <td><span class="label label-success">运行中</span></td>
            </tr>
          </table>
        </div>
      </div>

       <div class="col-sm-12">
            <div class="panel panel-default">
              <div class="panel-heading" style="height: 50px">节点名称：<span id="#name">node1</span></div>
              <!-- <div class="panel-body">
            </div> -->
            <table class="table">
             <tr>
              <th></th>
              <th>查看</th>
              <th>ip地址</th>
              <th>cpu</th>
              <th>内存</th>
              <th>磁盘</th>
              <th>运行状态</th>
            </tr>
            <tr>
              <td><input type="checkbox" name=""></td>
              <td><a href="#">查看监控状态</a></td>
              <td>ip</td>
              <td>i3 1Ghz</td>
              <td>1G</td>
              <td>400G</td>
              <td><span class="label label-success">运行中</span></td>
            </tr>
          </table>
        </div>
      </div>


      <div class="clearfix"></div>
    </div>

        <!-- <div class="row">
          <div class="col-lg-12">
            <div class="panel panel-default">
              <div class="panel-heading"></div>
              <div class="panel-body">
                <div id="cpu" style="width: 1000px;height:400px;"></div>
              </div>
            </div>
          </div>
        </div> -->
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
         $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
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



   </script>

 </body>

 </html>