package pom;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Base_Page;
import scripts.Login_Test;

public class Home_Page extends Base_Page {
	Logger log = generic.LoggerHelper.getLogger(Home_Page.class);
	
	@FindBy(xpath="//span[.='log in']")
	private WebElement log_in;

	public Home_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLoginIsPresent()
	{
		verifyElementIsPresent(log_in);
		log.info("Login link is present");
	}
	
	public void clickLogin()
	{
		log_in.click();
	}

}
