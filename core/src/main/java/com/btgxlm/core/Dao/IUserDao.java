package com.btgxlm.core.Dao;

import com.btgxlm.core.model.User;

public interface IUserDao {
	public void addUser(User u);
	public User findUserByName(String username);
}
