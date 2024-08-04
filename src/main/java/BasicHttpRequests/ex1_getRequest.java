package BasicHttpRequests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class ex1_getRequest
{	
	@Test(priority = 1)
	public void getRequest_ValidID() 
	{
		given()                               // Pre-req
			.contentType("application/json") 
		.when()                              //request type  get()/post()/put()/delete()
			.get("https://reqres.in/api/users/2")
		.then()								//validation	
			.statusCode(200)
			.body("data.first_name", equalTo("Janet"))
			.body("data.last_name", equalTo("Weaver"))
			.body("data.id", equalTo(2))
			.contentType("application/json")
			.log().all();		
	}
		
	
	@Test(priority = 2)
	public void getRequest_inValidID() 
	{
		given()                               
			.contentType("application/json") 
		.when()                             
			.get("https://reqres.in/api/users/23")
		.then()								
			.statusCode(404)
			.log().all();		
	}
	
}
