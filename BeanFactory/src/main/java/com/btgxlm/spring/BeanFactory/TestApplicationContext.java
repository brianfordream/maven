package com.btgxlm.spring.BeanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.btgxlm.spring.model.User;
/*
 * ApplicationContext在容器加载时就已经将bean进行了加载和初始化，而beanFactory采用的是延迟加载的形式来注入bean
 * 即只有在使用到某个bean(调用getBean())，才对该bean进行加载实例化。这样，不方便发现一些存在的问题。而ApplicationContext
 * 实在容器启动时，一次性创建所有的bean，这样，在容器启动时，就可以发现spring配置中的一些错误。
 * BeanFactory 和 ApplicationContext都支持BeanPostProcessor、BeanFactoryPostProcessor的使用，但两者之间的区别是：BeanFactory
 * 需要手动注册，而ApplicationContext则是自动注册。
 */
public class TestApplicationContext {
	public static void main(String args[]){
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		User u=(User) context.getBean("user");   
		AbstractApplicationContext ctx=(AbstractApplicationContext)context;
		ctx.registerShutdownHook();
		
	}
}
