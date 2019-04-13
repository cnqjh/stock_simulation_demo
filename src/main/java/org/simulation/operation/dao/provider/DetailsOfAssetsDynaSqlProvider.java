package org.simulation.operation.dao.provider;

import static org.simulation.operation.common.UserConstants.*;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.DetailsOfAssets;

public class DetailsOfAssetsDynaSqlProvider {

	 public String find(final Map<String, Object> params) {
			String sql = new SQL() {
			    {
				SELECT("*");
				FROM(DETAILS_ASSETS_TABLE);
				if (params.get("detailsOfAssets") != null) {
					DetailsOfAssets detailsOfAssets = (DetailsOfAssets) params.get("detailsOfAssets");
				    if (detailsOfAssets.getStudentCode() != null && !detailsOfAssets.getStudentCode().equals("")) {
					WHERE("  student_code =#{detailsOfAssets.studentCode}");
				    }
				    if (detailsOfAssets.getStudentName() != null && !detailsOfAssets.getStudentName().equals("")) {
					WHERE("  student_name =#{detailsOfAssets.studentName} ");
				    }
				    if (detailsOfAssets.getTime() != null && !detailsOfAssets.getTime().equals("")) {
					WHERE("  time =#{detailsOfAssets.time} ");
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
			FROM(DETAILS_ASSETS_TABLE);
			if (params.get("detailsOfAssets") != null) {
				DetailsOfAssets detailsOfAssets = (DetailsOfAssets) params.get("detailsOfAssets");
			    if (detailsOfAssets.getStudentCode() != null && !detailsOfAssets.getStudentCode().equals("")) {
				WHERE("  student_code =#{detailsOfAssets.studentCode}");
			    }
			    if (detailsOfAssets.getStudentName() != null && !detailsOfAssets.getStudentName().equals("")) {
				WHERE("  student_name =#{detailsOfAssets.studentName} ");
			    }
			    if (detailsOfAssets.getTime() != null && !detailsOfAssets.getTime().equals("")) {
				WHERE("  time =#{detailsOfAssets.time} ");
			    }
			}
		    }
		}.toString();
	    }
}
