package com.rest.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class SpecBuilderTest {

	public static void main(String[] args) {

		RestAssured.baseURI = "URL";

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("URL").addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();

		ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		
		RequestSpecification res = given().spec(req).body("");

		Response response = res.when().post("/maps/api/place/add/json").then().spec(resspec).extract().response();

		String responseString = response.asString();
		System.out.println(responseString);

	}

}
