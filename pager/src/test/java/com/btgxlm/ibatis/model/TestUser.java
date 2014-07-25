package com.btgxlm.ibatis.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.btgxlm.ibatis.dao.IUserDao;
import com.btgxlm.ibatis.dao.UserDaoImpl;
import com.btgxlm.ibatis.pager.Pager;
import com.btgxlm.ibatis.util.MybatisUtil;
import com.btgxlm.ibatis.util.SystemContext;

public class TestUser {
	private IUserDao dao;
	@Before
	public void init(){
		dao=new UserDaoImpl();
	}
	@Test
	public void TestMybatisUtil(){
		MybatisUtil.closeSession(MybatisUtil.getSession());
	}
	
	@Test
	public void TestAdd(){
		User u=new User("heying","12","hemanzi");
		dao.add(u);
	}
	
	@Test
	public void TestDelete(){
		User u=new User("heying","12","hemanzi");
		u.setId(92);
		dao.delete(u);
	}
	
	@Test
	public void TestUpdate(){
		User u=new User("he","aini","pl");
		u.setId(139);
		dao.update(u);
	}
	
	@Test
	public void TestFind(){
		String username="yang";
		Pager<User> pages=dao.find(username);
		for(User u:pages.getList())
			System.out.println(u);
	}
	
	@Test
	public void TestFindPage(){
		String username="yang";
		SystemContext.setOrder("nickname");
		SystemContext.setPageIndex(0);
		SystemContext.setPageOffset(8);
		SystemContext.setSort("desc");
		Pager<User> pages=dao.findPager(username);
		for(User u:pages.getList())
			System.out.println(u);
	}
	
	@Test
	public void TestFindTest(){
		((UserDaoImpl)dao).findtest();
	}
	@After
	public void destroy(){
		
	}
}
