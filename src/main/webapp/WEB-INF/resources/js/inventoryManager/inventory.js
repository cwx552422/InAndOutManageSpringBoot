//添加进货药品信息
function addInventoryMsg(){
	var pageContext = $("PageContext").value;
	var path = $("#PageContext").val() +'/inventory/addInventoryMsg';
	var mname=$('#medname').val();
	var innum=$('#innum').val();
	var inPrice=$('#inPrice').val();
	var inTime=$('#inTime').val();
	var proname=$('#proname').val();
	$.post(path,{mname:mname,innum:innum,inPrice:inPrice,inTime:inTime,proname:proname},function(data){
		if(data==null||data==""){
			alert('添加失败');		
		 }else{
			 alert('添加成功');
        	 var path1 = $("#PageContext").val() + '/inventory/inMedMessage';
        	 return path;
			 showAtmiddle(path1);
		 }
	})
}


function inmedicineMesageLike(){
	alert("hello");
	var pageContext = $("PageContext").value;
	var path = $("#PageContext").val() + '/inventory/inmedicineMesageLike';
	var mname = $('#mname').val();
	var fmedname = $('#fmedname').val();
	$.post(path, {
		mname : mname,
		fmedname : fmedname
	}, function(data) {
		$('#intable').empty();
		/*$('#title').append("<h3>"+条件查询药品+"</h3>");*/
		
		$.each(data,function(index,list) {
			$('#intable').append(				
					"<tr class='active'>" + "<td>" + "IN"+list.inid + "</td>"
							+ "<td>"+ "INDOC"+ + list.inDocNo + "</td>" + "<td>"
							+list.med.mname + "</td>"
							+ "<td>" + list.med.fmedicine.fmedicine+ "</td>" + "<td>"
							+ list.inNum + "</td>" + "<td>"
							+ list.inPrice + "</td>" + "<td>"
							+ dateformat(list.inTime) + "</td>" + "<td>"
							+ list.pro.proName + "</td>" + "<td>"
							+ list.state + "</td>" + "</tr>");
		});

	})
}