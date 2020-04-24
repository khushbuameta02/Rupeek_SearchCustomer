package com.rupeek.customaersearch.tests;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetSingleRecordByPhone {
	
	@Test
	public void getAutherizationWithValidphone()
	{
   given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXBlZWsiLCJleHAiOjE1ODc3MzgxNDAsImlhdCI6MTU4NzcyMDE0MH0.KdCLd7wsDA8CxX3OROxRXsVVk9gnkzYREsk89VZl9l_OvhQKqDHFgcdajuLb2i9TBi_vI6A4TmvJhkOO87zfRg").get("http://13.126.80.194:8080/api/v1/users/8037602400")
   .then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
   .body("first_name", Matchers.equalTo("Aliko")).and().body("last_name", Matchers.equalTo("Dangote"));
   System.out.println("PASS");
		
		
	}
	
	@Test
	public void getAutherizationWithInValidphone()
	{
   given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXBlZWsiLCJleHAiOjE1ODc3MzgxNDAsImlhdCI6MTU4NzcyMDE0MH0.KdCLd7wsDA8CxX3OROxRXsVVk9gnkzYREsk89VZl9l_OvhQKqDHFgcdajuLb2i9TBi_vI6A4TmvJhkOO87zfRg").get("http://13.126.80.194:8080/api/v1/users/8037602467")
   .then().assertThat().statusCode(200).and().contentType("");
   System.out.println("PASS");
		
		
	}
	

}
