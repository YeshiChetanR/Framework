package com.atmecs.restful.executor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {

	
	static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static ApplicationContext getContext(){
		return context;
	}
}
