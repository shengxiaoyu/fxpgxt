<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h3 class="text-center text-top">
		<b>${plan.name}</b>
	</h3>
	<div class="panel panel-default">
		<div class="panel-heading">计划${plan.id }风险列表</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>风险编号</th>
					<th>风险名称</th>
					<th>内容</th>
					<th>指派</th>
					<th>更新</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody id="planRiskList">
				<c:forEach items="${riskList }" var="risk" varStatus="status">
				<tr>
					<td>${risk.id }</td>
					<td>${risk.name }</td>
					<td>${risk.content }</td>
					<td><a onclick="loadAssignRiskModal(this.id)" href="#" data-toggle="modal" data-target="#assignRiskModal" id='${risk.id }:${risk.name }:${risk.creator}:${risk.content }'>指派</a></td>
					<td><a onclick="loadUpdateModel(this.id)" data-toggle="modal" data-target="#updateRiskModal" id='${risk.id }:${risk.name }:${risk.creator}:${risk.content }:${plan.id }'>更新</a></td>
					<td><a onclick="loadDeleteRiskModal(this.id)" data-toggle="modal" data-target="#deleteRiskModal" id='${risk.id }:${risk.name }:${risk.creator}:${risk.content }:${plan.id }'>删除</a></td>
				</tr>
				</c:forEach>
				<tr> <td colspan="6"><a onclick="loadAddModal(this.id)" href="#" data-toggle="modal" id="${plan.id }" class="btn btn-default" data-target="#addRiskModal">添加风险</a></td></tr>
			</tbody>
		</table>
	</div>