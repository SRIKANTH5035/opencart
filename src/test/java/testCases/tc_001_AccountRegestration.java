package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegestrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class tc_001_AccountRegestration  extends BaseClass
{
	
	
   @Test(groups= {"regression","master"})
   public void test_account_registration()
   {
	   try
	   {
	   logger.info("Starting tc_001_AccountRegestration");
	  driver.get(rb.getString("appURL")); 
	  logger.info("Home page displayed");
	  driver.manage().window().maximize();
	  
		Homepage hp= new Homepage(driver);
		hp.clickMyaccount();
		logger.info("clicked on my account");
		hp.clickRegister();
		logger.info("clicked on Register");
		AccountRegestrationPage rp= new AccountRegestrationPage(driver);
		rp.setFirstname("Sairam");
		logger.info("First name entered");
		rp.setLastName("Shrirdi");
		logger.info("Last name entered");
		rp.setEmail(randomestring()+"@gmail.com");
		logger.info("Email entered");
		rp.setTelephone("0424723568");
		logger.info("Telphone number enteered");
		rp.setPassword("Sairam123");
		logger.info("Entered pswd");
		rp.setPassword_correction("Sairam123");
		logger.info("conform paswd");
		rp.selectSubcription();
		logger.info("clicked yes on subcription");
		rp.avoidSubscription();
		logger.info("clicked no on subcription");
		rp.tickPrivacyPolicy();
		logger.info("clicked on privacy policy");
		rp.clickContinue();
		logger.info("clicked on continue");
		
		String confmsg= rp.getConformationmsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account registartion  is success");
			Assert.assertTrue(true);
			
		}
		else
					{
			
			logger.info("Account registartion  failed");
			captureScreen(driver,"test_account_registration" );
			Assert.assertTrue(false);	
		}
   }
	   catch (Exception e)
	   {
		   logger.info("Account registartion  failed");
			Assert.assertTrue(false);   
	   }
   
   
   logger.info("ended tc_001_AccountRegestration");
}
}
