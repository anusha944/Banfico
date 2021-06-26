package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class Base_Page {
	public WebDriver driver;
	
	public Base_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/*
	 * This method is used to perform title validation of each page in the AUT
	 */
	public void verifyTitle(String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.titleContains(title));
			Reporter.log("title contains",true);
		}
		catch(Exception e)
		{
			Reporter.log("element not present");
			Assert.fail();
		}
	}
	
	/*
	 * This method is used to validate if the element is present on the page before performing any action on it
	 */
	public void verifyElementIsPresent(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			Reporter.log("element not present");
			Assert.fail();
		}
	}
	

}