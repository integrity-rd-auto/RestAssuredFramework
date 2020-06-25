package UserTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseTest;
import apiBuilder.PostApiBuilderUsingHashMap;
import apiBuilder.PostApiBuilderUsingPOJO;
import apiConfig.APIPathConfig;
import apiConfig.HeaderConfig;
import apiVerifications.APIVerification;
import io.restassured.RestAssured;
import utils.JavaUtil;

public class PostSingleUserUsingPOJO extends BaseTest {

	@BeforeClass

	public void postRequest() {

		PostApiBuilderUsingPOJO payload = new PostApiBuilderUsingPOJO(JavaUtil.randomintNumber(), JavaUtil.randomString(),
				JavaUtil.randomString());

		response = RestAssured.given().when().headers(HeaderConfig.defaultHeaders()).body(payload)
				.post(APIPathConfig.CREATE_POST);

	}

	@Test

	public void validateStatusCode() {

		logger.info("###### postAPITest003 Starts ######");

		APIVerification.responseCodeValiddation(response, 201);

	}

}
