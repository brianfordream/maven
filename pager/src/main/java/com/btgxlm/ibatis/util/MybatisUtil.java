package com.btgxlm.ibatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory;
	private MybatisUtil(){
	}
	static{
		factory=buildSessionFactory();
	}
	private static SqlSessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub
		InputStream in = null;
		SqlSessionFactory factory=null;
		try {
			in=Resources.getResourceAsStream("mybatis-config.xml");
		   factory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return factory;
	}
	
	public static SqlSessionFactory getSessionFactory(){
		return factory;
	}
	public static SqlSession getSession(){
		return factory.openSession();
	}
	public static void closeSession(SqlSession session){
		session.close();
	}
}
