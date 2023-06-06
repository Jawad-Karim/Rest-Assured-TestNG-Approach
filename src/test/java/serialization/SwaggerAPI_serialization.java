package serialization;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class SwaggerAPI_serialization {

	//create a new record
	@Test(priority=1)
	public void post_testPetSerializationXML() {

		SwaggerAPI_pet pet1 = new SwaggerAPI_pet();

		pet1.setId(7);
		pet1.setPetId(1);
		pet1.setQuantity(2);
		pet1.setShipDate("01/02/2023");
		pet1.setStatus("placed");
		pet1.setComplete("completed");

		given()
		.contentType("application/xml")
		.body(pet1)
		.when()
		.post("https://petstore.swagger.io/v2/store/order")
		.then()
		.log().all();
		//.body(equalTo("{\"status\":\"placed\"}"));

	}

	//get pet info by id
	@Test(priority=2)
	public void get_pet_de_serializatonXML() {

		SwaggerAPI_pet pet2 = get("https://petstore.swagger.io/v2/store/order/7").as(SwaggerAPI_pet.class);
		System.out.println("respons : "+ pet2.toString());
	}
}
