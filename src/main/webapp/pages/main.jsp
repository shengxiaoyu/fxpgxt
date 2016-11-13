
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>风险评估系统</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <style>
        body { padding-top: 100px; }
        .user-icon {
            width: 30px;
            height: 30px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">风险管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/index">首页 <span class="sr-only">(current)</span></a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <a class="btn btn-default" href="#" data-toggle="modal" data-target="#addRiskModal">添加风险</a>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><img
                            src="/assets/img/user.jpg" alt="用户" class="user-icon"> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人中心</a></li>
                        <li><a href="/logout">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
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
                        <th>创建时间</th>
                        <th>跟踪</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody id="risk-list">
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</div>

<%--退课模态框--%>
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
                        <label for="risk-possibility" class="control-label">可能性（高中低）:</label>
                        <input type="text" class="form-control"  id="risk-possibility">
                    </div>
                    <div class="form-group">
                        <label for="risk-level" class="control-label">影响程度 高中低）:</label>
                        <input type="text" class="form-control"  id="risk-level">
                    </div>
                    <div class="form-group">
                        <label for="risk-gate" class="control-label">触发器/阈值:</label>
                        <input type="text" class="form-control"  id="risk-gate">
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


<%--删除风险--%>
<div class="modal fade" id="deleteRiskModal" tabindex="-1" role="dialog" aria-labelledby="dropCourseModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="deleteRiskModalLabel"> 确认删除风险<sapn id="deleteRiskSpan"></sapn></h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="comfirm-delete-btn">确认</button>
            </div>
        </div>
    </div>
</div>




<%--选课模态框--%>
<div class="modal fade" id="FollowAddModal" tabindex="-1" role="dialog" aria-labelledby="chooseCourseModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="FollowAddModalLabel">跟踪风险</h4>
            </div>
            <div class="modal-body">
                <form>
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
                        <input type="text" class="form-control" readonly="readonly" id="showRisk-possibility">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-level" class="control-label">影响程度（高中低）:</label>
                        <input type="text" class="form-control" readonly="readonly" id="showRisk-level">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-gate" class="control-label">触发器/阈值:</label>
                        <input type="text" class="form-control" readonly="readonly" id="showRisk-gate">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-creator" class="control-label">提交者:</label>
                        <input type="text" class="form-control" readonly="readonly" id="showRisk-creator">
                    </div>
                    <div class="form-group">
                        <label for="showRisk-follower" class="control-label">跟踪者:</label>
                        <input type="text" class="form-control" readonly="readonly" id="showRisk-follower">
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
<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/assets/js/course.js"></script>
<script>
    //loadChooseModal();
    deleteRisk();
    followRisk();
    loadAddModal();
    loadCourses();
</script>
</body>
</html>
