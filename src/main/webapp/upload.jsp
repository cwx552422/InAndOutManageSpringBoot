<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传下载</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath }/upload?paths=${pageContext.request.contextPath }"
		method="post" enctype="multipart/form-data">
		<div>
			<img
				src="${pageContext.request.contextPath }/static/img/index/people.jpg"
				id="peopleimg">
		</div>
		<ul>
			<li class="form-group">头像<input name="file" id="file" checked
				type="file" /></li>
		</ul>
		<ul>
			<input type="submit" value="上传">
		</ul>
	</form>
</body>
</html>
