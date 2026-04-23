package com.kodnest.RestAssuredSoapTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1 {
	
	@Test
	public void test_1()
	{
		

		baseURI = "https://reqres.in";

	    RequestSpecification request = given(); // non-BDD usage

	    request.header("x-api-key", "reqres_7daaa076661944b790678f1f1c65234f");

	    Response response = request.get("/api/users?page=2");

	    int status = response.statusCode();
	    System.out.println(response.getTime());
	    System.out.println(response.getContentType());
	    System.out.println(response.getBody().asString());
	    
	    Assert.assertEquals(status, 200);
	}
	
	@Test
	public void test_2() {
		baseURI = "https://reqres.in";
		
		
		given()
			.header("x-api-key", "reqres_7daaa076661944b790678f1f1c65234f")
			.when()
			.get("api/users?page=2")
			.then()
			.statusCode(200)
			.body("data[1].id", equalTo(8))
			.log().all();
		
		
	}
}
