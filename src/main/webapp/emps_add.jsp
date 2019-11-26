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
	<title>修改客户信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
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
		                        <label for="userId" class="layui-form-label">
		                            <span class="x-red">*</span>用户编号</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="userId" autocomplete="off" name="userId"  class="layui-input"  required="" lay-verify="number" >
		                        </div>
	                        </div>
                		</td>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empName" class="layui-form-label">
		                            <span class="x-red">*</span>姓名</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="empName" autocomplete="off" name="empName"  class="layui-input" required="" lay-verify="required" >
		                        </div>
		                    </div>
                		</td>
                	</tr>
                	
					<tr>
                		<td>
                			<div class="layui-form-item">
		                        <label for="deptId" class="layui-form-label">
		                            <span class="x-red">*</span>部门</label>
		                        <div class="layui-input-inline">
		                            <select id="deptId" name="deptId" class="layui-input">
		                            	<c:forEach items="${deptList }" var="dep">
		                            		<option value="${dep.deptId }" >${dep.deptName }</option>
		                            	</c:forEach>
		                            </select>
		                        </div>
		                    </div>
                		</td>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empSex" class="layui-form-label">
		                            <span class="x-red">*</span>性别</label>
		                        <div class="layui-input-inline">
		                           <select id="empSex" name="empSex" class="layui-input">
		                            		<option value="男" >男</option>
		                            		<option value="女" >女</option>
		                            </select>
		                        </div>
		                    </div>
                		</td>
                	</tr>
                	
                	<tr>
                		<td>
                			<div class="layui-form-item">
		                        <label  class="layui-form-label">
		                            <span class="x-red">*</span>生日</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="empBirthday" autocomplete="off" name="empBirthday"  class="layui-input" required="" lay-verify="required" >
		                        </div>
		                    </div>
                		</td>
                		<td>
                			<div class="layui-form-item">
		                        <label class="layui-form-label">
		                            <span class="x-red">*</span>入职时间</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="empStartwork" autocomplete="off" name="empStartwork"  class="layui-input" required="" lay-verify="required" >
		                        </div>
		                     </div>
                		</td>
                	</tr>
                	
                	<tr>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empEducation" class="layui-form-label">
		                            <span class="x-red">*</span>学历</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="empEducation" name="empEducation"  class="layui-input"  required="" lay-verify="required" ></div>
		                    </div>
                		</td>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empIdentity" class="layui-form-label">
		                            <span class="x-red">*</span>身份证</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="empIdentity" name="empIdentity"  class="layui-input"  required="" lay-verify="number" ></div>
		                     </div>
                		</td>
                	</tr>
                	
                	<tr>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empPhone" class="layui-form-label">
		                            <span class="x-red">*</span>电话</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="empPhone" name="empPhone"  class="layui-input"  required="" lay-verify="phone" ></div>
		                    </div>
                		</td>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empQq" class="layui-form-label">
		                            <span class="x-red">*</span>QQ</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="empQq" name="empQq"  class="layui-input" required="" lay-verify="number" ></div>
		                     </div>
                		</td>
                	</tr>
                	
                	<tr>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empAddress" class="layui-form-label">
		                            <span class="x-red">*</span>住址</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="empAddress" name="empAddress"  class="layui-input"  required="" lay-verify="required" ></div>
		                    </div>
                		</td>
                		<td>
                			<div class="layui-form-item">
		                        <label for="empHometown" class="layui-form-label">
		                            <span class="x-red">*</span>家乡</label>
		                        <div class="layui-input-inline">
		                            <input type="text" id="empHometown" name="empHometown"  class="layui-input" required="" lay-verify="required" ></div>
		                     </div>
                		</td>
                	</tr>

                	<tr>
                		<td colspan="2" align="center">
                			<div class="layui-form-item">
		                        <label for="L_repass" class="layui-form-label"></label>
		                        <button  class="layui-btn" style="width: 120px" lay-filter="add" lay-submit="add" type="button">
		                          	修改
		                      </button>
		                    </div>
                		</td>
                	</tr>
                </table>
               </form>
            </div>
            <!-- 循环结尾 -->
            
        </div>
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
                form.on('submit(add)',
                function(data) {

                 $.ajax({
                        type: "POST",
                        url: "emps_add_agin",
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
            })();</script>
         
    </body>

</html>
