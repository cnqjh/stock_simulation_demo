package org.simulation.operation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.simulation.operation.dao.provider.DetailedDynaSqlProvider;
import org.simulation.operation.domain.StockDetailed;


public interface StockDetailedDao {

    // 动态查询
    @SelectProvider(type = DetailedDynaSqlProvider.class, method = "selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="create_date",property="createDate",javaType=java.util.Date.class),
		@Result(column="stock_code",property="stockCode"),
		@Result(column="stock_name",property="stockName"),
		@Result(column="deal_num",property="dealNum"),
		@Result(column="deal_price",property="dealPrice"),
		@Result(column="deal_money",property="dealMoney"),
		@Result(column="deal_state",property="dealState"),
		
		@Result(column="user_id",property="user",
			one=@One(select="org.math.stock.management.dao.UserDao.selectById",
		fetchType=FetchType.EAGER))
	})
    List<StockDetailed> selectByPage(Map<String, Object> params);

    @SelectProvider(type = DetailedDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);
}
