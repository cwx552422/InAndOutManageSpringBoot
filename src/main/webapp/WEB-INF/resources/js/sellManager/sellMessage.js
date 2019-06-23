
function semedicineMesageLike() {
	var pageContext = $("PageContext").value;
	var path = $("#PageContext").val() + '/sell/semedicineMesageLike';
	var mname = $('#mname').val();
	var fmedname = $('#fmedname').val();
	$.post(path, {
		mname : mname,
		fmedname : fmedname
	}, function(data) {
		$('#setable').empty();
		/*$('#title').append("<h3>"+条件查询药品+"</h3>");*/
		$.each(data,function(index,list) {
			$('#setable').append(
					"<tr class='active'>" + "<td>" + list.sid + "</td>"
							+ "<td>" + list.sdocno + "</td>" + "<td>"
							+ list.med.mname + "</td>"
							+ "<td>" + list.med.fmedicine.fmedicine + "</td>" + "<td>"
							+ list.snum + "</td>" + "<td>"
							+ list.spprice + "</td>" + "<td>"
							+ list.sdate + "</td>" + "<td>"							
							+ list.cust.cname + "</td>" + "</tr>");
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


