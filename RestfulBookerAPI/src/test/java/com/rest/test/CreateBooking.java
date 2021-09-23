package com.rest.test;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;


import com.rest.payloads.RequestPayload;
import com.rest.pojo.Booking;
import com.rest.pojo.BookingDates;
import com.rest.pojo.CreateBookingRequest;
import com.rest.pojo.CreateBookingResponse;
import com.rest.utils.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CreateBooking extends BaseClass {
	
	
	@Test
	public void createBooking()
	{
		requestSpecification= RestAssured.given();
	
		response= requestSpecification.header("Content-Type", "application/json")
				.log().all()
				.body(RequestPayload.getCreateRequestPayload())
				.pathParam("booking", "booking")
				.post("/{booking}");
		
		
		System.out.println("Response is : " + response.body().asString());
		CreateBookingResponse createBooking=response.as(CreateBookingResponse.class);
		Booking booking= createBooking.getBooking();
		
		//=======Verifying all the codes through POJO classes=============
		
		//verifying the status code
		assertEquals(response.getStatusCode(), 200);
		
		//verifying first name of booking
		assertEquals(booking.getFirstname(), "Sally");
		
		//verifying last name of booking
		assertEquals(createBooking.getBooking().getLastname(), "Brown");
		
		//verifying check-in time of booking
		assertEquals(createBooking.getBooking().getBookingdates().getCheckin(), "2020-03-06");

		
		
		//=======Verifying all the codes through JSON Path=============
		/*
		
		jsonPath= new JsonPath(response.body().asString());
		System.out.println("Response is : " + response.body().asString());
		
		//store the booking id and will use in next API request
		bookingID= jsonPath.get("bookingid");
		//verifying the status code
		assertEquals(response.getStatusCode(), 200);
		
		//verifying first name of booking
		assertEquals(jsonPath.get("booking.firstname"), "Sally");
		
		//verifying last name of booking
		assertEquals(jsonPath.get("booking.lastname"), "Brown");
		
		//verifying check-in time of booking
		assertEquals(jsonPath.get("booking.bookingdates.checkin"), "2020-03-06");

		*/
		
		
	} 

}
