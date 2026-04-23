package com.kodnest.RestAssuredSoapTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetTesting {
	
	@Test
	public void getTest()
	{
		baseURI = "https://reqres.in";
		
		given().
		header("x-api-key", "reqres_7daaa076661944b790678f1f1c65234f").
		get("/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name", hasItems("George", "Rachel"));
	}
	
	@Test
	public void postTest()
	{
		Map<String , Object> map = new HashMap<>();
		
//		map.put("name", "Jimmy");
//		map.put("job", "Teacher");
//		
//		System.out.println(map);
		
		JSONObject json = new JSONObject();
		
		
		json.put("name", "Jimmy");
		json.put("job", "Teacher");
		
		System.out.println(json.toJSONString());
	}
}
