package rest_Methods;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest {

	@Test(dataProvider = "testData1")
	public void dataDriventest_addNewEmployee(String a, String b, String c, String d, String e) {

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();

		request.header("Content-type", "application/json");

		JSONObject json_object = new JSONObject();
		json_object.put("id", a);
		json_object.put("email", b);
		json_object.put("first_name", c);
		json_object.put("last_name", d);
		json_object.put("avatar", e);

		request.body(json_object.toJSONString());
		Response response = request.post("api/users");

		//Response response = request.get("api/users");

		String prettyBody = response.asPrettyString();
		System.out.println("prettyBody : "+prettyBody);
		Assert.assertTrue(prettyBody.contains(a));
		Assert.assertTrue(prettyBody.contains(b));
		Assert.assertTrue(prettyBody.contains(c));
	}

	//@DataProvider(name = "testData1")
	public String[][] dataProvider1() {

		String data[][] = {{"55", "fname1", "lname1", "email1","avatar1"},{"56","fname2","lname2","email2","avatar2"},{"57","fname3","lname3","email3","avatar3",}};
		return 	(data);
	}

	@DataProvider(name = "testData1") //apache poi: 4.1.0
	public String[][] xldataProvider() throws Exception {

		String filePath = "./XLfolder/API_test_data.xlsx";
		int row = XLutils.getrowCount(filePath, 0);
		int cel = XLutils.getCellCount(filePath, 0, 1);

		String data[][] = new String[row][cel];
		for(int i=1; i<=row; i++) {
			for(int j=0; j<cel; j++) {
				data[i-1][j] = XLutils.getcellData(filePath, 0, i, j);
			}
		}
		return data;

	}

}
