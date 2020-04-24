package com.rupeek.customaersearch.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllRecordTest {
	
	
	@Test
	public void getAutherizationWithValid()
	{
   given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJydXBlZWsiLCJleHAiOjE1ODc3MzgxNDAsImlhdCI6MTU4NzcyMDE0MH0.KdCLd7wsDA8CxX3OROxRXsVVk9gnkzYREsk89VZl9l_OvhQKqDHFgcdajuLb2i9TBi_vI6A4TmvJhkOO87zfRg").get("http://13.126.80.194:8080/api/v1/users")
   .then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
   .body("first_name", Matchers.hasItem("Aliko")).and().body("last_name", Matchers.hasItem("Dangote")).and()
   .body("first_name", Matchers.hasItem("Bill")).and().body("last_name", Matchers.hasItem("Gates")).and()
   .body("first_name", Matchers.hasItem("Folrunsho")).and().body("last_name", Matchers.hasItem("Alakija"));
   
		
		
	}
	@Test
	public void getAutherizationWithInValid()
	{
   given().header("Authorization","Bearer eyJhbGciOiJIUzUxMiertJ9.eyJzdWIiOiJydXBlZWsiLCJleHAiOjE1ODc3MzgxNDAsImlhdCI6MTU4NzcyMDE0MH0.KdCLd7wsDA8CxX3OROxRXsVVk9gnkzYREsk89VZl9l_OvhQKqDHFgcdajuLb2i9TBi_vI6A4TmvJhkOO87zfRg").get("http://13.126.80.194:8080/api/v1/users")
   .then().assertThat().statusCode(401).and().contentType("");
  
		
		
	}

}
