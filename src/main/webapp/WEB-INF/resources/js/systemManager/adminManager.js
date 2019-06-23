function delAdmin(uid){
	$.post("delAdmin",{uid:uid},function(data){
		if(data==null||data==""){
			alert("删除失败");			
		 }else{
			 alert("删除成功")
			 showAtmiddle('adminMessage?pageNo=0');
		 }
	})
}


//增加管理员


function isname(uname){
	var parttern=/^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/ ;
	var parttern1= /^[a-zA-Z\/ ]{2,20}$/ ;
	if(parttern1.test(uname)||parttern.test(uname)){
		return true;
	}else{
		return false;
	}
}


function addadmin(){
	alert("hello");
	var uname=$('#add_uname').val();
	var upd=$('#add_Pwd').val();		
	var upd1=$('#add_Pwd1').val();
	var tel=$('#add_tel').val();
	var role=$('#add_role').val();
	if(isname(uname)){
		if(ispwd(upd)){
			if(upd==upd1){
					if(isphone2(tel)||isphone1(tel)){
						$.post("addAdmin",{uname:uname,upd:upd,tel:tel,role:role},function(data){
							if(data==null||data==""){
								alert("添加失败");			
							 }else{
								 
								 alert("添加成功");
								 $("#addAdminModal").modal("hide");
								 showAtmiddle('adminMessage?pageNo=0');
							 }
						})
					}else{
						$('#add_telspan').text("手机/电话号码格式不正确");
					}
			}else{
				$('#add_pwdspan1').text("两次输入的密码不一致");
			}	
		}else{
			$('#add_pwdspan').text("密码要以字母开头，长度在6-18之间，只能包含字符、数字和下划线");
		}
	}else{
		$('#add_unamespan').text("名字不符合规范");
	}	
}




$(function () {          
    $("#btn").click(function () {
        //将表单封装成一个表单数据对象
        var formData = new FormData($("#ff")[0]);  //必
        $.ajax({
            url: '@Url.Action("aaa")',
            type: "POST",
            data: formData,
            contentType: false, //必须false才会避开jQuery对 formdata 的默认处理 
            processData: false, //必须false才会自动加上正确的Content-Type
            success: function (data) {
                alert(data)
            }
        });

    });
});