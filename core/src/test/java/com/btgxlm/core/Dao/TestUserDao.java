package com.btgxlm.core.Dao;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import com.btgxlm.core.Dao.IUserDao;
import com.btgxlm.core.Dao.UserDaoImpl;
import com.btgxlm.core.model.User;
import com.btgxlm.core.util.HibernateUtil;
/**
 * maven test 约定大于配置，
 * 默认包含的测试类：
* *Test.java
* Test*.java
* *TestCase.java
*	*默认排除的测试类：
** /Abstract*Test.java
** /Abstract*TestCase.java
 * @author Administrator
 *
 */
public class TestUserDao {

	@Test
	public void test() {
		IUserDao dao=new UserDaoImpl();
		User user=new User("yang","123456","brian");
		dao.addUser(user);
//		assertNotNull(HibernateUtil.getSessionFactory());
		User u=dao.findUserByName("yang");
		System.out.println(u);
	}

}
