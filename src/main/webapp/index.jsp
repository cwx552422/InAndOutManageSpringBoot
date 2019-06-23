<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>药品进销存管理首页</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/index/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/inventory.css">
     	<link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.min.css">
		<link href="${pageContext.request.contextPath }/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/index/setPersonal.css">  
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/fileinput.min.css"> 
   
		<script src="${pageContext.request.contextPath }/static/js/jquery-3.2.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/inventoryManager/moment-with-locales(1).js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath }/static/js/inventoryManager/bootstrap-datetimepicker.min.js"></script>			
		<script src="${pageContext.request.contextPath }/static/js/inventoryManager/bootstrap-datetimepicker.zh-CN.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/index/index.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/inventoryManager/inventory.js"></script>	
    	<script src="${pageContext.request.contextPath }/static/js/inventoryManager/echarts.js"></script>	
   	<script src="${pageContext.request.contextPath }/static/js/systemManager/adminManager.js"></script>	
   	<script src="${pageContext.request.contextPath }/static/js/index/datacope.js"></script>	
    <script src="${pageContext.request.contextPath }/static/js/medicineMessageManager/medicineMessage.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/file/ajaxfileupload.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/recordSearch/log.js"></script>
	    <script src="${pageContext.request.contextPath }/static/js/file/locales/zh.js"></script>
	    <script src="${pageContext.request.contextPath }/static/js/file/fileinput.min.js"></script>	
	    <script src="${pageContext.request.contextPath }/static/js/sellManager/sellMessage.js"></script>
	    <script src="${pageContext.request.contextPath }/static/js/purchaseManager/purchaseMessage.js"></script>		
	</head>

	<body>
	<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-6 column" id="div1">
					<div id="headtext">
						<h2>医药进销存管理系统</h2>
					</div>
				</div>
				<div class="col-md-5 column" id="div2">
					<ul class="breadcrumb">
						<li>
							<a href="${pageContext.request.contextPath }/admin/indexmid">首页</a>
						</li>
						<li>
							<div class="btn-group">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									个人设置
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="#"  class="a globalSetBtn">个人信息更改</a>
									</li>
									<li>
										<a href="${pageContext.request.contextPath }/test.jsp"  onclick="" >头像更改</a>
									</li>
									<li>
										<a href="#" data-toggle="modal" data-target="#setpwdModal">密码更改</a>
									</li>
									<li>
										<a href="#" onclick="showAtmiddle('recordList.jsp')">其它</a>
									</li>
								</ul>										
							</div>
						</li>
						<li>
							<a href="${pageContext.request.contextPath }/admin/exitmid">退出</a>
						</li>
					</ul>
				</div>
				<div class="col-md-1 column" id="people">
					<table>
						<tr>
						    <td><img src="${admin.getImg() }" class="img-circle" id="img12"></td>
							<td style="margin-top: 5px;">${admin.getUname() }</td>
						</tr>
					</table>
				</div>
			</div>

			<div class="row clearfix">
				<div class="col-md-2 column" id="div3">
					<div id="left" data-spy="scroll" data-target="#navbar-example" data-offset="0">
						<div class="panel-group" id="accordion">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h4 class="panel-title">
									<img src="${pageContext.request.contextPath }/static/img/index/admin.png" class="leftLittle">&nbsp;
									<a data-toggle="collapse" data-parent="#accordion" 
									   href="#collapseOne">
										系统设置
									</a>
								</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in">
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/admin/adminMessage?pageNo=0')">管理员资料</a>
									</div>
									<div class="panel-body">
										<a href="#" onclick="backData()">备份数据</a>
									</div>
									<div class="panel-body">
										<a href="#" onclick="deleteData()">删除数据</a>
									</div>
									<div class="panel-body">
										<a href="#" onclick="resumeData()">恢复数据</a>
									</div>									
								</div>
							</div>
							<div class="panel panel-success">
								<div class="panel-heading">
									<h4 class="panel-title">
									<img src="${pageContext.request.contextPath }/static/img/index/medicine.png" class="leftLittle">&nbsp;
									<a data-toggle="collapse" data-parent="#accordion" 
									   href="#collapseTwo">
										药品信息管理
									</a>
								</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse collapse">
								
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/medicine/formOfMedicine')">药品分类</a>
									</div>
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/medicine/allMedicine?pageNo=0')">所有药品</a>
									</div>
								</div>
							</div>
							<div class="panel panel-info">
								<div class="panel-heading">
									<h4 class="panel-title">
									<img src="${pageContext.request.contextPath }/static/img/index/in.png" class="leftLittle">&nbsp;
								<a data-toggle="collapse" data-parent="#accordion" 
								   href="#collapseThree">
								进货管理
								</a>
							</h4>
								</div>
								<div id="collapseThree" class="panel-collapse collapse">
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/inventory/inMedMessage?pageNo=0')">进货信息查询</a>
									</div>
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/inventory/inbill')">进货退单</a>
									</div>
									<div class="panel-body">
										<%-- <a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/InventoryStatistics.jsp')">进货图表统计</a> --%>
									<a href="#" data-toggle="modal" data-target="#showInvenotryModal">进货图表统计</a>
									</div>
								</div>
							</div>
							<div class="panel panel-warning">
								<div class="panel-heading">
									<h4 class="panel-title">
									<img src="${pageContext.request.contextPath }/static/img/index/sell.png" class="leftLittle">&nbsp;
								<a data-toggle="collapse" data-parent="#accordion" 
								   href="#collapseFour">
									销售管理
								</a>
							</h4>
								</div>
								<div id="collapseFour" class="panel-collapse collapse">
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/sell/sellMessage?pageNo=0')">销售信息查询</a>
									</div>
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/sell/sellbill')">销售开单</a>
									</div>
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/sell/reebillMessage?pageNo=0')">销售退单</a>
									</div>
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/sell/profitsStatistics')">利润结算</a>
									</div>
									<div class="panel-body">
										<a href="#" data-toggle="modal" data-target="#showsellModal">利润图表统计</a>
									</div>
								</div>
							</div>
							<div class="panel panel-danger">
								<div class="panel-heading">
									<h4 class="panel-title">
									<img src="${pageContext.request.contextPath }/static/img/index/exist.png" class="leftLittle">&nbsp;	
								<a data-toggle="collapse" data-parent="#accordion" 
								   href="#collapseFive">
									库存管理
								</a>
							</h4>
								</div>
								<div id="collapseFive" class="panel-collapse collapse">
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/purchase/purchaseMessage')">库存信息管理</a>
									</div>
									<div class="panel-body">
										<a href="#" data-toggle="modal" data-target="#showpurchaseModal">库存图表统计</a>
									</div>
								
								</div>
							</div>
							<div class="panel panel-warner">
								<div class="panel-heading">
									<h4 class="panel-title">
									<img src="${pageContext.request.contextPath }/static/img/index/record.png" class="leftLittle">	
									<a data-toggle="collapse" data-parent="#accordion" 
									   href="#collapseSix">
										日志查询
									</a>
									</h4>
								</div>
								<div id="collapseSix" class="panel-collapse collapse">
									<div class="panel-body">
										<a href="#" onclick="showAtmiddle('${pageContext.request.contextPath }/log/loglist?pageNo=0')">操作记录</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-9 column" id="middle">
					<div id="mid">欢迎登陆系统</div>
				</div>
				<div class="col-md-1 column" id="right">
					<div id="message">
						<img src="${pageContext.request.contextPath }/static/img/index/message.png" id="messageImg">&nbsp;信息公告
						<div id="showMessage">
							<div class="Carcontainer">
								<div id="myCarousel" class="carousel slide">
									
									<!-- 轮播（Carousel）项目 -->
									<div class="carousel-inner">
										<div class="item active">
											2018.12.25日进购了一批新药，请及时录入信息
										</div>
										<div class="item">
											请及时下载12月份的进货订单和销售订单核对药品信息
										</div>
										<div class="item">
											今天将会有药品运送到这，及时录入信息
										</div>
									</div>
									<!-- 轮播（Carousel）导航 -->
									<a class="carousel-control left" href="#myCarousel" data-slide="prev"></a>
									<a class="carousel-control right" href="#myCarousel" data-slide="next"></a>
								</div>
							</div>
						</div>
					</div>
					<div>
						<div id="form_datetime"></div>

					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column" id="bottom">
					&copy;MEDICINE MANAGER SYSTEM, powered by CHENLI.法律声明<br/> 转载内容版权归作者及来源网站所有，本站原创内容转载请注明来源
				</div>
			</div>
			
<!----------------------------- 个人信息修改弹出框 --------------------------->		
<div class="modal fade" id="setModal" style="display:none;">
	
	<div class="modal-dialog modal-sm" style="width:540px;">
		<div class="modal-content" style="border:none;">
			<div class="col-left"><img id="peopleimg" src="${admin.getImg() }"></div>
			<div class="col-right">
				<div class="modal-header">
					<button type="button" id="login_close" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title" id="loginModalLabel" style="font-size: 18px;">个人信息修改</h4>
				</div>
				<div class="modal-body">	
						<form id="login_form" action="" method="post" autocomplete="off">
							
							<ul>
								<li class="form-group">姓名：<input class="form-control" id="id_uname" maxlength="50" name="account_l" value="${admin.getUname() }" type="text"></li>
								<li class="form-group">
								联系方式<input class="form-control" id="id_tel" name="password_l" value="${admin.getTel() }" type="text">
								<span style="float: right" id="telspan"></span>
								</li>				
				
							</ul>
						</form>
						<div class="login-box marginB10">
							<button id="modify_btn" type="button" class="btn btn-micv5 btn-block globalLogin">修改</button>
							<div id="modify_error" class="tips-error bg-danger" style="display: none;">错误提示</div>
						</div>				
				</div>
			</div>
		</div>
	</div>	
</div>		

<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/index/script.js"></script>

</div>


<!----------------------------- 个人头像修改弹出框 --------------------------->		
<div class="modal fade" id="setimgModal" style="display:none;">	
	<div class="modal-dialog" style="width:450px;">
		<div class="modal-content" style="border:none;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
					<h4 class="modal-title" id="setimgModal" style="font-size: 18px;">个人头像修改</h4>
				</div>
				<div class="modal-body">	
						<form id="set_form" action="" method="post" autocomplete="off"  enctype="multipart/form-data">
						<div><img src="${pageContext.request.contextPath }/static/img/index/people.jpg" id="peopleimg"></div>		
							<ul>				
								<li class="form-group">头像<input name="file" id="file" checked type="file" /></li>					
							</ul>
						</form>
						<div class="modify-box marginB10">
							<button id="modifyimg_btn" type="button" class="btn btn-micv5 btn-block globalLogin">修改</button>
							<div id="set-form-tips" class="tips-error bg-danger" style="display: none;">错误提示</div>
						</div>				
				</div>
			</div>
		</div>
</div>	



<!----------------------------- 个人密码修改弹出框 --------------------------->		
<div class="modal fade" id="setpwdModal" style="display:none;">	
	<div class="modal-dialog" style="width:450px;">
		<div class="modal-content" style="border:none;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
					<h4 class="modal-title" id="setpwdModalLabel" style="font-size: 18px;">个人密码修改</h4>
				</div>
				<div class="modal-body">	
						<form id="set_form" action="" method="post" autocomplete="off">
							
							<ul>
								<li class="form-group">原密码<input class="form-control" id="id_oldPwd" maxlength="50" name="account_l"  type="password"></li>
								<li class="form-group">新密码<input class="form-control" id="id_newPwd" name="password_l" type="password"></li>
								<li class="form-group">
								再次输入新密码<input class="form-control"  id="id_newPwd1" type="password"/>
								<span style="float: right" id="pwdspan"></span>
								</li>					
							</ul>
						</form>
						<div class="modify-box marginB10">
							<button id="modifypwd_btn" type="button" class="btn btn-micv5 btn-block globalLogin">修改</button>
							<div id="set-form-tips" class="tips-error bg-danger" style="display: none;">错误提示</div>
						</div>				
				</div>
			</div>
		</div>
		<script>var oldupd="${sessionScope.admin.upd}";</script>
</div>

<!----------------------------- 进货图表显示 --------------------------->		
<div class="modal fade" id="showInvenotryModal" style="display:none;">	
	<div class="modal-dialog" style="width:800px;height:700px">
		<div class="modal-content" style="border:none;width:960px;height:600px">
			<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
				<h3 class="modal-title" id="showInvenotryModal" style="font-size: 25px;">进货图表统计</h3>					
				</div>
			<div class="modal-body">				
				<div id="main" style="width: 870px; height: 452px;"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var myChart1 = echarts.init(document.getElementById('main'));
	myChart1.setOption({
		title : {
			text : '进购统计图表',
			
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
	<!----------------------------- 库存图表显示 --------------------------->		
<div class="modal fade" id="showpurchaseModal" style="display:none;">	
	<div class="modal-dialog" style="width:800px;height:700px">
		<div class="modal-content" style="border:none;width:960px;height:600px">
			<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
				<h3 class="modal-title" id="setpwdModalLabel" style="font-size: 25px;">库存图表统计</h3>			
				</div>
			<div class="modal-body">
				
				<div id="inmain" style="width: 870px; height: 452px;"></div>
			</div>
		</div>
	</div>
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
	


<!----------------------------- 利润图表显示 --------------------------->		
<div class="modal fade" id="showsellModal" style="display:none;">	
	<div class="modal-dialog" style="width:800px;height:700px">
		<div class="modal-content" style="border:none;width:960px;height:600px">
			<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
					</button>
				<h3 class="modal-title"  style="font-size: 25px;">利润图表统计</h3>			
				</div>
			<div class="modal-body">
				
				<div id="semain" style="width: 870px; height: 452px;"></div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var myChart3 = echarts.init(document.getElementById('semain'));
	myChart3.setOption({
		title : {
			text : '销售利润统计图表',
			
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '进货金额', '销售金额','利润' ]
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
			name : '进货金额',
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
			name : '销售金额',
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
			name : '利润',
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
		} ]
	});
	myChart3.showLoading();
	$.post("${pageContext.request.contextPath }/sell/profitsStatisticsdisplay").done(function(data) {
		var mname = new Array();
		var inprice = new Array();
		var sprice = new Array();
		var profits = new Array();
		$.each(data, function(i, is) {
			mname[i] = is.mname;
			inprice[i] = is.inprice;
			sprice[i] = is.sprice;
			profits[i] = is.profits;
		});
		myChart3.hideLoading();
		myChart3.setOption({
			xAxis: {
				name : '药品名称',
	            data : mname
	        },
			series : [ {
				name : '进货金额',
				data : inprice
			}, {
				name : '销售金额',
				data : sprice
			}, {
				name : '利润',
				data : profits
			}]
		});
	});
		
</script>
	



	</body>

	
</html>






