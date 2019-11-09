<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
主页
<a href="quanxian">权限</a>

 		<%--  <shiro:principal></shiro:principal>	--%>
 		
 		<shiro:hasPermission name="客户管理">
			有用户管理权限 		
 		</shiro:hasPermission>
 		<shiro:lacksPermission name="客户管理">
 			没有用户管理权限 
 		</shiro:lacksPermission>
		
	
 		<c:forEach items="${listPer }" var="rl" begin="0">
			<p>${rl.permissionName }</p>
			
 			<c:forEach items="${rl.perList}" var="pl">
				<p>-----${pl.perName }</p>
			</c:forEach> 
		</c:forEach>
		
</body>
</html>
