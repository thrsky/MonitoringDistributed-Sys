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
            <li class="active"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#new">
                添加服务器？
            </button></li>
        </ol>
    </div>
    <!--/.row-->
    <div class="modal fade" id="new" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form class="form-horizontal" id="new_modal_form" method="post" action="/api/warnMessage/create">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">添加方式</h4>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="id" id="modal_id"/>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">要求</label>
                            <span>服务器已安装Java</span>
                        </div>
                        <hr>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">步骤1</label>
                            <span>下载 http://www.thrsky.top/assets/server/init.sh</span>
                        </div>
                        <hr>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">步骤2</label>
                            <span>执行init.sh文件</span>
                        </div>
                        <hr>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">步骤3</label>
                            <span>使用本web项目</span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@include file="common/serverList.jsp"%>

<!--/.row-->

<!--/.main-->
<%@include file="common/tail.jsp"%>

</body>

</html>