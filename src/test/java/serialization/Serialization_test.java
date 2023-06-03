package serialization;

import static io.restassured.RestAssured.*;
import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Serialization_test {

	// POST with serialization process
	@Test(priority=1)
	public void postPerson_serialization() {

		Student student = new Student();
		student.setId(7);
		student.setFirst_name("jawad");
		student.setLast_name("karim");
		student.setEmail("adf@gmail.com");

		ArrayList<String> courseList = new ArrayList<String>();
		courseList.add("java");
		courseList.add("selenium");
		courseList.add("API");
		student.setCourseList(courseList);

		given()
			.contentType(ContentType.JSON)
			.body(student)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.assertThat().statusCode(201);

	}

	// GET with de_serialization process
	@Test(priority=2)
	public void getPerson_deserialization() {

		Student student2 = get("https://reqres.in/api/users?page=2").as(Student.class);
		System.out.println(student2.getFirst_name());
	}

}
