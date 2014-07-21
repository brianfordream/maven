package com.btgxlm.core.Dao;

import static org.junit.Assert.assertNotNull;
import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.btgxlm.core.util.DaoSessionFactory;

public class TestDaoSessionFactory {
	@Test
	public void test(){
		SessionFactory sessionFactory=new DaoSessionFactory().getSessionFactory();
		assertNotNull(sessionFactory);
	}
}
