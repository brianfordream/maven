package com.btgxlm.core.util;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoSessionFactory {
	private SessionFactory sessionFactory;
	public SessionFactory GetSessionFactory(){
		return getSessionFactory();
	}
	public SessionFactory getSessionFactory() {
		ApplicationContext context=new ClassPathXmlApplicationContext();
		SessionFactory sessionFactory = (SessionFactory) context.getBean("mySessionFactory");
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
