package P1_BasicHttpRequests;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
public class ex1_getRequest
{	
	@Test
	public void getRequest_ValidID() 
	{
		given()                              
			.contentType("application/json") 
		.when()                              
			.get("https://reqres.in/api/users/2")
		.then()								
			.log().all();		
	}
	
}
