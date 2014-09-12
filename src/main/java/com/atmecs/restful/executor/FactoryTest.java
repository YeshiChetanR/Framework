package com.atmecs.restful.executor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class FactoryTest {
	Properties p = new Properties();
	public String fileSeparator = System.getProperty("file.separator");
	public String configuration;
	public String suite;
	
	ApplicationContext context = Context.getContext();
		
	/*public FactoryTest(String configuration,String suite) {
		this.configuration = configuration;
		this.suite=suite;
	}*/
	
	public FactoryTest() {
		this.configuration = "Configuration.properties";
		this.suite = "suite.json";
	}
	
	
	@Factory(dataProvider = "EP")
	public Object[] createTestCaseInstance(String testCaseName,String contract) {

		    Object[] controller = new Object[1];
		    controller[0] = context.getBean("controller",testCaseName,contract);
			return controller;

	}

	@DataProvider(name = "EP")
	public Iterator<Object[]> getData() throws FileNotFoundException, IOException, ParseException {
		
		List<Object[]> dataProviderList = new ArrayList<Object[]>();
		InputStream configProperties = new FileInputStream(System.getProperty("user.dir") + fileSeparator + "Configuration.properties");
		p.load(configProperties);
		
		JSONParser testCaseParser = new JSONParser();
		JSONObject	suiteData = (JSONObject) testCaseParser.parse(new FileReader(System.getProperty("user.dir") + fileSeparator + "suite.json"));
		JSONArray suiteArray = (JSONArray) suiteData.get(p.get("suite"));
		for (int testCase = 0; testCase < suiteArray.size(); testCase++) {

			JSONObject testCaseObject = (JSONObject) suiteArray.get(testCase);
			int testCaseKeyNumber= testCase + 1;
			String testCaseKey = "TC" + testCaseKeyNumber;
			String testCaseName = (String) testCaseObject.get(testCaseKey);
			dataProviderList.add(new Object[] {testCaseName,p.get("contract")});
		}
		return dataProviderList.iterator();
	}
}
