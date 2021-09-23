package com.rest.test;

import static org.testng.Assert.assertEquals;

import org.apache.http.entity.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.rest.payloads.RequestPayload;
import com.rest.utils.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAuthenticationToken extends BaseClass {
	
	

	
	@Test
	public void getAuthToken()
	{
		
	/*	
		We can also create json object in this way to use payload in request body
		JSONObject payload1 = new JSONObject();
		payload1.put("username", "admin"); 
		payload1.put("password", "password123");
		System.out.println("Payload : " + payload1.toJSONString());
		RequestSpecification request = RestAssured.given().body(payload1.toJSONString());
		
*/		
		requestSpecification= RestAssured.given();
		response= requestSpecification.header("Content-Type", "application/json")
		.body(RequestPayload.getAuthenticationPayload())
		.log().all()
		.pathParam("auth", "auth")
		.when()
		.post("/{auth}");
		
		System.out.println("Response is: " + response.body().asString());
		
		//Verify the status code should be displayed 200
		assertEquals(response.getStatusCode(), 200, "Status code should be 200");
		
		
		jsonPath= new JsonPath(response.body().asString());
		
		//Fetching the toekn ID from the response and storing for future use
		tokenID= jsonPath.get("token");
		System.out.println("Token: " +tokenID);
		
		System.out.println("Token: " +getTokenID());

		
	}

}
