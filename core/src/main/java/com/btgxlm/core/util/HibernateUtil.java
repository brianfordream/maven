package com.btgxlm.core.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory buildSessionFactory(){
	    Configuration configuration =new Configuration();
	    configuration.configure();
	    ServiceRegistry  serviceRegistry =new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	private static SessionFactory sessionFactory=buildSessionFactory();
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
