package UserTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import apiConfig.APIPathConfig;
import apiConfig.HeaderConfig;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMultiUserTest extends BaseTest {
	
	@Test

	public void getAPITest002() {

		Response response = RestAssured.given().headers(HeaderConfig.defaultHeaders()).when().get(APIPathConfig.GET_LIST_USERS);
		String s = response.getBody().asString();

		JsonPath json = new JsonPath(s);

		Assert.assertEquals("8",json.getString("data.id[1]"));
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		Assert.assertEquals(response.getHeader("Server"),"cloudflare");

	}

}
