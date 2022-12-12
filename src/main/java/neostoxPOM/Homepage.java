package neostoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class Homepage 
{
    @FindBy (id = "lbl_username")private WebElement username;
	
	@FindBy (id = "lbl_curbalancetop")private WebElement balence;
	
	@FindBy (xpath = "(//a[text()='Close'])[5]")private WebElement close;
	
	@FindBy (xpath = "(//a[text()='OK'])[2]")private WebElement ok;
	
	@FindBy (xpath = "//a[@id='lnk_logout']")private WebElement logoutbutton;
	
	@FindBy (xpath = "//div[@id='analyserDropDownmob']")private WebElement analyzerbutton;
	
	@FindBy (xpath = "//span[text()='Options Analyzer']")private WebElement optionanalyzeButton;

	
	public Homepage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	
	public String getUsername(WebDriver driver) 
	{
		Utility.wait(driver, 3000);
		
		String actualUsername = username.getText();
	
		return actualUsername;
	
	}
	public void PopUphandle(WebDriver driver) 
	{
		if(ok.isDisplayed())
		{
			ok.click();
			close.click();
		}
		else {
			Reporter.log("ji");
		}	
		
	}
	public void logOut(WebDriver driver)
	{
		Utility.wait(driver, 1000);
		
		username.click();
		
		Utility.wait(driver, 2000);
		logoutbutton.click();
	}	
	public String availableAcbalance(WebDriver driver) 
	{
		Utility.wait(driver, 1000);
		
		String actualbalance = balence.getText();
		Reporter.log("actualbalance balance is ", true);
		
		return actualbalance;
	}
	
	public String Analyzer(WebDriver driver) 
	{
		Utility.wait(driver, 1000);
		analyzerbutton.click();
		Reporter.log("click on Analyzer button ",true);
		Utility.wait(driver, 1000);
		
		optionanalyzeButton.click();
		Reporter.log("click on Analyzer Options button ",true);
		return null;
		
		
	}
	
	
}
