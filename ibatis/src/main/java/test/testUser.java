package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.btgxlm.model.User;

public class testUser {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException{
		testUser test=new testUser();
		test.testDelete();
	
	}
	
	/*
	 * 插入数据
	 */
	public void testInsert(){
		InputStream is;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory =new  SqlSessionFactoryBuilder().build(is);
			SqlSession session=factory.openSession();
			User u=new User();
			u.setNickname("孙悟空");
			u.setPassword("1234");
			u.setUsername("wukong");
			session.insert("com.btgxlm.model.User.add",u);
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 查询数据
	 */
	public void testQuery() throws IOException{
		InputStream is;
		is=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		List<User> users=session.selectList("com.btgxlm.model.User.query", "wukong");
		session.commit();
		session.close();
		for(User u:users){
			System.out.println("UserName:"+u.getUsername()+"\n\tPassword:"+u.getPassword()+"\n\tNickName:"+u.getNickname());
		}
	}
	
	/*
	 * 更新数据
	 */
	public void testUpdate() throws IOException{
		InputStream is;
		is=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		User u=new User();
		u.setId(135);
		u.setUsername("yang");
		u.setPassword("yang");
		u.setNickname("he");
		session.update("com.btgxlm.model.User.update", u);
		session.commit();
		session.close();
	}
	
	/*
	 * 删除数据
	 */
	public void testDelete() throws IOException{
		InputStream is;
		is=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		int id=135;
		session.delete("com.btgxlm.model.User.delete", id);
		session.commit();
		session.close();
	}
	
	
}
