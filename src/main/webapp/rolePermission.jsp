<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basepath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Insert title here</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <style type="text/css">
    	.tab{
    		border: 1px solid black;
    		
    	}
    	td{
    		width: 120px;
    		height: 30px;
    		border: 1px solid black;
    		text-align: center;
    		background-color: white;
    	}
    </style>
</head>
<body>
	<div>
			<c:forEach items="${roleList }" var="role">
				<input type="checkbox" name=""  lay-skin="primary">
				${role.roleName }
			</c:forEach>
	</div>
	<div class="layui-card-body layui-table-body layui-table-main">
		<c:forEach items="${permissionList }" var="per" begin="1">
			<p>${per.permissionName }</p>
			<table class="layui-table layui-form">
				<thead>
                  <tr>
                  	<th>选择</th><th>权限ID</th><th>权限</th><th>路径</th><th>操作</th>
                  </tr>
                </thead>
                <tbody>
					<c:forEach items="${per.perList }" var="pee">
						<tr>
							<td><input type="checkbox" name=""  lay-skin="primary"></td>
							<td>${pee.perId }</td>
							<td>${pee.perName }</td>
							<td>${pee.perUrl }</td>
							<td>操作</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</c:forEach>
		
	</div>
</body>
</html>
