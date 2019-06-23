<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>系统操作记录</title>
		<script src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-3.2.1.min.js" ></script>
		<link rel="stylesheet" href="../../css/bootstrap.min.css">
	</head>
	<body>
		<div id="userTable">
			<table class="table">
				<caption>
					<h3>所有系统操作</h3>
					<form>	
					<input type="text" id="record" name="record" placeholder="请输入操作关键字">				
						<select name="操作人" id="uname">
							<option>无</option>
							<c:forEach items="${alist }" var="alist">
							<option>${alist.getUname() }</option>
						</c:forEach>
						</select>
						&nbsp;&nbsp;<button type="button" class="btn btn-info" onclick="listLikeMsgLog()">搜索</button>
					</form>
				
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/log/exportOperationExcel">导出报表</a>
				</caption>
				<thead>
					<tr>
						<td>操作员</td>
						<td>操作描述</td>
						<td>操作日期</td>
				    </tr>
				</thead>
				<tbody id="ltable">
					<c:forEach items="${list}" var="log">
					<tr class="active">
						<td>${log.getAdmin().getUname() }</td>
						<td>${log.getRecord() }</td>
						<td>${log.getTime() }</td>									
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><a href="#"
						onclick="showAtmiddle('${pageContext.request.contextPath}/log/loglist?pageNo=1')">首页</a>
						<a href="#"
						onclick="showAtmiddle('${pageContext.request.contextPath}/log/loglist?pageNo=${pageNo-1}')">上一页</a>
						<a href="#"
						onclick="showAtmiddle('${pageContext.request.contextPath}/log/loglist?pageNo=${pageNo+1}')"
						id="next">下一页</a> <a href="#"
						onclick="showAtmiddle('${pageContext.request.contextPath}/log/loglist?pageNo=${last }')">尾页</a>
					</td>
				</tr>
				</tbody>				
			</table>
		</div>
	</body>
</html>
