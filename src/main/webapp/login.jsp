<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basepath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登录</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        body{
            background-color: antiquewhite;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-3" style="position: absolute;top: 150px;">
                
                <form action="login" method="post" role="form" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-lg-4 text-center">
                            <legend>CRM系统登陆</legend>
                        </div>
                    </div>
                
                    <div class="form-group" style="margin-top: 20px;">
                        <label for="uname" class="col-lg-1 control-label">工 &nbsp;&nbsp;号</label>
                        <div class="col-lg-3">
                            <input type="text" class="form-control" id="uname" name="userWorkId" placeholder="请输入您的工号">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 30px;">
                        <label for="upass" class="col-lg-1 control-label" style="min-width:85px">密 &nbsp;&nbsp; 码</label>
                        <div class="col-lg-3">
                            <input type="password" class="form-control" id="upass" name="userPass" placeholder="请输入您的密码">
                        </div>
                    </div>
                    <div class="form-group"  style="margin-top: 30px;">
                        <div class="col-lg-3 col-lg-offset-1">
                            <button type="submit" class="btn btn-success btn-block">登录</button>
                        </div>
                    </div>                    
                </form>
            </div>            
        </div>
    </div>
    <script src="js/jquery-2.2.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
