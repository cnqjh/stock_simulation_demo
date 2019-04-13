package org.simulation.operation.service;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.StockQuery;




public interface StockQueryService {

	List<StockQuery> findStock(StockQuery stockQuery,PageModel pageModel);

	void modifyStockQuery(StockQuery stockQuery);

	StockQuery findStockQueryById(String id);
}
