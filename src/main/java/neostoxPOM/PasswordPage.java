package neostoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PasswordPage 
{
	@FindBy(xpath = "//input[@id='txt_accesspin']")private WebElement passwordFeild;
	
	@FindBy(xpath = "//a[@id='lnk_submitaccesspin']")private WebElement subMitButton;
	
	public PasswordPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	public void sendpassword(WebDriver driver,String password) 
	{
		Utility.wait(driver, 2000);
		
		passwordFeild.sendKeys(password);	
		
	}

	public void clickOnsubmitButton(WebDriver driver) 
	{
		Utility.wait(driver, 2000);
		
		subMitButton.click();
		
	}
}
