<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script
	src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>

<script
	src="${pageContext.request.contextPath }/static/js/inventoryManager/echarts.js"></script>

</head>

<body>
<div id="main" style="width: 1000px; height: 400px;"></div>
		<div id="inmain" style="width: 1000px; height: 452px;"></div>
		
<script type="text/javascript">
	var myChart1 = echarts.init(document.getElementById('main'));
	myChart1.setOption({
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
	myChart1.showLoading();
	$.post("${pageContext.request.contextPath }/inventory/statisticsBymonthzhuxing?nyear=2018").done(function(data) {
		var date = new Array();
		var tprice = new Array();
		var tnum = new Array();
		$.each(data, function(i, is) {
			date[i] = is.tdate;
			tprice[i] = is.tprice;
			tnum[i] = is.tnum;
		});
		myChart1.hideLoading();
		myChart1.setOption({
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
</div>		
<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('inmain'));
	myChart.setOption({
		title : {
			text : '库存统计图表',
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '入库数量', '销售数量','盘点数量' ]
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
			data : []
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : '入库数量',
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
			name : '销售数量',
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
		},{
			name : '盘点数量',
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
	$.post("${pageContext.request.contextPath }/purchase/purchaseMessageStatitics").done(function(data) {
		var mname = new Array();
		var tinnum = new Array();
		var tsnum = new Array();
		var cnum = new Array();
		$.each(data, function(i, is) {
			mname[i] = is.mname;
			tinnum[i] = is.tinnum;
			tsnum[i] = is.tsnum;
			cnum[i] = is.cnum;
		});
		myChart.hideLoading();
		myChart.setOption({
			xAxis: {
				name : '药品名称',
	            data : mname
	        },
			series : [ {
				name : '进货数量',
				data : tinnum
			}, {
				name : '销售数量',
				data : tsnum
			}, {
				name : '盘点数量',
				data : cnum
			}]
		});
	});
		
</script>
</body>

</html>