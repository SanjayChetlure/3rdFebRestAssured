package P3_Logging_Query_Path_Parameters_Cookies_Headers;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ex1_getLogs
{	
	@Test
	public void getRequest_ValidID() 
	{	
		given()                              
			.contentType("application/json") 
		.when()                              
			.get("https://reqres.in/api/users/2")
		.then()								
			//.log().body();
			//.log().status();
			//.log().headers();
			//.log().cookies();
			.log().all();
	}
}
