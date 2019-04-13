package org.simulation.operation.controller;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.TotalRanking;
import org.simulation.operation.service.TotalRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TotalRankingController {

	/**
	 * 自动注入Service
	 * */
	@Autowired
	@Qualifier("totalRankingService")
	private TotalRankingService totalRankingService;
	
	
	@RequestMapping(value="/ranking/selectRanking")
	 public String selectRanking(Integer pageIndex,
			 @ModelAttribute TotalRanking totalRanking,
			 Model model){
		System.out.println("totalRanking = " + totalRanking);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<TotalRanking> totalRankings = totalRankingService.findTotalRanking(totalRanking, pageModel);
		model.addAttribute("totalRankings", totalRankings);
		model.addAttribute("pageModel", pageModel);
		return "ranking/totalRanking";
		
	}
}
