package org.simulation.operation.service;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.ViolationeCord;


public interface ViolationeCordService {

	List<ViolationeCord> findViolationeCord(ViolationeCord violationeCord,PageModel pageModel);
}
