package com.btgxlm.core.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
