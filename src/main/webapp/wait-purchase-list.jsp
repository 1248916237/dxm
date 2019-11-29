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
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5" action="waitPurchase" style="display: inline;">
                                <!-- <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="开始日" name="start" id="start">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="截止日" name="end" id="end">
                                </div> -->
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="userId"  placeholder="采购负责人编号" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                            <button class="layui-btn" onclick="xadmin.open('添加采购单','./selMaterial',1025,595)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <!-- <div class="layui-card-header">
                            
                        </div> -->
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>采购单编号</th>
                                    <th>采购负责人编号</th>
                                    <th>时间</th> 
                                    <th>采购单的详情</th>          
                                    <th>状态</th>
                                    <th>操作</th>
                                  </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${waitPurchase.list  }" var="wp" varStatus="sta">
                                <tr>
                                    <td id="pur">${wp.purchaseId }</td>
                                    <td><a onclick="xadmin.open('采购员详情','selUser?userId=${wp.userId }',1025,595)" style="cursor:pointer">${wp.userId }</a></td>
                                                                              
                                   <td><span><fmt:formatDate value="${wp.purchaseDate }" pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
                                   
                                    <td>
                                   <button type="button" role="document"  onclick="btn(${wp.purchaseId })" class="check">点击查看订单详情</button>
                                      
                                <div class="modal fade" id="myModal${wp.purchaseId }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="margin-top: 120px;">
                                        <div class="modal-dialog" role="document">
                                           <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                  <h4 class="modal-title" id="myModalLabel${wp.purchaseId }">采购单详情</h4>
                                              </div>
                                                <div class="modal-body">
                                                    <table class="table table-bordered table-hover">
                                                      <tr>
                                                       <th>采购的原材料</th>
                                                       <th>原材料的用途</th>
                                                       <th>采购的数量</th>
                                                       <th>原材料的单价（元）</th>
                                                      </tr>
                                                      <c:forEach items="${wp.materialList }" var="wm">
                                                      <tr>
                                                        <td>${wm.materialName }</td>
                                                        <td>${wm.materialIntro }</td>
                                                        <td>${wm.materialNum }</td>
                                                        <td>${wm.materialPrice }</td>
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
                                      <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled">未采购</span></td>
                                    <td class="td-manage">
                                      <a onclick="member_stop(this,${wp.purchaseId})" href="javascript:;"  title="启用">
                                        <i class="layui-icon">&#xe601;</i>
                                      </a>
                                      <!-- <a title="编辑"  onclick="xadmin.open('编辑','member-edit.html',600,400)" href="javascript:;">
                                        <i class="layui-icon">&#xe642;</i>
                                     </a> -->
                                      <!-- <a onclick="xadmin.open('修改密码','member-password.html',600,400)" title="修改密码" href="javascript:;">
                                        <i class="layui-icon">&#xe631;</i>
                                      </a> -->
                                       <a title="删除" onclick="member_del(this,${wp.purchaseId })" href="javascript:;">
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
                                 <div class="message">
                        共<i class="blue">${waitPurchase.total}</i>条记录，当前显示第&nbsp;<i
                            class="blue">${waitPurchase.pageNum}/${waitPurchase.pages}</i>&nbsp;页
                    </div>
                        <div class="layui-card-body ">
                        
                            <!-- <div class="page"> -->
                            <div class="page" >
                       
                    <div style="text-align:center;">
                        <ul class="pagination">
                            <c:if test="${!waitPurchase.isFirstPage}">
                                <li><a href="waitPurchase">首页</a></li>
                                <li><a href="waitPurchase?pn=${waitPurchase.prePage }">上一页</a></li>
                            </c:if>
                            <c:forEach items="${waitPurchase.navigatepageNums}" var="navigatepageNum">
                            
                                <c:if test="${navigatepageNum==waitPurchase.pageNum}">
                                    <li class="active"><a  href="waitPurchase?pn=${navigatepageNum}">${navigatepageNum}</a></li>
                                </c:if>
                                <c:if test="${navigatepageNum!=waitPurchase.pageNum}">
                                    <li><a href="waitPurchase?pn=${navigatepageNum}">${navigatepageNum}</a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${!waitPurchase.isLastPage}">
                                <li><a  href="waitPurchase?pn=${waitPurchase.nextPage  }">下一页</a></li>
                                <li><a  href="waitPurchase?pn=${waitPurchase.pages }">最后一页</a></li>
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
          layer.confirm('确认要更改吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $.ajax({
                	type:"get",
                	url:"updateState",
                	data:{purchaseId:id},
                	dataType:"json",
                	success:function(response)
                	{
                		$(obj).parents("tr").remove();

                	}
                })
                
                
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已采购');
                layer.msg('已采购!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('未采购');
                layer.msg('未采购!',{icon: 5,time:1000});
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
                data: {purchaseId:id},
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

