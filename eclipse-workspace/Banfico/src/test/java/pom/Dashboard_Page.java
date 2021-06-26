package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;

import generic.Base_Page;
import junit.framework.Assert;

public class Dashboard_Page extends Base_Page {
	
	Logger log = generic.LoggerHelper.getLogger(Dashboard_Page.class);
	
	@FindBy(xpath="//span[contains(.,'Create')]")
	private WebElement create_button;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement name_textbox;
	
	@FindBy(xpath="//input[@name='clientId']")
	private WebElement clientId_textbox;
	
	@FindBy(xpath="//input[@name='secret']")
	private WebElement client_Secret_textbox;
	
	@FindBy(xpath="//div[@class=' css-ry5ku3-placeholder' and text()='product']")
	private WebElement product_dropdown;
	
	@FindBy(xpath="//button[@class='button special']")
	private WebElement createApplication_button;
	
	@FindBy(xpath="//div[@id='react-select-2-option-0']")
	private WebElement COP_OUTBOUND_API;
	
	@FindBy(xpath="//span[normalize-space()='{\"errorMessage\":\"Client app_v23 already exists\"}']")
	private WebElement errorMessageApplicationCreation;

	public Dashboard_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreate()
	{
		create_button.click();
	}
	
	public void enterName(String name)
	{
		name_textbox.sendKeys(name);
	}
	
	public void enterclientId(String clientId)
	{
		clientId_textbox.sendKeys(clientId);
	}
	
	public void enterclientSecret(String clientSecret)
	{
		client_Secret_textbox.sendKeys(clientSecret);
	}
	
	public void clickProductDropdown()
	{
		product_dropdown.click();
	}
	
	public void verifyDropdownOptionIsPresent()
	{
		 verifyElementIsPresent(COP_OUTBOUND_API);
		 log.info("dropdown option is present");
	}
	
	public void selectOptionFromDropdown()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(COP_OUTBOUND_API).click().build().perform();
	}
	
	public void clickCreateApplicationButton()
	{
		createApplication_button.click();
	}
	
	public void verifyApplicationCreationErrorMessage()
	{
		String actual=errorMessageApplicationCreation.getText();
		String expected="{\"errorMessage\":\"Client app_v23 already exists\"}";
		Assert.assertEquals(expected, actual);
	}

}
