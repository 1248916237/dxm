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
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" >
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="clientName" name="clientName" required="" lay-verify="required" class="layui-input" ></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_pass" class="layui-form-label">
                            <span class="x-red">*</span>性别</label>
                        <div class="layui-input-inline">
                            <input type="text" id="clientSex" name="clientSex" required="" lay-verify="required" class="layui-input" ></div>
                        <div class="layui-form-mid layui-word-aux"></div></div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>电话</label>
                        <div class="layui-input-inline">
                           <input type="text" id="clientPhone" name="clientPhone" required="" lay-verify="phone"  class="layui-input" ></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_pass" class="layui-form-label">
                            <span class="x-red">*</span>地址</label>
                        <div class="layui-input-inline">
                            <input type="text" id="clientAddress" name="clientAddress" required="" lay-verify="required" class="layui-input" ></div>
                        <div class="layui-form-mid layui-word-aux">6到16个字符</div></div>
                     <div class="layui-form-item">
                        <label for="L_pass" class="layui-form-label">
                            <span class="x-red">*</span>银行卡号</label>
                        <div class="layui-input-inline">
                            <input type="text" id="clientCard" name="clientCard" required="" lay-verify="number" class="layui-input" ></div>
                        <div class="layui-form-mid layui-word-aux"></div></div>
						<div class="layui-form-item">
                        	<label for="L_username" class="layui-form-label">
                            	<span class="x-red">*</span>开户行</label>
                        	<div class="layui-input-inline">
                            <input type="text" id="cardKind" name="cardKind" required="" lay-verify="required" class="layui-input" >
                            <input type="hidden" id="userId" name="userId" required="" lay-verify="required" class="layui-input" value="1">
                            <input type="hidden" id="clientAge" name="clientAge" required="" lay-verify="required" class="layui-input" value="122">
                            </div>
                    	</div>
                    	<div class="layui-form-item">
                        	<label for="L_username" class="layui-form-label">
                            	<span class="x-red"></span>客户状态</label>
                        	<div class="layui-input-inline">
                            <input type="text" id="clientState" name="clientState" required="" lay-verify="required" class="layui-input" >
                            </div>
                    	</div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                        <button  class="layui-btn" lay-filter="add" lay-submit="">
                          	添加
                      </button>
                      </div>
                </form>
            </div>
        </div>
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
                        url: "client_add",
                        data: data.field,
                        dataType: "json",
                        success: function (response) {
                        	layer.alert("添加成功", {
                                icon: 6
                            },
                            function() {
                                //关闭当前frame
                                //xadmin.close();

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
