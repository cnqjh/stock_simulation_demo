package org.simulation.operation.controller;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.ViolationeCord;
import org.simulation.operation.service.ViolationeCordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViolationeCordController {

	/**
	 * 自动注入Service
	 * */
	@Autowired
	@Qualifier("violationeCordService")
	private ViolationeCordService violationeCordService;
	
	
	@RequestMapping(value="/violationeCord/selectViolationeCord")
	 public String selectNotice(Model model,Integer pageIndex,
			 @ModelAttribute ViolationeCord violationeCord){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<ViolationeCord> violationeCords = violationeCordService.findViolationeCord(violationeCord, pageModel);
		model.addAttribute("violationeCords",violationeCords);
		model.addAttribute("pageModel", pageModel);
		return "violationeCord/violationeCord";
		
	}
}
