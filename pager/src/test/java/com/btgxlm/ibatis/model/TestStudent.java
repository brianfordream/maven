package com.btgxlm.ibatis.model;

import org.junit.Before;
import org.junit.Test;

import com.btgxlm.ibatis.dao.IUserDao;
import com.btgxlm.ibatis.dao.UserDaoImpl;
import com.btgxlm.ibatis.pager.Pager;
import com.btgxlm.ibatis.util.MybatisUtil;

public class TestStudent {
	private IUserDao dao;
	@Before
	public void init(){
		dao=new UserDaoImpl();
	}
	@Test
	public void TestGetStudent(){
		Pager<Student> pages=((UserDaoImpl)dao).findForeign();
			for(Student u:pages.getList())
			System.out.println(u);
	}
	
	@Test
	public void TestGetClass(){
		Pager<Classmate> pages=((UserDaoImpl)dao).findClass();
			for(Classmate u:pages.getList())
			System.out.println(u);
	}
	
	@Test
	public void TestGetClass2(){
		Pager<Classmate> pages=((UserDaoImpl)dao).findClass2();
			for(Classmate u:pages.getList())
			System.out.println(u);
	}
}
