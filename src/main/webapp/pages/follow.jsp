
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>风险评估系统</title>
    <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
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
<div class="container-fluid">
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">追踪列表</div>

    <table class="table table-striped" style="width:100%;border:1px white solid">
        <tr bgcolor="#4F81BD" style="color: #000;">
            <th style="text-align: center">编号</th>
            <th style="text-align: center">名称</th>
            <th style="text-align: center">内容</th>
            <th style="text-align: center">可能性</th>
            <th style="text-align: center">影响力</th>
            <th style="text-align: center">阈值</th>
            <th style="text-align: center">追踪者</th>
            <th style="text-align: center">起始时间</th>
            <th style="text-align: center">终止时间</th>
            <th style="text-align: center">追踪</th>
        </tr>
		<c:forEach items="${followedModelList}" var="followedRisk"  varStatus="loop">
            <tr >
                <td align="center">${loop.index+1 }</td>
                <td align="center" >${followedRisk.risk_name}</td>
                <td align="center">${followedRisk.risk_content}</td>
                <td align="center">${followedRisk.risk_po}</td>
                <td align="center">${followedRisk.risk_inf}</td>
                <td align="center">${followedRisk.gate}</td>
                <td align="center">${followedRisk.follower}</td>
                <td align="center">${followedRisk.begin}</td>
                <td align="center">${followedRisk.end}</td>
                <td><a onclick="loadFollowRiskModal(this.id)" href="#" 
                data-toggle="modal" data-target="#FollowAddModal" id="${followedRisk.id}:${followedRisk.risk_id}:
                ${followedRisk.risk_name}:${followedRisk.risk_content}:${followedRisk.risk_po}:${followedRisk.risk_inf}:${followedRisk.gate}:
                ${followedRisk.description}:${followedRisk.begin}:${followedRisk.end}">追踪</a></td>
            </tr>
        </c:forEach>
    </table>
        </div>
    </div>
</div>
</div>

<%--追踪风险模态框 --%>
<div class="modal fade" id="FollowAddModal" tabindex="-1" role="dialog" aria-labelledby="chooseCourseModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="FollowAddModalLabel">风险跟踪</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="showfollowed-id" class="control-label">追踪编号:</label>
                        <input type="text" class="form-control" readonly="readonly" id="showfollowed-id">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-id" class="control-label">风险编号:</label>
                        <input type="text" class="form-control" readonly="readonly" id="showRisk-id">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-name" class="control-label">风险名称:</label>
                        <input type="text" class="form-control" readonly="readonly" id="showRisk-name">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-content" class="control-label">风险内容:</label>
                        <input type="text" class="form-control" readonly="readonly" id="showRisk-content">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-possibility" class="control-label">可能性（高中低）:</label>
                        <input type="text" class="form-control"  id="showRisk-possibility">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-level" class="control-label">影响程度（高中低）:</label>
                        <input type="text" class="form-control"  id="showRisk-level">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-gate" class="control-label">触发器/阈值:</label>
                        <input type="text" class="form-control"  id="showRisk-gate">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-description" class="control-label">具体描述:</label>
                        <input type="text" class="form-control"  id="showRisk-description">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-begin" class="control-label">开始时间:</label>
                        <input type="text" class="form-control" readonly="readonly" id="showRisk-begin">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-end" class="control-label">是否结束:</label>
                        <input type="text" class="form-control"  id="showRisk-end">
                    </div>



                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="follow-btn">跟踪</button>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="./assets/js/jquery.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./assets/js/follow.js"></script>
</body>
</html>
