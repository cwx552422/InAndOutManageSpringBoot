<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药品类型</title>

<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
 <script src="${pageContext.request.contextPath }/static/js/medicineMessageManager/medicineMessage.js"></script>	

<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
</head>
<body>
<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
	<div id="userTable">
		<table class="table">
			<caption>
				<h3 id="title">药品类型</h3>
				<form>
					<input type="text" placeholder="请输入名称关键字" id="fmedname"> 			
					<button type="button" class="btn btn-info" onclick="formofmedicineMesageLike()">搜索</button>
				</form>
				&nbsp;&nbsp;<a href="#" id="flash" onclick="showAtmiddle('${pageContext.request.contextPath }/medicine/formOfMedicine')">刷新</a>
				&nbsp;&nbsp;<a href="#" class="a globalSetBtn" data-toggle="modal" data-target="#addformOfMedicine">新增</a>
			</caption>
			<thead>
				<tr>
					<td>类型编号</td>
					<td>药品类型</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="ftable">
				<c:forEach items="${list }" var="fmed">
					<tr class="active">
						<td>${fmed.getFid() }</td>
						<td>${fmed.getFmedicine() }</td>
						<td><a href="#" onclick="delformMed(${fmed.getFid()})">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	<!--------------------新增弹出框----------->
	<div class="modal fade" id="addformOfMedicine" style="display:none;">	
	<div class="modal-dialog" style="width:450px;">
		<div class="modal-content" style="border:none;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
					<h4 class="modal-title" id="setpwdModalLabel" style="font-size: 18px;">新增药品类型</h4>
				</div>
				<div class="modal-body">	
						<form id="addAdmin_form" action="" method="post" autocomplete="off">					
							<ul>
								<li class="form-group">
									药品类型<input class="form-control" id="fmedicine" maxlength="50"  type="text">
									<span style="float: right" id="add_unamespan"></span>
								</li>													
						</form>
						<div class="modify-box marginB10">
							<button id="addAdmin_btn" type="button" class="btn btn-micv5 btn-block globalLogin" onclick="addFormOfMedicine()">添加</button>
							<div id="set-form-tips" class="tips-error bg-danger" style="display: none;">错误提示</div>
						</div>				
				</div>
			</div>
		</div>
</body>
</html>