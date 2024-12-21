package com.api.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginAPITest2 {
	@Test(description="Verify if Login API is working")
	public void loginTest() {
        LoginRequest loginRequest=new LoginRequest("Gangesh Gunjan", "Jha@123gg");
		AuthService authService=new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		System.out.println(loginResponse.getType());
		System.out.println(loginResponse.getRoles());
		System.out.println(loginResponse.getUsername());

		
		Assert.assertTrue(loginResponse.getToken()!=null);
		Assert.assertTrue(loginResponse.getEmail()!=null);
		Assert.assertEquals(loginResponse.getType(), "Bearer");
		Assert.assertEquals(loginResponse.getId(), 248);
		Assert.assertEquals(loginResponse.getRoles(),Arrays.asList("ROLE_USER"));
		Assert.assertEquals(loginResponse.getUsername(), "Gangesh Gunjan");
		
		
	}
}
