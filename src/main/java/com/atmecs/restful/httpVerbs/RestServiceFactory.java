package com.atmecs.restful.httpVerbs;

import org.springframework.stereotype.Component;


public class RestServiceFactory{
	
	/*public IRestService createGetRequest(){
		return new GetHttpVerb();
	}
	
	public IRestService createPostRequest(){
		return new PostHttpVerb();
	}
	
	public IRestService createPutRequest(){
		return new PutHttpVerb();
	}
	
	public IRestService createDeleteRequest(){
		return new DeleteHttpVerb();
	}*/
	
	
	public IRestService getService(String s){
		
		if(s.equals("GET")){
			return new GetHttpVerb();
		}
		else if(s.equals("PUT")){
			return new PutHttpVerb();
		}
		else if(s.equals("POST")){
			return new PostHttpVerb();
		}
		else if(s.equals("DELETE")){
			return new DeleteHttpVerb();
		}
		else{
			return null;		
		}
	}
	
}
