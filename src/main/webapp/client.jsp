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
</head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form action="client_list" class="layui-form layui-col-space5" style="display: inline;">
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="cilentName" id="uname" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button type="submit" class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                            <button class="layui-btn" onclick="xadmin.open('添加用户','/dxm/client_add.jsp')"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr><th>ID</th><th>用户名</th><th>性别</th><th>手机</th><th>地址</th><th>银行卡号</th><th>种类</th><th>操作</th></tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${clientList.list }" var="client">
                                    <tr>
                                    	<td>${client.clientId }</td>
                                    	<td><a onclick="xadmin.open('客户订单详情','/dxm/client_order?clientId=${client.clientId}')">${client.clientName }</a></td>
                                    	<td>${client.clientSex }</td>
                                    	<td>${client.clientPhone }</td>
                                    	<td>${client.clientAddress }</td>
                                    	<td>${client.clientCard }</td>
                                    	<td class="td-status">${client.cardKind }</td>
                                    	<td class="td-manage">
	                                      <a title="编辑" onclick="xadmin.open('修改页面','/dxm/client_update?clientId=${client.clientId}')">
	                                        <i class="layui-icon">&#xe642;</i>
	                                      </a>&nbsp;&nbsp;&nbsp;&nbsp;
	                                      <a title="删除"  onclick="member_del(this,'${client.clientId }')">
	                                        <i class="layui-icon">&#xe640;</i>
	                                      </a>
	                                    </td>
	                                   </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <c:if test="${clientList.pageNum >1 }">
                                  	<a class="prev" href="client_list?pn=${clientList.prePage }">&lt;&lt;</a>
                                  </c:if>
                                  <c:if test="${clientList.pageNum <=1 }">
                                  	<a class="prev">第一页</a>
                                  </c:if>
                                  <a class="num">共${clientList.size }条记录</a>
                                  <a class="num" >共${clientList.pages }页</a>
                                  <c:if test="${clientList.pageNum < clientList.pages}">
                                  	<a class="prev" href="client_list?pn=${clientList.nextPage }">&gt;&gt;</a>
                                  </c:if>
                                  <c:if test="${clientList.pageNum == clientList.pages }">
                                  	<a class="prev">尾页</a>
                                  </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    
  <script>
      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $.ajax({
                type: "get",
                url: "del_client",
                data: "clientId="+id,
                dataType: "json",
                success: function (response) {
                	
                }
              });
              
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }
      

    </script>
</html>
