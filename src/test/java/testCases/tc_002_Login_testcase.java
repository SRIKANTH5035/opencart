package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Login_Page;
import testBase.BaseClass;

public class tc_002_Login_testcase extends BaseClass
{


@Test(groups= {"sanity", "master"})
public void Loign_test() 
{
	logger.info("Starting tc_002_Login_testcase ");
	
	try
	{
		driver.get(rb.getString("appURL"));
		logger.info("HOme PAgeDisplayed");
		driver.manage().window().maximize();
		Homepage hp= new Homepage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		Login_Page lp= new Login_Page(driver);
		lp.setEmail("email");
		logger.info("email provided");
		lp.setPswd("password");
		logger.info("Password provided");
		lp.ClickLogin();
		logger.info("Login Button clicked");
		
		boolean targetpage= lp.isMyAccountPageExist();
		
		if (targetpage)
		{
			logger.info("Login success");
			Assert.assertTrue(targetpage);
		}
		else
		{
			logger.info("Login Failed");
			captureScreen(driver,"Loign_test");
			Assert.assertTrue(false);
		}
		
	}
	
	catch (Exception e)
	{
		logger.fatal("Login Failed");
		Assert.fail();
	}
	logger.info("Finished tc_002_login_testcase");
}

}
