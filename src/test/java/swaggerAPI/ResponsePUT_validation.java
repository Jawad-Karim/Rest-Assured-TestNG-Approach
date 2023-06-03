package swaggerAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponsePUT_validation extends ExtentReportsBase{
	
	RequestSpecification request;
	Response response;
	
	@BeforeClass
	public void getResponse() {
		
		RestAssured.baseURI = "https://petstore.swagger.io";
		request = RestAssured.given();
		
		request.header("ContentType", "application/json");
		request.contentType(ContentType.JSON);
		
		// map for category................. start.......
		HashMap<Object, Object> categoryMap = new HashMap<Object, Object>();
		categoryMap.put("id", 01);
		categoryMap.put("name", "persian cat");
		// map for category.................. end........

		// List for urlList................ start........
		List <Object> urlList = new ArrayList<Object>();
		urlList.add("http://persiancat.com");
		urlList.add("http://persiancat.com");
		// List for urlList................ end.........
		
		// maps for tags................ start.........
		HashMap<Object, Object> tagMap1 = new HashMap<Object, Object>();
		tagMap1.put("id", "101");
		tagMap1.put("name", "toni");
		
		HashMap<Object, Object> tagMap2 = new HashMap<Object, Object>();
		tagMap2.put("id", "102");
		tagMap2.put("name", "pony");
		// maps for tags................ end........
		
		// List for tagList................ start........
		List <Object> tagList = new ArrayList<Object>();
		tagList.add(tagMap1);
		tagList.add(tagMap2);
		// List for tagList................ end........
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("id", "214");
	
		
		map.put("category", categoryMap);
		
		
		map.put("name", "catty");
		
		
		map.put("photoUrls", urlList);
		
		
		map.put("tags", tagList);
		
		
		map.put("status", "Avaiable");
		
		
		
		response = request.body(map).put("/v2/pet");
	
	}
	
	@Test(priority=1)
	public void getContentType18() {
		logger = reports.createTest("test method "+i);
		String headerContentType = response.header("Content-Type");
		System.out.println("headerContentType : "+ headerContentType);
		Assert.assertEquals(headerContentType, "application/json");
	}
	
	@Test(priority=2)
	public void getServerType19() {
		logger = reports.createTest("test method "+i);
		String serverType = response.header("server");
		System.out.println("serverType : " +serverType);
		Assert.assertEquals(serverType, "Jetty(9.2.9.v20150224)");
	}
	
	@Test(priority=3)
	public void getContentEncoding20() {
		logger = reports.createTest("test method "+i);
		String contentEncoding = response.header("Content-Encoding");
		System.out.println("contentEncoding : " +contentEncoding);
		Assert.assertEquals(contentEncoding, null);
		
	}
	
	@Test(priority=4)
	public void getAllHeaders21() {
		logger = reports.createTest("test method "+i);
		Headers allHeaders = response.headers();
		for(Header header : allHeaders) {
			
			System.out.println("header name : "+ header.getName() + ",   value : "+ header.getValue());
		}
	}
	
	@Test(priority=5)
	public void getResponseTime22() {
		logger = reports.createTest("test method "+i);
		long responseTime = response.getTime();
		System.out.println("response time : "+ responseTime);
	}
	
	@Test(priority=6)
	public void getStatusLine23() {
		logger = reports.createTest("test method "+i);
		String statusline = response.getStatusLine();
		System.out.println("status line : "+ statusline);
	}
	
	@Test(priority=7)
	public void getStatusCode24() {
		logger = reports.createTest("test method "+i);
		int statuscode = response.getStatusCode();
		System.out.println("status code : "+ statuscode);
		Assert.assertEquals(statuscode, 200, "Correct status code not returned");
	}
	
	@Test(priority=8)
	public void getResponseBody25() {
		logger = reports.createTest("test method "+i);
		String body = response.getBody().asPrettyString();
		System.out.println("body : "+ body);
		
		//Thread.sleep(2000);
	}
	
	@Test(priority=9)
	public void deleteMethod26() {
		logger = reports.createTest("test method "+i);
		response = request.delete("/v2/pet/101");
		System.out.println("delete statusline : "+ response.statusLine());
	}

}
