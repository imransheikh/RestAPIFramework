package com.rest.test;

import static org.junit.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.rest.utils.BaseClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetBookingById extends BaseClass {
	
	
	@Test
	public void getBookingById()
	{
		requestSpecification= RestAssured.given();
		response= requestSpecification.header("Content-Type", "application/json")
				.log().all()
				.pathParam("booking", "booking")
				.pathParam("bookingID", bookingID)
				//.pathParam("bookingID", bookingID)
				.get("/{booking}/{bookingID}");
		
		System.out.println("Response is: " + response.body().asString());
		jsonPath= new JsonPath(response.body().asString());
		
		//verify that first name not be null
		assertNotNull(jsonPath.get("firstname"));
		
		//verify that last name not be null
		assertNotNull(jsonPath.get("lastname"));
		
		//verify that total price not be null
		assertNotNull(jsonPath.get("totalprice"));
		
		//verify that check-in date is not null
		assertNotNull(jsonPath.get("bookingdates.checkin"));
	}

}
