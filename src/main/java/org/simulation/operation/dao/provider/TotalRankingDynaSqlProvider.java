package org.simulation.operation.dao.provider;

import static org.simulation.operation.common.UserConstants.RANKINGTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.TotalRanking;


public class TotalRankingDynaSqlProvider {

    // 分页动态查询
    public String selectWhitParam(final Map<String, Object> params) {
	String sql = new SQL() {
	    {
		SELECT("*");
		FROM(RANKINGTABLE);
		if (params.get("totalRanking") != null) {
		    TotalRanking totalRanking = (TotalRanking) params.get("totalRanking");
		    if (totalRanking.getUserCode() != null && !totalRanking.getUserCode().equals("")) {
			WHERE("  user_code LIKE CONCAT ('%',#{totalRanking.userCode},'%') ");
		    }
		    if (totalRanking.getUserName() != null && !totalRanking.getUserName().equals("")) {
			WHERE("  user_name LIKE CONCAT ('%',#{totalRanking.userName},'%') ");
		    }
		}
	    }
	}.toString();
	if (params.get("pageModel") != null) {
	    PageModel firstLimitParam = (PageModel) params.get("pageModel");
	    int f = firstLimitParam.getFirstLimitParam();
	    sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
	}

	return sql;
    }

    // 动态查询总数量
    public String count(final Map<String, Object> params) {
	return new SQL() {
	    {
		SELECT("count(*)");
		FROM(RANKINGTABLE);
		if (params.get("totalRanking") != null) {
		    TotalRanking totalRanking = (TotalRanking) params.get("totalRanking");
		    if (totalRanking.getUserCode() != null && !totalRanking.getUserCode().equals("")) {
			WHERE("  user_code LIKE CONCAT ('%',#{totalRanking.userCode},'%') ");
		    }
		    if (totalRanking.getUserName() != null && !totalRanking.getUserName().equals("")) {
			WHERE("  user_name LIKE CONCAT ('%',#{totalRanking.userName},'%') ");
		    }
		}
	    }
	}.toString();
    }
}
