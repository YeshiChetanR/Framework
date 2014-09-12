package com.atmecs.restful.assertion;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

@Component
public class AssertResponse implements Assertion{
	
	public boolean getAssertion(Response response,JSONObject obj){
		
		/*String json = response.asString();
		JsonPath jp = new JsonPath(json);
		ArrayList json1 = jp.get("results.formatted_address");
		Assert.assertEquals(obj.get("formatted_address"), json1.get(0));*/
		
		if (response.statusCode() == 200) {
			return true;
		} else {
			return false;
		}
	}

}
