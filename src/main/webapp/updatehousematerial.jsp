<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <base href="<%=basepath %>" >
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]--></head>
    
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form">
                	
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            
                        <div class="layui-input-inline">
                            <input type="hidden" id="houseMaterialId" name="houseMaterialId" value="${sel.houseMaterialId }" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div>
                    
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>原材料编号</label>
                        <div class="layui-input-inline">
                            <input type="text" id="materialId" name="materialId" value="${sel.materialId }" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>原材料名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="username" disabled="disabled" name="username" value="${sel.material.materialName }" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>仓库名</label>
                   			<div class="layui-input-inline">
                            <select id="houseId" name="houseId" class="valid">
                            	<option value="1" ${sel.houseId  ==1 ?'selected':''} > 一号库</option>
                            	<option value="2"  ${sel.houseId  ==2 ?'selected':''} >二号库</option>
                             </select>   
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>原材料数量</label>
                        <div class="layui-input-inline">
                            <input type="text" id="materialNumber" name="materialNumber" value="${sel.materialNumber }" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>仓库原材料状态</label>
                        <div class="layui-input-inline">
                            <select id="materialState" name="materialState" class="valid">
                            	<option value="1" ${sel.materialState  ==1 ?'selected':''} > 缺货</option>
                            	<option value="0"  ${sel.materialState  ==0 ?'selected':''} >正常</option>
                             </select>   
                        </div>
                    </div>
                   
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"></label>
            <button class="layui-btn" lay-filter="add" lay-submit="">修改</button></div>
        </form>
        </div>
        </div>
        <script>layui.use(['form', 'layer'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //监听提交
                form.on
                (
		                'submit(add)',
		                function(data)
		                {
		                	
		                	console.log('---');
		                    $.ajax
		                    ({
		                        type: "POST",
		                        url: "updatehm",
		                        data: data.field,
		                        dataType: "json",
		                        success: function (response)
		                        {
		                        	layer.alert(
	                        			"修改成功", 
	                        			{icon: 6 },
	                            		function()
	                            			{
				                                //关闭当前frame
				                                xadmin.close();
				
				                                // 可以对父窗口进行刷新 
				                                xadmin.father_reload();
			                                }
	                       			); 
		                         }
		                     }); 
		               		 return false;
	                }
                );

                

            });</script>
        <script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
    </body>

</html>