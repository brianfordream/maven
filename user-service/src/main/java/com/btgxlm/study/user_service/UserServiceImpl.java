package com.btgxlm.study.user_service;

import com.btgxlm.core.Dao.IUserDao;
import com.btgxlm.core.model.User;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao;
	public UserServiceImpl(IUserDao userDao){
		this.userDao=userDao;
	}
	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	public User loadUserByName(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(username);
	}

}
