package org.simulation.operation.service;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.HistoryHolding;


public interface HistoryHoldingService {

	List<HistoryHolding> findHistoryHolding(HistoryHolding historyHolding,PageModel pageModel);

	void sava(List<HistoryHolding> h);

}
