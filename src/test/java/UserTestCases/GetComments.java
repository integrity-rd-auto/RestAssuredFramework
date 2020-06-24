package UserTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import apiConfig.APIPathConfig;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetComments extends BaseTest {

	@Test

	public void getAPITest001() {

		logger.info("###### getAPITest001 Starts ######");

		Response response = RestAssured.given().when().get(APIPathConfig.GET_SINGLE_USER);
		String s = response.getBody().asString();

		logger.info("Response time : " + response.time());

		logger.info("Response code : " + response.statusCode());

		Assert.assertEquals(response.statusCode(), 201);

		logger.info("###### getAPITest001 Ends ######");

	}

}
