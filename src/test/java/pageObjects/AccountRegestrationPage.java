

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegestrationPage 
{
WebDriver driver;

public AccountRegestrationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@id='input-firstname']")
WebElement txt_firstName;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement txt_lasttName;
@FindBy(xpath="//input[@id='input-email']")
WebElement txt_Email;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement txt_Telephone;
@FindBy(xpath="//input[@id='input-password']")
WebElement txt_Password;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement txt_Password_Conformation;
@FindBy(xpath="//label[normalize-space()='Yes']//input[@name='newsletter']")
WebElement rd_Subscribe_yes;
@FindBy(xpath="//input[@value='0']")
WebElement rd_Subscribe_No;
@FindBy(xpath="//input[@name='agree']")
WebElement ch_Privacypolociy;
@FindBy(xpath="//input[@value='Continue']")
WebElement btn_Continue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConformation;

public void setFirstname(String fname)
{
	txt_firstName.sendKeys(fname);
}

public void setLastName(String lname)
{
	txt_lasttName.sendKeys(lname);
}
public void setEmail(String email)
{
	txt_Email.sendKeys(email);
}
public void setTelephone(String tno)
{
	txt_Telephone.sendKeys(tno);
}
public void setPassword(String pwd)
{
	txt_Password.sendKeys(pwd);
}
public void setPassword_correction(String pwdconf)
{
	txt_Password_Conformation.sendKeys(pwdconf);
}
public void selectSubcription()
{
	rd_Subscribe_yes.click();
}
public void avoidSubscription()
{
	rd_Subscribe_No.click();
}

public void tickPrivacyPolicy()
{
	ch_Privacypolociy.click();
}
public void clickContinue()
{
	btn_Continue.click();
}
 public String getConformationmsg()
 {
	 try
	 {
		 return(msgConformation.getText());
	 }
	 catch(Exception e)
	 {
		 return(e.getMessage());
	 }
 }
}
