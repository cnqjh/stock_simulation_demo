package org.simulation.operation.controller;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.DetailsOfAssets;
import org.simulation.operation.service.DetailsOfAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailsOfAssetsController {


	/**
	 * 自动注入Service
	 * */
	@Autowired
	@Qualifier("detailsOfAssetsService")
	private DetailsOfAssetsService detailsOfAssetsService;
	
	
	@RequestMapping(value="/detailed/detailsOfAssets")
	 public String selectDetailed(Model model,Integer pageIndex,
			 @ModelAttribute DetailsOfAssets detailsOfAssets){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<DetailsOfAssets> detailsOfAssetsList = detailsOfAssetsService.findList(detailsOfAssets, pageModel);
		model.addAttribute("detailsOfAssetsList", detailsOfAssetsList);
		model.addAttribute("pageModel", pageModel);
		return "detailed/detailsOfAssets";
		
	}
}
