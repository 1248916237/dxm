<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <base href="<%=basepath %>" >
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
    </head>
    
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">演示</a>
                <a>
                    <cite>导航元素</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
                <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
            </a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                    
                        <div class="layui-card-body ">
                            <form action="selHouseProduct" class="layui-form layui-col-space5">
                            
                                <div class="layui-input-inline layui-show-xs-block">
                                    <select name="houseProductState">
                                        <option value="">仓库产品状态</option>
                                        <option value="0">正常</option>
                                        <option value="1">缺货</option>
                                        </select>
                                </div>
                                
                                <div class="layui-input-inline layui-show-xs-block">
                                    <input type="text" name="productName" placeholder="请输入产品名" autocomplete="off" class="layui-input"></div>
                                
                                
                                <div class="layui-input-inline layui-show-xs-block">
                                    <input type="text" name="houseProductId" placeholder="请输入仓库产号" autocomplete="off" class="layui-input"></div>
                               
                                
                                 <div class="layui-input-inline layui-show-xs-block">
                                    <input type="text" name="productId" placeholder="请输入产品编号" autocomplete="off" class="layui-input"></div>
                                
                                
                                 <div class="layui-input-inline layui-show-xs-block">
                                    <input type="text" name="productNum" placeholder="请输入产品数量" autocomplete="off" class="layui-input"></div>
                                <div class="layui-input-inline layui-show-xs-block">
                                    	<input class="layui-btn" type="submit" value="搜索" lay-filter="sreach">
                                        
                                </div>
                                
                            </form>
                        </div>
                        
                        
                        <div class="layui-card-header">
                            
                            <button class="layui-btn" onclick="xadmin.open('添加仓库产品','./addhouseproduct.jsp',700,500)">
                                <i class="layui-icon"></i>添加</button></div>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                                <thead>
                                    <tr>
                                        <th>仓库产品编号</th>
                                        <th>产品编号</th>
                                        <th>产品名</th>
                                        <th>仓库名</th>
                                        <th>仓库产品数量</th>
                                        <th>仓库产品状态</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${pageinfo.list }" var="p">
                                		<tr>
                                			<td>${p.houseProductId}</td>
                                			<td>${p.productId}</td>
                                			<td>${p.product.productName}</td>
                                			<td><c:if test="${p.houseId==1}">1号库</c:if><c:if test="${p.houseId==2}">2号库</c:if>
                                			</td>
                                			<td>${p.productNum}</td>
                                			<td class="td-status">
                                			     <c:if test="${p.houseProductState ==1}">缺货</c:if>
                                                 <c:if test="${p.houseProductState ==0}">正常</c:if>
                                            </td>
                                			<td class="td-manage">
                                            <a title="修改" onclick="xadmin.open('修改','/dxm/updateHouseProduct?houseProductId=${p.houseProductId}')" href="javascript:;">
                                                <i class="layui-icon">&#xe63c;</i></a>
                                            <a title="删除" onclick="member_del(this,'${p.houseProductId }')" href="javascript:;">
                                                <i class="layui-icon">&#xe640;</i></a> 
                                            </td>	
                                		</tr>
                                	
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <c:if test="${pageinfo.pageNum >1 }">
                                  	<a class="prev" href="getHouseProduct?pn=${pageinfo.prePage }">&lt;&lt;</a>
                                  </c:if>
                                  <c:if test="${pageinfo.pageNum <=1 }">
                                  	<a class="prev">第一页</a>
                                  </c:if>
                                  <a class="num" href="#">共${pageinfo.size }条记录</a>
                                  <a class="num" href="#">共${pageinfo.pages }页</a>
                                  <c:if test="${pageinfo.pageNum < pageinfo.pages}">
                                  	<a class="prev" href="getHouseProduct?pn=${pageinfo.nextPage }">&gt;&gt;</a>
                                  </c:if>
                                  <c:if test="${pageinfo.pageNum == pageinfo.pages }">
                                  	<a class="prev">尾页</a>
                                  </c:if>
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>layui.use(['laydate', 'form'],
        function() {
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#start' //指定元素
            });

            //执行一个laydate实例
            laydate.render({
                elem: '#end' //指定元素
            });
        });

        /*用户-停用*/
        function member_stop(obj, id) {
            layer.confirm('确认要停用吗？',
            function(index) {

                if ($(obj).attr('title') == '启用') {

                    //发异步把用户状态进行更改
                    $(obj).attr('title', '停用');
                    $(obj).find('i').html('&#xe62f;');

                    $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                    layer.msg('已停用!', {
                        icon: 5,
                        time: 1000
                    });

                } else {
                    $(obj).attr('title', '启用');
                    $(obj).find('i').html('&#xe601;');

                    $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                    layer.msg('已启用!', {
                        icon: 5,
                        time: 1000
                    });
                }

            });
        }

        /*用户-删除*/
           function member_del(obj, id) 
       		{
        	   layer.confirm('确认要删除吗？',
   	            function(index) {
   	                //发异步删除数据
   	                //$(obj).parents("tr").remove();
	   	            $.ajax({
	                     type: "post",
	                     url: "delHouseProduct",
	                     data: {"houseProductId":id},
	                     dataType: "json",
	                     success: function (response) 
	                     {
	                    	 console.log(response);
	  	                      $(obj).parents("tr").remove();
	  	                      layer.msg(
	                    		  '已删除!',
	                    		  {
	                         		 icon: 1,
	                         		 time: 1000
	                     		  }
                      		   );
	  	                }
	           		});
   	                
   	            });
        	
        	
        	
        	   
       		}
       

        function delAll(argument) {

            var data = tableCheck.getData();

            layer.confirm('确认要删除吗？' + data,
            function(index) {
                //捉到所有被选中的，发异步进行删除
                layer.msg('删除成功', {
                    icon: 1
                });
                $(".layui-form-checked").not('.header').parents('tr').remove();
            });
        }</script>
</html>