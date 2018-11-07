package org.simulation.operation.service.impl;

import java.util.List;

import org.simulation.operation.common.PageModel;
import org.simulation.operation.dao.UserDao;
import org.simulation.operation.domain.User;
import org.simulation.operation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;



@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService{

	/**
	 * 自动注入持久层Dao对象
	 * */
	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly=true)
	@Override
	public User login(String loginName, String loginPassword) {
//		System.out.println("HrmServiceImpl login -- >>");
		return userDao.selectByLoginnameAndPassword(loginName, loginPassword);
	}


	@Override
	public User findUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUser(User user, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
