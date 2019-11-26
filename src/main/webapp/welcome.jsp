<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>

<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basepath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>欢迎页面</title>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body onload="showtime()">
       <div class="layui-fluid">
           <div class="layui-row layui-col-space15">
               <div class="layui-col-md12">
                   <div class="layui-card">
                       <div class="layui-card-body ">
                           <blockquote class="layui-elem-quote">欢迎管理员：
                               <span class="x-red"><shiro:principal property="userId"></shiro:principal></span>
<%--                                 <%
									Date d = new Date();
									SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String now = df.format(d);
								%>
								当前时间：<%=now %> --%>
							<span id="time"></span>
                           </blockquote>
                       </div>
                   </div>
               </div>
               <div class="layui-col-md12">
                   <div class="layui-card">
                       <div class="layui-card-header">数据统计</div>
                       <div class="layui-card-body ">
                           <ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">
                               <li class="layui-col-md2 layui-col-xs6">
                                   <a href="javascript:;" class="x-admin-backlog-body">
                                       <h3>文章数</h3>
                                       <p>
                                           <cite>66</cite></p>
                                   </a>
                               </li>
                               <li class="layui-col-md2 layui-col-xs6">
                                   <a href="javascript:;" class="x-admin-backlog-body">
                                       <h3>会员数</h3>
                                       <p>
                                           <cite>12</cite></p>
                                   </a>
                               </li>
                               <li class="layui-col-md2 layui-col-xs6">
                                   <a href="javascript:;" class="x-admin-backlog-body">
                                       <h3>回复数</h3>
                                       <p>
                                           <cite>99</cite></p>
                                   </a>
                               </li>
                               <li class="layui-col-md2 layui-col-xs6">
                                   <a href="javascript:;" class="x-admin-backlog-body">
                                       <h3>商品数</h3>
                                       <p>
                                           <cite>67</cite></p>
                                   </a>
                               </li>
                               <li class="layui-col-md2 layui-col-xs6">
                                   <a href="javascript:;" class="x-admin-backlog-body">
                                       <h3>文章数</h3>
                                       <p>
                                           <cite>67</cite></p>
                                   </a>
                               </li>
                               <li class="layui-col-md2 layui-col-xs6 ">
                                   <a href="javascript:;" class="x-admin-backlog-body">
                                       <h3>文章数</h3>
                                       <p>
                                           <cite>6766</cite></p>
                                   </a>
                               </li>
                           </ul>
                       </div>
                   </div>
               </div>
 <!--               <div class="layui-col-sm6 layui-col-md3">
                   <div class="layui-card">
                       <div class="layui-card-header">下载
                           <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>
                       <div class="layui-card-body  ">
                           <p class="layuiadmin-big-font">33,555</p>
                           <p>新下载
                               <span class="layuiadmin-span-color">10%
                                   <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>
                           </p>
                       </div>
                   </div>
               </div>
               <div class="layui-col-sm6 layui-col-md3">
                   <div class="layui-card">
                       <div class="layui-card-header">下载
                           <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>
                       <div class="layui-card-body ">
                           <p class="layuiadmin-big-font">33,555</p>
                           <p>新下载
                               <span class="layuiadmin-span-color">10%
                                   <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>
                           </p>
                       </div>
                   </div>
               </div> 
               <div class="layui-col-sm6 layui-col-md3">
                   <div class="layui-card">
                       <div class="layui-card-header">下载
                           <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>
                       <div class="layui-card-body ">
                           <p class="layuiadmin-big-font">33,555</p>
                           <p>新下载
                               <span class="layuiadmin-span-color">10%
                                   <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>
                           </p>
                       </div>
                   </div>
               </div>
               <div class="layui-col-sm6 layui-col-md3">
                   <div class="layui-card">
                       <div class="layui-card-header">下载
                           <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>
                       <div class="layui-card-body ">
                           <p class="layuiadmin-big-font">33,555</p>
                           <p>新下载
                               <span class="layuiadmin-span-color">10%
                                   <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>
                           </p>
                       </div>
                   </div>
               </div>-->
               <div class="layui-col-md12">
                   <div class="layui-card">
                       <div class="layui-card-header">系统信息</div>
                       <div class="layui-card-body ">
                           <table class="layui-table">
                               <tbody>
                                   <tr>
                                       <th>CRM系统版本</th>
                                       <td>1.0.180420</td></tr>
                               </tbody>
                           </table>
                       </div>
                   </div>
               </div>
               <div class="layui-col-md12">
                   <div class="layui-card">
                       <div class="layui-card-header">开发团队</div>
                       <div class="layui-card-body ">
                           <table class="layui-table">
                               <tbody>
                                   <tr>
                                       <th>版权所有</th>
                                       <td>襄阳思创教育</td>
                                   </tr>
                                   <tr>
                                       <th>开发者</th>
                                       <td>刘强军、颜增、何江涛</td></tr>
                               </tbody>
                           </table>
                       </div>
                   </div>
               </div>
               <div class="layui-col-md12">
                   <blockquote class="layui-elem-quote layui-quote-nm">感谢cctv,本系统由思创金老师提供技术支持。</blockquote>
               </div>
           </div>
       </div>
<script>

	function showtime ()
	{
		var today,hour,second,minute,year,month,date;
		var strDate ;
		today=new Date();
		var n_day = today.getDay();
		switch (n_day)
			{
			    case 0:{
			      strDate = "星期日";
			    }break;
			    case 1:{
			      strDate = "星期一";
			    }break;
			    case 2:{
			      strDate ="星期二";
			    }break;
			    case 3:{
			      strDate = "星期三";
			    }break;
			    case 4:{
			      strDate = "星期四";
			    }break;
			    case 5:{
			      strDate = "星期五";
			    }break;
			    case 6:{
			      strDate = "星期六";
			    }break;
			    case 7:{
			      strDate = "星期日";
			    }break;
			}
		year = today.getYear()+1900;
		month = today.getMonth()+1;
		date = today.getDate();
		hour = today.getHours();
		
		minute =today.getMinutes();
		if (minute < 10) {
			minute = '0' + minute
		}
		second = today.getSeconds();
		if (second < 10) {
			second = '0' + second
		}
		
		document.getElementById('time').innerHTML =year + "-" + month + "-" + date + "-" +"   " + hour + ":" + minute + ":" + second + " " + strDate;
		setTimeout("showtime();", 1000); /* 设定函数自动执行时间为 1000 ms(1 s) */
	}
</script>
</body>
</html>
