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
    <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
</head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form action="getRoleList" class="layui-form layui-col-space5" style="display: inline;">
                                <div class="layui-inline layui-show-xs-block">
                                    <select id="select" name="roleId" class="layui-input" style="display: inline;width: 200px">
                                    	<option value="1" selected="selected" style="color: #80868B">请点击选择角色</option>
                                    	<c:forEach items="${allRole }" var="all">
                                    		<option value="${all.roleId }">${all.roleName }</option>
                                    	</c:forEach>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button type="submit" class="layui-btn" id="cha"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                            <button class="layui-btn" onclick="xadmin.open('添加角色','/dxm/addRole')"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                        	<div style="text-align: center;font-size: 18px;font-weight: 600">${roleById.roleName }权限列表</div>
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr><th>选择</th><th>权限ID</th><th>权限名称</th><th>URL</th><th>角色名</th></tr>
                                </thead>
                                <tbody>
									<c:forEach items="${roleById.permissionList }" var="rpe" varStatus="status">
										<tr ${rpe.permissionType =='menu1'?'style="background-color: #C6F7F5"':'' }>
											<td>${status.count }</td>
											<td>
												${rpe.permissionId }
											</td>
											<td>${rpe.permissionName }</td>
											<td>${rpe.permissionUrl }</td>
											<td>${roleById.roleName }</td>
										</tr>
									</c:forEach>
								</tbody>
               				</table>
                        </div>
                        <%-- <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <c:if test="${pageInfo.pageNum >1 }">
                                  	<a class="prev" href="order_list?pn=${pageInfo.prePage }">&lt;&lt;</a>
                                  </c:if>
                                  <c:if test="${pageInfo.pageNum <=1 }">
                                  	<a class="prev">第一页</a>
                                  </c:if>
                                  <a class="num">共${pageInfo.size }条记录</a>
                                  <a class="num" >共${pageInfo.pages }页</a>
                                  <c:if test="${pageInfo.pageNum < pageInfo.pages}">
                                  	<a class="prev" href="order_list?pn=${pageInfo.nextPage }">&gt;&gt;</a>
                                  </c:if>
                                  <c:if test="${pageInfo.pageNum == pageInfo.pages }">
                                  	<a class="prev">尾页</a>
                                  </c:if>
                                </div>
                            </div>
                        </div> --%>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    
    <script>
    $(document).ready(function () {
        $('#cha').click(function (e) { 
  			var clientId = $('#select').val();
  			console.log(clientId);
            $.ajax({
                type: "POST",
                url: "order_list",
                data: {"clientId":clientId},
                dataType: "json",
                success: function (response) {
                	console.log(response.size);
                }
              });
            
        }); 
    	
    	
    });
    </script>
    
  <script>

      /*用户-删除*/
      function member_del(obj,id){
           layer.confirm('确认要发货吗？',function(index){
              //发异步删除数据
              $.ajax({
                type: "get",
                url: "order_state",
                data: "orderId="+id,
                dataType: "json",
                success: function (response) {
                	
                }
              });
              
              $(obj).parents("tr").remove();
              layer.msg('已发货!',{icon:1,time:1000});
          });
      }
      

    </script>
</html>
