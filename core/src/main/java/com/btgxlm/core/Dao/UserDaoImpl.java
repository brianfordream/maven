package com.btgxlm.core.Dao;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;

import com.btgxlm.core.model.User;
import com.btgxlm.core.util.HibernateUtil;

public class UserDaoImpl implements IUserDao {
	private Session session;
	public void addUser(User u) {
		// TODO Auto-generated method stub
		session=HibernateUtil.getSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
	}

	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		session=HibernateUtil.getSession();
		session.beginTransaction();
		User user=(User)session.createQuery("from User where username=?").setParameter(0, username).list().get(0);
		session.getTransaction().commit();
		HibernateUtil.closeSession(session);
		return user;
		
	}

}
