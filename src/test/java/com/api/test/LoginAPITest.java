package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class LoginAPITest {

	@Test(description="Verify if Login API is working")
	public void loginTest() {

		Response response =given().baseUri("http://64.227.160.186:8080").header("Content-Type","application/json").body("{\r\n"
				+ "  \"username\": \"Gangesh Gunjan\",\r\n"
				+ "  \"password\": \"Jha@123gg\"\r\n"
				+ "}").post("/api/auth/login");//end point
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
