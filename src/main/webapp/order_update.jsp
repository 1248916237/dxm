<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
   	<link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>

	<style type="text/css">
	.bat
	{
		text-align: right;
	}

</style>
</head>
<body>
 <div class="wrap">
 <c:forEach items="${ordProList }" var="ol">
  <div class="page-title">
    <span class="modular fl"><i class="order"></i><em id="orderId">${ol.orderId }</em></span>
  </div>
  <dl class="orderDetail">
   <dd>
    <ul>
     <li><span class="h-cont h-right">订单状态：</span>
      <span class="h-cont h-left"> 
         <c:if test="${ol.orderState==2 }">已完成</c:if>
         <c:if test="${ol.orderState==1 }"><span style="color: aqua">待付款</span></c:if>
         <c:if test="${ol.orderState==0 }"><span style="color: red">待发货</span> </c:if>
      </span></li>

     <li><span class="h-cont h-right">下单时间：</span>
      <span class="h-cont h-left"><fmt:formatDate value="${ol.orderDate }" pattern="yyyy-MM-dd HH:mm"/></span></li>
	
	
	<c:if test="${ol.orderPayment == 0}">
	  <li style="padding-left: 38px;width: 525px;display: inline;"><span class="h-cont h-right">尾款支付时间：</span>
     	<form class="layui-form layui-col-space5" style="display: inline;">
	       <div class="layui-inline layui-show-xs-block">
	           <input class="layui-input"  autocomplete="off" placeholder="选择尾款支付时间" name="start" id="start">
	       </div>
	    </form>
     </li></c:if>
    </ul>
   </dd>
   <dd>
    <table class="list-style">
     <tr>
      <th>产品名</th>
      <th>单价</th>
      <th>数量</th>
      <th>小计</th>
     </tr>
     <c:forEach items="${ol.opList }" var="olp">
     	<tr>
     		<td class="center">${olp.proDuc.productName }</td>
     		<td class="center"><span><i>￥</i><em>${olp.productPrice }.00</em></span></td>
     		<td class="center">${olp.productNum }</td>
     		<td class="center"><i>￥</i>${olp.productNum * olp.productPrice }.00</td>
     	</tr>
     </c:forEach>
     
     <tr></tr>
     
      <tr>
      <td colspan="5"><div class="fr"><span style="font-size:15px;font-weight:bold;">
         <i>订单共计金额：</i>
         <b>￥${ol.orderAllPrice }.00</b>
        </span>
       </div>
      </td>
     </tr>
    </table>
   </dd>
	<button  class="layui-btn" style="width: 120px;height: 50px" id="tijiao" >修改</button>

  </dl>
  <div>
  	
  </div>
  </c:forEach>
 </div>
</body>
    <script>

      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var  form = layui.form;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        $('#tijiao').click(function(){
        	var payDate = $('#start').val();
        	var orderId = $('#orderId').html();
        	console.log(payDate);
        	$.ajax({
                type: "POST",
                url: "order_paydate",
                data: {"payDate":payDate,"orderId":orderId},
                dataType: "json",
                success: function (response) {
                	confirm("修改成功");
                 	xadmin.father_reload();
                }
            });
        });

      });

 
    </script>
</html>
