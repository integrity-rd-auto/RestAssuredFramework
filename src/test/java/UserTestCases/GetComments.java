package UserTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseTest;
import apiConfig.APIPathConfig;
import apiVerifications.APIVerification;
import io.restassured.RestAssured;

public class GetComments extends BaseTest {

	// Response response;

	@BeforeClass

	public void getRequest() {

		response = RestAssured.given().when().get(APIPathConfig.GET_SINGLE_USER);

	}

	@Test

	public void validateStatusCode() {

		APIVerification.responseCodeValiddation(response, 200);

		logger.info("###### getAPITest001 Ends ######");

	}

	@Test

	public void validateResponseTime() {

		APIVerification.responseTimeValiddation(response);

		logger.info("###### getAPITest001 Ends ######");

	}

	@Test

	public void validateResponseBody() {

		APIVerification.validateJsonArrayStringBody(response, 0, "body", "some comment");
		APIVerification.validateJsonArrayIntBody(response, 0, "id", 1);
		logger.info("###### getAPITest001 Ends ######");
	}
}
