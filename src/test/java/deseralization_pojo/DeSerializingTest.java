package deseralization_pojo;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeSerializingTest {
	

	@Test
	public void TestDeserialPOJO() {
		
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		
		Get_list_users listUsers = RestAssured.given().when().get().as(Get_list_users.class);
		
		//System.out.println("list of Users : "+listUsers.toString());
		
		//System.out.println("list of data : "+ listUsers.getData());
		
		//System.out.println("support data :"+ listUsers.getSupport());
		
		List <DataPOJO> datas = listUsers.getData();
		for(int i=0; i<datas.size(); i++) {
			
			System.out.println(i+". data list : "+datas.get(i));
		}
	}
}
