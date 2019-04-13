package org.simulation.operation.domain;

import java.io.Serializable;
import java.util.Date;

//deal_inf:交易明细表
public class StockDetailed implements Serializable{

	private String id;
	private String stockCode;//股票代码
	private String stockName;//股票名称
	private Date createDate;//创建时间
	private String dealNum;//成交量
	private String dealPrice;//成交价
	private String dealMoney;//交易金额
	private String dealState;//交易状态
	private User user;
	
	public StockDetailed () {
		super();
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

	

	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}




	public String getDealMoney() {
		return dealMoney;
	}

	public void setDealMoney(String dealMoney) {
		this.dealMoney = dealMoney;
	}


	public String getDealNum() {
		return dealNum;
	}


	public void setDealNum(String dealNum) {
		this.dealNum = dealNum;
	}


	public String getDealPrice() {
		return dealPrice;
	}


	public void setDealPrice(String dealPrice) {
		this.dealPrice = dealPrice;
	}


	public String getDealState() {
		return dealState;
	}


	public void setDealState(String dealState) {
		this.dealState = dealState;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", stockCode=" + stockCode + ", stockName=" + stockName
				+ ", createDate=" + createDate +
				", dealNum=" + dealNum +", dealPrice=" + dealPrice +
				", state=" + dealState + ", dealMoney=" + dealMoney +", user=" + user + "]";
	}

	
}
