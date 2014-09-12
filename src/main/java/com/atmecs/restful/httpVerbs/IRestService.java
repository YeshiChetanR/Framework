package com.atmecs.restful.httpVerbs;

import org.json.simple.JSONObject;

import com.jayway.restassured.response.Response;

public interface IRestService {

	public Response getResponse(JSONObject obj);
	
}
