package org.simulation.operation.service;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.TotalRanking;


public interface TotalRankingService{
	List<TotalRanking> findTotalRanking(TotalRanking totalRanking,PageModel pageModel);
}
