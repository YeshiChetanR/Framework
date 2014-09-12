package com.atmecs.restful.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

public class JsonParser implements IParser{
	
	@Override
	public Object getParserObject(String file) throws FileNotFoundException, IOException, ParseException {
		
		String fileSeparator = System.getProperty("file.separator");
		JSONParser parser = new JSONParser();
		String path =  System.getProperty("user.dir") + fileSeparator + file;
		JSONObject obj = (JSONObject) parser.parse(new FileReader(new File(path)
				.getAbsolutePath()));
		return obj;
	}
	
}
