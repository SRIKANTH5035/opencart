package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Login_Page;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class tc_003_loginDDT extends BaseClass
{
	
	@Test(dataProvider="LoginData")
	public void test_LoginDDT(String email, String pwd, String exp)
	{
		logger.info("Starting tc_003_loginDDT");
		
		try
		{
			
			driver.get(rb.getString("appURL"));
			driver.manage().window().maximize();
			
			Homepage hp= new Homepage(driver);
			hp.clickMyaccount();
			logger.info("Clicked on My Account ");
			hp.clickLogin();
			logger.info("Clicked on Login ");
			Login_Page lp= new Login_Page(driver);
			lp.setEmail(email);
			logger.info("Email entered ");
			lp.setPswd(pwd);
			logger.info("Password entered ");

			lp.ClickLogin();
			logger.info("Clicked on Login");
			

			boolean targetpage=lp.isMyAccountPageExist();
			
			if(exp.equals("Valid"))
			{
				if(targetpage==true)
				{
					logger.info("Login Success ");
					
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					logger.error("Login Failed ");
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{		
					logger.error("Login Failed ");
					Assert.assertTrue(true);
				}
			}
			
			
			
			
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		logger.info(" Finished TC_003_LoginDDT ");
	}
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;
				
	}
	

}
