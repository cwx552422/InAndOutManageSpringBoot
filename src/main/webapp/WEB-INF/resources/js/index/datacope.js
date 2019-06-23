
//备份数据信息
function backData(){
	$.post("backData",function(data){
		if(data==null||data==""){
			alert("备份失败");			
		 }else{
			 alert("备份成功");	
		 }
	})
}
  
function resumeData(){
	$.post("resumeData",function(data){
		if(data==null||data==""){
			alert("还原失败");			
		 }else{
			 alert("还原成功");	
		 }
	})
}


function deleteData(){
	$.post("deleteAllData",function(data){
		if(data==null||data==""){
			alert("删除失败");			
		 }else{
			 alert("删除成功");	
		 }
	})
}