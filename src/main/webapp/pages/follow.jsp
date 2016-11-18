
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
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">追踪列表</div>

    <table style="width:100%;border:1px white solid">
        <tr bgcolor="#4F81BD" style="color: #fff;">
            <th style="text-align: center">编号</th>
            <th style="text-align: center">名称</th>
            <th style="text-align: center">内容</th>
            <th style="text-align: center">可能性</th>
            <th style="text-align: center">影响力</th>
            <th style="text-align: center">阈值</th>
            <th style="text-align: center">追踪者</th>
            <th style="text-align: center">起始时间</th>
            <th style="text-align: center">终止时间</th>
        </tr>

        <c:forEach items="${managements}" var="row"  varStatus="loop">
            <tr >
                <td align="center" >${row.id}</td>
                <td align="center" >${row.name}</td>
                <td align="center">${row.content}</td>
                <td align="center">${row.po}</td>
                <td align="center">${row.impact}</td>
                <td align="center">${row.gate}</td>
                <td align="center">${row.follower}</td>
                <td align="center">${row.begin}</td>
                <td align="center">${row.end}</td>
            </tr>
        </c:forEach>
    </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="./assets/js/jquery.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./assets/js/follow.js"></script>
</body>
</html>
