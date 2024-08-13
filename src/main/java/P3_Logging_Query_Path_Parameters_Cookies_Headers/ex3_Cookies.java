package P3_Logging_Query_Path_Parameters_Cookies_Headers;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;


public class ex3_Cookies
{
	//@Test(priority = 1)
	public void testCookie()
	{
		given()
		
		.when()
			.get("https://google.com/")		
		.then()
		.cookie("AEC","AVYB7cphHcINAFglElXOu5h_M1WgqvMh9tUXoo4hb4Tv0y1m3MDY_vkDBA")
		.log().cookies();
	}
	
	
	//@Test(priority = 2)
	public void getCookieInfo()
	{
		 Response resp = given()
		
		.when()
			.get("https://google.com/");
		
		String cookie = resp.getCookie("AEC");
		 System.out.println("----Cookie Info----"+cookie);
	}
	
	@Test(priority = 3)
	public void getAllCookies()
	{
		 Response resp = given()
		
		.when()
			.get("https://google.com/");
		
		Map<String, String> cookies = resp.cookies();
		Set<String> allCookieNames = cookies.keySet();
		
		for(String cookieName:allCookieNames)
		{
			System.out.println(cookieName+" = "+cookies.get(cookieName));
		}
	}
}
