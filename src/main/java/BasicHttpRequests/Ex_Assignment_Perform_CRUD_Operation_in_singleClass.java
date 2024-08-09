package BasicHttpRequests;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

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
		
		
	}
	
	@Test(priority = 3)
	public void TC3_UpdateSpecificStudentDatails() 
	{
		
	}
	
	
	@Test(priority = 4)
	public void TC3_DeeleteSpecificStudentDatails() 
	{
		
	}
	
	

}
