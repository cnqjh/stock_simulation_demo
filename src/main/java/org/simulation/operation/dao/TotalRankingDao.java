package org.simulation.operation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.simulation.operation.dao.provider.TotalRankingDynaSqlProvider;
import org.simulation.operation.domain.TotalRanking;
public interface TotalRankingDao {


	// 动态查询
	@SelectProvider(type=TotalRankingDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="user_code",property="userCode"),
		@Result(column="user_name",property="userName"),
		@Result(column="earnings_rate",property="earningsRate"),
		@Result(column="ranking",property="ranking"),
		@Result(column="rising_falling",property="risingFalling"),
		@Result(column="original_money",property="originalMoney"),
		@Result(column="total_assets",property="totalAssets"),	
		@Result(column="total_loss",property="totalLoss"),
		@Result(column="investment_grade",property="investmentGrade"),
		@Result(column="top_num",property="topNum"),
		@Result(column="total_click_num",property="totalClickNum"),
		@Result(column="day_earnings_rate",property="dayEarningsRate"),
		@Result(column="day_avg_eaenings_rate",property="dayAvgEaeningsRate"),
		@Result(column="total_use_money",property="totalUseMoney"),
		@Result(column="operation_results",property="operationResults"),
		@Result(column="violations_result",property="violationsResult"),
		@Result(column="compre_hensive",property="comprehensive"),
		@Result(column="der_standard",property="derStandard"),
		@Result(column="choose_stock_ability",property="chooseStockAbility"),
		@Result(column="choose_time_ability",property="chooseTimeAbility")
	})
	List<TotalRanking> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=TotalRankingDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
}
