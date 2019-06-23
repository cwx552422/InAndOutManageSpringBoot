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
					<h3>所有进货药品</h3>
					<form>
						<input type="text" placeholder="请输入名称关键字" id="mname">
						<select name="类型" id="fmedname">
							<option>无</option>
						<c:forEach items="${flist }" var="flist">
							<option>${flist.getFmedicine() }</option>
						</c:forEach>
						</select>
						&nbsp;&nbsp;<button type="button" class="btn btn-info" onclick="inmedicineMesageLike()">搜索</button>
					</form>
					&nbsp;&nbsp;<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/inventory/inMedMessage?pageNo=0')">刷新</a>
					&nbsp;&nbsp;<a href="#" class="a globalSetBtn" data-toggle="modal" data-target="#addInventoryModal">新增</a> 
			
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/inventory/exportExcel">导出报表</a>
				</caption>
				<thead>
					<tr>
						<td>进货编号</td>
						<td>进货单据号</td>						
						<td>药品名称</td>
						<td>药品类型</td>
						<td>进货数量</td>
						<td>进货单价</td>
						<td>进货日期</td>
						<td>供应商</td>
						<td>状态</td>
						
				    </tr>
				</thead>
				<tbody id="intable">
				<c:forEach items="${list}" var="inmed">
				 	<tr class="active">
						<td>IN${inmed.getInid() }</td>
						<td>INDOCNO${inmed.getInDocNo() }</td>						
						<td>${inmed.getMed().getMname() }</td>
						<td>${inmed.getMed().getFmedicine().getFmedicine() }</td>
						<td>${inmed.getInNum() }</td>
						<td>${inmed.getInPrice() }</td>
						<td>${inmed.getInTime() }</td>
						<td>${inmed.getPro().getProName() }</td>
						<td>${inmed.getState() }</td>
					</tr> 
				</c:forEach>
				<tr>
					<td colspan="5"><a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/inventory/inMedMessage?pageNo=1')">首页</a>
						<a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/inventory/inMedMessage?pageNo=${pageNo-1}')">上一页</a>
						<a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/inventory/inMedMessage?pageNo=${pageNo+1}')"
						id="next">下一页</a> <a
						href="#" onclick="showAtmiddle('${pageContext.request.contextPath}/inventory/inMedMessage?pageNo=${last }')">尾页</a>
					</td>
				</tr>					
				</tbody>				
			</table>
		</div>
		
		
		<!--------------------新增弹出框----------->
	<div class="modal fade" id="addInventoryModal" style="display:none;">	
	<div class="modal-dialog" style="width:450px;">
		<div class="modal-content" style="border:none;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
					<h4 class="modal-title" id="setpwdModalLabel" style="font-size: 18px;">新增进货药品</h4>
				</div>
				<div class="modal-body">	
						<form id="addAdmin_form" action="" method="post" autocomplete="off">					
							<ul>
							<li class="form-group">
									药品名称<select  class="form-control" id="medname" type="text"/>
									<c:forEach items="${mlist}" var="mname1">
									<option>${mname1.getMname() }</option>
									</c:forEach>																		
									</select>
								</li>
												
								<li class="form-group">
									进货数量<input class="form-control" id="innum"  type="text">
									<span style="float: right" id="innum"></span>
								</li>
								<li class="form-group">
									进货单价<input class="form-control" id="inPrice"  type="text">
									<span style="float: right" id="inPrice"></span>
								</li>
								<li class="form-group">
								进货时间<input class="form-control"  id="inTime" type="text"/><span>格式为：2018-01-04</span>
								<span style="float: right" id="inTime"></span>
								</li>	
								<li class="form-group">
									进货厂家<select  class="form-control" id="proname" type="text"/>
									<c:forEach items="${plist}" var="pname">
									<option>${pname.getProName() }</option>
									</c:forEach>																		
									</select>
								</li>																																
							</ul>
						</form>
						<div class="modify-box marginB10">
							<button id="addAdmin_btn" type="button" class="btn btn-micv5 btn-block globalLogin" onclick="addInventoryMsg()">添加</button>
							<div id="set-form-tips" class="tips-error bg-danger" style="display: none;">错误提示</div>
						</div>				
				</div>
			</div>
		</div>
	</body>
</html>
