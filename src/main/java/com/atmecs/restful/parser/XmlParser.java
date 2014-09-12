package com.atmecs.restful.parser;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.crypto.dsig.XMLObject;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
public class XmlParser implements IParser{

	@Override
	public Object getParserObject(String file) throws FileNotFoundException, IOException, ParseException {
		XmlParser obj = (XmlParser) new XmlParser();
		XMLObject xmlObject= (XMLObject) obj.getParserObject(file);
		return obj;
	}
}
