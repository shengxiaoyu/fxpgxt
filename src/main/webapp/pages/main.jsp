
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>风险评估系统</title>
    <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/w3note.css">
    <style>
        body { padding-top: 100px; }
        .user-icon {
            width: 30px;
            height: 30px;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<!-- 风险列表 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">风险列表</div>
                <!-- Table -->
                <table class="table table-striped" id="resourceTable">
                    <thead>
                    <tr>
                        <th>风险编号</th>
                        <th>风险名称</th>
                        <th>创建者</th>
                        <th>内容</th>
                        <th>指派</th>
                       <!-- 
                        <th>删除</th> --> 
                    </tr>
                    </thead>
                    <tbody id="risk-list">
                    	
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
	<div class="col-md-12">
		
	</div>
</div>

<%--添加风险模态框--%>
<div class="modal fade" id="addRiskModal" tabindex="-1" role="dialog" aria-labelledby="dropCourseModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="dropCourseModalLabel">添加风险</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="risk-name" class="control-label">风险名称:</label>
                        <input type="text" class="form-control"  id="risk-name">
                    </div>
                    <div class="form-group">
                        <label for="risk-content" class="control-label">风险内容:</label>
                        <input type="text" class="form-control"  id="risk-content">
                    </div>
                     <div class="form-group">
                        <label for="risk-creator" class="control-label">创建者：</label>
                        <input type="text" class="form-control" readonly="readonly" id="risk-creator" value="${user.name }">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="comfirm-add-btn">确认</button>
            </div>
        </div>
    </div>
</div>

<%--指派风险模态框 --%>
<div class="modal fade" id="assignRiskModal"  tabindex="-1" role="dialog" aria-labelledby="dropCourseModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" ></h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label  class="control-label">风险名称：<input type="text" class="form-control" id="assign-risk-name" readonly="readonly"></label>
                        &nbsp
                        <label  class="control-label">风险内容：<input type="text" class="form-control" id="assign-risk-content" readonly="readonly"> </label>
                        
                    </div>
                </form>
                <form>
                <label  class="control-label">可指派人员：</label>
               	 <div>
               	 <c:forEach  items="${followers }" var="follower">
                	<p style="margin: 5px 42px 10px">&nbsp&nbsp<input type="checkbox" name="follower" value="${follower.name }">${follower.name }</p>
                </c:forEach>
                </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="comfirm-assign-btn">确认</button>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="./assets/js/jquery.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./assets/js/main.js"></script>

</body>
</html>
