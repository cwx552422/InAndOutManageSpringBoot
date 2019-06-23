<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>柱形图</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
   <link href="${pageContext.request.contextPath }/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/inventory.css">
	<script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/ inventoryManager/moment-with-locales(1).js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/static/js/ inventoryManager/bootstrap-datetimepicker.min.js"></script>			
	<script src="${pageContext.request.contextPath }/static/js/ inventoryManager/bootstrap-datetimepicker.zh-CN.js"></script>	
    <script src="${pageContext.request.contextPath }/static/js/ inventoryManager/inventory.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/ inventoryManager/echarts.js"></script>		
	
</head>
<body>
	<%-- <div id="userTable">
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
						<a href="#" onclick=showAtmiddle("zhuxing()")><img
							src="${pageContext.request.contextPath }/static/img/inventory/zhuxingtu.png"></a>
						<a href="#"><img id="bingtu"
							src="${pageContext.request.contextPath }/static/img/inventory/bingtu.png"></a>
					</div>
				</form>
			</caption>
			
			
			
		</table> --%>
		<div id="imain1" style="width: 600px; height: 400px;"></div>
	
</body>
<script>
//异步加载图形


	//柱形图

	var myChart = echarts.init(document.getElementById('imain1'));
	var colors = ['#5793f3', '#d14a61'/* , '#675bba' */];
	myChart.setOption = {
	    color: colors,

	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross'
	        }
	    },
	    grid: {
	        right: '20%'
	    },
	    toolbox: {
	        feature: {
	            dataView: {show: true, readOnly: false},
	            restore: {show: true},
	            saveAsImage: {show: true}
	        }
	    },
	    legend: {
	        data:['进购总量','进购总金额'/* ,'平均温度' */]
	    },
	    xAxis: [
	        {
	            type: 'category',
	            axisTick: {
	                alignWithLabel: true
	            },
	            data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	            name: '进购总量',
	            min: 0,
	            max: 1000,
	            position: 'right',
	            axisLine: {
	                lineStyle: {
	                    color: colors[0]
	                }
	            },
	            axisLabel: {
	                formatter: '{value} ml'
	            }
	        },
	        {
	            type: 'value',
	            name: '进购总金额',
	            min: 0,
	            max: 10000,
	            position: 'right',
	            offset: 80,
	            axisLine: {
	                lineStyle: {
	                    color: colors[1]
	                }
	            },
	            axisLabel: {
	                formatter: '{value} ml'
	            }
	        },
	      /*  {
	            type: 'value',
	            name: '温度',
	            min: 0,
	            max: 25,
	            position: 'left',
	            axisLine: {
	                lineStyle: {
	                    color: colors[2]
	                }
	            },
	            axisLabel: {
	                formatter: '{value} °C'
	            }
	        }*/
	    ]};
	    myChart.showLoading();
	  
		// 异步加载数据
		$.get("${pageContext.request.contextPath }/inventory/statisticsBymonth?s=1&&nyear=2017").done(function (data) {
		    // 填入数据
			alert(data);
		    var inventoryStatistics =  JSON.parse(data);
		    var date=new Array();
		    var tprice=new Array();
		    var tnum=new Array();		   
		     $.each(inventoryStatistics,function(i,is){ 		    	 
		    	 date[i]=is.date;
		    	 tprice[i]=is.tprice;
		    	 tnum[i]=is.tnum;
		     }); 
		    myChart.hideLoading();
		    myChart.setOption({
//		        xAxis: {
//		            data: arr1
//		        },
		        series: [
		            {
		                name:'进购总量',
		                type:'bar',
		                data:tnum
		            },
		            {
		                name:'进购总金额',
		                type:'bar',
		                yAxisIndex: 1,
		                data:tprice
		             }
//		            {
//		                name:'平均温度',
//		                type:'line',
//		                yAxisIndex: 2,
//		                data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
//		            }
		        ]
		  
		})
	    
	})





   

		
</script>
</html>