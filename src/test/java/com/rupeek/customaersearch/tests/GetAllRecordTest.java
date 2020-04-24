package com.rupeek.customaersearch.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import customersearch_app.IAutho;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllRecordTest implements IAutho {
	
	
	@Test
	public void getAutherizationWithValid()
	{
   given().header("Authorization",TOKEN).get("http://13.126.80.194:8080/api/v1/users")
   .then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
   .body("first_name", Matchers.hasItem("Aliko")).and().body("last_name", Matchers.hasItem("Dangote")).and()
   .body("first_name", Matchers.hasItem("Bill")).and().body("last_name", Matchers.hasItem("Gates")).and()
   .body("first_name", Matchers.hasItem("Folrunsho")).and().body("last_name", Matchers.hasItem("Alakija"));
   
	
		
	}
	@Test
	public void getAutherizationWithInValid()
	{
   given().header("Authorization","WRONG_TOKEN").get("http://13.126.80.194:8080/api/v1/users")
   .then().assertThat().statusCode(401).and().contentType("");
  
		
		
	}

}
