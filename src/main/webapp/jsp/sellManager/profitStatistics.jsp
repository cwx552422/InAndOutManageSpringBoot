<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>利润结算信息</title>
		<script src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-3.2.1.min.js" ></script>
		<link rel="stylesheet" href="../../css/bootstrap.min.css">
	</head>
	<body>
		<div id="userTable">
			<table class="table">
				<caption>
					<h3>利润统计</h3>
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/sell/exportprofitExcel">导出报表</a>					
				</caption>
				<thead>
					<tr>
						<td>药品编号</td>
						<td>药品名称</td>
						<td>销售数量</td>
						<td>退货数量</td>
						<td>进货单价</td>
						<td>销售单价</td>
						<td>进货金额</td>
						<td>销售金额</td>
						<td>利润</td>
				    </tr>
				</thead>
				<tbody>
				<!-- <tr>
						<td colnum="3">所有总统计</td>
						<td>退货总数量</td>
						<td>进货总数量</td>
						<td>----</td>
						<td>所有药品进货总金额</td>
						<td>所有药品销售总金额</td>
						<td>所有药品总利润</td>
				    </tr> -->
				<c:forEach items="${list}" var="promed">
					<tr class="active">
						<td>MID${promed.getMid() }</td>
						<td>${promed.getMname() }</td>
						<td>${promed.getSnum() }</td>									
						<td>${promed.getRenum() }</td>
						<td>${promed.getInpp() }</td>									
						<td>${promed.getSpp() }</td>
						<td>${promed.getInprice() }</td>
						<td>${promed.getSprice() }</td>
						<td>${promed.getProfits() }</td>
											
					</tr>
				</c:forEach>
				</tbody>				
			</table>
		</div>
	</body>
</html>
