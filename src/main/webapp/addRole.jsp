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
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
    <style type="text/css">
    	table{
    		margin:10px 20px;
    		float:left;
    		border: 1px solid red;
    		width: 400px;
    	}
    	tr {
    		border: 1px solid red;
			width: 400px;
			height: 40px;
			text-align: center;
		}
		td {
			border: 1px solid red;
			width: 400px;
			height: 40px;
		}
    	
    </style>
</head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form style="width: 900px;position: relative;" action="addRolePer" >
                    <div class="layui-inline layui-show-xs-block" style="float: left;width: 500px;margin-bottom: 30px">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>角色名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="roleName" name="roleName" required="required" lay-verify="required" class="layui-input" >
                        </div>
                    </div>
                    
	               	<c:forEach items="${permissionList }" var="per" begin="1">
	               		<table >
	                   	<tr>
	                   		<td style="text-align: center;">
	                   			<input type="checkbox" name="perId" class="chk" value="${per.permissionId }">${per.permissionName } 
	                   		</td>
	                   	</tr>
	                   	<tr style="background-color: white;">
	                   		<td>
	                   			<c:forEach items="${per.perList }" var="pee">
	                   				<input type="checkbox" name="perId" class="chk" value="${pee.perId }">${pee.perName }
	                   			</c:forEach>
	                   		</td>
	                   	</tr>
	                   </table>
	               	</c:forEach>
                    <div style="position: absolute;top: -20px;left: 622px">
                    <!-- style="float: left;width: 400px;height: 80px;margin: 10px 20px;text-align: center;line-height: 80px" -->
                        <button id="add" class="layui-btn" lay-filter="add" lay-submit="" type="button" style="margin-top: 20px">
                          	添加
                      </button>
                      </div>
                </form>
            </div>
            
            
        </div>
        <script >
			$(document).ready(function () {
            	
				$('#add').click(function (e) { 
					var perId=new Array();
	                	$('input[type="checkbox"]:checked').each(function(){  
	                		perId.push($(this).val());//向数组中添加元素  
	                	});
                	var roleName = $('#roleName').val();
					var role= {
							roleName:roleName,
							perId:perId
					};
					console.log(role);
					$.ajax({
	                    type: "POST",
	                    url: "addRolePerList",
	                    data: JSON.stringify(role),
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
        
         /* layui.use(['form', 'layer'],
            function() {
        		
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //监听提交
                form.on('submit(add)',
                function(data) {

                	var perId=new Array();
                	$('input[type="checkbox"]:checked').each(function(){  
                		perId.push($(this).val());//向数组中添加元素  
                	}); 
					var role= {
							roleName:$('#roleName'),
							perId:perId
					}
					console.log(role);
                  $.ajax({
                        type: "POST",
                        url: "addRolePer",
                        data: role,
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
            });  */
         
         </script>
        <script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
    </body>

</html>
