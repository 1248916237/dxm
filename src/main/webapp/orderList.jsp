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
                            <form action="order_list" class="layui-form layui-col-space5" style="display: inline;">
                                <div class="layui-inline layui-show-xs-block">
                                    <!-- <input type="text" name="cilentName" id="uname" placeholder="请输入用户名" autocomplete="off" class="layui-input"> -->
                                    <select id="select" name="clientId" class="layui-input" style="display: inline;width: 200px">
                                    	<option value=000 selected="selected" style="color: #80868B">按客户姓名查找</option>
                                    	<c:forEach items="${clientList.list }" var="cli">
                                    		<option value="${cli.clientId }">${cli.clientName }</option>
                                    	</c:forEach>
                                    </select>
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button type="submit" class="layui-btn" id="cha"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                            <button class="layui-btn" onclick="xadmin.open('添加订单','/dxm/orderPro')"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr><th>订单编号</th><th>下单时间</th><th>客户</th><th>配送方式</th><th>支付情况</th><th>订单状态</th><th>定金支付时间</th><th>总金额</th><th>操作</th> </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${pageInfo.list }" var="order">
                                    <tr>
                                    	<td><a title="订单详情" onclick="xadmin.open('订单详情','/dxm/order_info?orderId=${order.orderId}')" style="color: blue;cursor: pointer;">${order.orderId }</a></td>
                                    	<td> <fmt:formatDate value="${order.orderDate }" pattern="yyyy-MM-dd HH:mm"/></td>
                                    	<td><a title="客户详情" onclick="xadmin.open('客户详情','/dxm/client_info?clientId=${order.clientId}')" style="color: blue;cursor: pointer;">
	                                        	${order.client.clientName }</a>
                                    	</td>
                                    	<td>${order.orderWay }</td>
                                    	<td>
                                    		<c:if test="${order.orderPayment==0 }">已付定金￥${order.orderAllPrice*0.5 }</c:if>
                                    		<c:if test="${order.orderPayment==1 }">已付款</c:if>
                                    	</td>
                                    	<td>
                                    		<c:if test="${order.orderState==2 }">已完成</c:if>
                                    		<c:if test="${order.orderState==1 }"><span style="color: aqua">待付款</span></c:if>
                                    		<c:if test="${order.orderState==0 }"><span style="color: red">待发货</span> </c:if>
                                    	
                                    	</td>
                                    	<td> <fmt:formatDate value="${order.payDate }" pattern="yyyy-MM-dd HH:mm"/></td>
                                    	<td>￥${order.orderAllPrice }.00</td>
                                    	<td class="td-manage">
										   <c:if test="${order.orderPayment==0 }">
										   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											   <a title="尾款支付" onclick="xadmin.open('修改订单','/dxm/order_update?orderId=${order.orderId }')">
		                                       	 <i class="layui-icon">&#xe637;</i>
		                                       </a>
										   </c:if>
										   &nbsp;&nbsp;&nbsp;&nbsp;
										   <c:if test="${order.orderState==0 }">
										   		<button class="layui-btn" style="height:24px;line-height: 24px " onclick="member_del(this,'${order.orderId }')">
										   			 发货
										   		</button>
										   </c:if>
	                                    </td>
	                                   </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
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
