package org.simulation.operation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.dao.StockDetailedDao;
import org.simulation.operation.domain.StockDetailed;
import org.simulation.operation.service.StockDetailedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("stockDetailedService")
public class StockDetailedServiceImpl implements StockDetailedService{

	@Autowired
	private StockDetailedDao stockDetailedDao;
	@Transactional(readOnly=true)
	@Override
	public List<StockDetailed> findStockDetailed(StockDetailed stockDetailed, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("stockDetailed", stockDetailed);
		int recordCount = stockDetailedDao.count(params);
		pageModel.setRecordCount(recordCount);
		System.out.println("recordCount-->"+recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<StockDetailed> stockDetaileds = stockDetailedDao.selectByPage(params);
		for(StockDetailed detailed:stockDetaileds) {
			switch(detailed.getDealState()) {
			case "0":detailed.setDealState("买");
			break;
			case "1":detailed.setDealState("卖");
			break;
			default:break;
			}
		}
		 
		return stockDetaileds;
	}
}
