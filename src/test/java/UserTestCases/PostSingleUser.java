package UserTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseTest;
import apiBuilder.PostApiBuilder;
import apiConfig.APIPathConfig;
import apiConfig.HeaderConfig;
import apiVerifications.APIVerification;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JavaUtil;

public class PostSingleUser extends BaseTest {

	//Response response;

	@BeforeClass

	public void postRequest() {

		response = RestAssured.given().when().headers(HeaderConfig.defaultHeaders())
				.body(PostApiBuilder.payLoad(JavaUtil.randomNumber(), JavaUtil.randomString(), JavaUtil.randomString()))
				.post(APIPathConfig.CREATE_POST);

	}

	@Test

	public void validateStatusCode() {

		logger.info("###### postAPITest003 Starts ######");

		/*
		 * response = RestAssured.given().when().headers(HeaderConfig.defaultHeaders())
		 * .body(PostApiBuilder.payLoad(JavaUtil.randomNumber(),
		 * JavaUtil.randomString(), JavaUtil.randomString()))
		 * .post(APIPathConfig.CREATE_POST);
		 */

		APIVerification.responseCodeValiddation(response, 201);

	}

}
