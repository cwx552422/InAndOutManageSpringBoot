<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>药品进货信息</title>
		<script src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-3.2.1.min.js" ></script>
		<link rel="stylesheet" href="../../css/bootstrap.min.css">
	</head>
	<body>
		<div id="userTable">
			<table class="table">
				<caption>
					<h3>所有已售药品</h3>
					<form>
						<input type="text" placeholder="请输入名称关键字" id="mname">
						<select name="类型" id="fmedname">
							<option>无</option>
							<c:forEach items="${flist }" var="flist">
							<option>${flist.getFmedicine() }</option>
						</c:forEach>
						</select>
						&nbsp;&nbsp;<button type="button" class="btn btn-info onc" onclick="semedicineMesageLike()">搜索</button>
					</form>
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/sell/exportSellExcel">导出报表</a>
				</caption>
				<thead>
					<tr>
						<td>销售编号</td>
						<td>销售单据号</td>
						
						<td>药品名称</td>
						<td>药品类型</td>
						<td>销售数量</td>
						<td>销售单价</td>
						<td>售卖日期</td>
						<td>客户</td>
				    </tr>
				</thead>
				<tbody id="setable">
				<c:forEach items="${list}" var="sellmed">
					<tr class="active">
						<td>S${sellmed.getSid() }</td>
						<td>MCS${sellmed.getSdocno() }</td>						
						<td>${sellmed.getMed().getMname() }</td>
						<td>${sellmed.getMed().getFmedicine().getFmedicine() }</td>					
						<td>${sellmed.getSnum() }</td>
						<td>${sellmed.getSpprice() }</td>
						<td>${sellmed.getSdate() }</td>
						<td>${sellmed.getCust().getCname() }</td>					
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/sell/sellMessage?pageNo=1')">首页</a>
						<a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/sell/sellMessage?pageNo=${pageNo-1}')">上一页</a>
						<a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/sell/sellMessage?pageNo=${pageNo+1}')"
						id="next">下一页</a> <a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/sell/sellMessage?pageNo=${last }')">尾页</a>
					</td>
				</tr>
				</tbody>				
			</table>
		</div>
	</body>
</html>
