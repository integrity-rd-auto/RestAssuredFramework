package Base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.SetUp;

public class BaseTest {
	
	public static Logger logger;
	
	public static Response response;

	@BeforeClass

	public void baseTest() {

		RestAssured.baseURI = utils.SetUp.Initialization().get("baseUrl");
		
		logger = Logger.getLogger("RestAssuredFramework");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\test-output\\log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	}
