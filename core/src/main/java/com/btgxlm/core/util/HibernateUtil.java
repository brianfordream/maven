package com.btgxlm.core.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.domain.Superclass;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateUtil {
	private static SessionFactory buildSessionFactory(){
	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	SessionFactory sessionFactory = (SessionFactory) context.getBean("mySessionFactory");
	    return sessionFactory;
	}
	private static SessionFactory sessionFactory=buildSessionFactory();


	private HibernateUtil(){

	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}


	public static Session getSession(){
		return sessionFactory.openSession();
	}
	public static void closeSession(Session session){
		if(session!=null)
			session.close();
	}	
}
