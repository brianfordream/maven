package com.btgxlm.core.Dao;

import static org.junit.Assert.assertNotNull;
import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.btgxlm.core.util.DaoSessionFactory;

public class TestDaoSessionFactory {
	@Test
	public void test(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sessionFactory=new DaoSessionFactory().getSessionFactory();
		assertNotNull(sessionFactory);
	}
}
