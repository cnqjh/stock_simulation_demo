package org.simulation.operation.domain;

import java.io.Serializable;

//holding_stock_inf:历史持仓表
public class HistoryHolding implements Serializable{
	private String id;
	private String stockCode;//股票代码
	private String stockName;//股票名称
	private String holdingNum;//持股量
	private String costPrice;//成本价
	private String closingPrice;//收盘价
	private String marketValue;//市值
	private String floatingProfitAndLoss;//浮动盈亏
	private String profitAndLossRatio;//盈亏比例
	private String holdingRatio;//持有比例
	private String state;//状态
	private String currency;//币种
	private User user;
	
	public HistoryHolding() {
		super();
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

	public String getHoldingNum() {
		return holdingNum;
	}

	public void setHoldingNum(String holdingNum) {
		this.holdingNum = holdingNum;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public String getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(String closingPrice) {
		this.closingPrice = closingPrice;
	}

	public String getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}

	public String getFloatingProfitAndLoss() {
		return floatingProfitAndLoss;
	}

	public void setFloatingProfitAndLoss(String floatingProfitAndLoss) {
		this.floatingProfitAndLoss = floatingProfitAndLoss;
	}

	public String getProfitAndLossRatio() {
		return profitAndLossRatio;
	}

	public void setProfitAndLossRatio(String profitAndLossRatio) {
		this.profitAndLossRatio = profitAndLossRatio;
	}

	public String getHoldingRatio() {
		return holdingRatio;
	}

	public void setHoldingRatio(String holdingRatio) {
		this.holdingRatio = holdingRatio;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
