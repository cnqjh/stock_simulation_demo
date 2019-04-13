package org.simulation.operation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.simulation.operation.dao.provider.HistoryHoldingDynaSqlProvider;
import org.simulation.operation.domain.HistoryHolding;



public interface HistoryHoldingDao {

	// 动态查询
	@SelectProvider(type=HistoryHoldingDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="stock_code",property="stockCode"),
		@Result(column="stock_name",property="stockName"),
		@Result(column="inventory",property="holdingNum"),
		@Result(column="cost_price",property="costPrice"),
		@Result(column="closing_price",property="closingPrice"),
		@Result(column="market_price",property="marketValue"),
		@Result(column="float_profit_loss",property="floatingProfitAndLoss"),
		@Result(column="profit_loss_proportion",property="profitAndLossRatio"),
		@Result(column="position_proportion",property="holdingRatio"),
		@Result(column="state",property="state"),
		@Result(column="currency",property="currency")
	})
//		@Result(column="USER_ID",property="user",
//			one=@One(select="org.math.stock.management.dao.UserDao.selectById",
//		fetchType=FetchType.EAGER))
//	})
	List<HistoryHolding> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=HistoryHoldingDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@SelectProvider(type=HistoryHoldingDynaSqlProvider.class,method="sava")
	void savaHoldData(@Param("list")List<HistoryHolding> historyHolding);
}
