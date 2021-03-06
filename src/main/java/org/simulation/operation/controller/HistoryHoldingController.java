package org.simulation.operation.controller;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.HistoryHolding;
import org.simulation.operation.service.HistoryHoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HistoryHoldingController {

	/**
	 * 自动注入Service
	 * */
	@Autowired
	@Qualifier("historyHoldingService")
	private HistoryHoldingService historyHoldingService;
	
	
	@RequestMapping(value="/historyHolding/selectHistoryHolding")
	 public String selectHistoryHolding(Model model,Integer pageIndex,
			 @ModelAttribute HistoryHolding historyHolding){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<HistoryHolding> historyHoldings = historyHoldingService.findHistoryHolding(historyHolding, pageModel);
		model.addAttribute("historyHoldings", historyHoldings);
		model.addAttribute("pageModel", pageModel);
		return "historyHolding/historyHolding";
		
	}
}
