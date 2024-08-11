package DiffrentWaysOfCreatingPostRequestPayload;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class ex2_CreatePostBody_Using_OrgJSONLibrary
{	
	@Test(priority = 1)
	public void TC1_postBodyUsingMap() 
	{
		//LinkedHashMap map=new LinkedHashMap();
		JSONObject jo=new JSONObject();
		jo.put("id", "3");
		jo.put("name", "aditya");
		jo.put("location", "Pune");
		jo.put("phone", 3333);
		
		String [] courcseNames= {"RPA","Power BI"};
		jo.put("courses", courcseNames);
		
		
		given()                              
			.contentType("application/json") 
			.body(jo.toString())             //convert JSON object data into java(String) format
		.when()                              
			.post("http://localhost:3000/students")
		.then()	
			.statusCode(201)
			.log().all();		
	}
}
