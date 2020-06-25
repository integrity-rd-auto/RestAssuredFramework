package UserTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseTest;
import apiConfig.APIPathConfig;
import apiConfig.HeaderConfig;
import apiVerifications.APIVerification;
import io.restassured.RestAssured;

public class GetMultiUserTest extends BaseTest {

	@BeforeClass

	public void responseSetUp() {

		response = RestAssured.given().headers(HeaderConfig.defaultHeaders()).when().get(APIPathConfig.GET_LIST_USERS);
	}

	@Test

	public void validateResponseCode() {

		APIVerification.responseCodeValiddation(response, 200);
	}

	@Test

	public void validateResponseBody() {

		logger.info("###### getAPITest002 Starts ######");
		APIVerification.validateJsonObjectStringBody(response, "data.id[1]", "2");

	}

	@Test

	public void validateResponseHeader() {

		APIVerification.validateHeadersBody(response, "Server", "nginx/1.16.0");
	}

}
