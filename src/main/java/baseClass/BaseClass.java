package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import resources.ExtentReportManager;



public class BaseClass {
	//Scope in whole class 
	public Properties prop;
	public static WebDriver driver;
	public static String emailId = randomEmailAddress();

	
	public void initializeDriver() throws IOException
	{
		//Read the file
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		
		//Access the content inside the Properties File
		
		// Properties is a Class
		prop = new Properties();
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
			
		}else{
			System.out.println("Please choose valid Browser");
		}
		
	}
	
	
	// To take the screenshot and store in one folder-
	
		public static String screenShot(WebDriver driver, String filename) {
			String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			// 20241107080800
	 
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + date + ".png";
			try { // VerifyRresgiertaionWithValiData_20241107080800.png
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;
		}
	 
		@BeforeSuite
		public void startReport() {
			ExtentReportManager.setup();
		}
	 
		@AfterSuite
		public void endReport() {
			ExtentReportManager.endReport();
		}
	 
	
	
		
		
	@BeforeMethod
	public void browserLaunch() throws IOException
	{
		initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	// Random Email Address
	 public static String randomEmailAddress()
	{
		return System.currentTimeMillis()+"@gmail.com";
		
	}

}
