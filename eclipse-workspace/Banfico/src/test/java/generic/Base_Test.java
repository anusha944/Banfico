package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import generic.*;

public class Base_Test implements Automation_Constants {
	public WebDriver driver;
	/**
	 * this method instantiates a browser and navigates to the application URL 
	 */
	@BeforeMethod
	public void open_Application()
	{
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"); 
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions); 
		driver.get("https://developer.banka-cop.obly.io/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	/*
	 * This method is used to close all the browsers opened during the test
	 */
	@AfterMethod
	public void close_Application()
	{
		driver.quit();
	}
	

}
