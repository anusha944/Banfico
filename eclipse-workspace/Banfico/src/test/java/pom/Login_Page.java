package pom;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Base_Page;
import junit.framework.Assert;
import scripts.Login_Test;

public class Login_Page extends Base_Page {
	
	Logger log = generic.LoggerHelper.getLogger(Login_Page.class);
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username_or_email_textbox;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password_textbox;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement login_button;
	
	@FindBy(xpath="//span[contains(text(),' Invalid username or password')]")
	private WebElement error_message;

	public Login_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyUsernameOrEmailIsPresent()
	{
		 verifyElementIsPresent(username_or_email_textbox);
		 log.info("UsernameOrEmail text box is present");
	}
	
	public void verifyPasswordIsPresent()
	{
		verifyElementIsPresent(password_textbox);
		log.info("password text box is present");
	}
	
	public void enterUsernameOrEmail(String usernameOrEmail)
	{
		username_or_email_textbox.sendKeys(usernameOrEmail);
	}
	
	public void enterPassword(String password)
	{
		password_textbox.sendKeys(password);
	}
	
	public void clickLogin()
	{
		login_button.click();
	}
	
	@SuppressWarnings("deprecation")
	public void verifyErrorMessage()
	{
		String actual=error_message.getText();
		Assert.assertEquals("Invalid username or password.", actual);
	}


}
