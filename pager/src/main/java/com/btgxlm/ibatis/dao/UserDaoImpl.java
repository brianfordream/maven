package com.btgxlm.ibatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.btgxlm.ibatis.model.Classmate;
import com.btgxlm.ibatis.model.Student;
import com.btgxlm.ibatis.model.User;
import com.btgxlm.ibatis.pager.Pager;
import com.btgxlm.ibatis.util.MybatisUtil;
import com.btgxlm.ibatis.util.SystemContext;

public class UserDaoImpl implements IUserDao<User> {
	private SqlSession session;
	public void add(User user) {
		// TODO Auto-generated method stub
		session=MybatisUtil.getSession();
		session.insert("com.btgxlm.ibatis.model.User.add",user);
		session.commit();
		MybatisUtil.closeSession(session);
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		session=MybatisUtil.getSession();
		session.delete("com.btgxlm.ibatis.model.User.delete",user);
		session.commit();
		MybatisUtil.closeSession(session);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		session=MybatisUtil.getSession();
		session.update("com.btgxlm.ibatis.model.User.update",user);
		session.commit();
		MybatisUtil.closeSession(session);
	}

	public Pager<User> find(String username) {
		// TODO Auto-generated method stub
		Pager<User> pager=new Pager<User>();
		List<User> datas;
		session=MybatisUtil.getSession();
		datas=session.selectList("com.btgxlm.ibatis.model.User.find",username);
		session.commit();
		MybatisUtil.closeSession(session);
		pager.setList(datas);
		return pager;
	}

	public Pager<User> findPager(String username) {
		// TODO Auto-generated method stub
		Pager<User> pager=new Pager<User>();
		List<User> datas;
		Map<String,Object> variables=new HashMap<String,Object>();
		String sort=SystemContext.getSort();
		String order=SystemContext.getOrder();
		int index=SystemContext.getPageIndex();
		int offset=SystemContext.getPageOffset();
		variables.put("nickname", "brian");
		variables.put("username",username);
		variables.put("order", order);
		variables.put("sort", sort);
		variables.put("index",index);
		variables.put("offsize", offset);
		session=MybatisUtil.getSession();
		datas=session.selectList("com.btgxlm.ibatis.model.User.findpage",variables);
		session.commit();
		MybatisUtil.closeSession(session);
		pager.setList(datas);
		return pager;
	}
	
	public Pager<User> findtest() {
		// TODO Auto-generated method stub
		Pager<User> pager=new Pager<User>();
		List<User> datas;
		session=MybatisUtil.getSession();
		Map<String,Object> map=new HashMap<String ,Object>();
		User u=new User("yang","123","32");
		//String username="he";
		map.put("user", u);
		//map.put("username",username);
		datas=session.selectList(User.class.getName()+".testMultipleAttribute",map);
		session.commit();
		MybatisUtil.closeSession(session);
		pager.setList(datas);
		return pager;
	}
	
	public Pager<Student> findForeign(){
		Pager<Student> pager=new Pager<Student>();
		List<Student> datas;
		session=MybatisUtil.getSession();
		Map<String,Object> map=new HashMap<String ,Object>();
		Student student=new Student();
		student.setId(1);
		map.put("student", student);		
		datas=session.selectList(Student.class.getName()+".testForeign",map);
		session.commit();
		MybatisUtil.closeSession(session);
		pager.setList(datas);
		return pager;
	}
	
	public Pager<Classmate> findClass(){
		Pager<Classmate> pager=new Pager<Classmate>();
		List<Classmate> datas;
		session=MybatisUtil.getSession();
		Map<String,Object> map=new HashMap<String ,Object>();
		Classmate classmate=new Classmate();
		classmate.setId(1);
		map.put("class",classmate);
		datas=session.selectList(Student.class.getName()+".testClass",map);
		session.commit();
		MybatisUtil.closeSession(session);
		pager.setList(datas);
		return pager;
	}
	
	public Pager<Classmate> findClass2(){
		Pager<Classmate> pager=new Pager<Classmate>();
		List<Classmate> datas;
		session=MybatisUtil.getSession();
		datas=session.selectList(Student.class.getName()+".testClass",3);
		session.commit();
		MybatisUtil.closeSession(session);
		pager.setList(datas);
		return pager;
	}

}
