package UserTestCases;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import apiBuilder.PostApiBuilder;
import apiConfig.APIPathConfig;
import apiConfig.HeaderConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JavaUtil;

public class PostSingleUser extends BaseTest {

	@Test

	public void postAPITest003() {

		logger.info("###### postAPITest003 Starts ######");

		
		Response response = RestAssured.given().when().headers(HeaderConfig.defaultHeaders())
				.body(PostApiBuilder.payLoad(JavaUtil.randomNumber(), JavaUtil.randomString(), JavaUtil.randomString())).post(APIPathConfig.CREATE_POST);
		
		logger.info("###### Response Generated ######");
		
		logger.info("Response code : " + response.statusCode());
		
		logger.info("###### If Response Code is other than 201 , Tests fails ######");
		
		Assert.assertEquals(response.statusCode(), 200);

		logger.info("###### If Response Code is other than 201 , Tests fails ######");
		
		logger.info("###### getAPITest001 Ends ######");

	}

}
