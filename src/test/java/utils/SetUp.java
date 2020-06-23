package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SetUp {

	public static Map<String, String> map = new HashMap<String, String>();

	public static Properties prop = new Properties();

	public static FileInputStream fisDev;
	public static FileInputStream fisQa;
	public static FileInputStream fisStaging;

	public static Map<String, String> Initialization() {

		String environment = System.getProperty("env");

		try {

			if (environment.equalsIgnoreCase("dev")) {

				fisDev = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\java\\config\\dev.properties");

				prop.load(fisDev);
				map.put("baseUrl", prop.getProperty("baseUrl"));
				map.put("userName", prop.getProperty("userName"));
				map.put("passWord", prop.getProperty("passWord"));
				map.put("port", prop.getProperty("port"));
			}

			if (environment.equalsIgnoreCase("qa")) {

				fisQa = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\java\\config\\dev.properties");

				prop.load(fisQa);
				map.put("baseUrl", prop.getProperty("baseUrl"));
				map.put("userName", prop.getProperty("userName"));
				map.put("passWord", prop.getProperty("passWord"));
				map.put("port", prop.getProperty("port"));
			}

			else if (environment.equalsIgnoreCase("qa")) {

				fisStaging = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\java\\config\\qa.properties");

				prop.load(fisStaging);
				map.put("baseUrl", prop.getProperty("baseUrl"));
				map.put("userName", prop.getProperty("userName"));
				map.put("passWord", prop.getProperty("passWord"));
				map.put("port", prop.getProperty("port"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}
	
	public static Map<String,String> getConfigReader(){
		if(map==null) {
			map=Initialization();
		}	
		
		return map;
		
	}

}
