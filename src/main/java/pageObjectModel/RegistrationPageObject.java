package pageObjectModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageObject {
	
	public WebDriver driver;
	//encapsulation concept
	private By firstName = By.xpath("//input[@id='input-firstname']");
	private By lastName = By.xpath("//input[@id='input-lastname']");
	private By email = By.xpath("//input[@id='input-email']");
	private By telePhone = By.xpath("//input[@id='input-telephone']");
	private By password = By.xpath("//input[@id='input-password']");
	private By confirmPass = By.xpath("//input[@id='input-confirm']");
	private By privacyPolicy = By.xpath("//input[@name='agree']");
	private By btnContinue = By.xpath("//input[@value='Continue']");
	private By actualRegistrationMessage= By.xpath("//h1[text()='Your Account Has Been Created!']");
	
	//Registration with Blank Data Locators-
	private By warning = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	private By warnRegFName = By.xpath("//div[text()='First Name must be between 1 and 32 characters!']");
	
	
	
	
	public RegistrationPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public void fillRegistrationDetails(String emailAddress, String fName , String lName , String tPhone, String passw, String conPass) 
	{
		
		driver.findElement(firstName).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(email).sendKeys(emailAddress);
		driver.findElement(telePhone).sendKeys(tPhone);
		driver.findElement(password).sendKeys(passw);
		driver.findElement(confirmPass).sendKeys(conPass);
		driver.findElement(privacyPolicy).click();
		
	}
	
	public String registrationSucessfull()
	{
		return driver.findElement(actualRegistrationMessage).getText();
	}
	
	 
//	public String warningRegistration()
//	{
//		return driver.findElement(warning).getText();
//		
//	}
//	
//	public String warningRegistrationFName()
//	{
//		return driver.findElement(warnRegFName).getText();		
//	}
	
	public List<String> getRegistrationWarnings() {

	    List<By> warningLocators = Arrays.asList(
	        warning,
	        warnRegFName
	    );

	    List<String> actualWarnings = new ArrayList<>();

	    for (By locator : warningLocators) {
	        actualWarnings.add(driver.findElement(locator).getText());
	    }

	    return actualWarnings;
	}

	
	
	public void clickOnContinueBtn()
	{
		driver.findElement(btnContinue).click();
		
	}
	
	
	
	
}
