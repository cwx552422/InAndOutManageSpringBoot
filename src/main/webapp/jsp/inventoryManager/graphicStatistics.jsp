<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图表统计</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
   <link href="${pageContext.request.contextPath }/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/inventory.css">
	<script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/inventoryManager/moment-with-locales(1).js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/static/js/inventoryManager/bootstrap-datetimepicker.min.js"></script>			
	<script src="${pageContext.request.contextPath }/static/js/inventoryManager/bootstrap-datetimepicker.zh-CN.js"></script>	
    <script src="${pageContext.request.contextPath }/static/js/inventoryManager/inventory.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/inventoryManager/echarts.js"></script>		
	
</head>

<body>   
				
 <div id="userTable">
		<table class="table">
			<caption>
				<h3>进货图表统计</h3>
				<form>
					<div>
						<input type="radio" name="statiscs" value="month" checked>按月统计
						<input type="radio" name="statiscs" value="year">按年统计 				
						<input id="form_datetime" type="text" value="" size="6">
					</div>
					<div id="img">
						<a href="#" onclick="showAtmiddle("${pageContext.request.contextPath }/inventory/statisticsBymonth?s=0&&nyear=2017")"><img
							src="${pageContext.request.contextPath }/static/img/inventory/excel.png"></a>
						<a href="#" data-toggle="modal" data-target="#showInvenotryModal"><img
							src="${pageContext.request.contextPath }/static/img/inventory/zhuxingtu.png"></a>
						<a href="#"><img id="bingtu"
							src="${pageContext.request.contextPath }/static/img/inventory/bingtu.png"></a>
					</div>
				</form>
			</caption>
			<div >
				<thead>
					<tr>
						<td>进货月份</td>
						<td>进货月总数量</td>
						<td>进货月总价格</td>
					</tr>
				</thead>
				  <tbody id="itable">
				  
					 <c:forEach items="${list}" var="bymonth">
						<tr class="active">
							<td>${bymonth.getTdate() }</td>
							<td>${bymonth.getTnum() }</td>
							<td>${bymonth.getTprice() }</td>
						</tr>
					</c:forEach> 
				</tbody>  
			</div>
			
		</table>
	</div> 
		<!----------------------------- 进货图表显示 --------------------------->		
<div class="modal fade" id="showInvenotryModal" style="display:none;">	
	<div class="modal-dialog" style="width:800px;height:700px">
		<div class="modal-content" style="border:none;width:800px;height:450px">
			<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
					<h4 class="modal-title" id="setpwdModalLabel" style="font-size: 18px;">进货图表统计</h4>
				</div>
			<div class="modal-body">
				<div id="main" style="width: 600px; height: 400px;"></div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('main'));
	myChart.setOption({
		title : {
			text : '进购统计图表',
			subtext : '纯属虚构'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '进购总量', '进购总金额' ]
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			data : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月',
					'10月', '11月', '12月' ]
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : '进购总量',
			type : 'bar',
			data : [],
			markPoint : {
				data : [ {
					type : 'max',
					name : '最大值'
				}, {
					type : 'min',
					name : '最小值'
				} ]
			},
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		}, {
			name : '进购总金额',
			type : 'bar',
			data : [],
			markPoint : {
				data : [ {
					name : '年最高',
					value : 182.2,
					xAxis : 7,
					yAxis : 183,
					symbolSize : 18
				}, {
					name : '年最低',
					value : 2.3,
					xAxis : 11,
					yAxis : 3
				} ]
			},
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		} ]
	});
	myChart.showLoading();
	$.post("${pageContext.request.contextPath }/inventory/statisticsBymonthzhuxing?nyear=2018").done(function(data) {
		var date = new Array();
		var tprice = new Array();
		var tnum = new Array();
		$.each(data, function(i, is) {
			date[i] = is.tdate;
			tprice[i] = is.tprice;
			tnum[i] = is.tnum;
		});
		myChart.hideLoading();
		myChart.setOption({
			series : [ {
				name : '进购总量',
				data : tnum
			}, {
				name : '进购总金额',
				data : tprice
			} ]
		});
	});
		
</script>	
	
    </body>
   
</html>