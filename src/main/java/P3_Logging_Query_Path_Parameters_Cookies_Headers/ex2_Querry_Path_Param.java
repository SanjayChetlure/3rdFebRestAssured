package P3_Logging_Query_Path_Parameters_Cookies_Headers;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;
public class ex2_Querry_Path_Param
{	
	//https://reqres.in/api/users?page=2&id=5
	//path param:- 
	//Query param:-
	
	//@Test
	public void TC1_querry_pathParam() 
	{
		given()                              
			.contentType("application/json")		
		.when()                              
			.get("https://reqres.in/api/users?page=2&id=5")
		.then()								
			.log().all();		
	}
	
	//@Test
	public void TC2_querry_pathParam() 
	{
		given()                              
			.contentType("application/json")
			.pathParam("path1","api")
			.pathParam("path2","users")
			.queryParam("page", "2")
			.queryParam("id", "5")
		.when()                              
			.get("https://reqres.in/{path1}/{path2}")
		.then()								
			.log().all();		
	}
	
	
	//@Test
	public void TC3_querry_pathParam() 
	{
		given()                              
			.contentType("application/json")
			.pathParams("path1","api","path2","users")
			.queryParams("page", "2", "id", "5")
		.when()                              
			.get("https://reqres.in/{path1}/{path2}")
		.then()								
			.log().all();		
	}
	
	
	
}
