package com.atmecs.restful.parser;

import org.springframework.stereotype.Component;

public class ParserFactory {

	/*public IParser createJsonParser(){
		return new JsonParser();
	}
	
	public IParser createXmlParser(){
		return null;
	}
	*/
	public IParser getParser(String x){
		
		if(x.equals("json")){
			return new JsonParser();
		}
		else if(x.equals("xml")){
			return new XmlParser();
		}
		else
		{
			return null;
		}
		
	}
	
}
