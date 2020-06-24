package apiVerifications;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.restassured.response.Response;
import utils.Reporting;

public class APIVerification extends Reporting {

	public static void responseCodeValiddation(Response response, int statusCode) {

		try {
			Assert.assertEquals(response.getStatusCode(), statusCode);
		} catch (AssertionError e) {
			//e.printStackTrace();			
			logger.log(Status.FAIL, e.fillInStackTrace());
		}

	}
	
	public static void responseTimeValiddation(Response response) {

		try {
			//Assert.assertEquals(response.getTime(), time);
			
			Assert.assertTrue(response.getTime() <= 3000);
		} catch (AssertionError e) {
			//e.printStackTrace();			
			logger.log(Status.FAIL, e.fillInStackTrace());
		}

	}
	
	
}
