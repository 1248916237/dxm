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
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
    <body>
        <div class="x-nav">
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5">
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="开始日" name="start" id="start">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="截止日" name="end" id="end">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                                <button class="layui-btn" onclick="xadmin.open('添加用户','./member-add.html',600,400)"><i class="layui-icon"></i>添加</button>
                            </form>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>性别</th>
                                    <th>手机</th>
                                    <th>地址</th>
                                    <th>银行卡号</th>
                                    <th>状态</th>
                                    <th>操作</th></tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${clientList.list }" var="client">
                                    <tr>
                                    	<td>${client.clientId }</td>
                                    	<td><a href="client_order?clientId=${client.clientId }">${client.clientName }</a></td>
                                    	<td>${client.clientSex }</td>
                                    	<td>${client.clientPhone }</td>
                                    	<td>${client.clientAddress }</td>
                                    	<td>${client.clientCard }</td>
                                    	<td class="td-status">
                                    		<c:if test="${client.clientState ==1 }">活跃客户</c:if>
                                    		<c:if test="${client.clientState ==0 }">已流失客户</c:if>
                                    	</td>
                                    	<td class="td-manage">
                                    	<c:if test="${client.clientState ==0 }">
	                                      <a  href="client_update?clientId=${client.clientId }"  title="启用">
	                                        <i class="layui-icon">&#xe601;</i>
	                                      </a>
	                                     </c:if>
	                                      <a title="编辑" href="client_update?clientId=${client.clientId }">
	                                        <i class="layui-icon">&#xe642;</i>
	                                      </a>
	                                      <a title="修改"  onclick="xadmin.open('','/dxm/client_update?clientId=${client.clientId}')">
	                                        <i class="layui-icon">&#xe640;</i>
	                                      </a>
	                                    </td>
	                                   </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <c:if test="${clientList.pageNum >1 }">
                                  	<a class="prev" href="client_list?pn=${clientList.prePage }">&lt;&lt;</a>
                                  </c:if>
                                  <c:if test="${clientList.pageNum <=1 }">
                                  	<a class="prev">第一页</a>
                                  </c:if>
                                  <a class="num" href="#">共${clientList.size }条记录</a>
                                  <a class="num" href="#">共${clientList.pages }页</a>
                                  <c:if test="${clientList.pageNum < clientList.pages}">
                                  	<a class="prev" href="client_list?pn=${clientList.nextPage }">&gt;&gt;</a>
                                  </c:if>
                                  <c:if test="${clientList.pageNum == clientList.pages }">
                                  	<a class="prev">尾页</a>
                                  </c:if>
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
        var  form = layui.form;


        // 监听全选
        form.on('checkbox(checkall)', function(data){

          if(data.elem.checked){
            $('tbody input').prop('checked',true);
          }else{
            $('tbody input').prop('checked',false);
          }
          form.render('checkbox');
        }); 
        
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
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }

      function delAll (argument) {
        var ids = [];

        // 获取选中的id 
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
               ids.push($(this).val())
            }
        });
  
        layer.confirm('确认要删除吗？'+ids.toString(),function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
</html>
