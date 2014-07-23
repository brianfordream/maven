package com.btgxlm.spring.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
/*
 * DisposableBean为Bean的销毁提供回调功能,在bean实例销毁前调用接口的destroy()方法.
 */
public class User implements InitializingBean,DisposableBean{
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public User(){
		System.out.print("默认构造函数:");
		this.username="constructName";
		System.out.println(this);
	}
	
	public void init(){
		this.username="initName";
		System.out.println("指定初始化方法"+this);
	}
	
	public String toString(){
		return username;
	}

	public void destroy() throws Exception {
		System.out.println("Destroy in Disposable");
	}
	
	public void destroyMethod(){
		System.out.println("Destroy in destroy-method");
	}
	public void afterPropertiesSet() throws Exception {
		this.username="afterIniting";
		System.out.println("afterPropertiesSet在初始化bean之后"+this);
	}

}
