package com.atmecs.restful.httpVerbs;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.jayway.restassured.response.Response;
public class DeleteHttpVerb implements IRestService{

	@Override
	public Response getResponse(JSONObject obj) {
		return null;
	}

}
