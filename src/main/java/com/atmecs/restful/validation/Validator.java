package com.atmecs.restful.validation;

import org.json.simple.JSONObject;

import com.jayway.restassured.response.Response;

public interface Validator {
	public String validate(Response res,JSONObject obj);
}
