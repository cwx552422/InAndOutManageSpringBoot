<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>销售开单</title>
		<script src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-3.2.1.min.js" ></script>
		<link rel="stylesheet" href="../../css/bootstrap.min.css">
	</head>
	<body>
	</form>
		 <div id="userTable">
		<form action="${pageContext.request.contextPath }/sell/exportsellbillExcel">
			<table class="table">
				<caption>
					<h3>药品销售开单</h3>
					&nbsp;&nbsp;<button>导出销售单</button>
				</caption>			
				<tbody>
				
					<tr>
						<td>药品名字</td>
						<td><input type="text" id="mname" name="mname"></td>
						
				    </tr>
				    <tr>
						<td>销售数量</td>
						<td><input type="text" id="sellnum" name="sellnum"></td>
						
				    </tr>
				    <tr>
						<td>销售单价</td>
						<td><input type="text" id="sellprice" name="sellprice"></td>
						
				    </tr>
				    <tr>
						<td>销售总金额</td>
						<td><input type="text" id="totalprice" name="totalprice"></td>						
				    </tr>
				     <tr>
						<td>开单人</td>
						<td><input type="text" id="uname" name="uname"></td>
						
				    </tr>
				    <tr>
						<td>日期(例:2018-01-02)</td>
						<td><input type="text" id="date" name="date"></td>						
				    </tr>				   				   
				</tbody>				
			</table>
			</form>
		</div> 
	</body>
</html>
