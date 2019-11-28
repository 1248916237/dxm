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
	<title>修改客户信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
    <style type="text/css">
    	body{
    		font-size: 16px;
    	}
    	.inp{
    		width: 150px;
    		height: 35px;
    		outline: none;
    		border: 1px solid rgb(155, 155, 235);
    		border-radius: 5px;
    	}
    	th{
    		width: 220px;
    		height: 50px
    	}
    	input hover{
    		border: 1px solid blue;
    	}
    </style>
</head>
    <body>
       <div>
       	<table style="margin: 50px">
       		<tr>
       			<td style="width: 320px;height: 50px">
       				订单编号：
       				<input class="inp" autocomplete="off" required="" lay-verify="required" type="text" id="orderId" placeholder="点击自动生成">
       				<input type="hidden">
       			</td>
       			<td style="width: 320px;height: 50px">
       				下单客户：
       				<select  class="inp" name="" id="clientId">
       					<c:forEach items="${clientList.list }" var="cli">
       						<option value="${cli.clientId }">${cli.clientName }</option>
       					</c:forEach>
       				</select>
       			</td>
       		</tr>
       		<tr>
       			<td style="width: 320px;height: 50px">
       				付款情况：
       				<select  class="inp" name="" id="orderPayment">
       					<option value="1">已付款</option>
       					<option value="0">已定金</option>
       				</select>
       			</td>
       			<td style="width: 320px;height: 50px">
       				发货方式：
       				<select class="inp"  name="" id="orderWay">
       					<option value="快递">快递</option>
       					<option value="自取">自取</option>
       				</select>
       			</td>
       		</tr>
       		<tr>
       			<td style="width: 320px;height: 50px" colspan="2">
       				订单状态：
       				<select  class="inp" name="" id="orderState">
       					<option value="0">待发货</option>
       					<option value="1">待付尾款</option>
       				</select>
       			</td>
       		</tr>
       		</table>
       		<table style="margin: 50px">
       		<tr>
       			<td colspan="3" style="text-align: center;"><span style="font-size: 18px">添加产品</span></td>
       		</tr>
       		<tbody id="tbody">
       			<tr>
       				<th>产品名</th>
       				<th>数量</th>
       				<th>操作</th>
       			</tr>
       			
       		</tbody>

       		<tr>
       			<td>	
       			    <select class="inp" style="width: 220px" name="" id="productId">
       					<c:forEach items="${proList }" var="pro">
       						<option value="${pro.productId }">${pro.productId }、${pro.productName }&nbsp;￥${pro.productPrice }.00</option>
       					</c:forEach>
       				</select>
       				
       			</td>
       			<td style="text-align:center;">
       				<input class="inp" type="text" required="" lay-verify="required" id="productNum" autocomplete="off" style="padding-left: 10px"> 
       			</td>
       			<td>
       				<button id="proAdd" style="width: 120px;height: 35px;border-radius:4px;border:1px solid #dddddd" type="button">+</button>
       			</td>
       		</tr>
       	</table>
       </div>
       <div style="margin-left: 250px">
       	<button class="layui-btn" style="width: 200px" id="add" ><i class="layui-icon"></i>添加</button>
       </div>
    </body>
       <script>
       	  function del(tr)
       	  {
       		  tr.parentNode.parentNode.remove();
       	  }
       
           $(document).ready(function () {
                $('#orderId').click(function (e) { 
                   var orderId = new Date().getTime();
                   console.log(orderId);
                   $('#orderId').val(orderId);
               });
                
                $('#proAdd').click(function(e){
                	var productId = $('#productId').val();
                	
                	var productNum = $('#productNum').val();
                	var tr = $('<tr class="data"><th>'+productId+'</th><th>'+productNum+'</th><th><button id="proDel" style="width: 40px;height: 35px;border-radius:4px;border:1px solid #dddddd" type="button" onclick="del(this)" >-</button></th></tr>');
                	$('#tbody').append(tr);
                	/* $('#productNum').val(''); */
                });
                
                /* $('#proDel').click(function(e){
                	
                }); */
            	
            	$('#add').click(function(){
            		var orderProductList = [];
            		$('.data').each(function(){
            			var children = $(this).children();
            			console.log(children[0]);
            			var child = {productId:children[0].innerHTML,productNum:children[1].innerHTML};
            			orderProductList.push(child);
            		});
            		
            		var data = {
            			id:$('#orderId').val(),
            			clientId:$('#clientId').val(),
            			orderState:$('#orderState').val(),
            			orderPayment:$('#orderPayment').val(),
            			orderWay:$('#orderWay').val(), 
            			orderProductList:orderProductList
            		};
            		
            		$.ajax({
                        type: "POST",
                        url: "order_add",
                        data: JSON.stringify(data),
                        contentType:'application/json',
                        dataType: "json",
                        success: function (response) {
                        	confirm("添加成功");
                         	xadmin.father_reload(); 
                        }
                    });
            		
            		
            	});
           });
       </script>
</html>
