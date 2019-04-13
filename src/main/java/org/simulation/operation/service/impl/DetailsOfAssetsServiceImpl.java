package org.simulation.operation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.dao.DetailsOfAssetsDao;
import org.simulation.operation.domain.DetailsOfAssets;
import org.simulation.operation.service.DetailsOfAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("detailsOfAssetsService")
public class DetailsOfAssetsServiceImpl implements DetailsOfAssetsService{
	
	@Autowired
	private DetailsOfAssetsDao detailsOfAssetsDao;

	@Transactional(readOnly=true)
	@Override
	public List<DetailsOfAssets> findList(DetailsOfAssets detailsOfAssets, PageModel pageModel) {
		// TODO Auto-generated method stub
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("detailsOfAssets", detailsOfAssets);
		int recordCount = detailsOfAssetsDao.count(params);
		pageModel.setRecordCount(recordCount);
		System.out.println("recordCount-->"+recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<DetailsOfAssets> DetailsOfAssetsList=detailsOfAssetsDao.find(params);
		return DetailsOfAssetsList;
	}

}
