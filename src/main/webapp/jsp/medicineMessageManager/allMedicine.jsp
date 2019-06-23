<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>所有药品信息</title>
<script src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>
<body>
	<div id="userTable">
		<table class="table">
			<caption>
				<h3 id="title">所有药品</h3>
				<form>
					<input type="text" placeholder="请输入名称关键字" id="mname"> <select
						name="类型" id="fmedname">
						<option>无</option>
						<c:forEach items="${flist }" var="flist">
							<option>${flist.getFmedicine() }</option>
						</c:forEach>
					</select> &nbsp;&nbsp;
					<button type="button" class="btn btn-info" onclick="medicineMesageLike()">搜索</button>
				</form>
				&nbsp;&nbsp;<a
					href="${pageContext.request.contextPath }/medicine/exportExcel">导出报表</a>
			</caption>
			<thead>
				<tr>
					<td>药品编号</td>
					<td>名称</td>
					<td>剂型</td>
					<td>单位</td>
					<td>制作商</td>
					<td>生产日期</td>
					<td>有效期</td>
					<td>药品描述</td>
				</tr>
			</thead>
			<tbody id='medtable'>
				<c:forEach items="${list }" var="med">
					<tr class="active">
						<td>M${med.getMid() }</td>
						<td>${med.getMname() }</td>
						<td>${med.getFmedicine().getFmedicine() }</td>
						<td>${med.getUnits()}</td>
						<td>${med.getManufacture() }</td>
						<td>${med.getProDate() }</td>
						<td>${med.getValidDate() }</td>
						<td>${med.getDescription() }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><a href="#"
						onclick="showAtmiddle('${pageContext.request.contextPath}/medicine/allMedicine?pageNo=1')">首页</a>
						<a href="#"
						onclick="showAtmiddle('${pageContext.request.contextPath}/medicine/allMedicine?pageNo=${pageNo-1}')">上一页</a>
						<a href="#"
						onclick="showAtmiddle('${pageContext.request.contextPath}/medicine/allMedicine?pageNo=${pageNo+1}')"
						id="next">下一页</a> <a href="#"
						onclick="showAtmiddle('${pageContext.request.contextPath}/medicine/allMedicine?pageNo=${last }')">尾页</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
