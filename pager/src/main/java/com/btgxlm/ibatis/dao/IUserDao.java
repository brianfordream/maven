package com.btgxlm.ibatis.dao;
import com.btgxlm.ibatis.model.User;
import com.btgxlm.ibatis.pager.Pager;

public interface IUserDao <T>{
	void add(User user);
	void delete(User uesr);
	void update(User user);
	Pager<T> find(String username);
	Pager<T> findPager(String username);
}
