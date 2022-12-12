package neostoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class Loginpage 
{
	@FindBy(xpath = "//input[@id='MainContent_signinsignup_txt_mobilenumber']")private WebElement mobilenumberField;
	
	@FindBy(xpath = "//a[@class='btn btn-signup']")private WebElement signINbutton;
	
	public Loginpage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	public void sendMoblileNumber(WebDriver driver,String MobileNumber) 
	{
		Utility.wait(driver, 1000);

		mobilenumberField.sendKeys(MobileNumber);
		
		Reporter.log("Sending mobileNum" ,true);
	}
	
	public void clicksignINbutton() 
	{
		signINbutton.click();
		Reporter.log("click signIN button" ,true);
	}
}
