package com.atmecs.restful.httpVerbs;

import static com.jayway.restassured.RestAssured.get;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.jayway.restassured.response.Response;
@Component
public class GetHttpVerb implements IRestService{

	@Override
	public Response getResponse(JSONObject obj) {
		Response res = get((String) obj.get("uri"));
		return res;
	}

}
