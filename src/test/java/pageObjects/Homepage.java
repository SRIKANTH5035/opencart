package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
WebDriver driver;

public Homepage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnk_myaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnk_register;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnk_login;
	
	public void clickMyaccount()
	{
		lnk_myaccount.click();
	}
	
	public void clickRegister()
	{
		lnk_register.click();
	}
	public void clickLogin()
	{
		lnk_login.click();
	}
}
