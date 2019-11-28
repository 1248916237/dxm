<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5" action="selMatSupplier" method="post" style="display: inline;">
                               <div class="layui-inline layui-show-xs-block">
                                   <input type="text" name="materialName"  placeholder="请输入原材料名称关键字" autocomplete="off" class="layui-input">
                               </div>
                               <div class="layui-inline layui-show-xs-block">
                                   <button class="layui-btn" type="submit" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                               </div>
                            </form>
                            <button class="layui-btn" onclick="xadmin.open('添加原材料','selHouse',800,500)"><i class="layui-icon"></i>添加</button>
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button> 
                            
                        </div>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form">
                              <thead>
                                <tr>
                                  <th>
                                    <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                  </th> 
                                  <th>原材料ID</th>
                                  <th>原材料名称</th>
                                  <th>原材料用途</th>
                                  <th>原材料单价</th>
                                  <th>仓库编号</th>
                                  <th>供应商名称</th>
                                  <th>操作</th>
                              </thead>
                              <tbody>
                              <c:forEach items="${selMatSupplier.list }" var="sms">
                                <tr>
                                 <td>
                                    <input type="checkbox" name=" " value="${sms.materialId }"   lay-skin="primary"> 
                                  </td> 
                                  <td>${sms.materialId }</td>
                                  <td>${sms.materialName }</td>
                                  <td>${sms.materialIntro }</td>
                                  <td>${sms.materialPrice }</td>
                                  <td>${sms.houseId }</td>
                                  <td>${sms.supplier.supplierName }</td>
                                  <td class="td-manage">
                                    <!-- <a onclick="member_stop(this,'10001')" href="javascript:;"  title="启用">
                                      <i class="layui-icon">&#xe601;</i>
                                    </a> -->
                                   <%--  <a title="编辑"  onclick="xadmin.open('编辑','selSupplierById?supplierId=${ss.supplierId}')" href="javascript:;">
                                      <i class="layui-icon">&#xe642;</i>
                                    </a> --%>
                                    <a title="删除" onclick="member_del(this,${sms.materialId })" >
                                      <i class="layui-icon">&#xe640;</i>
                                    </a>
                                  </td>
                                </tr>
                                </c:forEach>
                              </tbody>
                            </table>
                        </div>
                                               <div class="message" style="margin-left:20px">
                        共<i class="blue">${selMatSupplier.total}</i>条记录，当前显示第&nbsp;<i
                            class="blue">${selMatSupplier.pageNum}/${selMatSupplier.pages}</i>&nbsp;页</div>
                        <div class="layui-card-body ">
                            <div class="page">
                               <div style="text-align:center;">
                        <ul class="pagination">
                            <c:if test="${!selMatSupplier.isFirstPage}">
                                <li><a href="selMatSupplier">首页</a></li>
                                <li><a href="selMatSupplier?pn=${selMatSupplier.prePage }">上一页</a></li>
                            </c:if>
                            <c:forEach items="${selMatSupplier.navigatepageNums}" var="navigatepageNum">
                            
                                <c:if test="${navigatepageNum==selMatSupplier.pageNum}">
                                    <li class="active"><a  href="selMatSupplier?pn=${navigatepageNum}">${navigatepageNum}</a></li>
                                </c:if>
                                <c:if test="${navigatepageNum!=selMatSupplier.pageNum}">
                                    <li><a href="selMatSupplier?pn=${navigatepageNum}">${navigatepageNum}</a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${!selMatSupplier.isLastPage}">
                                <li><a  href="selMatSupplier?pn=${selMatSupplier.nextPage  }">下一页</a></li>
                                <li><a  href="selMatSupplier?pn=${selMatSupplier.pages }">最后一页</a></li>
                            </c:if>
                        </ul>
                    </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var form = layui.form;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });


      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $.ajax({
            	  type:"get",
            	  url:"delMaterial",
            	  data:{materialId : id},
            	  dataType:"json",
            	  success:function(response)
            	  {
            		  $(obj).parents("tr").remove();
                      layer.msg('已删除!',{icon:1,time:1000});
            	  }
              })
              
          });
      }
 


      function delAll (argument) {
          var list = [];

          // 获取选中的id 
          $('tbody input').each(function(index, el) {
              if($(this).prop('checked')){
                 list.push($(this).val())
              }
              console.log(list);
          });
    
          layer.confirm('确认要删除吗？'+list.toString(),function(index){
              //捉到所有被选中的，发异步进行删除
              $.ajax({
            	 type:"POST",
                 url:"delByIds",
                 data:JSON.stringify(list),
                 contentType:'application/json',
                 dataType: "json",
                 success:function (response) {
                	 
                	 layer.msg('删除成功', {icon: 1});
                     $(".layui-form-checked").not('.header').parents('tr').remove();
                 },
            	  
              })
              
          });
        }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
</html>
