<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>药品库存信息</title>
		<script src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-3.2.1.min.js" ></script>
		<link rel="stylesheet" href="../../css/bootstrap.min.css">
	</head>
	<body>
		<div id="userTable">
			<table class="table">
				<caption>
					<h3>所有库存药品</h3>
					<form>
						<input type="text" id="mname" name="mname" placeholder="请输入名称关键字">						
						&nbsp;&nbsp;<button type="button" class="btn btn-info" onclick="purmedicineMesageLike()">搜索</button>
					</form>
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/purchase/exportExcel">导出报表</a>
				</caption>
				<thead>
					<tr>						
						<td>药品编号</td>
						<td>药品名称</td>
						<td>入库数量</td>
						<td>销售数量</td>
						<td>盘点数量</td>
						<td>盘点日期</td>
						<td>药品生产日期</td>
						<td>药品有效期</td>
				    </tr>
				</thead>
				<tbody id="purtable">
				<c:forEach items="${list}" var="pmed">
					<tr class="active">
						<td>m${pmed.getMid() }</td>
						<td>${pmed.getMname()}</td>
						<td>${pmed.getTinnum()}</td>
						<td>${pmed.getTsnum()}</td>
						<td>${pmed.getCnum()}</td>
						<td>${crruentTime}</td>
						<td>${pmed.getProdate()}</td>	
						<td>${pmed.getValiddate()}</td>				
					</tr>
				</c:forEach>
				</tbody>				
			</table>
		</div>
	</body>
</html>
