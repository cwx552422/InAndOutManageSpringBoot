<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
		
     	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/fileinput.min.css"> 
		<script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/file/locales/zh.js"></script>
	    <script src="${pageContext.request.contextPath }/static/js/file/fileinput.min.js"></script>	
</head>
<body>
	<div class="form-group">
   <label for="" class="col-sm-2 control-label">photo</label>
   <div class="col-sm-10">
      <input id="myFile" type="file" name="myFile" class="fileloading">
   </div>
  <input type="hidden" name="user.logo" id="logo">
  </div>
	</body>
	<script type="text/javascript">
	$("#myFile").fileinput({
        language : 'zh',
        uploadUrl : "${pageContext.request.contextPath }/admin/uplode/photo?paths=${pageContext.request.contextPath}",
        autoReplace : true,
        maxFileCount : 1,
        allowedFileExtensions : [ "jpg", "png", "gif" ],
        browseClass : "btn btn-primary", //按钮样式 
        previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
    }).on("fileuploaded", function(e, data) {
        var res = data.response;       
        $("#logo").attr("value", res.success);
        alert("重新进入系统后有效");
    })
	</script>
</html>