package com.btgxlm.core.util;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DaoSessionFactory {
	private SessionFactory sessionFactory;
	public SessionFactory GetSessionFactory(){
		return getSessionFactory();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
