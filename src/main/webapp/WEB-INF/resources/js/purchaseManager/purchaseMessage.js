function purmedicineMesageLike() {

	var pageContext = $("PageContext").value;
	var path = $("#PageContext").val() + '/purchase/purLikeMed';
	var mname = $('#mname').val();
	$.post(path, {
		mname : mname,
	}, function(data) {
		$('#purtable').empty();
		$.each(data,function(index,list) {
			$('#purtable').append(
					"<tr class='active'>" + "<td>" + list.mid + "</td>"
							+ "<td>" + list.mname + "</td>" + "<td>"
							+ list.tinnum + "</td>"
							+ "<td>" + list.tsnum + "</td>" + "<td>"
							+ list.cnum + "</td>" + "<td>"
							+ list.cnum + "</td>" + "<td>"
							+ list.prodate + "</td>" + "<td>"
							+ list.validdate + "</td>" + "</tr>");
		});

	})
}

