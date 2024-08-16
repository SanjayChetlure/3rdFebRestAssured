package P5_SchemaValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class ex1_SchemaValidation 
{
	@Test
	public void JSONSchemaValidation() 
	{	
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));
	}
	
	
	//@Test
	public void xmlSchemaValidation()
	{
		given()
		.when()
			.get("request url")
		.then()	
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("XMLSchema.xsd") );
	}
}

	

