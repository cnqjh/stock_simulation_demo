package org.simulation.operation.controller;


import javax.servlet.http.HttpSession;

import org.simulation.operation.domain.User;
import org.simulation.operation.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
import org.simulation.operation.common.UserConstants;


/**
 * 处理用户请求控制器
 */
@Controller
public class UserController {

    /**
     * 自动注入UserService
     */
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    /**
	 * 处理登录请求
	 * @param String loginname  登录名
	 * @param String password 密码
	 * @return 跳转的视图
	 * */
	@RequestMapping(value="/login")
	 public ModelAndView login(@RequestParam("loginName") String loginName,
			 @RequestParam("loginPassword") String loginPassword,
			 HttpSession session,
			 ModelAndView mv){
		// 调用业务逻辑组件判断用户是否可以登录
		User user = userService.login(loginName, loginPassword);
		if(user != null){
			// 将用户保存到HttpSession当中
			session.setAttribute(UserConstants.USER_SESSION, user);
			// 客户端跳转到main页面
			mv.setViewName("redirect:/main");
		}else{
			// 设置登录失败提示信息
			mv.addObject("message", "登录名或密码错误!请重新输入");
			// 服务器内部跳转到登录页面
			mv.setViewName("forward:/loginForm");
		}
		return mv;
	}







}
