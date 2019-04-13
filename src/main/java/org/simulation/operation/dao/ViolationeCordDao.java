package org.simulation.operation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.simulation.operation.dao.provider.ViolationeCordsDynaSqlProvider;
import org.simulation.operation.domain.ViolationeCord;


public interface ViolationeCordDao {

    // 动态查询
    @SelectProvider(type = ViolationeCordsDynaSqlProvider.class, method = "selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="violation_date",property="violationDate",javaType=java.util.Date.class),
		@Result(column="points_date",property="pointsDate",javaType=java.util.Date.class),
		@Result(column="violation_cause",property="violationCause"),
		@Result(column="violation_points",property="violationPoints"),
		@Result(column="login_status",property="loginStatus"),
		@Result(column="user_id", property = "user", one = @One(select = "org.math.stock.management.dao.UserDao.selectById", fetchType = FetchType.EAGER)) })
    List<ViolationeCord> selectByPage(Map<String, Object> params);

    @SelectProvider(type = ViolationeCordsDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);
}
