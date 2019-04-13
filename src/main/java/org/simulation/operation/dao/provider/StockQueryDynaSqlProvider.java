package org.simulation.operation.dao.provider;

import static org.simulation.operation.common.UserConstants.STOCKTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.StockQuery;


public class StockQueryDynaSqlProvider {

    // 分页动态查询
    public String selectWhitParam(final Map<String, Object> params) {
	String sql = new SQL() {
	    {
		SELECT("*");
		FROM(STOCKTABLE);
		if (params.get("stockQuery") != null) {
		    StockQuery stockQuery = (StockQuery) params.get("stockQuery");
		    if (stockQuery.getStockCode() != null && !stockQuery.getStockCode().equals("")) {
			WHERE("  stock_code =#{stockQuery.stockCode}");
		    }
		    if (stockQuery.getStockName() != null && !stockQuery.getStockName().equals("")) {
			WHERE("  stock_name =#{stockQuery.stockName}");
		    }
		    if (stockQuery.getCreateDate() != null && !stockQuery.getCreateDate().equals("")) {
			WHERE("  create_date =#{stockQuery.createDate} ");
		    }
		    if (stockQuery.getRegion() != null && !stockQuery.getRegion().equals("")) {
				WHERE("  region =#{stockQuery.region}");
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
		FROM(STOCKTABLE);
		if (params.get("stockQuery") != null) {
		    StockQuery stockQuery = (StockQuery) params.get("stockQuery");
		    if (stockQuery.getMarket() != null && !stockQuery.getMarket().equals("")) {
			WHERE("  market =#{stockQuery.market} ");
		    }
		    if (stockQuery.getStockCode() != null && !stockQuery.getStockCode().equals("")) {
			WHERE("  stock_code =#{stockQuery.stockCode} ");
		    }
		    if (stockQuery.getStockName() != null && !stockQuery.getStockName().equals("")) {
			WHERE("  stock_name =#{stockQuery.stockName}");
		    }
		    if (stockQuery.getCreateDate() != null && !stockQuery.getCreateDate().equals("")) {
			WHERE("  create_date =#{stockQuery.createDate} ");
		    }
		    if (stockQuery.getRegion() != null && !stockQuery.getRegion().equals("")) {
				WHERE("  region =#{stockQuery.region}");
			}
		}
	    }
	}.toString();
    }
}
