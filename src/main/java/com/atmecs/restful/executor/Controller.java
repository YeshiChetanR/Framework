package com.atmecs.restful.executor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.atmecs.restful.assertion.AssertResponse;
import com.atmecs.restful.assertion.Assertion;
import com.atmecs.restful.httpVerbs.IRestService;
import com.atmecs.restful.httpVerbs.RestServiceFactory;
import com.atmecs.restful.parser.IParser;
import com.atmecs.restful.parser.JsonParser;
import com.atmecs.restful.parser.ParserFactory;
import com.atmecs.restful.validation.ResponseValidator;
import com.atmecs.restful.validation.Validator;
import com.jayway.restassured.response.Response;

public class Controller {
	 boolean flag ;
	 String testCase,contract;
	
	 Status st = StatusFactory.getStatus();
	 ApplicationContext context =Context.getContext();
	
	 public Controller(String testCase,String contract) {
		this.testCase=testCase;
		this.contract=contract;
	}
	
	
	@Test
	public void test() throws FileNotFoundException, IOException, ParseException {
		
		IParser parser = (IParser) context.getBean("getParser",contract);
		JSONObject obj =  (JSONObject) parser.getParserObject(testCase);
		
		System.out.println(obj.toString());
		IRestService service = (IRestService) context.getBean("httpfactory",(String) obj.get("method"));
		Response res = service.getResponse(obj);
		
		Validator validator = context.getBean("responseValidator",Validator.class);
		String validation = validator.validate(res, obj);
		
		if(validation.equals("valid")){
			 Assertion assertion = context.getBean("assertResponse",Assertion.class);
			 flag = assertion.getAssertion(res,(JSONObject) obj.get("response body"));
			 System.out.println("status :"+flag);
			 st.al.put(testCase, flag);
			 
		}
		else{ 
			st.al.put(testCase, "false");
			System.out.println("status :"+flag);
		}
	}
	
	
	/*@AfterTest
	public void after(){
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
}




