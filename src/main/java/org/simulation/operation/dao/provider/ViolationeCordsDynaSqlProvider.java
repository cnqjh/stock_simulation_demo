package org.simulation.operation.dao.provider;

import static org.simulation.operation.common.UserConstants.VIOLATIONTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.simulation.operation.domain.ViolationeCord;


public class ViolationeCordsDynaSqlProvider {
    // 分页动态查询
    public String selectWhitParam(final Map<String, Object> params) {
	String sql = new SQL() {
	    {
		SELECT("*");
		FROM(VIOLATIONTABLE);
		if (params.get("violationeCord") != null) {
		    ViolationeCord violationeCord = (ViolationeCord) params.get("violationeCord");
		    if (violationeCord.getViolationDate() != null && !violationeCord.getViolationDate().equals("")) {
			WHERE("  violation_date LIKE CONCAT ('%',#{violationeCord.violationDate},'%') ");
		    }
		    if (violationeCord.getUser() != null && violationeCord.getUser().getUserName() != null && !violationeCord.getUser().getUserName().equals("")) {
			WHERE("  user_id LIKE CONCAT ('%',#{violationeCord.user.userName},'%') ");
		    }
		    if (violationeCord.getUser() != null && violationeCord.getUser().getUserCode() != null && !violationeCord.getUser().getUserCode().equals("")) {
			WHERE("  user_id LIKE CONCAT ('%',#{violationeCord.user.userCode},'%') ");
			}
		}
	    }
	}.toString();

	if (params.get("pageModel") != null) {
	    sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
	}

	return sql;
    }

    // 动态查询总数量
    public String count(final Map<String, Object> params) {
	return new SQL() {
	    {
		SELECT("count(*)");
		FROM(VIOLATIONTABLE);
		if (params.get("violationeCord") != null) {
		    ViolationeCord violationeCord = (ViolationeCord) params.get("violationeCord");
		    if (violationeCord.getViolationDate() != null && !violationeCord.getViolationDate().equals("")) {
			WHERE("  violation_date LIKE CONCAT ('%',#{violationeCord.violationDate},'%') ");
		    }
		    if (violationeCord.getUser() != null && violationeCord.getUser().getUserName() != null && !violationeCord.getUser().getUserName().equals("")) {
			WHERE("  user_name LIKE CONCAT ('%',#{violationeCord.user.userName},'%') ");
		    }
		    if (violationeCord.getUser() != null && violationeCord.getUser().getUserCode() != null && !violationeCord.getUser().getUserCode().equals("")) {
			WHERE("  user_code LIKE CONCAT ('%',#{violationeCord.user.userCode},'%') ");
			}
		}
	    }
	}.toString();
    }
}
