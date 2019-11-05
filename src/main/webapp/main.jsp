<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basepath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Insert title here</title>
</head>
<body>
登陆成功<br>
一大波列表<br>
一大波列表<br>
一大波列表<br>
一大波列表<br>
<a href="logout">退出</a>
<a href="adds">添加</a>
</body>
</html>
