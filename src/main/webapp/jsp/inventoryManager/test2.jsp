<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<div id="test" style="width: 600px; height: 400px;"></div>
</body>
<script>
var myChart = echarts.init(document.getElementById('test'));

myChart.setOption (
 {
	    title : {
	        text: '进购统计图表',
	        subtext: '纯属虚构'
	    },
	    tooltip : {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['进购总量','进购总金额']
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: true, readOnly: false}, 
	            magicType : {show: true, type: ['line', 'bar']},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    calculable : true,
	    xAxis : [
	        {
	            type : 'category',
	            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'进购总量',
	            type:'bar',
	            data:[],
	            markPoint : {
	                data : [
	                    {type : 'max', name: '最大值'},
	                    {type : 'min', name: '最小值'}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name: '平均值'}
	                ]
	            }
	        },
	        {
	            name:'进购总金额',
	            type:'bar',
	            data:[],
	            markPoint : {
	                data : [
	                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
	                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
	                ]
	            },
	            markLine : {
	                data : [
	                    {type : 'average', name : '平均值'}
	                ]
	            }
	        }
	    ]
	});
	
myChart.showLoading();

// 异步加载数据
$.get("${pageContext.request.contextPath }/inventory/statisticsBymonth?s=1&&nyear=2017").done(function (data) {
    // 填入数据
    var inventoryStatistics =  JSON.parse(data);
    var date=new Array();
    var tprice=new Array();
    var tnum= new Array();
     $.each(inventoryStatistics,function(i,is){ 		    	 
    	 date[i]=is.date;
    	 tprice[i]=is.tprice;
    	 tnum[i]=is.tnum;
     }); 
    myChart.hideLoading();
    myChart.setOption ({
    series : [
        {
            name:'进购总量',
            data:tnum        
        },
        {
            name:'进购总金额',
            data:tprice
        }
    ]
    });
});
</script>
</html>