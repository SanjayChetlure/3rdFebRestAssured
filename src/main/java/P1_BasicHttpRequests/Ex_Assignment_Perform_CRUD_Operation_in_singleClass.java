package P1_BasicHttpRequests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.LinkedHashMap;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
public class Ex_Assignment_Perform_CRUD_Operation_in_singleClass 
{
	String ID;
	
	@Test(priority = 1)
	public void TC1_postStudentDatails() 
	{
		LinkedHashMap map=new LinkedHashMap();
		map.put("id", "3");
		map.put("name", "aditya");
		map.put("location", "Pune");
		map.put("phone", 3333);
		
		String [] courcseNames= {"RPA","Power BI"};
		map.put("courses", courcseNames);
		
		ID=given()                              
			.contentType("application/json") 
			.body(map)
		.when()                              
			.post("http://localhost:3000/students")
		.then()	
			.statusCode(201)
			.log().all()
			.extract().jsonPath().getString("id");
		System.out.println(ID);		
		
		//get ID & store in global variable
	}
	
	@Test(priority = 2)
	public void TC2_getSpecificStudentDatails() 
	{
		
		given()                              
		.contentType("application/json") 
	.when()                              
		.get("http://localhost:3000/students/"+ID)
	.then()	
		.statusCode(200)
		.body("id", equalTo("3"))
		.body("name", equalTo("aditya"))
		.body("courses[0]", equalTo("RPA"))
		.contentType(ContentType.JSON)					//.contentType("application/json")	
		.log().all();
	}
	
	@Test(priority = 3)
	public void TC3_UpdateSpecificStudentDatails() 
	{
		LinkedHashMap map=new LinkedHashMap();
		map.put("id", ID);
		map.put("name", "ADITYA");
		map.put("location", "PUNE");
		map.put("phone", 3333);
		
		String [] courcseNames= {"RPA","Power BI"};
		map.put("courses", courcseNames);
		
		given()                              
			.contentType("application/json") 
			.body(map)
		.when()                              
			.put("http://localhost:3000/students/"+ID)
		.then()	
			.statusCode(200)
			.body("name", equalTo("ADITYA"))
			.log().all();
	}
	
	
	@Test(priority = 4)
	public void TC3_DeeleteSpecificStudentDatails() 
	{
		given()
			.contentType(ContentType.JSON)
		.when()
			.delete("http://localhost:3000/students/"+ID)
		.then()
			.statusCode(200);
	}
	
	

}
