package testCases;

import java.util.List;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModel.HomePageObject;
import pageObjectModel.RegistrationPageObject;
import resources.CommonMethods;
import resources.Constant;

public class registrationTestCases extends BaseClass{
	
	public RegistrationPageObject rpo;
	
	@Test
	public void verifyRegistrationWithValidData()
	{
		HomePageObject hpo = new HomePageObject(driver);
		hpo.clickOnAccount();
		hpo.clickOnRegister();
		rpo = new RegistrationPageObject(driver);
		
		
		rpo.fillRegistrationDetails(emailId, Constant.fName , Constant.lName, Constant.tPhone, Constant.passw, Constant.conPass);
		rpo.clickOnContinueBtn();
		
		String expected = "Your Account Has Been Created!";
		String actual= rpo.registrationSucessfull();
		
		CommonMethods.handleAssertion(expected, actual,"User not Registerd");
		
	}
	
	@Test
	public void verifyRegistrationWithBlankData() throws InterruptedException
	{
		HomePageObject hpo = new HomePageObject(driver);
		hpo.clickOnAccount();
		hpo.clickOnRegister();
		
		rpo = new RegistrationPageObject(driver);
		rpo.clickOnContinueBtn();
		Thread.sleep(1000);
		
		String expectedWarn = "Warning: You must agree to the Privacy Policy!";
		String expectedFName  = "First Name must be between 1 and 32 characters!";
		
		
		List<String> actualWarnings = rpo.getRegistrationWarnings();

	    CommonMethods.handleAssertion(expectedWarn,
	            actualWarnings.get(0),
	            "Privacy Policy warning missing");

	    CommonMethods.handleAssertion(expectedFName,
	            actualWarnings.get(1),
	            "First Name warning missing");

		
//		String actual = rpo.warningRegistration();
//		CommonMethods.handleAssertion(expectedWarn, actual, "Fill Registration Details  ");
//		CommonMethods.handleAssertion(expectedFName, actual, "Fill Registration Details  ");
//		
		System.out.println("Git demo");
		
		System.out.println("Shubham checges");
		
	}
	 
	 

}
