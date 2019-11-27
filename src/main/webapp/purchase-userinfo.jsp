<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="./css/bootstrap.min.css">
     <script type="text/javascript" src="./js/jquery.min.js"></script>
     <script type="text/javascript" src="./js/bootstrap.min.js"></script>
     
       <link rel="stylesheet" href="./css/xadmin.css">
       <!--  <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script> -->
        <script type="text/javascript" src="./js/xadmin.js"></script>
  <style>
     #location{
         position: relative;
         top: 50px;
         left: 300px;
     }
     #location1{
         position: relative;
         top: 50px;
         left: 314px;
     }
     	.sp{
	  font-size:5px;
	  color:red;
	  position:absolute;
	  top:5px;
	  z-index:12;
	}
     </style>
</head>
<body>
    
    <div class="container">
        
        <div class="row" >
            <div class="media col-xs-4" id="location">
            <form action="upload" method="post" enctype="multipart/form-data">
                <div  class="pull-left">
                <img class="media-object" src="${selUser.empPicture }" alt="Image" width="100px" height="120px"   >
                </div>
                <div class="media-body">
                    <h3 class="media-heading">${selUser.empName }</h3><br>
                    <p>工号：${selUser.userId } &emsp;${selUser.empSex }</p><br>
                    <p>电话：${selUser.empPhone }</p>
                </div>
                </form>
            </div>
        </div>
        <div class="row " > 
            <ul class="list-group col-xs-4" id="location1">
                <li class="list-group-item">来自：${selUser.empHometown }</li>
                <li class="list-group-item">工作地址：${selUser.empAddress }</li>
                <li class="list-group-item">
                                                出生年月：<span><fmt:formatDate value="${selUser.empBirthday }" pattern="yyyy-MM-dd HH:mm:ss"/></span></li>
                <li class="list-group-item">QQ：${selUser.empQq }</li>
                <li class="list-group-item">身份证号：${selUser.empIdentity }</li>
                <li class="list-group-item">学历：${selUser.empEducation }</li>
                <li class="list-group-item">
                                                开始工作时间：<span><fmt:formatDate value="${selUser.empStartwork }" pattern="yyyy-MM-dd HH:mm:ss"/></span></li>
                <li class="list-group-item">所属部门：${selUser.dept.deptName }</li>
                <li class="list-group-item">部门薪水：${selUser.dept.deptSalary }(/天)</li>
            </ul>
            
        </div>
        
    </div>
    
    <script type="text/javascript">
	function getUrl(obj)
	{
		var img = obj.files[0];
		var reader = new FileReader();
		reader.readAsDataURL(img);
		reader.onload = function(event)
		{
			var result = this.result;
			document.getElementById('yulan').src = result;
		}
	}
	
			 function update() {
        //关闭当前frame
         xadmin.close();
 
        // 可以对父窗口进行刷新 
        /* xadmin.father_reload(); */
            }
			
			
	</script>
    
</body>
</html>