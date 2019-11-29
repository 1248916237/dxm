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
                            <form action="getPermissionList" class="layui-form layui-col-space5" style="display: inline;">
                                <div class="layui-inline layui-show-xs-block">
                                    <select id="select" name="roleId" class="layui-input" style="display: inline;width: 200px">
                                    	<option value="1" selected="selected" style="color: #80868B">功能开发中敬请期待</option>
                                    	<%-- <c:forEach items="${allRole }" var="all">
                                    		<option value="${all.roleId }">${all.roleName }</option>
                                    	</c:forEach> --%>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button type="button" class="layui-btn" disabled="disabled"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                            <button class="layui-btn" onclick="xadmin.open('添加角色','/dxm/addPermission')"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr><th>选择</th><th>权限ID</th><th>权限名称</th><th>URL</th><th>操作</th></tr>
                                </thead>
                                <tbody>
									<c:forEach items="${permissionList }" var="rpe" varStatus="status">
										<tr ${rpe.permissionType =='menu1'?'style="background-color: #C6F7F5"':'' }>
											<td>${status.count }</td>
											<td>
												${rpe.permissionId }
											</td>
											<td>${rpe.permissionName }</td>
											<td>${rpe.permissionUrl }</td>
											<td>
												<a title="编辑"  onclick="xadmin.open('编辑','updatePermission?permissionId=${rpe.permissionId }')" href="javascript:;">
                                      				<i class="layui-icon">&#xe642;</i>
                                    			</a>
                                    			<c:if test="${rpe.permissionUrl==null }">
                                    				<a title="删除" onclick="member_del(this,${rpe.permissionId })" href="javascript:;">
			                                    		<i class="layui-icon">&#xe640;</i>
			                                    	</a>
                                    			</c:if>
			                                    
											</td>
										</tr>
										<c:forEach items="${rpe.perList }" var="pee">
											<tr>
												<td>${status.count }</td>
												<td>
													${pee.perId }
												</td>
												<td>${pee.perName }</td>
												<td>${pee.perUrl }</td>
												<td>
													<a title="编辑"  onclick="xadmin.open('编辑','updatePermission?permissionId=${pee.perId }')" href="javascript:;">
	                                      				<i class="layui-icon">&#xe642;</i>
	                                    			</a>
	                                    			<c:if test="${pee.perUrl==null }">
	                                    				<a title="删除" onclick="member_del(this,${pee.perId })" href="javascript:;">
				                                    		<i class="layui-icon">&#xe640;</i>
				                                    	</a>
	                                    			</c:if>
				                                    
												</td>
											</tr>
										</c:forEach>
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
           layer.confirm('确认删除吗？',function(index){
              //发异步删除数据
              $.ajax({
                type: "POST",
                url: "delPermission",
                data: {"permissionId":id},
                dataType: "json",
                success: function (response) {
                	
                }
              });
              xadmin.father_reload();
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }
      

    </script>
</html>
