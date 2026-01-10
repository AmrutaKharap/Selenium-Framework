package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
	
	public WebDriver driver;
	
	private By emailAddress = By.xpath("//input[@id='input-email']");
	private By password = By.xpath("//input[@id='input-password']");
	private By loginBTN = By.xpath("//input[@value='Login']");
	
	private By myAccount = By.xpath("//h2[text()='My Account']");
	
	
	public LoginPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public void fillLoginDetails(String emailaddress, String pass)
	{
		driver.findElement(emailAddress).sendKeys(emailaddress);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBTN).click();
		
		
	}
	
	public String loginSucessful()
	{
		return driver.findElement(myAccount).getText(); 
	}
	
	
	

}
