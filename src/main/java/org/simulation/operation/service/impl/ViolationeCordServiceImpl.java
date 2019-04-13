package org.simulation.operation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.dao.ViolationeCordDao;
import org.simulation.operation.domain.ViolationeCord;
import org.simulation.operation.service.ViolationeCordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("violationeCordService")
public class ViolationeCordServiceImpl implements ViolationeCordService{

	@Autowired
	private ViolationeCordDao violationeCordDao;
	@Transactional(readOnly=true)
	@Override
	public List<ViolationeCord> findViolationeCord(ViolationeCord violationeCord, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("violationeCord", violationeCord);
		int recordCount = violationeCordDao.count(params);
		pageModel.setRecordCount(recordCount);
		System.out.println("recordCount-->"+recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<ViolationeCord> violationeCords = violationeCordDao.selectByPage(params);
		 
		return violationeCords;
	}
}
