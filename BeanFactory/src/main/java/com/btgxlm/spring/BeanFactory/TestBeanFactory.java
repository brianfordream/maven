package com.btgxlm.spring.BeanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.btgxlm.spring.BeanPostProcessor.BeanPostProcessorImpl;
import com.btgxlm.spring.model.User;
/*
 * 如果在BeanFactory中不调用getBean则不会初始化bean
 */
public class TestBeanFactory {
	public static void main(String[] args)
	{
	  DefaultListableBeanFactory beanRegistry=new DefaultListableBeanFactory();
	  BeanFactory container=bindViaXMLFile(beanRegistry);
	 ConfigurableBeanFactory factory=(ConfigurableBeanFactory)container;
	 /*
	  * BeanFactory和ApplicationContext对待Bean的后置处理其稍有不同，ApplicationContext会自动检测在配置文件中实现了
	  * BeanPostProcessor接口的所有的bean，并把它们注册为后置处理器，然后在容器创建bean的适当时候调用它。部署一个
	  * 后置处理器同部署其他的bean并没有什么区别，而是用beanFactory实现的时候，bean后置处理器必须通过下面类似的代码
	  * 显式的去注册.
	  */
	 BeanPostProcessor beanPostProcessor=new BeanPostProcessorImpl();;
	factory.addBeanPostProcessor(beanPostProcessor);
	   //使用时才加载
	 User user=(User)container.getBean("user");
	  
	}
	 
	public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry)
	{
	  XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(registry);
	  reader.loadBeanDefinitions("ApplicationContext.xml");
	  return (BeanFactory)registry;
	  
	  //或者直接
	  //return new XmlBeanFactory(new ClassPathResource("../news-config.xml"));
	}
}
