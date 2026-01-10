package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;
import pageObjectModel.HomePageObject;
import pageObjectModel.LoginPageObject;
import resources.CommonMethods;
import resources.Constant;

public class loginTestCases extends BaseClass{
	
	
	@Test
	public void verifyLoginWithValidDetails()
	{
	
	HomePageObject hpo = new HomePageObject(driver);
	hpo.clickOnAccount();
	hpo.clickOnLogin();
	
	
	
	LoginPageObject lpo = new LoginPageObject(driver);
	lpo.fillLoginDetails(emailId, Constant.pass);
	
	String expected ="My Account";
	String actual = lpo.loginSucessful();
	CommonMethods.handleAssertion(expected, actual, "Login is not successfull");

	
	
	}
	
}
