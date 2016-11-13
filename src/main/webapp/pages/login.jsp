
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/style.css" />
</head>
<body>
<div class="container">
    <section id="content">
        <form action="/login" method="post" style=" text-align:center">
            <h1>欢迎登录风险评估系统</h1>
            <div>
                <input type="text" name="username" placeholder="Username" required="required" id="username" />
            </div>
            <br/>
            <div>
                <input type="password" name="password" placeholder="Password" required="required" id="password" />
            </div>
            <div class="login">
                <input type="submit" value="登录" />
            </div>
        </form>
    </section>
</div>
</body>
</html>
