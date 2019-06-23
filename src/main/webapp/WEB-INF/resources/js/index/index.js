//$(function () { $('.panel-collapse collapse').collapse('hide')});
$(function() {
	$('#collapseFive').collapse('hide')
});
$(function() {
	$('#collapseFour').collapse('hide')
});
$(function() {
	$('#collapseTwo').collapse('hide')
});
$(function() {
	$('#collapseThree').collapse('hide')
});
$(function() {
	$('#collapseOne').collapse('hide')
});
/*$(function() {
	//日历
	$('#datepicker').datepicker();
});*/


function showAtmiddle(url) {
	var xmlHttp;
	var flag=false;
	if(window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari,用来区分浏览器
		xmlHttp = new XMLHttpRequest(); //创建 XMLHttpRequest对象
	} else {
		// code for IE6, IE5
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlHttp.onreadystatechange = function() {
		//onreadystatechange — 当readystate变化时调用后面的方法
		
		if(xmlHttp.readyState == 4) {
			//xmlHttp.readyState == 4    ——    读取服务器响应结束

			if(xmlHttp.status == 200) {
				//xmlHttp.status == 200        ——    服务器反馈正常            
				flag=true;
				document.getElementById("middle").innerHTML = xmlHttp.responseText; //重设页面中id="middle"的div里的内容
				executeScript(xmlHttp.responseText); //执行从服务器返回的页面内容里包含的JavaScript函数
			}
			//错误状态处理
			else if(xmlHttp.status == 404) {
				alert("出错了☹   （错误代码：404 Not Found），……！");
				/* 对404的处理 */
				return;
			} else if(xmlHttp.status == 403) {
				alert("出错了☹   （错误代码：403 Forbidden），……");
				/* 对403的处理  */
				return;
			} else {
				alert("出错了☹   （错误代码：" + request.status + "），……");
				/* 对出现了其他错误代码所示错误的处理   */
				return;
			}
		}
		
	}

	//把请求发送到服务器上的指定文件（url指向的文件）进行处理
	xmlHttp.open("GET", url, true); //true表示异步处理
	xmlHttp.send();
}




//日期处理
$(function() {
	$('#form_datetime').datetimepicker({
    format: 'yyyy',
    autoclose: true,
    todayBtn: true,
    startView: 2,
    minView:2,
    maxView:4,
    language:  'zh-CN',
	})
});

//修改个人头像
/*$(function(){	
	$("#modifyimg_btn").click(function(){
		alert("he");
		    $.ajax({	    			    
		        url: "ModifyadminImg",
		        type: 'POST',
		        cache: false,
		        data: new FormData($('#file')[0]),
		        processData: false,
		        contentType: false,
		        dataType:"json",
//		        fileElementId:'file',
		        success : function(data) {
		        	if(data==null||data==""){
						alert("修改失败");			
					 }else{
						 $("#setModal").modal("hide");
						 alert("修改成功");
					 }	
		        }
		    });
	});	
});	
  */

$(function(){	
	  var form = new FormData(document.getElementById("test"));
	  var pageContext = $("PageContext").value;
	  var path = $("#PageContext").val() + '/admin/ModifyadminImg';
	  $("#modifyimg_btn").click(function(){
	    $.ajax({  
	        url : path,  
	        data : form,  
	        type : 'post',  
//	        processData:false,  
//	        contentType:false,  
	        success : function(data){  
	            alert("成功");
	        },  
	        error : function(data){  
	        	alert("成功");
	        }  
	    });  
	  });
});	
  

//修改个人信息
$(function(){	
	$("#modify_btn").click(function(){
		var tel = $("#id_tel").val();
		if(isphone2(tel)||isphone1(tel)){
			$.post("ModifyadminMessage",
					{uname:$("#id_uname").val(),tel:$("#id_tel").val()},
					function(data){
						if(data==null||data==""){
							alert("修改失败");			
						 }else{
							 $("#setModal").modal("hide");
							 alert("修改成功");
						 }		
					});	
		}else{
			$("#telspan").text("手机/电话号码格式不正确");
		}
	});	
});	
   


/*判断输入是否为合法的手机号码*/
function isphone2(tel)
{
     var partten = /^1[3,5,8]\d{9}$/;
     if(partten.test(tel))
     {
          //alert('是手机号码');
          return true;
     }
     else
     {
          return false;
          //alert('不是手机号码');
     }
}
/*判断输入是否为合法的电话号码，匹配固定电话或小灵通*/
function isphone1(tel)
{
     var partten = /^0(([1,2]\d)|([3-9]\d{2}))\d{7,8}$/;
     if(partten.test(tel))
     {
          //alert('是电话号码');
          return true;
     }
     else
     {
          //alert('不是电话号码');
          return false;
     }
}

//修改密码
$(function(){
	$("#modifypwd_btn").click(function(){
		var oldjspupd=$('#id_oldPwd').val();
		var newupd=$('#id_newPwd').val();
		var newupd1=$('#id_newPwd1').val();
		if(ispwd(newupd)){
			if(newupd==newupd1){
				if(oldjspupd==oldupd){
					$.post("modifypwd",{jspnewupd:newupd},function(data){
						alert(data);
						if(data==null||data==""){
							alert("修改失败");			
						 }else{				
							 alert("密码修改成功");
							 $("#setpwdModal").modal("hide");
						 }		
					});
				}else{
					$('#pwdspan').text("原密码输入不正确");
				}			
			}else{
				$('#pwdspan').text("两次输入的密码不一致");
			}	
		}else{
			$('#pwdspan').text("密码要以字母开头，长度在6-18之间，只能包含字符、数字和下划线");
		}
	})	
})
		
function ispwd(upd){
	var patern=/^[a-zA-Z]\w{5,17}$/;
	if(patern.test(upd)){
		return true;
	}else{
		return false;
	}
}



