package com.rest.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import com.rest.utils.BaseClass;
import io.restassured.RestAssured;

public class DeleteBooking extends BaseClass {
	
	
	@Test
	public void deleteBooking()
	{
		requestSpecification= RestAssured.given();
		response= requestSpecification.header("Content-Type", "application/json")
				.header("Cookie","token="+tokenID)
				.log().all()
				.pathParam("booking", "booking")
				.pathParam("bookingID", bookingID)
				.delete("/{booking}/{bookingID}");
		
		
		assertEquals(response.getStatusCode(), 201);
	}

}
