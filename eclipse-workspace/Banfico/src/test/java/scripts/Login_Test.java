package scripts;

import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.Excel;
import generic.RandomDataGenerator;
import pom.Dashboard_Page;
import pom.Home_Page;
import pom.Login_Page;

public class Login_Test extends Base_Test {
	Logger log = generic.LoggerHelper.getLogger(Login_Test.class);
	
	/*
	 * This test is used to verify the presence of Log in link on home page and successfully land on Login Page
	 */
	
	@Test
	public void clicklogin_Test()
	{
		log.info("*********started test clicklogin_Test*********");
		Home_Page hp=new Home_Page(driver);
		hp.verifyLoginIsPresent();
		hp.clickLogin();	
		Login_Page lp=new Login_Page(driver);
		lp.verifyUsernameOrEmailIsPresent();
		lp.verifyPasswordIsPresent();
		log.info("*********Successfully landed on login page***************");
	}
	
	/*
	 * This test is used to validate successful login by providing valid login credentials
	 */
	
	@Test
	public void successfullLogin_Test()
	{
		log.info("*********started test SuccessfullLogin_Test*********");
		Home_Page hp=new Home_Page(driver);
		hp.verifyLoginIsPresent();
		hp.clickLogin();	
		Login_Page lp=new Login_Page(driver);
		lp.verifyUsernameOrEmailIsPresent();
		lp.verifyPasswordIsPresent();
		String usernameOrEmail=Excel.getCellValue(PATH,"TestData",1,0);
		String password=Excel.getCellValue(PATH,"TestData",1,1);
		lp.enterUsernameOrEmail(usernameOrEmail);
		lp.enterPassword(password);
		lp.clickLogin();
		log.info("**********Successfully logged in***************");
	}
	
	/*
	 * This method tests unsuccessful scenario by providing valid username and invalid password
	 */
	
	@Test
	public void loginWithValidUserNameInvalidPassword_Test()
	{
		log.info("*********started test loginWithValidUserNameInvalidPassword_Test*********");
		Home_Page hp=new Home_Page(driver);
		hp.verifyLoginIsPresent();
		hp.clickLogin();	
		Login_Page lp=new Login_Page(driver);
		lp.verifyUsernameOrEmailIsPresent();
		lp.verifyPasswordIsPresent();
		String usernameOrEmail=Excel.getCellValue(PATH,"TestData",2,0);
		String password=Excel.getCellValue(PATH,"TestData",2,1);
		lp.enterUsernameOrEmail(usernameOrEmail);
		lp.enterPassword(password);
		lp.clickLogin();
		lp.verifyErrorMessage();
		log.info("**********Successfully validated the invalid login scenario with valid username and invalid password*******");
	}
	
	/*
	 * This method tests unsuccessful scenario by providing invalid username and valid password
	 */
	
	@Test
	public void loginWithInvalidUserNameValidPassword_Test()
	{
		log.info("*********started test loginWithInvalidUserNameValidPassword_Test*********");
		Home_Page hp=new Home_Page(driver);
		hp.verifyLoginIsPresent();
		hp.clickLogin();	
		Login_Page lp=new Login_Page(driver);
		lp.verifyUsernameOrEmailIsPresent();
		lp.verifyPasswordIsPresent();
		String usernameOrEmail=Excel.getCellValue(PATH,"TestData",3,0);
		String password=Excel.getCellValue(PATH,"TestData",3,1);
		lp.enterUsernameOrEmail(usernameOrEmail);
		lp.enterPassword(password);
		lp.clickLogin();
		lp.verifyErrorMessage();
		log.info("********Successfully validated the invalid login scenario with invalid username and valid password********");
	}
	
	/*
	 * This method tests unsuccessful scenario by providing invalid username and invalid password
	 */
	
	@Test
	public void loginWithInvalidUserNameInvalidPassword_Test()
	{
		log.info("*********started test loginWithInvalidUserNameInvalidPassword_Test*********");
		Home_Page hp=new Home_Page(driver);
		hp.verifyLoginIsPresent();
		hp.clickLogin();	
		Login_Page lp=new Login_Page(driver);
		lp.verifyUsernameOrEmailIsPresent();
		lp.verifyPasswordIsPresent();
		String usernameOrEmail=Excel.getCellValue(PATH,"TestData",4,0);
		String password=Excel.getCellValue(PATH,"TestData",4,1);
		lp.enterUsernameOrEmail(usernameOrEmail);
		lp.enterPassword(password);
		lp.clickLogin();
		lp.verifyErrorMessage();
		log.info("*********Successfully validated the invalid login scenario with invalid username and invalid password*****");
	}
	
	/*
	 * This method tests successful application creation
	 */
	
	@Test
	public void successfulApplicationCreation_Test() throws InterruptedException
	{
		log.info("*********started test successfulApplicationCreation_Test*********");
		Home_Page hp=new Home_Page(driver);
		hp.verifyLoginIsPresent();
		hp.clickLogin();	
		Login_Page lp=new Login_Page(driver);
		lp.verifyUsernameOrEmailIsPresent();
		lp.verifyPasswordIsPresent();
		String usernameOrEmail=Excel.getCellValue(PATH,"TestData",5,0);
		String password=Excel.getCellValue(PATH,"TestData",5,1);
		lp.enterUsernameOrEmail(usernameOrEmail);
		lp.enterPassword(password);
		lp.clickLogin();
		Dashboard_Page dp=new Dashboard_Page(driver);
		dp.clickCreate();
		String name="iv_app"+RandomDataGenerator.randomdigit(3);
		String clientId="iv_app"+RandomDataGenerator.randomdigit(3);
		String clientSecret=Excel.getCellValue(PATH,"TestData",5,2);
		dp.enterName(name);
		dp.enterclientId(clientId);
		dp.enterclientSecret(clientSecret);
		dp.clickProductDropdown();
		dp.verifyDropdownOptionIsPresent();
		dp.selectOptionFromDropdown();
		dp.clickCreateApplicationButton();
		log.info("*******Successfully created application***********");
	}
	
	/*
	 * This method tests error message for unsuccessful operation creation, non unique name or clientId
	 */
	
	@Test
	public void unsuccessfulApplicationCreation_Test() throws InterruptedException
	{
		log.info("*********started test unsuccessfulApplicationCreation_Test*********");
		Home_Page hp=new Home_Page(driver);
		hp.verifyLoginIsPresent();
		hp.clickLogin();	
		Login_Page lp=new Login_Page(driver);
		lp.verifyUsernameOrEmailIsPresent();
		lp.verifyPasswordIsPresent();
		String usernameOrEmail=Excel.getCellValue(PATH,"TestData",5,0);
		String password=Excel.getCellValue(PATH,"TestData",5,1);
		lp.enterUsernameOrEmail(usernameOrEmail);
		lp.enterPassword(password);
		lp.clickLogin();
		Dashboard_Page dp=new Dashboard_Page(driver);
		dp.clickCreate();
		String name="app_v12"; //pass existing name 
		String clientId="app_v23"; //pass existing clienId
		String clientSecret=Excel.getCellValue(PATH,"TestData",5,2);
		dp.enterName(name);
		dp.enterclientId(clientId);
		dp.enterclientSecret(clientSecret);
		dp.clickProductDropdown();
		dp.verifyDropdownOptionIsPresent();
		dp.selectOptionFromDropdown();
		dp.clickCreateApplicationButton();
		dp.verifyApplicationCreationErrorMessage();
		log.info("**********error message validated for unsuccessful application creation***********");
	}


}
