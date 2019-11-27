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
      <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>    
     <script src="./lib/layui/layui.js" charset="utf-8"></script>
     <script type="text/javascript" src="./js/xadmin.js"></script>
     <link rel="stylesheet" href="./css/bootstrap.min.css">
     <script type="text/javascript" src="./js/jquery.min.js"></script>
     <script type="text/javascript" src="./js/bootstrap.min.js"></script>
    <style type="text/css">
       .check{
       border: none;
       height:26px;
       border-radius: 5px;
       
     }
    </style>
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
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5" action="selectMaterial" method="post">
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="开始日" name="time1" id="start">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="截止日" name="time2" id="end">
                                </div>
                               <!--  <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                                </div> -->
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        <!-- <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加用户','./member-add.html',600,400)"><i class="layui-icon"></i>添加</button>
                        </div> -->
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <!-- <th>
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th> -->
                                    <th>采购单编号</th>
                                    <th>采购负责人工号</th>
                                    <th>时间</th> 
                                    <th>采购单的详情</th>          
                                    <th>状态</th> 
                                    <th>操作</th>
                                  </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${selMaterial.list  }" var="sm" varStatus="sta">
                                <tr>
                                   <!--  <td>
                                      <input type="checkbox" name="id" value="1"   lay-skin="primary"> 
                                    </td> -->
                                    <td id="pur">${sm.purchaseId }</td>
                                    <td><a onclick="xadmin.open('采购员详情','selUser?userId=${sm.userId }',1025,595)" style="cursor:pointer">${sm.userId }</a></td>
                                                                              
                                   <td><span><fmt:formatDate value="${sm.purchaseDate }" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
                                   
                                    <td>
                                   <button type="button" role="document"  onclick="btn(${sm.purchaseId })" class="check">点击查看采购单详情</button>
                                      
                                <div class="modal fade" id="myModal${sm.purchaseId }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin-top: 120px;">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                  <h4 class="modal-title" id="myModalLabel${sm.purchaseId }">采购单详情</h4>
                                              </div>
                                                <div class="modal-body">
                                                    <table class="table table-bordered table-hover">
                                                      <tr>
                                                       <th>采购的原材料</th>
                                                       <th>原材料的用途</th>
                                                       <th>采购的数量</th>
                                                       <th>原材料的单价（元）</th>
                                                      </tr>
                                                      <c:forEach items="${sm.materialList }" var="smm">
                                                      <tr>
                                                        <td>${smm.materialName }</td>
                                                        <td>${smm.materialIntro }</td>
                                                        <td>${smm.materialNum }</td>
                                                        <td>${smm.materialPrice }</td>
                                                      </tr>
                                                      </c:forEach>
                                                    </table> 
                                              </div>
                                              <div class="modal-footer">
                                                  <button type="button" class="btn btn-default" data-dismiss="modal"><span aria-hidden="true">x</span>关闭</button>
                                                  <!-- <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存</button> -->
                                              </div>
                                          </div>
                                      </div>
                                  </div>

                                    </td>
                                      <td class="td-status">
                                      <span class="layui-btn layui-btn-normal layui-btn-mini ">已采购</span></td> 
                                    <td class="td-manage">
                                     <!--  <a onclick="member_stop(this,'10001')" href="javascript:;"  title="启用">
                                        <i class="layui-icon">&#xe601;</i>
                                      </a> -->
                                      <!-- <a title="编辑"  onclick="xadmin.open('编辑','member-edit.html',600,400)" href="javascript:;">
                                        <i class="layui-icon">&#xe642;</i>
                                      </a> -->
                                      <!-- <a onclick="xadmin.open('修改密码','member-password.html',600,400)" title="修改密码" href="javascript:;">
                                        <i class="layui-icon">&#xe631;</i>
                                      </a> -->
                                       <a title="删除" onclick="member_del(this,${sm.purchaseId })" href="javascript:;">
                                        <i class="layui-icon">&#xe640;</i>
                                      </a> 
                                    <!--   <a title="删除" lay-filter="add" lay-submit="" href="javascript:;"> 
                                      <i class="layui-icon">&#xe640;</i>
                                      </a>-->
                                    </td>
                                    </tr>
                                  </c:forEach>
                                </tbody>
                            </table>
                        </div>
                                 <div class="message" style="margin-left:20px">
                        共<i class="blue">${selMaterial.total}</i>条记录，当前显示第&nbsp;<i
                            class="blue">${selMaterial.pageNum}/${selMaterial.pages}</i>&nbsp;页
                    </div>
                        <div class="layui-card-body ">
                            <div class="page"  style="height:40px">
                       
                    <div style="text-align:center;">
                        <ul class="pagination">
                            <c:if test="${!selMaterial.isFirstPage}">
                                <li><a href="selectMaterial">首页</a></li>
                                <li><a href="selectMaterial?pn=${selMaterial.prePage }">上一页</a></li>
                            </c:if>
                            <c:forEach items="${selMaterial.navigatepageNums}" var="navigatepageNum">
                            
                                <c:if test="${navigatepageNum==selMaterial.pageNum}">
                                    <li class="active"><a  href="selectMaterial?pn=${navigatepageNum}">${navigatepageNum}</a></li>
                                </c:if>
                                <c:if test="${navigatepageNum!=selMaterial.pageNum}">
                                    <li><a href="selectMaterial?pn=${navigatepageNum}">${navigatepageNum}</a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${!selMaterial.isLastPage}">
                                <li><a  href="selectMaterial?pn=${selMaterial.nextPage  }">下一页</a></li>
                                <li><a  href="selectMaterial?pn=${selMaterial.pages }">最后一页</a></li>
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
    //注册新增按钮的事件
    
    	
    	function btn(id)
    	{
    		$("#myModalLabel"+id).text("采购单"+id+"的详情");
    		$('#myModal'+id).modal();
   		  
    	}
    	
  
    
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
                layer.msg('未采购!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已采购!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $.ajax({
                type: "get",
                url: "waitDelPurchase",
                data: "purchaseId="+id,
                dataType: "json",
                success: function (response) {
                	$(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                    
                }
              });
              
              
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
