package com.rest.api;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTest {
	
/*	 @Test
	 public void getUserDetailsTest() {
		 
		 given().
		 get("https://reqres.in/api/users/2").
		 then().
		 statusCode(200).
		 log().all();
		 
	    }
*/
	 

	 
	 @Test
	 public void getUserDetails() {
		 
	       RestAssured.baseURI = "https://reqres.in/api/users/";
	  	 RequestSpecification httpRequest = RestAssured.given();
	  	 Response response = httpRequest.request(Method.GET, "2");
	  	 int statusCode = response.getStatusCode();
	  	 Assert.assertEquals(statusCode, 200); 
	 }

	 @Test
	 public void updateUserDetailsTest() {
	        RestAssured.baseURI = "https://reqres.in/api/login/";

	        RequestSpecification httpRequest = RestAssured.given();

	        JSONObject request = new JSONObject();
	    	request.put("email", "eve.holt@reqres.in");
			request.put("password", "cityslicka");

	        httpRequest.header("Content-Type", "application/json");

	        httpRequest.body(request.toJSONString());
	        Response response = httpRequest.request(Method.POST, "4");
	        int statusCode = response.getStatusCode();
	        Assert.assertEquals(statusCode, 201);
	    }
	 
	 @Test
	 public void getUserDelay() {
		 
	     RestAssured.baseURI = "https://reqres.in/api/users/";
	     Response response = null;
	     
	        try {
	            response = RestAssured.given()
	                .when().queryParam("delay", "3")
	                .get("/users");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	 
	     
	 }

}
