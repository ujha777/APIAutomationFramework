package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;


import io.restassured.response.Response;



public class AccountCreationTest {
	@Test(description="Verify if Login API is working")
	public void createAccountTest() {
		//Builder Pattern is used if we huge number of parameters
		//benefit is to use builder pattern is to no need to
		//remember order of the parameter 
		//But in constructor we need to remember the order
		
		//POJO Class of Response is not required bcoz in response we are getting
		//string only but not josn values
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
		.userName("ujha7777")
		.email("ujha7777@gmail.com")
		.firstName("Uttam")
		.password("ujha7777")
		.lastName("Jha")
		.mobileNumber("1234567890")
		.build();
		AuthService authService=new AuthService();
		Response response = authService.signUp(signUpRequest);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		
	}
}
