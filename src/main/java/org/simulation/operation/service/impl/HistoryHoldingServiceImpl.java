package org.simulation.operation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.dao.HistoryHoldingDao;
import org.simulation.operation.domain.HistoryHolding;
import org.simulation.operation.service.HistoryHoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("historyHoldingService")
public class HistoryHoldingServiceImpl implements HistoryHoldingService{

	@Autowired
	private HistoryHoldingDao historyHoldingDao;
	@Transactional(readOnly=true)
	@Override
	public List<HistoryHolding> findHistoryHolding(HistoryHolding historyHolding, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("historyHolding", historyHolding);
		int recordCount = historyHoldingDao.count(params);
		pageModel.setRecordCount(recordCount);
		System.out.println("recordCount-->"+recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<HistoryHolding> historyHoldings = historyHoldingDao.selectByPage(params);
		
		return historyHoldings;
	}
	@Override
	public void sava(List<HistoryHolding> h) {
		// TODO Auto-generated method stub
		historyHoldingDao.savaHoldData(h);
	}
}
