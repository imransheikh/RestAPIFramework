package com.rest.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;
import com.rest.utils.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetBookings extends BaseClass{
	
	
	
	@Test
	public void getBookings()
	{
		
		requestSpecification= RestAssured.given();
		response= requestSpecification.header("Content-Type", "application/json")
		.log().all()
		.pathParam("booking", "booking")
		.when()
		.get("/{booking}");
		
		System.out.println("Response: " + response.body().asString());
		jsonPath= new JsonPath(response.body().asString());
		
		List<Integer> count= jsonPath.get("bookingid");
		System.out.println("Total Number of bookings: " +count.size());		
		
		assertEquals(response.getStatusCode(), 200);
		
		
	}

}
