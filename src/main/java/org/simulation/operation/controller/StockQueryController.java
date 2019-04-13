package org.simulation.operation.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.common.RealTimeindStock;
import org.simulation.operation.common.UserConstants;
import org.simulation.operation.domain.HistoryHolding;
import org.simulation.operation.domain.RealTimeStock;
import org.simulation.operation.domain.StockQuery;
import org.simulation.operation.service.HistoryHoldingService;
import org.simulation.operation.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理用户请求控制器
 * */
@Controller
public class StockQueryController {


	/**
	 * 自动注入UserService
	 * */
	@Autowired
	@Qualifier("stockQueryService")
	private StockQueryService stockQueryService;
	
	@Autowired
	@Qualifier("historyHoldingService")
	private HistoryHoldingService historyHoldingService;
	
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param employee 模糊查询参数
	 * @param Model model
	 * */
	@RequestMapping(value="/stock/selectStock")
	 public String selectShStock(Integer pageIndex,
			 @ModelAttribute StockQuery stockQuery,
			 String region,HttpServletRequest request, HttpSession session,
			 Model model){
		System.out.println("stockQuery = " + stockQuery);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		if(region !=null && !"".equals(region)) {
			session.setAttribute(UserConstants.REGION_SESSION, region);
			stockQuery.setRegion(region);
		}else {
			String regionhttp = (String)request.getSession().getAttribute(UserConstants.REGION_SESSION); 
			stockQuery.setRegion(regionhttp);
		}
		
		List<StockQuery> stockQuerys = stockQueryService.findStock(stockQuery, pageModel);
		List<RealTimeStock> realTimeStocks = new ArrayList<>();
		for(StockQuery s:stockQuerys) {
			if(s.getStockCode() !=null && !"".equals(s.getStockCode())) {
				List<RealTimeStock> realTimeStock = new RealTimeindStock().getRealTimeindStock(s.getStockCode());
				realTimeStocks.addAll(realTimeStock);
			}
		}
		model.addAttribute("realTimeStocks", realTimeStocks);
		model.addAttribute("pageModel", pageModel);
		return "stock/stock";
		
	}
	
    @RequestMapping(value = "/stock/viewStock")
    public ModelAndView updateStock(String flag, @ModelAttribute RealTimeStock realTimeStock,ModelAndView mv) {   
	    	if (flag.equals("1")) {
				List<RealTimeStock> realTimeStocks = new RealTimeindStock().getRealTimeindStock(realTimeStock.getCode());
				mv.addObject("realTimeStocks",realTimeStocks);
			    mv.setViewName("stock/showUpdateStock");
				} else {
				    // 设置客户端跳转到查询请求
				    mv.setViewName("redirect:/stock/selectStock");
				}
    	
	// 返回
	return mv;
    }
    
    @RequestMapping(value = "/stock/addStock")
    public String addStock(@ModelAttribute RealTimeStock realTimeStock,Model model) {	    
	      List<RealTimeStock> realTimeStocks = new ArrayList<>();
	     //读取信息：获取除了”价格以外数据“
	      if(realTimeStock.getCode() != null && !"".equals(realTimeStock.getCode())) {
	    	  realTimeStocks = new RealTimeindStock().getRealTimeindStock(realTimeStock.getCode());
	    	  List<HistoryHolding> historyHolding = new ArrayList<>();
	    	  if(realTimeStocks.size() == 1) {
	    		  for(RealTimeStock s:realTimeStocks) {
	    			  HistoryHolding h = new HistoryHolding();
	    			  h.setId(new Date().getTime()+realTimeStock.getCode());
	    			  h.setState(realTimeStock.getState());
	    			  h.setStockCode(realTimeStock.getCode());
	    			  h.setCostPrice(realTimeStock.getPrice());
	    			  h.setHoldingNum(realTimeStock.getStockNum());
	    			  h.setCurrency("人民币");
	    			  h.setStockName(s.getName());
	    			  h.setClosingPrice(s.getLastClose());//昨日收盘价
	    			  historyHolding.add(h);
	    			  
	    		  }
	    	  }
	    	  historyHoldingService.sava(historyHolding);
	      }
		model.addAttribute("realTimeStocks",realTimeStocks);
	    return "stock/showAddStock";
	}


}
