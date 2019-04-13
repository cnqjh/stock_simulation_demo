package org.simulation.operation.domain;

public class RealTimeStock {
	  
		private String id;
	    private String code;//股票代码
	    private String name;//股票名字； 
	    private String open;//今日开盘价； 
	    private String lastClose;//昨日收盘价； 
	    private String price;//，当前价格； 
	    private String todayHigh;//今日最高价； 
	    private String todayLow;//今日最低价； 
	    private String competitiveBuyPrice;//竞买价，即“买一”报价； 
	    private String competitiveSellPrice;//竞卖价，即“卖一”报价； 
	    private String count;//成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百； 
	    private String total;//成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万； 
	    private String buyOneNum;//，“买一”申请4695股，即47手； 
	    private String buyOnePrice;//，“买一”报价； 
	    private String buyTwoNum;//，“买二” 
	    private String buyTowPrice;//“买二” 
	    private String buyThreeNum;//，“买三” 
	    private String buyThreePrice;//“买三” 
	    private String buyFourNum;//，“买四” 
	    private String buyFourPrice;//，“买四” 
	    private String buyFiveNum;//，“买五” 
	    private String buyFivePrice;//，“买五” 
	    private String sellOneNum;//，“卖一”申报3100股，即31手； 
	    private String sellOnePrice;//，“卖一”报价
	    private String sellTwoNum;//，“卖二” 
	    private String sellTowPrice;//“卖二” 
	    private String sellThreeNum;//，“卖三” 
	    private String sellThreePrice;//“卖三” 
	    private String sellFourNum;//，“卖四” 
	    private String sellFourPrice;//，“卖四” 
	    private String sellFiveNum;//，“卖五” 
	    private String sellFivePrice;//，“卖五” 
	    private String date;//，日期； 
	    private String time;//，时间；
	    private String dayK;//日k线
	    private String minK;//分时线图
	    private String weekK;//周K线
	    private String monthK;//月K线
	    private String stockNum;//购买股票量
	    private String state;//状态
	    public RealTimeStock() {
	    	super();
	    }
	    
	    
	    
		public String getStockNum() {
			return stockNum;
		}



		public void setStockNum(String stockNum) {
			this.stockNum = stockNum;
		}



		public String getState() {
			return state;
		}



		public void setState(String state) {
			this.state = state;
		}



		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getMinK() {
			return minK;
		}

		public void setMinK(String minK) {
			this.minK = minK;
		}

		public String getWeekK() {
			return weekK;
		}

		public void setWeekK(String weekK) {
			this.weekK = weekK;
		}

		public String getMonthK() {
			return monthK;
		}

		public void setMonthK(String monthK) {
			this.monthK = monthK;
		}

		public String getDayK() {
			return dayK;
		}

		public void setDayK(String dayK) {
			this.dayK = dayK;
		}




		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getOpen() {
			return open;
		}
		public void setOpen(String open) {
			this.open = open;
		}
		public String getLastClose() {
			return lastClose;
		}
		public void setLastClose(String lastClose) {
			this.lastClose = lastClose;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getTodayHigh() {
			return todayHigh;
		}
		public void setTodayHigh(String todayHigh) {
			this.todayHigh = todayHigh;
		}
		public String getTodayLow() {
			return todayLow;
		}
		public void setTodayLow(String todayLow) {
			this.todayLow = todayLow;
		}
		public String getCompetitiveBuyPrice() {
			return competitiveBuyPrice;
		}
		public void setCompetitiveBuyPrice(String competitiveBuyPrice) {
			this.competitiveBuyPrice = competitiveBuyPrice;
		}
		public String getCompetitiveSellPrice() {
			return competitiveSellPrice;
		}
		public void setCompetitiveSellPrice(String competitiveSellPrice) {
			this.competitiveSellPrice = competitiveSellPrice;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public String getBuyOneNum() {
			return buyOneNum;
		}
		public void setBuyOneNum(String buyOneNum) {
			this.buyOneNum = buyOneNum;
		}
		public String getBuyOnePrice() {
			return buyOnePrice;
		}
		public void setBuyOnePrice(String buyOnePrice) {
			this.buyOnePrice = buyOnePrice;
		}
		public String getBuyTwoNum() {
			return buyTwoNum;
		}
		public void setBuyTwoNum(String buyTwoNum) {
			this.buyTwoNum = buyTwoNum;
		}
		public String getBuyTowPrice() {
			return buyTowPrice;
		}
		public void setBuyTowPrice(String buyTowPrice) {
			this.buyTowPrice = buyTowPrice;
		}
		public String getBuyThreeNum() {
			return buyThreeNum;
		}
		public void setBuyThreeNum(String buyThreeNum) {
			this.buyThreeNum = buyThreeNum;
		}
		public String getBuyThreePrice() {
			return buyThreePrice;
		}
		public void setBuyThreePrice(String buyThreePrice) {
			this.buyThreePrice = buyThreePrice;
		}
		public String getBuyFourNum() {
			return buyFourNum;
		}
		public void setBuyFourNum(String buyFourNum) {
			this.buyFourNum = buyFourNum;
		}
		public String getBuyFourPrice() {
			return buyFourPrice;
		}
		public void setBuyFourPrice(String buyFourPrice) {
			this.buyFourPrice = buyFourPrice;
		}
		public String getBuyFiveNum() {
			return buyFiveNum;
		}
		public void setBuyFiveNum(String buyFiveNum) {
			this.buyFiveNum = buyFiveNum;
		}
		public String getBuyFivePrice() {
			return buyFivePrice;
		}
		public void setBuyFivePrice(String buyFivePrice) {
			this.buyFivePrice = buyFivePrice;
		}
		public String getSellOneNum() {
			return sellOneNum;
		}
		public void setSellOneNum(String sellOneNum) {
			this.sellOneNum = sellOneNum;
		}
		public String getSellOnePrice() {
			return sellOnePrice;
		}
		public void setSellOnePrice(String sellOnePrice) {
			this.sellOnePrice = sellOnePrice;
		}
		public String getSellTwoNum() {
			return sellTwoNum;
		}
		public void setSellTwoNum(String sellTwoNum) {
			this.sellTwoNum = sellTwoNum;
		}
		public String getSellTowPrice() {
			return sellTowPrice;
		}
		public void setSellTowPrice(String sellTowPrice) {
			this.sellTowPrice = sellTowPrice;
		}
		public String getSellThreeNum() {
			return sellThreeNum;
		}
		public void setSellThreeNum(String sellThreeNum) {
			this.sellThreeNum = sellThreeNum;
		}
		public String getSellThreePrice() {
			return sellThreePrice;
		}
		public void setSellThreePrice(String sellThreePrice) {
			this.sellThreePrice = sellThreePrice;
		}
		public String getSellFourNum() {
			return sellFourNum;
		}
		public void setSellFourNum(String sellFourNum) {
			this.sellFourNum = sellFourNum;
		}
		public String getSellFourPrice() {
			return sellFourPrice;
		}
		public void setSellFourPrice(String sellFourPrice) {
			this.sellFourPrice = sellFourPrice;
		}
		public String getSellFiveNum() {
			return sellFiveNum;
		}
		public void setSellFiveNum(String sellFiveNum) {
			this.sellFiveNum = sellFiveNum;
		}
		public String getSellFivePrice() {
			return sellFivePrice;
		}
		public void setSellFivePrice(String sellFivePrice) {
			this.sellFivePrice = sellFivePrice;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		
	    
	    


}
