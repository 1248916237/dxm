<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form action="getEmpsList" class="layui-form layui-col-space5" style="display: inline;">
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="userId" id="userId" placeholder="请输入账号" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="empName" id="empName" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button type="submit" class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                            <button class="layui-btn" onclick="xadmin.open('添加用户','/dxm/emps_add')"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr><th>账号</th><th>账号状态</th><th>姓名</th><th>性别</th><th>部门</th><th>现住址</th><th>进入公司时间</th><th>电话</th><th>身份证号</th></tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${empsList }" var="emp">
                                    <tr>
                                    	<td>${emp.userId }</td>
                                    	<td>
                                    		<c:if test="${emp.user.userState == 0 }">
                                    			<span style="color: red">已停用</span>
                                    		</c:if>
                                    		<c:if test="${emp.user.userState == 1 }">
                                    			<span >正常使用</span>
                                    		</c:if>
                                    	</td>
                                    	<td>${emp.empName }</td>
                                    	<td>${emp.empSex }</td>
                                    	<td>${emp.dept.deptName }</td>
                                    	<td>${emp.empAddress }</td>
                                    	<td><fmt:formatDate value="${emp.empStartwork }" pattern="yyyy-MM-dd"/> </td>
                                    	<td class="td-status">${emp.empPhone }</td>
                                    	<td class="td-manage">
	                                      <a title="编辑" onclick="xadmin.open('','/dxm/emps_update?userId=${emp.userId}')">
	                                        <i class="layui-icon">&#xe642;</i>
	                                      </a>&nbsp;&nbsp;&nbsp;&nbsp;
	                                      <c:if test="${emp.user.userState == 1 }">
                                    			<a title="停用账号"  onclick="member_del(this,'${emp.userId }','0')">
	                                        		<i class="layui-icon">&#xe640;</i>
	                                      		</a>
                                    	  </c:if>
                                    	  <c:if test="${emp.user.userState == 0 }">
                                    			<a title="启用账号"  onclick="member_del(this,'${emp.userId }','1')">
	                                        		<i class="layui-icon">&#xe62f;</i>
	                                      		</a>
                                    	  </c:if>
	                                    </td>
	                                   </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    
  <script>
      /*用户-删除*/
      function member_del(obj,id,userState){
    	  if(userState == 1){
    		  layer.confirm('确认要启用吗？',function(index){
                  //发异步删除数据
                  $.ajax({
                    type: "get",
                    url: "del_userId",
                    data: {
                    	"userId":id,
                    	"userState":userState
                    },
                    dataType: "json",
                    success: function (response) {
                    	
                    }
                  });
                  xadmin.father_reload();
                  layer.msg('已启用!',{icon:1,time:1000});
              });
    	  }if (userState == 0) {
    		  layer.confirm('确认要停用吗？',function(index){
                  //发异步删除数据
                  $.ajax({
                    type: "get",
                    url: "del_userId",
                    data: {
                    	"userId":id,
                    	"userState":userState
                    },
                    dataType: "json",
                    success: function (response) {
                    	
                    }
                  });
                  xadmin.father_reload();
                  layer.msg('已停用!',{icon:1,time:1000});
              });
		}
          
      }
      

    </script>
</html>
