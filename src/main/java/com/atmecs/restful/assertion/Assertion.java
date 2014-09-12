package com.atmecs.restful.assertion;

import org.json.simple.JSONObject;

import com.jayway.restassured.response.Response;

public interface Assertion {
	public boolean getAssertion(Response response,JSONObject obj);
}
