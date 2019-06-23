function delformMed(fid){
	alert("hello");
	var pageContext = $("PageContext").value;
	var path = $("#PageContext").val() + '/medicine/delformMed';
	$.post(path,{fid:fid},function(data){
		if(data==null||data==""){
			alert("删除失败");			
		 }else{
			 alert("删除成功")
		 }
	})
}


function addFormOfMedicine() {
	var pageContext = $("PageContext").value;
	var path = $("#PageContext").val() + '/medicine/addFormOfMedicine';
	var fmedicine = $('#fmedicine').val();
	alert(fmedicine);
	$.post(path, {
		fmedicine : fmedicine
	}, function(data) {
		if (data == null || data == "") {
			alert('添加失败');
		} else {
			alert('添加成功');
			var path1 = $("#PageContext").val() + '/medicine/formOfMedicine';
			return path;
			showAtmiddle(path1);
		}
	})
}

function medicineMesageLike() {
	var pageContext = $("PageContext").value;
	var path = $("#PageContext").val() + '/medicine/medicineMesageLike';
	var mname = $('#mname').val();
	var fmedname = $('#fmedname').val();
	$.post(path, {
		mname : mname,
		fmedname : fmedname
	}, function(data) {
		$('#medtable').empty();
		/*$('#title').append("<h3>"+条件查询药品+"</h3>");*/
		
		$.each(data,function(index,list) {
			$('#medtable').append(
					"<tr class='active'>" + "<td>" + list.mid + "</td>"
							+ "<td>" + list.mname + "</td>" + "<td>"
							+ list.fmedicine.fmedicine + "</td>"
							+ "<td>" + list.units + "</td>" + "<td>"
							+ list.manufacture + "</td>" + "<td>"
							+ dateformat(list.proDate) + "</td>" + "<td>"
							+ list.validDate + "</td>" + "<td>"
							+ list.description + "</td>" + "</tr>");
		});

	})
}

function formofmedicineMesageLike(){
	var pageContext = $("PageContext").value;
	var path = $("#PageContext").val() + '/medicine/formofmedicineMesageLike';
	var fmedname = $('#fmedname').val();
	var operate = '删除';
	$.post(path, {
		fmedname : fmedname
	}, function(data) {
		$('#ftable').empty();
		$.each(data,function(index,list) {
			$('#ftable').append(
					"<tr class='active'>" + "<td>" + list.fid + "</td>"
							+ "<td>" + list.fmedicine + "</td>" 
							+ "<td><a href='#' onclick=''>"  + operate +"</a></td>"
						+ "</tr>");
		});

	})
}


function dateformat(str){  
    if(str == null || str == "" || typeof(str)=="undefined"){  
       return "";  
    }  
    var now = new Date(str);  
    var year = now.getFullYear();  
    var month =(now.getMonth() + 1).toString();  
    var day = (now.getDate()).toString();  
    if (month.length == 1) {  
         month = "0" + month;  
    }  
    if (day.length == 1) {  
         day = "0" + day;  
    }  
     var dateTime = year +"-"+ month +"-"+  day;  
   return dateTime;  
}  