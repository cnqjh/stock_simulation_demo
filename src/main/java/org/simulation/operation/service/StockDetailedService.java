package org.simulation.operation.service;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.StockDetailed;


public interface StockDetailedService {

	/**
	 * 获得所有StockDetailed
	 * @return StockDetailed对象的List集合
	 * */
	List<StockDetailed> findStockDetailed(StockDetailed stockDetailed,PageModel pageModel);
}
