package org.simulation.operation.service;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.domain.User;

public interface UserService {

	/**
	 * 用户登录
	 * @param  loginname
	 * @param  password
	 * @return User对象
	 * */
	User login(String loginname,String password);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return 用户对象
	 * */
	User findUserById(String id);
	
	/**
	 * 获得所有用户
	 * @return User对象的List集合
	 * */
	List<User> findUser(User user);
		
	/**
	 * 修改用户
	 * @param User 用户对象
	 * */
	void modifyUser(User user);
}
