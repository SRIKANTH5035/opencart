package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	WebDriver driver;
	
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email_address;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement  btn_login;
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	
	public void setEmail(String ename)
	{
		txt_email_address.sendKeys(ename);
	}
	
	public void setPswd(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	
	public void ClickLogin()
	{
		btn_login.click();
	}
	public boolean isMyAccountPageExist()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch (Exception e)
		{
			return(false);
		}
	}
}
