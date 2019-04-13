package org.simulation.operation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.simulation.operation.dao.provider.DetailsOfAssetsDynaSqlProvider;
import org.simulation.operation.domain.DetailsOfAssets;


public interface DetailsOfAssetsDao {

	// 根据参数查询用户总数
	@SelectProvider(type=DetailsOfAssetsDynaSqlProvider.class,method="count")
	int count(Map<String, Object> params);

	@SelectProvider(type=DetailsOfAssetsDynaSqlProvider.class,method="find")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="student_code",property="studentCode"),
		@Result(column="student_name",property="studentName"),
		@Result(column="time",property="time"),
		@Result(column="expenditure",property="expenditure"),
		@Result(column="income",property="income"),
		@Result(column="balance",property="balance"),
		@Result(column="total_assets",property="totalAssets")
	})
	List<DetailsOfAssets> find(Map<String, Object> params);

}
