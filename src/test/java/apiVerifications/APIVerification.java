package apiVerifications;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Reporting;

public class APIVerification extends Reporting {

	public static void responseCodeValiddation(Response response, int statusCode) {

		try {
			Assert.assertEquals(response.getStatusCode(), statusCode);
		} catch (AssertionError e) {
			// e.printStackTrace();
			logger.log(Status.FAIL, e.fillInStackTrace());
		}

	}

	public static void responseTimeValiddation(Response response) {

		try {
			Assert.assertTrue(response.getTime() <= 3000);
		} catch (AssertionError e) {
			e.printStackTrace();
			// logger.log(Status.FAIL, e.fillInStackTrace());
		}

	}

	public static void validateJsonArrayStringBody(Response response, int i, String key, String value) {

		try {
			JSONArray jsonResponseBody = new JSONArray(response.body().asString());
			Assert.assertEquals(jsonResponseBody.getJSONObject(i).getString(key), value);

		} catch (AssertionError e) {
			e.printStackTrace();
			// logger.log(Status.FAIL, e.fillInStackTrace());
		}

	}

	public static void validateJsonArrayIntBody(Response response, int i, String key, int value) {

		try {
			JSONArray jsonArrayResponseBody = new JSONArray(response.body().asString());
			Assert.assertEquals(jsonArrayResponseBody.getJSONObject(i).getInt(key), value);

		} catch (AssertionError e) {
			e.printStackTrace();
			// logger.log(Status.FAIL, e.fillInStackTrace());
		}

	}

	public static void validateJsonObjectStringBody(Response response, String key, String value) {

		try {
			JsonPath jsonObjectResponseBody = new JsonPath(response.getBody().asString());

			Assert.assertEquals(jsonObjectResponseBody.getString(key), value);
		} catch (AssertionError e) {
			e.printStackTrace();

		}

	}

	public static void validateHeadersBody(Response response, String key, String value) {
		try {

			Headers headers = response.getHeaders();
			Assert.assertEquals(headers.getValue(key), value);
		} catch (AssertionError e) {
			e.printStackTrace();
			// logger.log(Status.FAIL, e.fillInStackTrace());
		}

	}

}
