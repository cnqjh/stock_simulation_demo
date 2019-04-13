package org.simulation.operation.dao.provider;

import static org.simulation.operation.common.UserConstants.HISTORYHOLDINGTABLE;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import org.simulation.operation.domain.HistoryHolding;


public class HistoryHoldingDynaSqlProvider {

    // 分页动态查询
    public String selectWhitParam(final Map<String, Object> params) {
	String sql = new SQL() {
	    {
		SELECT("*");
		FROM(HISTORYHOLDINGTABLE);
		if (params.get("historyHolding") != null) {
		    HistoryHolding historyHolding = (HistoryHolding) params.get("historyHolding");
		    if (historyHolding.getStockCode() != null && !historyHolding.getStockCode().equals("")) {
			WHERE("  stock_code =#{historyHolding.stockCode} ");
		    }
		    if (historyHolding.getStockName() != null && !historyHolding.getStockName().equals("")) {
			WHERE("  stock_name =#{historyHolding.stockName} ");
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
		FROM(HISTORYHOLDINGTABLE);
		if (params.get("historyHolding") != null) {
		    HistoryHolding historyHolding = (HistoryHolding) params.get("historyHolding");
		    if (historyHolding.getStockCode() != null && !historyHolding.getStockCode().equals("")) {
			WHERE("  stock_code =#{historyHolding.stockCode} ");
		    }
		    if (historyHolding.getStockName() != null && !historyHolding.getStockName().equals("")) {
			WHERE("  stock_name =#{historyHolding.stockName} ");
		    }

		}
	    }
	}.toString();
    }

    public String sava(Map map) {
    	
    	List<HistoryHolding> h = (List<HistoryHolding>)map.get("list");
    	StringBuilder sb = new StringBuilder();  
    	sb.append("INSERT INTO "+HISTORYHOLDINGTABLE);
    	sb.append("(id " + ",stock_code " + ",stock_name " + ",inventory " + ",cost_price" + ",closing_price" + 
    			",market_price " + ",float_profit_loss " + ",profit_loss_proportion " + 
    			",position_proportion " + ",currency "+",state)");
        sb.append("VALUES ");  
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].id'}',#'{'list[{0}].stockCode'}',#'{'list[{0}].stockName'}'"+
                            ",#'{'list[{0}].holdingNum'}',#'{'list[{0}].costPrice'}',#'{'list[{0}].closingPrice'}',#'{'list[{0}].marketValue'}'"+
							",#'{'list[{0}].floatingProfitAndLoss'}',#'{'list[{0}].profitAndLossRatio'}',#'{'list[{0}].holdingRatio'}',#'{'list[{0}].currency'}'"+
							",#'{'list[{0}].state'}')");
        for (int i = 0; i < h.size(); i++) {  
            sb.append(mf.format(new Object[]{i}));  
            if (i < h.size() - 1) {  
                sb.append(",");  
            }  
        } 
	    			
	return sb.toString();
    }
}
