<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>控制台-服务器总览</title>
    <%@include file="common/head.jsp" %>
</head>

<body>
<%@include file="common/navbar.jsp" %>
<%@include file="common/sidebar.jsp" %>

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
        <div class="col-sm-12">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">告警规则列表
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#new">
                        new Message
                    </button>
                </div>

                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th style="width: 600px">名称</th>
                        <th>状态</th>
                        <th>临界值</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="item">
                        <tr>
                            <th scope="row">${item.id}</th>
                            <td>${item.title}</td>
                            <%--<td>${item.status}</td>--%>
                            <td><c:choose>
                                <c:when test="${item.status==1}">监控中</c:when>
                                <c:otherwise>暂停使用</c:otherwise>
                            </c:choose></td>
                            <td>${item.warnLine}</td>
                            <%--<td><c:if test="${item.status==1}">监控中</c:if>--%>
                            <%--<td><c:if test="${item.status==1}">暂停使用</c:if>--%>
                            <td><a type="button" class="warnMessageBtnUpdate" id="${item.id}" data-toggle="modal"
                                   data-target="#myModal">
                                编辑
                            </a>|<a type="button" class="warnMessageBtnDelete" id="${item.id}" data-toggle="modal"
                                    data-target="#delete">删除</a>|
                                <c:choose>
                                    <c:when test="${item.status==1}">
                                        <a type="button" class="warnMessageBtnStop" id="${item.id}" data-toggle="modal"
                                           data-target="#stop">暂停</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a type="button" class="warnMessageBtnStart" id="${item.id}" data-toggle="modal"
                                           data-target="#start">启用</a>
                                    </c:otherwise>
                                </c:choose>
                                <%--<a type="button" class="warnMessageBtnStop" id="${item.id}" data-toggle="modal"--%>
                                    <%--data-target="#stop">暂停</a>--%>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!--/.row-->
    <!--/.main-->
    <%@include file="common/tail.jsp" %>


    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form class="form-horizontal" id="modal_form" method="post">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">告警规则</h4>
                    </div>
                    <div class="modal-body">
                        <%--<div class="form-group">--%>
                        <%--<label class="col-sm-2 control-label">id</label>--%>
                        <%--<div class="col-sm-10">--%>
                        <input type="hidden" name="id" id="modal_id"/>
                        <%--</div>--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">标题</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="modal_title" name="title"
                                       placeholder="title">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">对指定服务器监控</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="ip" id="modal_ip_type">
                                    <c:forEach var="server" items="${serverList}">
                                        <option value="${server.ip}">${server.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">监控项目</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="item" id="modal_monitor_type">
                                    <option value="cpu">cpu</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">方式</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="type" id="modal_type">
                                    <option value="1">大于</option>
                                    <option value="0">等于</option>
                                    <option value="-1">小于</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">百分比</label>
                            <div class="col-sm-10">
                                <input type="text" name="warnLine" class="form-control" id="modal_percentage">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">发送到该邮箱</label>
                            <div class="col-sm-10">
                                <input type="email" name="email" class="form-control" id="modal_email">
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-primary" value="submit"/>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="new" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form class="form-horizontal" id="new_modal_form" method="post" action="/api/warnMessage/create">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">告警规则</h4>
                    </div>
                    <div class="modal-body">
                        <%--<div class="form-group">--%>
                        <%--<label class="col-sm-2 control-label">id</label>--%>
                        <%--<div class="col-sm-10">--%>
                        <input type="hidden" name="id" id="modal_id"/>
                        <%--</div>--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">标题</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="new_modal_title" name="title"
                                       placeholder="title">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">对指定服务器监控</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="ip" id="new_modal_ip_type">
                                    <c:forEach var="server" items="${serverList}">
                                        <option value="${server.ip}">${server.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">监控项目</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="item" id="new_modal_monitor_type">
                                    <option value="cpu">cpu</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">方式</label>
                            <div class="col-sm-10">
                                <select class="form-control" name="type" id="new_modal_type">
                                    <option value="1">大于</option>
                                    <option value="0">等于</option>
                                    <option value="-1">小于</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">百分比</label>
                            <div class="col-sm-10">
                                <input type="text" name="warnLine" class="form-control" id="new_modal_percentage">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">发送到该邮箱</label>
                            <div class="col-sm-10">
                                <input type="email" name="email" class="form-control" id="new_modal_email">
                            </div>
                        </div>


                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-primary" value="submit"/>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">
                    确认删除？
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a type="button" id="btn-confirm-delete" class="btn btn-primary">确认删除</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="stop" tabindex="-1" role="dialog" aria-labelledby="myModalLabe2">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabe2">Modal title</h4>
                </div>
                <div class="modal-body">
                    确认暂停？
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a type="button" id="btn-confirm-stop" class="btn btn-primary">确认暂停</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="start" tabindex="-1" role="dialog" aria-labelledby="myModalLabe3">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabe3">Modal title</h4>
                </div>
                <div class="modal-body">
                    确认启用？
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a type="button" id="btn-confirm-start" class="btn btn-primary">确认启用</a>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    $(".warnMessageBtnUpdate").click(function () {
        console.log($(this).attr('id'));
        var id = $(this).attr('id');
        $.get('/api/warnMessage/' + id, {}, function (result) {
            console.log(result);
            $('#modal_id').val(result.id);
            $('#modal_title').val(result.title);
            $('#modal_percentage').val(result.warnLine);
            $('#modal_monitor_type').val("cpu");
            $('#modal_type').val(result.type);
            $('#modal_email').val(result.email);
            $('#modal_form').attr('action', '/api/warnMessage/update');
        })
    });
    $(".warnMessageBtnDelete").click(function () {
        console.log($(this).attr('id'));
        var id = $(this).attr('id');
        $('#btn-confirm-delete').attr('href', '/api/warnMessage/' + id + '/delete');
    });
    $(".warnMessageBtnStop").click(function () {
        console.log($(this).attr('id'));
        var id = $(this).attr('id');
        $('#btn-confirm-stop').attr('href', '/api/warnMessage/' + id + '/stop');
    });
    $(".warnMessageBtnStart").click(function () {
        console.log($(this).attr('id'));
        var id = $(this).attr('id');
        $('#btn-confirm-start').attr('href', '/api/warnMessage/' + id + '/start');
    });
</script>

</html>

