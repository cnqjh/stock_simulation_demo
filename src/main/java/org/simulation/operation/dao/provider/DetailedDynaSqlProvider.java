package org.simulation.operation.dao.provider;

import static org.simulation.operation.common.UserConstants.DETAILEDTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.simulation.operation.domain.StockDetailed;


public class DetailedDynaSqlProvider {

    // 分页动态查询
    public String selectWhitParam(final Map<String, Object> params) {
	String sql = new SQL() {
	    {
		SELECT("*");
		FROM(DETAILEDTABLE);
		if (params.get("stockDetailed") != null) {
		    StockDetailed stockDetailed = (StockDetailed) params.get("stockDetailed");
		    if (stockDetailed.getStockCode() != null && !stockDetailed.getStockCode().equals("")) {
		    	WHERE("  stock_code LIKE CONCAT ('%',#{stockDetailed.stockCode},'%') ");
		    }
		    if (stockDetailed.getStockName() != null && !stockDetailed.getStockName().equals("")) {
		    	WHERE("  stock_name LIKE CONCAT ('%',#{stockDetailed.stockName},'%') ");
		    }
		    if (stockDetailed.getCreateDate() != null && !stockDetailed.getCreateDate().equals("")) {
				WHERE("  create_date LIKE CONCAT ('%',#{stockDetailed.createDate},'%') ");
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
		FROM(DETAILEDTABLE);
		if (params.get("stockDetailed") != null) {
		    StockDetailed stockDetailed = (StockDetailed) params.get("stockDetailed");
		    if (stockDetailed.getStockCode() != null && !stockDetailed.getStockCode().equals("")) {
		    	WHERE("  stock_code LIKE CONCAT ('%',#{stockDetailed.stockCode},'%') ");
		    }
		    if (stockDetailed.getStockName() != null && !stockDetailed.getStockName().equals("")) {
		    	WHERE("  stock_name LIKE CONCAT ('%',#{stockDetailed.stockName},'%') ");
		    }
		    if (stockDetailed.getCreateDate() != null && !stockDetailed.getCreateDate().equals("")) {
				WHERE("  create_date LIKE CONCAT ('%',#{stockDetailed.createDate},'%') ");
			}
		}
	    }
	}.toString();
    }
}
