<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" >
                  <div class="layui-form-item">
                      <label for="username" class="layui-form-label">
                          <span class="x-red">*</span>供应商名称
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="name" name="supplierName" required="" lay-verify="required"
                          autocomplete="off" class="layui-input">
                      </div>
                      <!-- <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为您唯一的登入名
                      </div> -->
                  </div>
                  <div class="layui-form-item">
                      <label for="phone" class="layui-form-label">
                          <span class="x-red">*</span>供应商地址
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="address" name="supplierAddress" required=""  lay-verify="required"
                          autocomplete="off" class="layui-input">
                      </div>
                      <!-- <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为您唯一的登入名
                      </div> -->
                  </div>
                  <div class="layui-form-item">
                      <label for="L_email" class="layui-form-label">
                          <span class="x-red">*</span>供应商种类
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="kind" name="supplierKind" required=""  lay-verify="required"
                          autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>主要销售那种商品种类
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label"><span class="x-red">*</span>供应商电话</label>
                      <div class="layui-input-inline">
                        <input type="phone" id="phone" name="supplierPhone" required=""   lay-verify="phone"
                        autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  <div class="layui-form-item">
                      <label for="L_pass" class="layui-form-label">
                          <span class="x-red" style="margin-left:-20px;">*</span><span>供应商银行卡号</span>
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="card" name="supplierCard" required="" lay-verify="number"
                          autocomplete="off" class="layui-input">
                      </div>
                      <!-- <div class="layui-form-mid layui-word-aux">
                          6到16个字符
                      </div> -->
                  </div>
                  <div class="layui-form-item">
                      <label for="L_repass" class="layui-form-label">
                          <span class="x-red">*</span>供应商开户行
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="type" name="cardKind" required="" lay-verify="required"
                          autocomplete="off" class="layui-input">
                      </div>
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
        <script>
       
        layui.use(['form', 'layer','jquery'],
                function() {
                    $ = layui.jquery;
                    var form = layui.form,
                    layer = layui.layer;
                    
                  
                  //监听提交
                    form.on('submit(add)',
                    function(data) {

                     $.ajax({
                            type: "POST",
                            url: "addSupplier",
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
  
        });
        </script>
        <script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
       

    </body>

</html>
