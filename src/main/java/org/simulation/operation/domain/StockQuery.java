package org.simulation.operation.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//stock_inf:股票查询
public class StockQuery implements Serializable{

	private String id;//主键
	private Date createDate;//创建时间
	private String stockCode;//股票代码
	private String stockName;//股票名称
	private String closingPrice;//收盘价
	private String highestPrice;//最高价
	private String minimumPrice;//最低价
	private String openingPrice;//开盘价
	private String beforeClosing;//前收盘
	private String roseFallMoney;//涨跌额
	private String roseFallAmplitude;//涨跌幅
	private String turnoverRate;//换手率
	private String dealNum;//成交量
	private String dealMoney;//成交金额
	private String totalValue;//总市值
	private String circulationMarketValue;//流通市值
	private String market;
	private String region;
	
	public StockQuery() {
		super();
	}
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}



	public String getMarket() {
		return market;
	}



	public void setMarket(String market) {
		this.market = market;
	}



	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(String closingPrice) {
		this.closingPrice = closingPrice;
	}
	public String getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(String highestPrice) {
		this.highestPrice = highestPrice;
	}
	public String getMinimumPrice() {
		return minimumPrice;
	}
	public void setMinimumPrice(String minimumPrice) {
		this.minimumPrice = minimumPrice;
	}
	public String getOpeningPrice() {
		return openingPrice;
	}
	public void setOpeningPrice(String openingPrice) {
		this.openingPrice = openingPrice;
	}
	public String getBeforeClosing() {
		return beforeClosing;
	}
	public void setBeforeClosing(String beforeClosing) {
		this.beforeClosing = beforeClosing;
	}
	public String getRoseFallMoney() {
		return roseFallMoney;
	}
	public void setRoseFallMoney(String roseFallMoney) {
		this.roseFallMoney = roseFallMoney;
	}
	public String getRoseFallAmplitude() {
		return roseFallAmplitude;
	}
	public void setRoseFallAmplitude(String roseFallAmplitude) {
		this.roseFallAmplitude = roseFallAmplitude;
	}
	public String getTurnoverRate() {
		return turnoverRate;
	}
	public void setTurnoverRate(String turnoverRate) {
		this.turnoverRate = turnoverRate;
	}
	public String getDealNum() {
		return dealNum;
	}
	public void setDealNum(String dealNum) {
		this.dealNum = dealNum;
	}
	public String getDealMoney() {
		return dealMoney;
	}
	public void setDealMoney(String dealMoney) {
		this.dealMoney = dealMoney;
	}
	public String getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}
	public String getCirculationMarketValue() {
		return circulationMarketValue;
	}
	public void setCirculationMarketValue(String circulationMarketValue) {
		this.circulationMarketValue = circulationMarketValue;
	}
	
	
	
}
