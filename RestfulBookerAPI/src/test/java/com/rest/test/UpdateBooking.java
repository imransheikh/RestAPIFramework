package com.rest.test;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.rest.payloads.RequestPayload;
import com.rest.utils.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class UpdateBooking extends BaseClass {
	
	
	@Test
	public void updateBooking() throws FileNotFoundException, IOException, ParseException
	{
		
		requestSpecification= RestAssured.given();
		response= requestSpecification.header("Content-Type", "application/json")
				.contentType("application/json")
				.header("Cookie","token="+tokenID)
				.log().all()
				.body(RequestPayload.getUpdateBookingPayload())
				.pathParam("booking", "booking")
				.pathParam("bookingID", bookingID)
				.put("/{booking}/{bookingID}");
		
		System.out.println("Put response is : " + response.body().asString());
		jsonPath= new JsonPath(response.body().asString());
		
		//verify the status code
		assertEquals(response.getStatusCode(), 200);
		
		//Verify the first name
		assertEquals(jsonPath.get("firstname"), "James");
		
		
	}

}
