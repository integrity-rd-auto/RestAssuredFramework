package utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtil {

	public static String randomNumber() {

		Random number = new Random();
		int intid = number.nextInt(1000);
		String id = Integer.toString(intid);

		return id;

	}
	public static String randomString() {

		String randomString = RandomStringUtils.randomAlphabetic(1);
		
		return randomString;

	}
	
	
	

}
