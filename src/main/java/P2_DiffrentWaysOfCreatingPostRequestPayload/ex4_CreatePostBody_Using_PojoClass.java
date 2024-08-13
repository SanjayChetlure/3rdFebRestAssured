package P2_DiffrentWaysOfCreatingPostRequestPayload;

import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ex4_CreatePostBody_Using_PojoClass
{	
	@Test(priority = 1)
	public void TC1_postBodyUsingPojo() 
	{
		StudentsPojo sp=new StudentsPojo();
		sp.setId("3");
		sp.setName("Aditya");
		sp.setLocation("Pune");
		sp.setPhone("3333");
		
		String [] courses= {"RPA", "Power BI"};
		sp.setCources(courses);
		
		
		given()                              
			.contentType("application/json") 
			.body(sp)             
		.when()                              
			.post("http://localhost:3000/students")
		.then()	
			.statusCode(201)
			.body("name", equalTo(sp.getName()))	            //.body("name", equalTo("Aditya"))	
			.body("cources[0]", equalTo(sp.getCources()[0]))	//	.body("cources[0]", equalTo("RPA"))
			.log().all();
	}
}
