package com.atmecs.restful.parser;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface IParser {
	public Object getParserObject(String file) throws FileNotFoundException, IOException, ParseException;
}
