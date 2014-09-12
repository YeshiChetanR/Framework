package com.atmecs.restful.validation;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.jayway.restassured.response.Response;

public class ResponseValidator implements Validator{

	@Override
	public String validate(Response res,JSONObject obj) {
		
		if(res!=null){
			if(res.contentType().contains((CharSequence) obj.get("response type")))
				return "valid";
			else
				return "invalid";
		}
		else{
		return "invalid";
		}
	}

}
