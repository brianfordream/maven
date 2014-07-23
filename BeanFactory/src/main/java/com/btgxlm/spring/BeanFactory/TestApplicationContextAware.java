package com.btgxlm.spring.BeanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.btgxlm.spring.model.Worker;

public class TestApplicationContextAware {
	public static void main(String args[]){
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Worker worker=(Worker) context.getBean("worker");
	}
}
