<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
   <link href="${pageContext.request.contextPath }/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/inventory.css">
	<script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/ inventoryManager/moment-with-locales(1).js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/static/js/ inventoryManager/bootstrap-datetimepicker.min.js"></script>			
	<script src="${pageContext.request.contextPath }/static/js/ inventoryManager/bootstrap-datetimepicker.zh-CN.js"></script>	
    <script src="${pageContext.request.contextPath }/static/js/ inventoryManager/inventory.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/ inventoryManager/echarts.js"></script>		
	
</head>
<body>
<!-- <a onclick="zhuxing()" href="#">heloo</a> -->
<div id="test" style="width: 850px; height: 550px;" onload="zhuxing()"></div>
</body>
</html>