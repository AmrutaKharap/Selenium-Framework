package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// POM--> Design Pattern

public class HomePageObject {
	public WebDriver driver;
	
	private By account= By.xpath("//a[@title='My Account']");
	
	private By register= By.xpath("(//a[text()='Register'])[1]");
	
	private By login = By.xpath("//a[text()='Login']");
	
	public HomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void clickOnAccount() 
	{
		driver.findElement(account).click();
	}
	
	public void clickOnRegister()
	{
		driver.findElement(register).click();
	}
	
	public void clickOnLogin()
	{
		driver.findElement(login).click();
	}

}
