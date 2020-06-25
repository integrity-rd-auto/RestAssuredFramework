package UserTestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseTest;
import apiConfig.APIPathConfig;
import apiConfig.HeaderConfig;
import apiVerifications.APIVerification;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleUserTest2  {
	Response response;

	@BeforeClass

	public void responseSetUp() {

		response = RestAssured.given().headers(HeaderConfig.defaultHeaders()).when().get();
	}

	@Test

	public void validateResponseCode() {

		//APIVerification.responseCodeValiddation(response, 200);
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}

	
}
