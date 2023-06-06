package rest_Methods;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_and_Post_Request_Test {
	
	//String baseUrl = "https://reqres.in/api/users";
	
	@Test
	public void getMethod() {
		
		//specify baseURI
		RestAssured.baseURI = "https://reqres.in";
		
		//create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//create response object
		Response response = httpRequest.get("/api/users?page=2");
		
		//print response in console window
		String prettyStringBody = response.getBody().asPrettyString();
		System.out.println("response body : "+prettyStringBody);
		Boolean b = prettyStringBody.contains("Michael");
		System.out.println("boolean : "+b);
		
		//veify response statusline and print
		String statusline = response.getStatusLine();
		System.out.println("statusline : "+ statusline);
		Assert.assertEquals("HTTP/1.1 200 OK", statusline);
		
		//veify response status code and print
		int statuscode = response.getStatusCode();
		System.out.println("status code : "+ statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//veify header content type
		String headerContentType = response.header("Content-type");
		Assert.assertEquals(headerContentType, "application/json; charset=utf-8");
		
		//veify header server
		String headerServer = response.header("Server");
		Assert.assertEquals(headerServer, "cloudflare");
		
		//veify header content encoding
		String headerContentEncoding = response.header("Content-encoding");
		Assert.assertEquals(headerContentEncoding, "gzip");
		
		System.out.println("headerContentType : "+headerContentType);
		System.out.println("headerServer : "+headerServer);
		System.out.println("headerContentEncoding : "+headerContentEncoding);
		
		//print all headers
		Headers allHeaders = response.getHeaders();
		for(Header header : allHeaders) {
			
			System.out.println("header_name : "+header.getName()+"header_value : "+header.getValue());
		}
		
	}
	
	//POST method
	@Test
	public void post_method() {
		
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-type", "application/json");
		//httpRequest.header("titile", "analyst");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "jawad");
		jsonObject.put("job", "QA analyst");
		
		
		httpRequest.body(jsonObject.toJSONString());
		httpRequest.post("/api/users");
		System.out.println("new resorce is created");
		
		
		Response response = httpRequest.get("/api/users");
		System.out.println("body : "+ response.getBody().asPrettyString());
		
		
	}
	
	
	

}
