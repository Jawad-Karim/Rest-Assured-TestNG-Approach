package deserialization_POST;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Deserialization_POJO_POST_test {

	@Test
	public void pojo_post() {

		CategoryPOJO category = new CategoryPOJO();
		category.setId(101);
		category.setName("cat");

		PhotoUrlPOJO photos = new PhotoUrlPOJO();
		photos.setCatPhotoUrl("http://catphoto.com");
		photos.setDogPhotoUrl("http://dogphoto.com");

		List<PhotoUrlPOJO> photoList = new ArrayList<PhotoUrlPOJO>();
		photoList.add(photos);

		TagsPOJO tag1 = new TagsPOJO();
		tag1.setId(201);
		tag1.setName("tags for cat");

		TagsPOJO tag2 = new TagsPOJO();
		tag2.setId(201);
		tag2.setName("tags for cat");

		List <TagsPOJO> tags = new ArrayList<TagsPOJO>();
		tags.add(tag1);
		tags.add(tag2);

		Home_Pojo home = new Home_Pojo();
		home.setId(100);
		home.setCategory(category);
		home.setName("pet_store");
		home.setPhotoUrls(photoList);
		home.setTags(tags);
		home.setStatus("available");


		Response response = given()
				.header("Content-Type", "application/json")
				.contentType(ContentType.JSON)
				.body(home)
				.when()
				.post("https://reqres.in/api/users");

		System.out.println("status line : "+ response.statusLine());
		System.out.println("response body : "+ response.asPrettyString());			
	}
}
