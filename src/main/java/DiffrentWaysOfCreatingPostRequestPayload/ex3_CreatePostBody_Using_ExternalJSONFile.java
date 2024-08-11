package DiffrentWaysOfCreatingPostRequestPayload;

import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;

public class ex3_CreatePostBody_Using_ExternalJSONFile
{	
	@Test(priority = 1)
	public void TC1_postBodyUsingMap() 
	{
		//File f=new File("D:\\workspace\\3rdFebRestAssured\\SampleData.json");
		File f=new File("./SampleData.json");
		
		given()                              
			.contentType("application/json") 
			.body(f)            
		.when()                              
			.post("http://localhost:3000/students")
		.then()	
			.statusCode(201)
			.log().all();		
	}
}
