package serialization;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Student_API_without_Serialization {
	
	public HashMap map = new HashMap();
	
	@Test(priority=1)
	public void createNewStudent() {
		
		map.put("id", "9");
		map.put("first_name", "jawad");
		map.put("last_name", "karim");
		map.put("email", "adga@gmail.com");
		
		ArrayList <String> courseList = new ArrayList<String>();
		courseList.add("selenium");
		courseList.add("Java");
		
		map.put("courses", courseList);
		
		RequestSpecification httpRequest = RestAssured.given()
			.contentType(ContentType.JSON)
			.body(map);
			
		Response response = httpRequest.post("https://reqres.in/api/users");
			int status_code = response.getStatusCode();
			String stringBody = response.body().asString();
			
			Assert.assertEquals(stringBody.contains("createdAt"), true);
		
		
	}
	
	//get Request
	@Test
	public void getRquest() {
		
		RestAssured.given().
		when().
		get("https://reqres.in/api/users").
		then().
		statusCode(200)
		.log().all();
		
	}

}
