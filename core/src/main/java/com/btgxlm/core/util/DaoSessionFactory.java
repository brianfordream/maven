package com.btgxlm.core.util;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
@Service
public class DaoSessionFactory {
	@Resource(name="mySessionFactory")
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
