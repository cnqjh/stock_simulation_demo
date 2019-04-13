package org.simulation.operation.service.impl;



import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.dao.TotalRankingDao;
import org.simulation.operation.domain.TotalRanking;
import org.simulation.operation.service.TotalRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("totalRankingService")
public class TotalRankingServiceImpl implements TotalRankingService{

	@Autowired
	private TotalRankingDao totalRankingDao;
	
	@Transactional(readOnly=true)	
	@Override
	public List<TotalRanking> findTotalRanking(TotalRanking totalRanking, PageModel pageModel) {
		Map<String,Object> params = new HashMap<>();
		params.put("totalRanking", totalRanking);
		int recordCount = totalRankingDao.count(params);
		pageModel.setRecordCount(recordCount);
		System.out.println("recordCount-->"+recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<TotalRanking> totalRankings = totalRankingDao.selectByPage(params);
		return totalRankings;
	}

}
