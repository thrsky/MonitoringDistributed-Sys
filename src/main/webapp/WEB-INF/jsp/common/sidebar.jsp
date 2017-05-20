<%--
  Created by IntelliJ IDEA.
  User: xjy
  Date: 2017/5/14
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <form role="search">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Search"></div>
    </form>
    <ul class="nav menu">
        <li>
            <a href="/index">
                <svg class="glyph stroked dashboard-dial">
                    <use xlink:href="#stroked-dashboard-dial"></use>
                </svg>
                Dashboard
            </a>
        </li>
        <%--<li class="active">--%>
            <%--<a href="info">--%>
                <%--<svg class="glyph stroked line-graph">--%>
                    <%--<use xlink:href="#stroked-line-graph"></use>--%>
                <%--</svg>--%>
                <%--运行状态--%>
            <%--</a>--%>
        <%--</li>--%>
        <li>
            <a href="/serverList">
                <svg class="glyph stroked pencil">
                    <use xlink:href="#stroked-pencil"></use>
                </svg>
                服务器列表
            </a>
        </li>
        <li>
            <a href="/serverList">
                <svg class="glyph stroked pencil">
                    <use xlink:href="#stroked-pencil"></use>
                </svg>
                告警设置
            </a>
        </li>
    </ul>
</div>