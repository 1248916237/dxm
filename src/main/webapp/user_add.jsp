<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basepath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
    <style >
    	tr{
    		height: 40px;
    	}
    	td{
    		width: 350px;
    	}
    </style>
</head>
    <body>
        <div class="layui-fluid">
        	<!-- 循环起始 -->
            <div class="layui-row">
                <form class="layui-form" >
                <table>
                	<tr>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empName" class="layui-form-label">
		                            <span class="x-red">*</span>姓名</label>
		                        <div class="layui-input-inline">
		                            <select id="empId" name="empId" class="layui-input">
		                            	<c:forEach items="${empsList }" var="emp">
		                            		<option value="${emp.empId }">${emp.empName }</option>
		                            	</c:forEach>
		                            </select>
		                        </div>
		                    </div>
                		</td>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empSex" class="layui-form-label">
		                            <span class="x-red">*</span>部门</label>
		                        <div class="layui-input-inline">
		                           <select id="deptId" name="deptId" class="layui-input">
		                            	<c:forEach items="${deptList }" var="dep">
		                            		<option value="${dep.deptId }">${dep.deptName }</option>
		                            	</c:forEach>
		                            </select>
		                        </div>
		                    </div>
                		</td>
                	</tr>
                	
                	<tr>
                		<td colspan="2" >
                			<div class="layui-form-item">
		                        <label  class="layui-form-label">
		                            <span class="x-red">*</span>角色</label>
		                        <div class="layui-input-inline" style="width: 580px;">
		                        	<c:forEach items="${allRole }" var="role">
		                        		<input type="checkbox" value="${role.roleId }" name="roleList">${role.roleName }
		                        	</c:forEach>
		                        </div>
		                    </div>
                		</td>
                	</tr>
                	
                	<tr>
                		<td colspan="2" align="center">
                			<div class="layui-form-item">
		                        <label for="L_repass" class="layui-form-label"></label>
		                        <button  class="layui-btn" style="width: 120px" lay-filter="add" id="add" lay-submit="add" type="button">
		                          	添加
		                      </button>
		                    </div>
                		</td>
                	</tr>
                </table>
               </form>
            </div>
            <!-- 循环结尾 -->
            
        </div>
<script >
	$(document).ready(function () {
          	
		$('#add').click(function (e) { 
			var roleShu=new Array();
               	$('input[type="checkbox"]:checked').each(function(){  
               		roleShu.push($(this).val());//向数组中添加元素  
               	});
            var empId = $('#empId').val();
            var deptId = $('#deptId').val();
			var user= {
					deptId:deptId,
					empId:empId,
					roleShu:roleShu
			};
			console.log(user);
			$.ajax({
                   type: "POST",
                   url: "user_add_agin",
                   data: JSON.stringify(user),
                   contentType:'application/json', 
                   dataType: "json",
                   success: function (response) {
                   	if (response.resultState==0) {
                   		alert(response.resultMsg);
					} else {
						alert(response.resultMsg);
                    	//关闭当前frame
                           xadmin.close();
                           // 可以对父窗口进行刷新 
                           xadmin.father_reload();
					}
                   }
               });
			
			//js
           });
      	});
      	
 </script>
 
   <script>
   layui.use(['laydate','form'], function(){
       var laydate = layui.laydate;
       var  form = layui.form;
       
       //执行一个laydate实例
       laydate.render({
         elem: '#empBirthday' //指定元素
       });
       
       //执行一个laydate实例
       laydate.render({
         elem: '#empStartwork' //指定元素
       });


     });
   </script>
   <script>layui.use(['form', 'layer'],
       function() {
   		
           $ = layui.jquery;
           var form = layui.form,
           layer = layui.layer;
           
           //监听提交
           form.on('submit(adds)',
           function(data) {

            $.ajax({
                   type: "POST",
                   url: "emps_add_ddagin",
                   data: data.field,
                   dataType: "json",
                   success: function (response) {
                   	layer.alert("添加成功", {
                           icon: 6
                       },
                       function() {
                           //关闭当前frame
                           xadmin.close();

                           // 可以对父窗口进行刷新 
                           xadmin.father_reload();
                       }); 
                   }
               }); 
               return false;
           });

       });</script>
 
<script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
         
    </body>

</html>
