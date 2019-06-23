<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>药品退货信息</title>
		<script src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-3.2.1.min.js" ></script>
		<link rel="stylesheet" href="../../css/bootstrap.min.css">
	</head>
	<body>
		<div id="userTable">
		<form>
			<table class="table">
				<caption>
					<h3>所有退货药品</h3>				
						<input type="text" placeholder="请输入名称关键字">
						<select name="类型">
							<option>无</option>
							<option>无</option>
								<c:forEach items="${flist }" var="flist">
							<option>${flist.getFmedicine() }</option>
							</c:forEach>
						</select>
						&nbsp;&nbsp;<button type="button" class="btn btn-info">搜索</button>					
					&nbsp;&nbsp;<a>批量操作</a>
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/sell/exportRebillExcel">导出报表</a>
				</caption>
				<thead>
					<tr>
						<td>退货编号</td>
						<td>销售单据号</td>						
						<td>药品名称</td>
						<td>药品类型</td>
						<td>退货数量</td>
						<td>退货日期</td>
						<td>退货客户</td>
						<td>操作人</td>
				    </tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="remed">
					<tr class="active">
						<td>RE${remed.getReid() }</td>
						<td>MCS${remed.getSell().getSdocno() }</td>
						<td>${remed.getSell().getMed().getMname() }</td>
						<td>${remed.getSell().getMed().getFmedicine().getFmedicine() }</td>					
						<td>${remed.getRenum() }</td>
						<td>${remed.getRedate() }</td>
						<td>${remed.getSell().getCust().getCname() }</td>
						<td>${remed.getAdmin().getUname() }</td>					
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/sell/reebillMessage?pageNo=1')">首页</a>
						<a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/sell/reebillMessage?pageNo=${pageNo-1}')">上一页</a>
						<a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/sell/reebillMessage?pageNo=${pageNo+1}')"
						id="next">下一页</a> <a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/sell/reebillMessage?pageNo=${last }')">尾页</a>
					</td>
				</tr>
				</tbody>				
			</table>
			</form>
		</div>
	</body>
</html>
