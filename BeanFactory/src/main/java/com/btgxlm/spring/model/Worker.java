package com.btgxlm.spring.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/*
 * ApplicationContextAware感知当前的上下文，通过它可以调用容器的服务
 * BeanNameAware 可以感知Ioc容器中配置实例的Bean的名称.
 */
public class Worker implements ApplicationContextAware ,BeanNameAware{
	private String workname;
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		// 通过感知applicationContext获取Employee，然后雇佣自己。
		 Employee employee= (Employee) context.getBean("employee");
		 this.workname="ApplicationContextAwareWorker";
		 employee.EmployWorker(this);
	}
	public String toString(){
		return workname;
	}
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println(name);
	}
}
