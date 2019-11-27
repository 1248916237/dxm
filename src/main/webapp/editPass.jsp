<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 	<link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>

	    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form">
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>登录名
                      </label>
                      <div class="layui-input-inline" style="line-height: 38px">
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <span style="color: black;font-weight: 600;"><shiro:principal property="userId"></shiro:principal></span>
                      </div>
                  </div>
                  
                  <div class="layui-form-item">
                      <label for="L_pass" class="layui-form-label">
                          	旧密码
                      </label>
                      <div class="layui-input-inline">
                          <input type="password" id="L_pass" name="pass" required="" lay-verify="pass"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          6到16个字符
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="repass" class="layui-form-label">
                          	新密码
                      </label>
                      <div class="layui-input-inline">
                          <input type="password" id="repass" name="repass" required="" lay-verify="repass"
                          autocomplete="off" class="layui-input">
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="lepass" class="layui-form-label">
                          	确认密码
                      </label>
                      <div class="layui-input-inline">
                          <input type="password" id="lepass" name="lepass" required="" lay-verify="repass"
                          autocomplete="off" class="layui-input">
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="R_repass" class="layui-form-label"></label>
                      <div class="layui-input-inline" id="msg" style="color: red"></div>
                  </div>
                  <div class="layui-form-item">
                  	
                      <label for="L_repass" class="layui-form-label">
                      </label>
                      <button  class="layui-btn" lay-filter="add" lay-submit="">
                         	 增加
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

                //自定义验证规则
                form.verify({
                    nikename: function(value) {
                        if (value.length < 5) {
                            return '昵称至少得5个字符啊';
                        }
                    },
                    /* pass: [/(.+){6,12}$/, '密码必须6到12位'], */
                    repass: function(value) {
                        if ($('#lepass').val() != $('#repass').val()) {
                            return '两次密码不一致';
                        }
                    }
                });

              //监听提交
                form.on('submit(add)',
                function(data) {

                 $.ajax({
                        type: "POST",
                        url: "editPass",
                        data: data.field,
                        dataType: "json",
                        success: function (response) {
                        	if (response.resultState==1) {
                        		layer.alert("修改成功", {icon: 6 },function() {xadmin.close();xadmin.father_reload();});
							}else {
								$('#msg').html(response.resultMsg);
								setTimeout(() => {
									$('#msg').html("");
								}, 1000);
							}
                        	 
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
