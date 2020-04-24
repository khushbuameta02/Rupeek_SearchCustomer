package com.rupeek.customaersearch.tests;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import customersearch_app.IAutho;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetSingleRecordByPhone implements IAutho {
	
	@Test
	public void getAutherizationWithValidphone()
	{
   given().header("Authorization",TOKEN).get("http://13.126.80.194:8080/api/v1/users/8037602400")
   .then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
   .body("first_name", Matchers.equalTo("Aliko")).and().body("last_name", Matchers.equalTo("Dangote"));
   
		
		
	}
	
	@Test
	public void getAutherizationWithInValidphone()
	{
   given().header("Authorization",TOKEN).get("http://13.126.80.194:8080/api/v1/users/8037602467")
   .then().assertThat().statusCode(200).and().contentType("");
   
		
		
	}
	

}
