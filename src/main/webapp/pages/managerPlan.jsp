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
<div class=" col-md-2">
			<!--左侧导航栏-->
				<ul class="nav nav-pills nav-stacked">
				
				    <li class="nav-header">
						计划列表
					 </li>
					 <c:forEach items="${planList}" var="plan" varStatus="status">
					 	
					 	<li <c:if test="${status.index eq 0}"> class="active" </c:if> > 
								<a data-toggle="tab" href="#${plan.id }">${plan.name} </a>
						</li>
					 	
					 	
					 		
					 </c:forEach>
					 <li> 
						<a data-toggle="tab" href=#>添加计划</a>
					</li>
				</ul>
			</div>
			<!-- 右侧计划内容栏 -->
			<div class="tab-content col-md-5 ">
			<c:forEach items="${planList }" var="plan" varStatus="status">
				<div class="tab-pane active"id="${plan.id }">
				<h3 class="text-center text-top">
					<b>${plan.name}</b>
					</h3>
					</div>
			</c:forEach>	
		
		</div>
		</div>
		<script type="text/javascript" src="./assets/js/jquery.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./asssets/js/managerPlan.js"></script>
</body>
</html>