
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>"></base>
    <meta charset="gbk">
    <title>注册界面</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/w3note.css">
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
                欢迎注册风险评估系统
            </h2>
            <br/>
            <br/>
            <br/>
            <br/>
            <form class="form-horizontal" action="register.do" method="post">

                <br/>
                <br/>
                <br/>
                <div class="form-group">
                    <label class="col-sm-2 control-label col-sm-offset-3" for="inputEmail">帐 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp户</label>
                    <div class="col-sm-3">
                        <input id="inputEmail" type="text" name="username" class="form-control" placeholder="User"/>
                    </div>
                </div>
                <div class="from-group">
                    <label class="col-sm-2 control-label col-sm-offset-3" for="inputPassword">密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码</label>
                    <div class="col-sm-3">
                        <input id="inputPassword" type="password" name="password" class="form-control" placeholder="Password"/>
                    </div>
                </div>
                <br/><br/><br/>
                <div class="from-group">
                    <label class="col-sm-2 control-label col-sm-offset-3" for="inputPassword">确认密码</label>
                    <div class="col-sm-3">
                        <input id="inputPassword2" type="password" name="confirmPassword" class="form-control" placeholder="Password"/>
                    </div>
                </div>
                <br/>
                <div class="form-group">
                    <br/><br/>


                    <div class="from-group">
                        <div class ="col-sm-offset-5 col-sm-6">
                            <button type="submit" class="btn btn-default">注册</button>
                            <a class="btn btn-default col-md-offset-1" href="pages/login.jsp">已有账号登录</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
