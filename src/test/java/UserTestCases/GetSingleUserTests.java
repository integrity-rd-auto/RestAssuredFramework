package UserTestCases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseTest;
import apiConfig.APIPathConfig;
import apiConfig.HeaderConfig;
import apiVerifications.APIVerification;
import io.restassured.RestAssured;

public class GetSingleUserTests extends BaseTest {

	@BeforeClass

	public void responseSetUp() {

		response = RestAssured.given().headers(HeaderConfig.defaultHeaders()).when().get(APIPathConfig.GET_SINGLE_USER);
	}

	@Test
	public void validateResponseCode() {
		logger.info("###### GetSingleUserTests.validateResponseCode Starts ######");
		APIVerification.responseCodeValiddation(response, 200);
		logger.info("###### GetSingleUserTests.validateResponseCode Ends ######");
	}

}
