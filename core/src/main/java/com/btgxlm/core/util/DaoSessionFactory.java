package com.btgxlm.core.util;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

public class DaoSessionFactory extends HibernateDaoSupport {

//	public SessionFactory getXmlSessionFactory(){
////ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
////DaoSessionFactory factory=(DaoSessionFactory) context.getBean("daotest");
////return factory.getSessionFactory();
//return this.getSessionFactory();
//}
}
