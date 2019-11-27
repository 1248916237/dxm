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
	<script type="text/javascript" src="./js/xadmin.js"></script>
	 <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
	<link rel="stylesheet" href="./css/bootstrap.min.css">
     <script type="text/javascript" src="./js/jquery.min.js"></script>
     <script type="text/javascript" src="./js/bootstrap.min.js"></script>
	 <style>
.inp{
    width: 150px;
    height: 35px;
    outline: darkturquoise;
    padding-left: 10px;
    border: 1px solid rgb(155, 155, 235);
    border-radius: 5px;
}
</style> 
</head>
<body>
<div class="container">
    
    <div class="row">            
              <form action="#" method="POST" class="form-horizontal">
                  <legend style="font-size: 18px;">添加采购员信息</legend>
                  <div style="margin-left: 280px;">
                  <div class="form-group">
                      <label for="ID" class="col-xs-3 control-label">采购员工号：</label>
                      <div class="col-xs-3">
                      <select name="" id="ID" class="form-control" required="required">
                      <c:forEach items="${selUserId }" var="su">
                          <option value="${su.userId }">${su.userId }</option>
                      </c:forEach>
                      </select>
                    </div>   
                  </div>
                </div>
              </form>
    </div>

    <div class="row">
            <legend style="font-size: 18px;margin-top: 50px">添加原材料信息</legend>
        <div class="col-xs-6" >
                
        <table class="table" style="margin-left: 260px;">
            <thead id="tbody">
                <tr>
                    <th colspan="2" style="text-align: center;font-size: 16px;">采购原材料</th>
                </tr>
                <tr>
                        <th><span style="margin-left: 35px;">原材料信息</span></th>
                        <th><span style="margin-left: 35px;">原材料数量</span></th>
                        <th><span style="margin-left: 35px;">操作</span></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                <td>
                    <select name="" id="matId" class="form-control" required="required">
                        <c:forEach items="${selMaterial }" var="sm">
                        <option value="${sm.materialId }">${sm.materialId }、${sm.materialName }&nbsp;:&nbsp;${sm.materialIntro }</option>
                        </c:forEach>
                    </select>
                    </td>
                    <td><input type="text" name="" id="matNum" class="inp"></td>
                    <td><button id="add" class="btn" type="button" style="width:50px;margin-left: 20px;outline:none;">+</button></td>
                </tr>
               
            </tbody>
        </table>
        
        <button id="addAll"  class="btn btn-primary" style="margin-left: 400px;width: 150px;margin-top: 30px;">添加</button> 
    </div>
</div>
</div>

<script>    
   
   
     $('#add').click(function (e) { 
         var materialId = $('#matId').val();
         var materialNum = $('#matNum').val();
         var tr =('<tr class="data"><td><span style="margin-left: 35px;">'+materialId+'</span></td> <td><span style="margin-left: 35px;">'+materialNum+'</span></td> <td><button onclick="del(this)" class="btn" type="button" style="width:30px;margin-left: 35px;outline:none;">-</button></td></tr>');
         $('#tbody').append(tr);
     });
     
     layui.use(['form', 'layer','jquery'],
     
     $('#addAll').click(function (e) { 
         var purMaterialList = [];
        $('.data').each(function () {
        var children = $(this).children();
            var child ={materialId:children[0].children[0].innerHTML,materialNum:children[1].children[0].innerHTML};
            purMaterialList.push(child);
            console.log(purMaterialList);
        });

     var data ={
        userId:$('#ID').val(),
        purMaterialList:purMaterialList
     };
     console.log(data);
     
     
     $.ajax({
         type: "POST",
         url: "addPurMaterial",
         data: JSON.stringify(data),
         contentType:'application/json',
         dataType: "json",
         success: function (response) {
             /* alert("添加采购单成功！"); */
        	 layer.alert("添加采购单成功！", {
                 icon: 6
             },
             function() {
                 //关闭当前frame
                 xadmin.close();

                 // 可以对父窗口进行刷新 
                 xadmin.father_reload();
             });
         },

     });
     
     
     })
     
     
 );


 function del(tr)
 {
     tr.parentNode.parentNode.remove();
 }


</script>


</body>
</html>
