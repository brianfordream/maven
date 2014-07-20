package com.btgxlm.study.user_service;

import org.junit.Test;

import com.btgxlm.core.Dao.UserDaoImpl;
import com.btgxlm.core.model.User;

public class TestUserDao {
@Test
public void test(){
	User user=new User("heying","123","Iloceyou");
	IUserService service=new UserServiceImpl(new UserDaoImpl());
	service.add(user);
	System.out.println(service.loadUserByName("heying"));
}
}
