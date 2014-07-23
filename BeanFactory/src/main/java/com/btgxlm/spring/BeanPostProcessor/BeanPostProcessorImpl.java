package com.btgxlm.spring.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/*
 * BeanPostProcessor接口，该接口作用是：如果我们需要在Spring容器完成Bean的实例化，
 * 配置和其他的初始化后添加一些自己的逻辑处理，我们就可以定义一个或者多个BeanPostProcessor接口的实现。
 */
public class BeanPostProcessorImpl implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Before initing bean:"+beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("After initing bean:"+beanName);
		return bean;
	}

}
