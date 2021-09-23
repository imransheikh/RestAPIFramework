package com.rest.payloads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



import com.rest.pojo.BookingDates;
import com.rest.pojo.CreateBookingRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class RequestPayload {
	
	
	
	
	public static CreateBookingRequest getCreateRequestPayload()
	{
		CreateBookingRequest createBookings = new CreateBookingRequest();
		createBookings.setFirstname("Sally");
		createBookings.setLastname("Brown");
		createBookings.setTotalprice(111);
		createBookings.setDepositpaid(true);
		createBookings.setAdditionalneeds("Breakfast");
		
		BookingDates bookingDates= new BookingDates();
		bookingDates.setCheckin("2020-03-06");
		bookingDates.setCheckout("2020-03-09");
		createBookings.setBookingdates(bookingDates);
		
		//JSONObject jsonObj = new JSONObject(createBookings);
		//System.out.println("Json Request: " + jsonObj);
		return createBookings;
	}
	
	
	public static String getPayload()
	{
		String payload= "{\r\n" + 
				"  \"firstname\" : \"Sally\",\r\n" + 
				"  \"lastname\" : \"Brown\",\r\n" + 
				"  \"totalprice\" : 111,\r\n" + 
				"  \"depositpaid\" : true,\r\n" + 
				"  \"additionalneeds\" : \"Breakfast\",\r\n" + 
				"  \"bookingdates\" : {\r\n" + 
				"    \"checkin\" : \"2020-03-06\",\r\n" + 
				"    \"checkout\" : \"2020-03-09\"\r\n" + 
				"  }\r\n" + 
				"}";
		
		return payload;
	
	}
	
	
	
	public static String getAuthenticationPayload() {

		String payload = "{\"username\":\"admin\",\"password\":\"password123\"}";

		return payload;

	}
	
	

	
	public static String getUpdateBookingPayload() throws FileNotFoundException, IOException, ParseException {
		
		String jsonFilePath = System.getProperty("user.dir") + "/JSON_Files/UpdateBooking_Payload.json";
		File payload = new File(jsonFilePath);
			
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(payload));
		JSONObject jsonObject = (JSONObject)obj; 
		
		//System.out.println("Json Request: " + jsonObject.toJSONString());
		return jsonObject.toJSONString();

	}

}
