<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户管理模块</title>
<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/static/js/script.js"></script>
<script src="${pageContext.request.contextPath }/static/js/systemManager/addManager.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/css/index/userManager.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/index/setPersonal.css">  
 
</head>
<body>
	<div id="userTable">
		<table class="table">
			<caption>
				<h3>管理员设置</h3>
				&nbsp;&nbsp;<a href="#" class="a globalSetBtn" data-toggle="modal" data-target="#addAdminModal">新增</a> 
				&nbsp;&nbsp;<a href="#" id="flash" onclick="showAtmiddle('${pageContext.request.contextPath }/admin/adminMessage?pageNo=0')">刷新</a>
				&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/admin/exportExcel">导出报表</a>
			</caption>
			<thead>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>角色</td>
					<td>联系方式（TEL）</td>
					<td>操作方式</td>
				</tr>
			</thead>
			<tbody id="adminContent">
				<c:forEach var="admin" items="${list}">
					<tr class="active">
						<td>${admin.getUid()}</td>
						<td>${admin.getUname()}</td>
						<td>${admin.getRole()}</td>
						<td>${admin.getTel()}</td>
						<td><a href="#" onclick="delAdmin(${admin.getUid()})">删除</a>
					</tr>
				</c:forEach> 
				<tr>
					<td colspan="5"><a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/admin/adminMessage?pageNo=1')">首页</a>
						<a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/admin/adminMessage?pageNo=${pageNo-1}')">上一页</a>
						<a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/admin/adminMessage?pageNo=${pageNo+1}')"
						id="next">下一页</a> <a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/admin/adminMessage?pageNo=${last }')">尾页</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!--------------------新增弹出框----------->
	<div class="modal fade" id="addAdminModal" style="display:none;">	
	<div class="modal-dialog" style="width:450px;">
		<div class="modal-content" style="border:none;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
					<h4 class="modal-title" id="setpwdModalLabel" style="font-size: 18px;">新增管理员</h4>
				</div>
				<div class="modal-body">	
						<form id="addAdmin_form" action="" method="post" autocomplete="off" enctype="multipart/form-data">					
							<ul>
								<li class="form-group">
									姓名<input class="form-control" id="add_uname" maxlength="50"  type="text">
									<span style="float: right" id="add_unamespan"></span>
								</li>					
								<li class="form-group">
									密码<input class="form-control" id="add_Pwd"  type="password">
									<span style="float: right" id="add_pwdspan"></span>
								</li>
								<li class="form-group">
									再次输入密码<input class="form-control" id="add_Pwd1"  type="password">
									<span style="float: right" id="add_pwdspan1"></span>
								</li>
								<li class="form-group">
								联系方式tel<input class="form-control"  id="add_tel" type="text"/>
								<span style="float: right" id="add_telspan"></span>
								</li>	
								<li class="form-group">
									角色<select  class="form-control" id="add_role" type="text"/>
									<option>超级管理员</option>
									<option>普通管理员</option>
									</select>
								</li>											
								<!-- <li class="form-group">
								 <input name="imgurl" id="add_img" checked type="file" /> 
								</li>	 -->															
							</ul>
						</form>
						<div class="modify-box marginB10">
							<button id="addAdmin_btn" type="button" class="btn btn-micv5 btn-block globalLogin" onclick="addadmin()">添加</button>
							<div id="set-form-tips" class="tips-error bg-danger" style="display: none;">错误提示</div>
						</div>				
				</div>
			</div>
		</div>
		
</div>	
</body>
</html>
