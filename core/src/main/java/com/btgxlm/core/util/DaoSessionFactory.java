package com.btgxlm.core.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DaoSessionFactory {
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory GetSessionFactory(){
		return sessionFactory;
	}
}
