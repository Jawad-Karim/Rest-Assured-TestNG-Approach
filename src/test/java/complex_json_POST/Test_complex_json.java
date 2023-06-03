package complex_json_POST;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test_complex_json {
	
	@Test
	public void executeTest() {
		
		// assign data for 1st block for web automation
		WebAutomation webauto1 = new WebAutomation();
		webauto1.setCourseTitle("selenium");
		webauto1.setPrice(3000);
		
		// assign data for 2nd block for web automation
		WebAutomation webauto2 = new WebAutomation();
		webauto2.setCourseTitle("Java");
		webauto2.setPrice(4000);
		
		// Store data sets in ArrayList
		List <WebAutomation> webList = new ArrayList<WebAutomation>();
		webList.add(webauto1);
		webList.add(webauto2);
		
		// assign data for 1st block for API automation
		ApiAutomation api1 = new ApiAutomation();
		api1.setCourseTitle("API automation");
		api1.setPrice(2000);
		
		// assign data for 1st block for API automation
		ApiAutomation api2 = new ApiAutomation();
		api2.setCourseTitle("rest assured");
		api2.setPrice(2000);
		
		// Store data sets in ArrayList
		List <ApiAutomation> apiList = new ArrayList<ApiAutomation>();
		apiList.add(api1);
		apiList.add(api2);
		
		// assign data for 1st block for mobile automation
		MobileAutomation mobile1 = new MobileAutomation();
		mobile1.setCourseTitle("Mobile Automation");
		mobile1.setPrice(4000);
		
		// Store data sets in ArrayList
		List <MobileAutomation> mobileList = new ArrayList<MobileAutomation>();
		mobileList.add(mobile1);
		
		// assign data list to Course objects
		Courses courses = new Courses();
		courses.setWebAutomation(webList);
		courses.setApiAutomation(apiList);
		courses.setMobileAutomation(mobileList);
		
		// assign all data to Parent objects.
		ParentPOJO parent = new ParentPOJO();
		parent.setInstructor("jawad");
		parent.setUrl("softwaretestingandautomation.com");
		parent.setServices("softwaretesting");
		parent.setExpertize("automation");
		parent.setCourses(courses);
		parent.setLinkedin("linkedinid");
		
		
		Response response = given()
				.auth().none()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(parent)//.log().all()
				.post("https://reqres.in/api/users");
				
		System.out.println("post response is : "+ response.asPrettyString());
	}

}
