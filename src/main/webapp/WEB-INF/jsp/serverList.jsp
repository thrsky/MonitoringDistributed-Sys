<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>控制台-服务器总览</title>
    <%@include file="common/head.jsp"%>
</head>

<body>
<%@include file="common/navbar.jsp"%>
<%@include file="common/sidebar.jsp"%>

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
        <c:forEach items="${list}" var="server">
            <div class="col-sm-12">
                <div class="panel panel-default">
                    <div class="panel-heading" style="height: 50px">节点名称：<span id="#name">${server.name}</span></div>
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
                            <td><a href="#{server.ip}/info">查看监控状态</a></td>
                            <td>#{server.ip}</td>
                            <td>#{server.cpu}</td>
                            <td>#{server.memory}</td>
                            <td>#{server.disk}</td>
                            <td><span class="label label-success">#{server.status}</span></td>
                        </tr>
                    </table>
                </div>
            </div>
        </c:forEach>

        <div class="clearfix"></div>
    </div>

<!--/.row-->

<!--/.main-->
<%@include file="common/tail.jsp"%>

</body>

</html>