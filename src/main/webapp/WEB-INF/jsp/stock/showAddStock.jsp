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
			var s='${requestScope.realTimeStocks}';
			if(s.length>2){
				var sbtitleHide=document.getElementById("requestScope_hide");
				sbtitleHide.style.display='none'; 
				var sbtitle=document.getElementById("requestScope_data");
				sbtitle.style.display='block'; 
			}
			
	 	   var boxs  = $("input[type='checkbox'][id^='box_']");	 	   
	 	  /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
	    	$("tr[id^='data_']").hover(function(){
	    		$(this).css("backgroundColor","#eeccff");
	    	},function(){
	    		$(this).css("backgroundColor","#ffffff");
	    	});
	        $(".pimg").click(function(){  
	            var _this = $(this);//将当前的pimg元素作为_this传入函数  
	            imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);  
	        });  
			$("#stockForm").submit(function(){
				var code = $("#code");
				
				var price = $("#price");
				var stockNum = $("#stockNum");
				var msg = "";
				if ($.trim(code.val()) == ""){
					msg = "股票代码不能为空！";
					code.focus();
				}else if ($.trim(price.val()) == ""){
					msg = "当前价格不能为空！";
					price.focus();
				}else if ($.trim(stockNum.val()) == ""){
					msg = "购买股票数量不能为空！";
					stockNum.focus();
				}
				if (msg != ""){
					$.ligerDialog.error(msg);
					return false;
				}else{
					return true;
				}
				$("#stockForm").submit();
			});

	    }); 
 
    function imgShow(outerdiv, innerdiv, bigimg, _this){  
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性  
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性  
      
            /*获取当前点击图片的真实大小，并显示弹出层及大图*/  
        $("<img/>").attr("src", src).load(function(){  
            var windowW = $(window).width();//获取当前窗口宽度  
            var windowH = $(window).height();//获取当前窗口高度  
            var realWidth = this.width;//获取图片真实宽度  
            var realHeight = this.height;//获取图片真实高度  
            var imgWidth, imgHeight;  
            var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放  
              
            if(realHeight>windowH*scale) {//判断图片高度  
                imgHeight = windowH*scale;//如大于窗口高度，图片高度进行缩放  
                imgWidth = imgHeight/realHeight*realWidth;//等比例缩放宽度  
                if(imgWidth>windowW*scale) {//如宽度扔大于窗口宽度  
                    imgWidth = windowW*scale;//再对宽度进行缩放  
                }  
            } else if(realWidth>windowW*scale) {//如图片高度合适，判断图片宽度  
                imgWidth = windowW*scale;//如大于窗口宽度，图片宽度进行缩放  
                            imgHeight = imgWidth/realWidth*realHeight;//等比例缩放高度  
            } else {//如果图片真实高度和宽度都符合要求，高宽不变  
                imgWidth = realWidth;  
                imgHeight = realHeight;  
            }  
                   // $(bigimg).css("width",imgWidth);//以最终的宽度对图片缩放  
              
            var w = (windowW-imgWidth)/2;//计算图片与窗口左边距  
            var h = (windowH-imgHeight)/2;//计算图片与窗口上边距  
            $(innerdiv).css({"top":h, "left":w});//设置#innerdiv的top和left属性  
            $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg  
        });  
          
        $(outerdiv).click(function(){//再次点击淡出消失弹出层  
            $(this).fadeOut("fast");  
        });  
    }
	</script>
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="${ctx}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${ctx}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：首页 &gt; 股票查询</td>
		<td width="15" height="32"><img src="${ctx}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	
	<table width="100%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
			<tr>
			  <td class="fftd">
			  	<form name="empform" method="post" id="empform" action="${ctx}/stock/viewStock">
			  	<!-- 隐藏表单，flag表示添加标记 -->
		    	 	<input type="hidden" name="flag" value="1">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td align="right">股票代码：</td>
					    <td><input autocomplete="off"type="text" name="code"></td>				    
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
	  <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
	    <div id="requestScope_hide">
	    <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
			<tr>
				<td colspan=4>
					<table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
					 <tr >
						  <td colspan=4>股票行情</td>		
					</tr>
						<tr>
						  <td>日期</td><td>NA</td>
						  <td>时间</td><td>NA</td>			
						</tr>
						<tr>
						 <td>股票代码</td><td>NA</td>	
			 			 <td>股票名字</td><td>NA</td>
						</tr>
						<tr>
							<td>今日开盘价</td><td>NA</td>			  
							<td>昨日收盘价</td><td>NA</td>
						</tr>
						<tr>
						<td>当前价格</td><td>NA</td>
						<td></td><td></td>
						</tr>
						<tr>
							<td>今日最高价</td><td>NA</td>
							<td>今日最低价</td><td>NA</td>
						</tr>
						<tr>
							<td>竞买价</td><td>NA</td>
			                <td>竞卖价</td><td>NA</td>
						</tr>
						<tr>
							<td>成交的股票数</td><td>NA</td>
			                <td>成交金额</td><td>NA</td>
						</tr>
					</table>
				</td>
				<td colspan=4>
				<table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
				<tr>
				<td>类型</td><td>股</td><td>价格</td>
				</tr>
				<tr>
				<td>买一</td><td>NA</td>
				<td>NA</td>
				</tr>
				<tr>
				<td>买二</td><td>NA</td>
				<td>NA</td>
				</tr>
				<tr>
				<td>买三</td><td>NA</td>
				<td>NA</td>
				</tr>
				<tr>
				<td>买四</td><td>NA</td>
				<td>NA</td>
				</tr>
				<tr>
				<td>买五</td><td>NA</td>
				<td>NA</td>
				</tr>
				<tr>
				<td>卖一</td><td>NA</td>
				<td>NA</td>
				</tr>
				<tr>
				<td>卖二</td><td>NA</td>
				<td>NA</td>
				</tr>
				<tr>
				<td>卖三</td><td>NA</td>
				<td>NA</td>
				</tr>
				<tr>
				<td>卖四</td><td>NA</td>
				<td>NA</td>
				</tr>
				<tr>
				<td>卖五</td><td>NA</td>
				<td>NA</td>
				</tr>				
				</table>
				</td>
			</tr>
		  </table>
	    </div>
	    <div id="requestScope_data"style="display:none;">
		  <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
			<c:forEach items="${requestScope.realTimeStocks}" var="realTimeStock" varStatus="stat">
			<tr>
				<td colspan=4>
					<table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
					 <tr >
						  <td colspan=4>股票行情</td>		
					</tr>
						<tr>
						  <td>日期</td><td>${realTimeStock.date }</td>
						  <td>时间</td><td>${realTimeStock.time }</td>			
						</tr>
						<tr>
						 <td>股票代码</td><td>${realTimeStock.code }</td>	
			 			 <td>股票名字</td><td>${realTimeStock.name }</td>
						</tr>
						<tr>
							<td>今日开盘价</td><td>${realTimeStock.open }</td>			  
							<td>昨日收盘价</td><td>${realTimeStock.lastClose }</td>
						</tr>
						<tr>
						<td>当前价格</td><td>${realTimeStock.price }</td>
						<td></td><td></td>
						</tr>
						<tr>
							<td>今日最高价</td><td>${realTimeStock.todayHigh }</td>
							<td>今日最低价</td><td>${realTimeStock.todayLow }</td>
						</tr>
						<tr>
							<td>竞买价</td><td>${realTimeStock.competitiveBuyPrice }</td>
			                <td>竞卖价</td><td>${realTimeStock.competitiveSellPrice }</td>
						</tr>
						<tr>
							<td>成交的股票数</td><td>${realTimeStock.count }</td>
			                <td>成交金额</td><td>${realTimeStock.total }</td>
						</tr>
					</table>
				</td>
				<td colspan=4>
				<table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
				<tr>
				<td>类型</td><td>股</td><td>价格</td>
				</tr>
				<tr>
				<td>买一</td><td>${realTimeStock.buyOneNum }</td>
				<td>${realTimeStock.buyOnePrice }</td>
				</tr>
				<tr>
				<td>买二</td><td>${realTimeStock.buyTwoNum }</td>
				<td>${realTimeStock.buyTowPrice }</td>
				</tr>
				<tr>
				<td>买三</td><td>${realTimeStock.buyThreeNum }</td>
				<td>${realTimeStock.buyThreePrice }</td>
				</tr>
				<tr>
				<td>买四</td><td>${realTimeStock.buyFourNum }</td>
				<td>${realTimeStock.buyFourPrice }</td>
				</tr>
				<tr>
				<td>买五</td><td>${realTimeStock.buyFiveNum }</td>
				<td>${realTimeStock.buyFivePrice }</td>
				</tr>
				<tr>
				<td>卖一</td><td>${realTimeStock.sellOneNum }</td>
				<td>${realTimeStock.sellOnePrice }</td>
				</tr>
				<tr>
				<td>卖二</td><td>${realTimeStock.sellTwoNum }</td>
				<td>${realTimeStock.sellTowPrice }</td>
				</tr>
				<tr>
				<td>卖三</td><td>${realTimeStock.sellThreeNum }</td>
				<td>${realTimeStock.sellThreePrice }</td>
				</tr>
				<tr>
				<td>卖四</td><td>${realTimeStock.sellFourNum }</td>
				<td>${realTimeStock.sellFourPrice }</td>
				</tr>
				<tr>
				<td>卖五</td><td>${realTimeStock.sellFiveNum }</td>
				<td>${realTimeStock.sellFivePrice }</td>
				</tr>				
				</table>
				</td>
			</tr>
			
			<tr>	
			   <td >分时线图</td>					 
			    <td ><img class="pimg"style="-webkit-user-select: none;cursor: zoom-in;" src="${realTimeStock.minK }" width="272" height="150"></td>
			     <td>日K线图</td>
			         <td ><img class="pimg"style="-webkit-user-select: none;cursor: zoom-in;" src="${realTimeStock.dayK }" width="272" height="150"></td>
			    <td>周K线图</td>
			         <td ><img class="pimg"style="-webkit-user-select: none;cursor: zoom-in;" src="${realTimeStock.weekK }" width="272" height="150"></td>
			   <td>月K线图</td>	
			         <td ><img class="pimg"style="-webkit-user-select: none;cursor: zoom-in;" src="${realTimeStock.monthK }" width="272" height="150"></td>	
				</tr>

			<tr>
			    <td colspan=8>
		    	 <form action="${ctx}/user/addStock" id="stockForm" method="post">
		    	 	<!-- 隐藏表单，flag表示添加标记 -->
		    	 	<input type="hidden" name="flag" value="2">
				  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
				    <tr><td class="font3 fftd">
				    	<table>
				    	<tr>
				    			<td class="font3 fftd" align="right">股&nbsp;票：</td><td><input type="text" name="code" id="code" value="${realTimeStock.code }" size="20"/></td>
				    			<td class="font3 fftd" align="right">当前价格：</td><td><input type="text" name="price" id="price" value="${realTimeStock.price }" size="20"/></td>
				    		</tr>
				    		
				    		<tr>
				    			<td class="font3 fftd" align="right">股：</td><td><input name="stockNum" id="stockNum" size="20" /></td>
				    			<td class="font3 fftd" align="right">状&nbsp;态：</td>
				    			<td>
				    			<select>
				    			<option></option>
				    			<option>购买</option>
				    			<option>预购</option>
				    			</select>
				    			</td>
				    		</tr>
				    		
				    	</table>
				    </td>
				    </tr>
					<tr><td class="main_tdbor"></td></tr>
					
					<tr><td align="left" class="fftd"><input type="submit" value="确认 ">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
				  </table>
				 </form>
			</td>
			</tr>
			</c:forEach>
		  </table>
		</div>
		</td>
	  </tr>
	</table>
	<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
	    <div id="innerdiv" >
	        <img id="bigimg" style="width:100%;border:5px solid #fff;" src="" />
	    </div>
    </div>
	<div style="height:10px;" id="newchartImg">
     
	</div>
</body>
</html>