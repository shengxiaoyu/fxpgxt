
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<meta charset="gbk">
<title>登陆界面</title>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>"></base>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="assets/js/jquery-1.11.3.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
</head>
<body>
<div class="container">
	<div class="row">
		<div class ="col-md-12 ">
			<h2 class="text-center">
				欢迎登陆风险评估系统
			</h2>
			<br/>
			<br/>
			<br/>
			<br/>
			<form class="form-horizontal" action="login.do" method="post">
		   <!-- 
		    	<div class="from-group">
				    <label class="control-label col-md-2 col-sm-offset-3">账户类型</label>
					<div class="col-sm-3">
					    <select name="userType" class="form-control">
						    <option>用户</option>
							<option>追踪者</option>
							<option>管理员</option>
						</select>
					</div>
				</div>
				
				<br/>
				 
				<br/>
				<br/>
				-->
				<div class="form-group">
				<label class="col-sm-2 control-label col-sm-offset-3" for="inputEmail">帐户</label>
					<div class="col-sm-3">
						<input id="inputEmail" type="text" name="username" class="form-control" placeholder="User"/>
					</div>
				</div>
				
				<div class="from-group">
					<label class="col-sm-2 control-label col-sm-offset-3" for="inputPassword">密码</label>
					<div class="col-sm-3">
						<input id="inputPassword" type="password" name="password" class="form-control" placeholder="Password"/>
					</div>
				</div>
				<br/>
				
				<div class="form-group">
				<br/><br/>
			   <!-- 
			    <div class ="col-sm-offset-5 col-sm-6">
					<div class="checkbox">
						 <label ><input type="checkbox" /> Remember me</label> 
					</div>
					<br/>
				</div>
				 -->
				<div class="from-group">
				    <div class ="col-sm-offset-5 col-sm-6">
				        <button type="submit" class="btn btn-default">登陆</button> 
				    	<a class="btn btn-default col-md-offset-1" href="pages/register.jsp">注册</a>
					</div>
				</div>
			    </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
