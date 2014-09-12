package com.atmecs.restful.executor;

import org.springframework.stereotype.Component;

public class StatusFactory {
	private static Status st;
	static {
		 st = new Status();
	}
	
	public static Status getStatus(){
		return st;
	}
}
