package org.simulation.operation.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.simulation.operation.dao.provider.StockQueryDynaSqlProvider;
import org.simulation.operation.domain.StockQuery;


public interface StockQueryDao {

	// 测试，根据stock_code股票查询用户
	//@Select("select * from "+STOCKTABLE+" where stock_code = #{stockCode}")
	//StockQuery selectByCode(String stockCode);
		
	// 动态查询
	@SelectProvider(type=StockQueryDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="stock_code",property="stockCode"),
		@Result(column="stock_name",property="stockName"),
		@Result(column="closing_price",property="closingPrice"),
		@Result(column="create_date",property="createDate",javaType=java.util.Date.class),
		@Result(column="highest_price",property="highestPrice"),
		@Result(column="minimum_price",property="minimumPrice"),
		@Result(column="opening_price",property="openingPrice"),
		@Result(column="before_closing",property="beforeClosing"),	
		@Result(column="rose_fall_money",property="roseFallMoney"),
		@Result(column="rose_fall_amplitude",property="roseFallAmplitude"),
		@Result(column="Turnover_rate",property="turnoverRate"),
		@Result(column="deal_num",property="dealNum"),
		@Result(column="deal_money",property="dealMoney"),
		@Result(column="total_value",property="totalValue"),
		@Result(column="market",property="market"),
		@Result(column="region",property="region"),
		@Result(column="circulation_market_value",property="circulationMarketValue")
	})
	List<StockQuery> selectByPage(Map<String, Object> params);
	
	// 根据参数查询用户总数
	@SelectProvider(type=StockQueryDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
}
