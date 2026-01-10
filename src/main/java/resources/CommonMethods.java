package resources;

import org.testng.asserts.SoftAssert;

//realTime
public class CommonMethods {
	
	public static void handleAssertion(String expected , String actual, String message)
	{

		 
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual , expected , message);
		sa.assertAll();
	}
	

}
