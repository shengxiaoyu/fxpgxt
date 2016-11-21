<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:forEach items="${list}" var="row" varStatus="status">
		<tr>
		
			<td>${row.riskName }</td>
			<td>${row.time }</td>
			<td><input type="checkbox" value="${row.riskId }"></input></td>
		</tr>
	</c:forEach>