<%--
  Created by IntelliJ IDEA.
  User: xjy
  Date: 2017/5/20
  Time: 上午9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="row">

    <!-- 服务器列表 -->
    <c:forEach items="${serverList}" var="server">
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
                        <td><a href="${server.ip}/info">查看监控状态</a></td>
                        <td>${server.ip}</td>
                        <td>${server.cpu}</td>
                        <td>${server.memory}</td>
                        <td>${server.disk}</td>
                        <td><span class="label label-success">${server.status}</span></td>
                    </tr>
                </table>
            </div>
        </div>
    </c:forEach>

    <div class="clearfix"></div>
</div>
