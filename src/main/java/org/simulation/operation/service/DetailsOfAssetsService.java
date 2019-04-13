package org.simulation.operation.service;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.DetailsOfAssets;



public interface DetailsOfAssetsService {

	List<DetailsOfAssets> findList(DetailsOfAssets detailsOfAssets, PageModel pageModel);

}
