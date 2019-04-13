<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>股票模拟操作管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
	<script language="javascript" type="text/javascript" src="${ctx}/DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(function(){
	 	   /** 获取上一次选中的部门数据 */
	 	   var boxs  = $("input[type='checkbox'][id^='box_']");
	 	   
	 	  /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
	    	$("tr[id^='data_']").hover(function(){
	    		$(this).css("backgroundColor","#eeccff");
	    	},function(){
	    		$(this).css("backgroundColor","#ffffff");
	    	})
	    	var region='${sessionScope.region}';
	    	if(region=="sh"){
	    		$('#region').html("上海证券");
	    	}else if(region=="sz"){
	    		$('#region').html("深圳证券");
	    	}
	    
	    })
	</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：股票查询 &gt; <span id="region"></span></div></td>
		<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	
	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
	  <!-- 查询区  -->
	  <tr valign="top">
	    <td height="30">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr>
			  <td class="fftd">
			  	<form name="empform" method="post" id="empform" action="${ctx}/stock/selectStock">
			  	<!-- 隐藏表单，flag表示添加标记 -->
		    	 	<input type="hidden" name="flag" value="2">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td align="right">股票代码：</td>
					    <td><input autocomplete="off"type="text" name="stockCode"></td>
					    <td align="right">股票名称：</td>
					    <td><input autocomplete="off"type="text" name="stockName"></td>	
					    <td align="right">创建日期：</td>
					    <td><input autocomplete="off"type="text" name="createDate" class="Wdate" onClick="WdatePicker()"></td>					    
					  </tr>
					  <tr>
					  <td colspan="6" align="right">
					       <input type="submit" value="搜索"/>
					       <input id="updata" type="button" onclick="javascript:window.location.reload()"value="重置"/>
					  </td>
					  </tr>
					</table>
				</form>
			  </td>
			</tr>
		  </table>
		</td>
	  </tr>
	  
	  <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
		  <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr class="main_trbg_tit" align="center">
		    <td>日期</td>
			  <td>时间</td>	
			  <td>股票代码</td>
			  <td>股票名字</td>
			  <td>今日开盘价</td>			  
			  <td>昨日收盘价</td>
			  <td>当前价格</td>
			  <td>今日最高价</td>
			  <td>今日最低价</td>
			  <td>竞买价</td>
			  <td>竞卖价</td>
			  <td>成交的股票数</td>
			  <td>成交金额</td>
			  <td align="center">操作</td>						
			</tr>
			<c:forEach items="${requestScope.realTimeStocks}" var="realTimeStock" varStatus="stat">
				<tr id="data_${stat.index}" align="center" class="main_trbg" >
					<td>${realTimeStock.date }</td>
					<td>${realTimeStock.time }</td>	
					<td>${realTimeStock.code }</td>	
					<td>${realTimeStock.name }</td>
					<td>${realTimeStock.open }</td>
					<td>${realTimeStock.lastClose }</td>
					<td>${realTimeStock.price }</td>
					<td>${realTimeStock.todayHigh }</td>
					<td>${realTimeStock.todayLow }</td>
					<td>${realTimeStock.competitiveBuyPrice }</td>
					<td>${realTimeStock.competitiveSellPrice }</td>
					<td>${realTimeStock.count }</td>
					<td>${realTimeStock.total }</td>
					  <td align="center" width="40px;"><a href="${ctx}/stock/viewStock?flag=1&code=${realTimeStock.code }">
							<img title="查看" src="${ctx}/images/update.gif"/></a>
					  </td>
					 
				</tr>
			</c:forEach>
		  </table>
		</td>
	  </tr>
	  <!-- 分页标签 -->
	  <tr valign="top"><td align="center" class="font3">
	  	 <fkjava:pager
	  	        pageIndex="${requestScope.pageModel.pageIndex}" 
	  	        pageSize="${requestScope.pageModel.pageSize}" 
	  	        recordCount="${requestScope.pageModel.recordCount}" 
	  	        style="digg"
	  	        submitUrl="${ctx}/stock/selectStock?pageIndex={0}"/>
	  </td></tr>
	</table>
	<div style="height:10px;"></div>
</body>
</html>