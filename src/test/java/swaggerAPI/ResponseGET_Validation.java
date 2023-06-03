package swaggerAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseGET_Validation extends ExtentReportsBase {
	
	//https://petstore.swagger.io/v2/pet/findByStatus?status=available
	Response response;
	
	@BeforeClass
	public void getResponse1() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		RequestSpecification request = RestAssured.given();
		
		response = request.param("status", "available").get("/findByStatus");
		//System.out.println("body : "+response.body().asPrettyString());
		//logger.info("this is before class");
	}
	
	@Test(priority=1)
	public void getContentType2() {
		
		logger = reports.createTest("test method "+i);
		logger.info("first test Method");
		String headerContentType = response.header("Content-Type");
		System.out.println("headerContentType : "+ headerContentType);
		logger.info("Content type2 : "+headerContentType);
	}
	
	@Test(priority=2)
	public void getServerType3() {
		
		logger = reports.createTest("test method "+i);
		String serverType = response.header("server");
		System.out.println("serverType : " +serverType);
		logger.info("serverType : "+ serverType);
		
	}
	
	@Test(priority=3)
	public void getContentEncoding4() {
		
		logger = reports.createTest("test method "+i);
		String contentEncoding = response.header("Content-Encoding");
		System.out.println("contentEncoding : " +contentEncoding);
		
	}
	
	@Test(priority=4)
	public void getAllHeaders5() {
		
		logger = reports.createTest("test method "+i);
		Headers allHeaders = response.headers();
		for(Header header : allHeaders) {
			
			System.out.println("header name : "+ header.getName() + ",   value : "+ header.getValue());
		}
	}
	
	@Test(priority=5)
	public void getResponseTime6() {
		
		logger = reports.createTest("test method "+i);
		long responseTime = response.getTime();
		System.out.println("response time : "+ responseTime);
		logger.info("response time : "+responseTime);
	}
	
	@Test(priority=6)
	public void getStatusLine7() {
		
		logger = reports.createTest("test method "+i);
		String statusline = response.getStatusLine();
		System.out.println("status line : "+ statusline);
	}
	
	@Test(priority=7)
	public void getStatusCode8() {
		
		logger = reports.createTest("test method "+i);
		int statuscode = response.getStatusCode();
		System.out.println("status code : "+ statuscode);
		Assert.assertEquals(statuscode, 200, "Correct status code not returned");
	}
	
	//@Test(priority=8)
	public void getResponseBody9() {
		
		logger = reports.createTest("test method "+i);
		String body = response.getBody().asPrettyString();
		System.out.println("body : "+ body);
		
	}

}
