package org.simulation.operation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.dao.StockQueryDao;
import org.simulation.operation.domain.StockQuery;
import org.simulation.operation.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("stockQueryService")
public class StockQueryServiceImpl implements StockQueryService{
	
	
	/**
	 * 自动注入持久层Dao对象
	 * */
	@Autowired
	private StockQueryDao stockQueryDao;
	@Transactional(readOnly=true)
	@Override
	public List<StockQuery> findStock(StockQuery stockQuery, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("stockQuery", stockQuery);
		int recordCount = stockQueryDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<StockQuery> stockQuerys = stockQueryDao.selectByPage(params);
		 
		return stockQuerys;
	}
	@Override
	public void modifyStockQuery(StockQuery stockQuery) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public StockQuery findStockQueryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
