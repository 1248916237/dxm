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
    <span class="modular fl"><i class="order"></i><em>${ol.orderId }</em></span>
  </div>
  <dl class="orderDetail">
   <dd>
    <ul>
     <li><span class="h-cont h-right">订单状态：</span>
      <span class="h-cont h-left">
      <c:if test="${ol.orderState == 0}">待发货</c:if>
      <c:if test="${ol.orderState == 1}">待付全款</c:if>
      <c:if test="${ol.orderState == 2}">已完成</c:if>
      </span></li>

     <li><span class="h-cont h-right">下单时间：</span>
      <span class="h-cont h-left"><fmt:formatDate value="${ol.orderDate }" pattern="yyyy-MM-dd HH:mm"/></span>
     </li>
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
     		<td class="center"> ${olp.productNum }</td>
     		<td class="center"><i>￥</i>${olp.productNum * olp.productPrice }.00</td>
     	</tr>
     </c:forEach>
     
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
  </dl>
  </c:forEach>
 </div>
</body>

</html>
