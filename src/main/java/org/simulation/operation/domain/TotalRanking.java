package org.simulation.operation.domain;

import java.io.Serializable;

//排行表：rank_inf
public class TotalRanking implements Serializable{
	private String id;
	private String userCode;//学号
	private String userName;//名字
	private String earningsRate;//收益率
	private String ranking;//排名
	private String risingFalling;//升降
	private String originalMoney;//初始金额
	private String totalAssets;//总资产
	private String totalLoss;//总损益
	private String investmentGrade;//投资等级
	private String topNum;//TOP数量
	private String totalClickNum;//总点击量
	private String dayEarningsRate;//日收益率
	private String dayAvgEaeningsRate;//日平均收益率
	private String totalUseMoney;//总可用资金
	private String operationResults;//操作分
	private String violationsResult;//违规分
	private String comprehensive;//综合分
	private String derStandard;//日收益率标准差
	private String chooseStockAbility;//选股能力
	private String chooseTimeAbility;//选时能力
	
	public TotalRanking() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEarningsRate() {
		return earningsRate;
	}

	public void setEarningsRate(String earningsRate) {
		this.earningsRate = earningsRate;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getRisingFalling() {
		return risingFalling;
	}

	public void setRisingFalling(String risingFalling) {
		this.risingFalling = risingFalling;
	}

	public String getOriginalMoney() {
		return originalMoney;
	}

	public void setOriginalMoney(String originalMoney) {
		this.originalMoney = originalMoney;
	}

	public String getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}

	public String getTotalLoss() {
		return totalLoss;
	}

	public void setTotalLoss(String totalLoss) {
		this.totalLoss = totalLoss;
	}



	public String getInvestmentGrade() {
		return investmentGrade;
	}

	public void setInvestmentGrade(String investmentGrade) {
		this.investmentGrade = investmentGrade;
	}

	public String getTopNum() {
		return topNum;
	}

	public void setTopNum(String topNum) {
		this.topNum = topNum;
	}

	public String getTotalClickNum() {
		return totalClickNum;
	}

	public void setTotalClickNum(String totalClickNum) {
		this.totalClickNum = totalClickNum;
	}

	public String getDayEarningsRate() {
		return dayEarningsRate;
	}

	public void setDayEarningsRate(String dayEarningsRate) {
		this.dayEarningsRate = dayEarningsRate;
	}

	public String getDayAvgEaeningsRate() {
		return dayAvgEaeningsRate;
	}

	public void setDayAvgEaeningsRate(String dayAvgEaeningsRate) {
		this.dayAvgEaeningsRate = dayAvgEaeningsRate;
	}

	public String getTotalUseMoney() {
		return totalUseMoney;
	}

	public void setTotalUseMoney(String totalUseMoney) {
		this.totalUseMoney = totalUseMoney;
	}

	public String getOperationResults() {
		return operationResults;
	}

	public void setOperationResults(String operationResults) {
		this.operationResults = operationResults;
	}

	public String getViolationsResult() {
		return violationsResult;
	}

	public void setViolationsResult(String violationsResult) {
		this.violationsResult = violationsResult;
	}

	public String getComprehensive() {
		return comprehensive;
	}

	public void setComprehensive(String comprehensive) {
		this.comprehensive = comprehensive;
	}

	public String getDerStandard() {
		return derStandard;
	}

	public void setDerStandard(String derStandard) {
		this.derStandard = derStandard;
	}

	public String getChooseStockAbility() {
		return chooseStockAbility;
	}

	public void setChooseStockAbility(String chooseStockAbility) {
		this.chooseStockAbility = chooseStockAbility;
	}

	public String getChooseTimeAbility() {
		return chooseTimeAbility;
	}

	public void setChooseTimeAbility(String chooseTimeAbility) {
		this.chooseTimeAbility = chooseTimeAbility;
	}
	@Override
	public String toString() {
		return "TotalRanking [id=" + id + ", userCode=" + userCode + ", userName=" + userName
				+ ", earningsRate=" + earningsRate +
				", ranking=" + ranking +", risingFalling=" + risingFalling +
				", originalMoney=" + originalMoney + ", totalAssets=" + totalAssets +", totalLoss=" + totalLoss + 
				", InvestmentGrade=" + investmentGrade +", topNum=" + topNum +", totalClickNum=" + totalClickNum +
				", dayEarningsRate=" + dayEarningsRate +", dayAvgEaeningsRate=" + dayAvgEaeningsRate +", totalUseMoney=" + totalUseMoney +
				", totalUseMoney=" + totalUseMoney +", operationResults=" + operationResults +", violationsResult=" + violationsResult +
				", comprehensive=" + comprehensive +", derStandard=" + derStandard +", chooseStockAbility=" + chooseStockAbility +
				", chooseTimeAbility=" + chooseTimeAbility +"]";
	}
		
}
