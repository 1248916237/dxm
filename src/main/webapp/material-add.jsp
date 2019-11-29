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
	<title>Insert title here</title>
    <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        <script type="text/javascript" src="./js/jquery.min.js"></script>
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
                      <label for="matName" class="layui-form-label">
                          <span class="x-red">*</span>原材料名称
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="matName" required="" lay-verify="required"
                          autocomplete="off" class="layui-input">
                      </div>
                      <!-- <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为您唯一的登入名
                      </div> -->
                  </div>
                  <div class="layui-form-item">
                      <label for="phone" class="layui-form-label">
                          <span class="x-red">*</span>原材料用途
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="matIntro"  required=""  lay-verify="required"
                          autocomplete="off" class="layui-input">
                      </div>
                      <!-- <div class="layui-form-mid layui-word-aux">
                          <span class="x-red">*</span>将会成为您唯一的登入名
                      </div> -->
                  </div>
                  <div class="layui-form-item">
                      <label for="materialPrice" class="layui-form-label">
                          <span class="x-red">*</span>原材料单价
                      </label>
                      <div class="layui-input-inline">
                          <input type="text" id="materialPrice"  required=""  lay-verify="required"
                          autocomplete="off" class="layui-input">
                      </div>
                  </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label" for="houseId"><span class="x-red">*</span>仓库编号</label>
                      <div class="layui-input-inline">
                      <select name="" id="houseId"  lay-verify="required">
                      <c:forEach items="${selHouse }" var="sh">
                          <option value="${sh.houseId }">${sh.houseId }、${sh.houseName }</option>
                      </c:forEach>
                       </select>
                    </div>
                  </div>
                  <div class="layui-form-item">
                      <label class="layui-form-label" for="supplierId"><span class="x-red">*</span>采购商编号</label>
                      <div class="layui-input-inline">
                      <select  id="supplierId" lay-verify="required">
                      <c:forEach items="${selSupplierId }" var="ss">
                          <option value="${ss.supplierId }">${ss.supplierId }、${ss.supplierName }</option>
                          </c:forEach>
                       </select>
                    </div>
                  </div>
                  <div class="layui-form-item">
                       <label for="addAll" class="layui-form-label">
                      </label> 
                    <button  class="layui-btn" type="button" id="addAll" >
                          增加
                      </button> 
                 
                  </div>
              </form>
            </div>
        </div>
        <script>
       
         layui.use(['form', 'layer','jquery'], 
                
                    $('#addAll').click(function() {
                    	
                    	var data={
                    			supplierId:$('#supplierId').val(),
                    			materialPrice:$('#materialPrice').val(),
                    			materialName:$('#matName').val(),
                    	        materialIntro:$('#matIntro').val(),
                    	        houseId:$('#houseId').val()
                    	};
                    	
                    	console.log(data);
                    	$.ajax({
                    		type: "POST",
                    	    url:"addMatSupplier",
                    	    data:data,
                    	    dataType: "json",
                    	    success: function (response) 
                    	    {
                    	    	 if(response)
                    	    		{ 
                    	    	 layer.alert("添加原材料成功！", {
                                     icon: 6
                                 },
                               
                    	    	 function() {
                                     //关闭当前frame
                                     xadmin.close();

                                     // 可以对父窗口进行刷新 
                                     xadmin.father_reload();
                                 }
                                 );
                    	    		 } 
                    	    	
                    	    },
                    		
                    	});
                    	
                    })
                  
                    
                  //监听提交
               
  
       ); 
        </script>
     
       

    </body>

</html>
