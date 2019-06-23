
function listLikeMsgLog() {
	var pageContext = $("PageContext").value;
	var path = $("#PageContext").val() + '/log/listLikeMsgLog';
	var uname = $('#uname').val();
	var record = $('#record').val();
	$.post(path, {
		uname : uname,
		record : record
	}, function(data) {
		$('#ltable').empty();
		/*$('#title').append("<h3>"+条件查询药品+"</h3>");*/
		
		$.each(data,function(index,list) {
			$('#ltable').append(
					"<tr class='active'>" + "<td>" + list.admin.uname + "</td>"
							+ "<td>" + list.record + "</td>" + "<td>"
							+ dateformat(list.time)+ "</td>"
							 + "</tr>");
		});

	})
}
