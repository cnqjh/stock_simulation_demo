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
	    	
	    var trlength = $("#historyHoldings tbody").children("tr").length;
	 	  for(var i=0;i<trlength-1;i++){
	 		 var state = $("#data_"+i).find("td").eq(5).html();var html='';
	 		 if(state =="1"){
	 			html +='<span  style="color:red;">购买</span>';
	 		 }
	 		 if(state =="2"){
	 			html +='<span  style="color:#87dc4a;">预购</span>';
	 		 }
	 		$("#data_"+i).find("td").eq(5).html(html);
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
		<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：首页 &gt; 股票明细</td>
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
			  	<form name="empform" method="post" id="empform" action="${ctx}/historyHolding/selectHistoryHolding">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td align="right">股票代码：</td>
					    <td><input autocomplete="off"type="text" name="stockCode"></td>
					    <td align="right">股票名称：</td>
					    <td><input autocomplete="off"type="text" name="stockName"></td>	
					    
					  </tr>
					  <tr>
					  <td colspan="6" align="right">
					       <input type="submit" value="搜索"/>
					       <input id="updata" onclick="javascript:window.location.reload()" type="button" value="重置"/>
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
		  <table id="historyHoldings"width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr class="main_trbg_tit" align="center">
			 
			  <td>股票代码</td>
			  <td>股票名称</td>			 
			  <td>持股量</td>
			  <td>成本价</td>
			  <td>收盘价</td>
			  <td>状态</td>
			  <td>浮动盈亏</td>	
			  <td>盈亏比例</td>
			  <td>持有比例</td>
			  <td>币种</td>			  							
			</tr>	
			<c:forEach items="${requestScope.historyHoldings}" var="historyHolding" varStatus="stat">
				<tr id="data_${stat.index}" align="center" class="main_trbg" >
					 					  
					  <td >${historyHolding.stockCode }</td>	
					  <td >${historyHolding.stockName }</td>
					  <td >${historyHolding.holdingNum }</td>
					  <td>${historyHolding.costPrice }</td>
					  <td>${historyHolding.closingPrice }</td>
					  <td>${historyHolding.state }</td>
					  <td>${historyHolding.floatingProfitAndLoss }</td>
					  <td>${historyHolding.profitAndLossRatio }</td>
					  <td>${historyHolding.holdingRatio }</td>
					  <td>${historyHolding.currency }</td>					 
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
	  	        submitUrl="${ctx}/historyHolding/selectHistoryHolding?pageIndex={0}"/>
	  </td></tr>
	</table>
	<div style="height:10px;"></div>
</body>
</html>