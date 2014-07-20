package com.btgxlm.study.user_service;

import com.btgxlm.core.model.User;

public interface IUserService {
	void add(User user);
	User loadUserByName(String username);
}
