package org.simulation.operation.controller;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.StockDetailed;
import org.simulation.operation.service.StockDetailedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StockDetailedController {

	/**
	 * 自动注入Service
	 * */
	@Autowired
	@Qualifier("stockDetailedService")
	private StockDetailedService stockDetailedService;
	
	
	@RequestMapping(value="/detailed/selectDetailed")
	 public String selectDetailed(Model model,Integer pageIndex,
			 @ModelAttribute StockDetailed stockDetailed){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<StockDetailed> stockDetaileds = stockDetailedService.findStockDetailed(stockDetailed, pageModel);
		model.addAttribute("stockDetaileds", stockDetaileds);
		model.addAttribute("pageModel", pageModel);
		return "detailed/stockDetailed";
		
	}
}
