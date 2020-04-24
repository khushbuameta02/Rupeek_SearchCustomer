package com.rupeek.customaersearch.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;

public class AutheticationTest {
	
	@Test
	public void getTokenWithValid() //to get all post
	{
		given().contentType(ContentType.JSON).body("{ \"username\" : \"rupeek\", \"password\" : \"password\"}").post("http://13.126.80.194:8080/authenticate").then().assertThat().statusCode(200)
		.and().contentType(ContentType.JSON).and().time(lessThan(9000L));
		
		Response response = given().contentType(ContentType.JSON).body("{ \"username\" : \"rupeek\", \"password\" : \"password\"}").post("http://13.126.80.194:8080/authenticate");
		System.out.println(response.getBody().asString());
	}
	
	@Test
	public void gettokenWithInvalid() //to get all post
	{
		given().contentType(ContentType.JSON).body("{ \"username\" : \"rupeek\", \"password\" : \"random\"}").post("http://13.126.80.194:8080/authenticate").then().assertThat().statusCode(401)
		.and().contentType("").and().time(lessThan(9000L));
		
	
	}
}
