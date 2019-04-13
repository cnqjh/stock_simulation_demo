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
	 	   /** 获取上一次选中的数据 */
	 	   var boxs  = $("input[type='checkbox'][id^='box_']");
	 	   
	 	  /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
	    	$("tr[id^='data_']").hover(function(){
	    		$(this).css("backgroundColor","#eeccff");
	    	},function(){
	    		$(this).css("backgroundColor","#ffffff");
	    	})
	    	
	    	
	    })
	</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：首页 &gt;总排行榜</td>
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
			  	<form name="empform" method="post" id="empform" action="${ctx}/ranking/selectRanking">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td >学号：
					    <input autocomplete="off"type="text" name="userCode">
					    姓名：
					    <input autocomplete="off"type="text" name="userName">					    
					  
					  
					       <input type="submit" value="搜索"/>       
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
			  <td>学号</td>
			  <td>姓名</td>
			  <td>收益率</td>			 
			  <td>排名</td>
			  <td>升降</td>
			  <td>初始金额</td>
			  <td>总资产</td>			  
			  <td>总损益</td>
			  <td>投资等级</td>
			  <td>TOP数量</td>
			  <td>总点击量</td>
			  <td>日收益率</td>
			  <td>日平均收益率</td>
			  <td>总可用资金</td>
			  <td>操作分</td>
			  <td>违规分</td>
			  <td>综合分</td>
			  <td>日收益率标准差</td>
			  <td>选股能力</td>
			  <td>选时能力</td>								
			</tr>	
			<c:forEach items="${requestScope.totalRankings}" var="totalRanking" varStatus="stat">
				<tr id="data_${stat.index}" align="center" class="main_trbg" onMouseOver="move(this);" onMouseOut="out(this);">
					 
					  <td >${totalRanking.userCode }</td>	
					  <td >${totalRanking.userName }</td>
					  <td >${totalRanking.earningsRate }</td>
					  <td>${totalRanking.ranking }</td>
					  <td>${totalRanking.risingFalling }</td>
					  <td>${totalRanking.originalMoney }</td>
					  <td>${totalRanking.totalAssets }</td>
					  <td>${totalRanking.totalLoss }</td>
					  <td>${totalRanking.investmentGrade }</td>
					  <td>${totalRanking.topNum }</td>
					  <td>${totalRanking.totalClickNum }</td>
					  <td>${totalRanking.dayEarningsRate }</td>
					  <td>${totalRanking.dayAvgEaeningsRate }</td>
					  <td>${totalRanking.totalUseMoney }</td>
					  <td>${totalRanking.operationResults }</td>
					  <td>${totalRanking.violationsResult }</td>
					  <td>${totalRanking.comprehensive }</td>
					  <td>${totalRanking.derStandard }</td>
					  <td>${totalRanking.chooseStockAbility }</td>
					  <td>${totalRanking.chooseTimeAbility }</td>
	
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
	  	        submitUrl="${ctx}/ranking/selectRanking?pageIndex={0}"/>
	  </td></tr>
	</table>
	<div style="height:10px;"></div>
</body>
</html>