package com.rest.utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseClass {
	
	
	public RequestSpecBuilder reqBuilder;
	public RequestSpecification requestSpecification;
	public Response response;
	public JsonPath jsonPath;
	protected RestAssured restAssured;
	public static String tokenID;
	public static int bookingID;
	
	@BeforeClass
	public void setUp()
	{
		restAssured = new RestAssured();
		RestAssured.baseURI= "https://restful-booker.herokuapp.com";
		
	
		
		
		
		
		
		
		
	}
	
	
	//@Test()
	public void testMe()
	{
	
	/*	
		//How to declare RequestSpecBuilder
		reqBuilder= new RequestSpecBuilder();
		reqBuilder.setBaseUri("https://restful-booker.herokuapp.com");
		reqBuilder.addQueryParam("Key", "value");
		reqBuilder.setContentType(ContentType.JSON);
		requestSpecification=reqBuilder.build();
		
				 given()			
				 .spec(requestSpecification)
				 .when()
				 .get()
				 .then()
				 .statusCode(200);
	*/		 
				 
		
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		
	}
	
	
	public String getTokenID()
	{
		System.out.println("Token Test: " + tokenID);
		return tokenID;
	}
	
	

}
