package UserTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseTest;
import apiBuilder.PostApiBuilderUsingHashMap;
import apiConfig.APIPathConfig;
import apiConfig.HeaderConfig;
import apiVerifications.APIVerification;
import io.restassured.RestAssured;
import utils.JavaUtil;

public class PostSingleUserUsingHashMap extends BaseTest {

	@BeforeClass

	public void postRequest() {

		response = RestAssured.given().when().headers(HeaderConfig.defaultHeaders())
				.body(PostApiBuilderUsingHashMap.payLoad(JavaUtil.randomNumber(), JavaUtil.randomString(), JavaUtil.randomString()))
				.post(APIPathConfig.CREATE_POST);

	}

	@Test

	public void validateStatusCode() {

		logger.info("###### postAPITest003 Starts ######");

		APIVerification.responseCodeValiddation(response, 201);

	}

}
