<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>药品进销存管理系统</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/login/login.css" />						
		<script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/login/login.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			function adminLogin() {
				var uname = $('#uname').val();	
				var upd = $('#upd').val();	
				var testify = $('testify').val();
				if (uname == null || uname == "") {
					if(upd==null||upd==""){
						$('#span1').text('用户名不能为空');
						$('#span2').text('*密码不能为空 ');
						$('#span3').text(' ');
					}else{
						$('#span1').text('用户名不能为空');
						$('#span2').text(' ');
						$('#span3').text(' ');
					}
					
				}
				else if(upd==null||upd==""){
					$('#span1').text(' ');
					$('#span2').text(' *密码不能为空');
					$('#span3').text(' ');
				}
				else{
					var inputCode = document.getElementById("testify").value.toUpperCase(); // 取得输入的验证码并转化为大写
					if (inputCode.length <= 0) { // 若输入的验证码长度为0
						$('#span3').text("请输入验证码！"); // 则弹出请输入验证码
					} else if (inputCode != code) { // 若输入的验证码与产生的验证码不一致时
					//则显示验证码输入错误
						$('#span3').text("验证码输入错误！@_@");
						createCode(); // 刷新验证码
						document.getElementById("testify").value = ""; // 清空文本框
					} else{
						$.post("${pageContext.request.contextPath }/admin/login",{uname:uname,upd:upd},function(data){
							/* var msg=JSON.parse(data); */ 
							if(data.trim()=="ok"){
								window.location.href="${pageContext.request.contextPath }/admin/loginmid"; // 跳转页面	 			
								 }else{	
									 $('#span4').text(' *账号或密码错误,请重新输入');						
								 }
						  }); 
					}			  
					/*  $.ajax({
				            url:"${pageContext.request.contextPath }/admin/login",
				            type:"post",
				            data:{uname:uname,upd:upd},
				            dataType:"json",
				            contentType: "application/json; charset=utf-8", 
				            success:function(res){
				                var obj = eval('('+res+')');
				                window.location.href="${pageContext.request.contextPath }/admin/loginmid";
				            },
				            error:function(error){
				            	alert("fd");
				            } 
				        }); */
				}
			}
		</script>
	</head>
	
	<body>
		<div class="container">
			</div>
			<div class="row clearfix">				
				<div class="col-md-12 column" id="div1" >
					<form class="form-horizontal" role="form" method="post" action="">
						<div class="form-group">
							<label for="uname" class="col-sm-3 control-label">用户名</label>
							<div class="col-sm-9">
								<input class="user" id="uname" type="text" />
								<span style="float: right" id="span1"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="upd" class="col-sm-3 control-label">密 码</label>
							<div class="col-sm-9">
								<input class="password" id="upd" type="password" />
								<span style="float: right" id="span2"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="testify" class="col-sm-3 control-label">验证码</label>
							<div class="col-sm-9">
								<input class="testify" id="testify" type="text" />
								<input type="text" readonly="readonly" id="code" onclick="createCode()" class="code" />
								<input type="button" value="刷新" onclick="s()" style="background-color: #CFEBFA;" class="loginbtn1" />
								<span style="float: right" id="span3"></span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									<label><input type="checkbox" />记住密码</label>
									<label><a href="#"><h4>忘记密码？</h4></a></label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<!-- <button type="submit" class="loginbtn2" onclick="adminLogin()">登 录 </button>	 -->	
								<input type="button" class="loginbtn2" value="登录" onclick="adminLogin()">	
								<span style="float: right" id="span4"></span>				
							</div> 
						</div>
					</form>
				</div>
			</div>
	</body>

</html>