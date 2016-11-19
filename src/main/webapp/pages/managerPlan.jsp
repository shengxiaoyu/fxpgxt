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
	<div class="tab-content">
	<!--左侧导航栏-->
		<div class=" col-md-2">
				<ul class="nav nav-pills nav-stacked" id="planList">
				    <li class="nav-header">
						计划列表
					 </li>
					 <c:forEach items="${planList}" var="plan" varStatus="status">
					 	<li data-pid=${plan.id }> 
							<a data-toggle="tab" class="xzplan" href="#planDetail${plan.id }" >${plan.name} </a>
						</li>
					 </c:forEach>
					 <li> 
						<a data-toggle="tab" href="#createPlanPlan">添加计划</a>
					 </li>
				</ul>
		</div>
	<!-- 中部计划内容栏 -->
		<div class="tab-content col-md-5 ">
			<c:forEach items="${planList }" var="plan" varStatus="status">
				<div class="tab-pane"id="planDetail${plan.id }" data-pid="${plan.id }" data-paneIndex="${status.index }">
					
				</div>
			</c:forEach>
			<div class="tab-pane" id="createPlanPlan">
				<div class="hero-unit well" >
					<h4>创建计划</h4>
					<div class="form-horizontal">
						<div class="form-group">
							<label class="col-md-3 control-label" for="createdPlanName">计划名称：</label>
							<div class="col-md-5">
								<input id="createdPlanName" type="text" class="form-control"name="planName" >
							</div>
						</div>
						<a class="btn btn-info" id="create-plan-btn">创建</a>
					</div>
				</div>
			</div>	
		</div>
		
	<!-- 右侧识别、演变问题风险排序列表 -->
		<div class="span6 col-md-5">
		<h3 class="text-center"><b>风险推荐</b></h3>
			<div class="sjxz">
			<h4>时间选择：</h4>
				<input id="kssj" type="date" value="${begin }">
				<label>——</label>
				<input id="jssj" type="date" value="${end }">
				&nbsp&nbsp
				<button id="sjxz-btn" class="btn btn-info">确定</button>
			</div>
			<div class="panel">
				<h4>识别风险统计：</h4>
				<table class="table table-striped" id="recognizedRiskTable">
					<thead>
						<tr>
							<th>风险名称</th>
							<th>识别次数</th>
							<th>选择</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
				<a id="recognizedRiskImport" class="btn btn-default" style="float:right" >导入选择风险</a>
			</div>
			<div class="panel">
				<h4>演变风险统计：</h4>
				<table class="table" id="comeTrueRiskTable">
					<thead>
						<tr>
							<th>风险名称</th>
							<th>实现次数</th>
							<th>选择</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<a id="comeTrueRiskImport" class="btn btn-default" style="float:right" >导入选择风险</a>
			</div>
		</div>
	</div>
	
	
	<%--添加风险模态框--%>
<div class="modal fade" id="addRiskModal" tabindex="-1" role="dialog" aria-labelledby="dropCourseModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="dropCourseModalLabel"></h4>
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

<%--删除风险模态框 --%>
<div class="modal fade" id="deleteRiskModal"  tabindex="-1" role="dialog" aria-labelledby="dropCourseModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" ></h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label  class="control-label">风险名称：<input type="text" class="form-control" id="delete-risk-name" readonly="readonly"></label>
                        &nbsp
                        <label  class="control-label">风险内容：<input type="text" class="form-control" id="delete-risk-content" readonly="readonly"> </label>
                        
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="comfirm-delete-btn">确认</button>
            </div>
        </div>
    </div>
</div>

<%--更新计划内风险模态框--%>
<div class="modal fade" id="updateRiskModal" tabindex="-1" role="dialog" aria-labelledby="dropCourseModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="dropCourseModalLabel"></h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="update-risk-name" class="control-label">风险名称:</label>
                        <input type="text" class="form-control"  id="update-risk-name">
                    </div>
                    <div class="form-group">
                        <label for="update-risk-content" class="control-label">风险内容:</label>
                        <input type="text" class="form-control"  id="update-risk-content">
                    </div>
                     <div class="form-group">
                        <label for="update-risk-creator" class="control-label">创建者：</label>
                        <input type="text" class="form-control" readonly="readonly" id="update-risk-creator">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="comfirm-update-btn">确认</button>
            </div>
        </div>
    </div>
</div>
		<script type="text/javascript" src="./assets/js/jquery.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./assets/js/managerPlan.js"></script>
</body>
</html>