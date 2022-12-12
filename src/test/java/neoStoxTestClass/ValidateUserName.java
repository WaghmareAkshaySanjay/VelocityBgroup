package neoStoxTestClass;

import org.testng.annotations.Test;

import base.Base;
import neostoxPOM.Homepage;
import neostoxPOM.Loginpage;
import neostoxPOM.PasswordPage;
import neostoxPOM.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class ValidateUserName extends Base
{
	Loginpage login;
	PasswordPage password;
	Homepage homepage;
	
	
	 @BeforeClass
	  public void launchNeoStox() throws IOException 
	 {
		 lunchChrome();
		 
		 login=new Loginpage(driver);
		 password=new PasswordPage(driver);
		 homepage=new Homepage(driver);
		 Reporter.log("browser is lunch",true);
	  }
	
	 @BeforeMethod
	  public void beforeMethod() throws EncryptedDocumentException, IOException, InterruptedException
	 {
		 login.sendMoblileNumber(driver,Utility.readDatafromPropertyFile("mobileNumber"));
		 login.clicksignINbutton();
		 Reporter.log("MobileNumber is accept ",true);
		 Utility.wait(driver, 1000);
		 
		 password.sendpassword(driver, Utility.readDatafromPropertyFile("password"));
		 Reporter.log("Password is Accept",true);
		 Thread.sleep(1000);
		 
		 password.clickOnsubmitButton(driver);
		 Reporter.log("click on submit button",true);
		 
		Thread.sleep(3000);
		 
		 homepage.PopUphandle(driver);
		 
	  }
	
	
	
  @Test
  public void ValaidateUserName() throws EncryptedDocumentException, IOException
  {
	  Assert.assertEquals(homepage.getUsername(driver), Utility.readDatafromPropertyFile("UserName"));
	  Utility.screenshot(driver,homepage.getUsername(driver));
	  Reporter.log("Validation  is passed",true);
	  
	  System.out.println("first TC is pass ");
  }
  

  
  @Test
  public void validateACbalance() throws IOException
  {
	  Assert.assertNotNull(homepage.availableAcbalance(driver));
	  Reporter.log("AC balance is "+homepage.availableAcbalance(driver), true);
	  
	  Utility.screenshot(driver, homepage.availableAcbalance(driver));
	  
  }

  @Test
  public void ckickOnAnalyzerButton() throws IOException 
  {
	  Utility.wait(driver, 1000);
	  
	 Assert.assertNotNull(homepage, "verify the elements are null TC is failed");
	
	 Utility.screenshot(driver, homepage.Analyzer(driver));
  }
  
  
  
  
  @AfterMethod
  public void LogOut() throws InterruptedException 
  {
	  Thread.sleep(3000);
	  
	  homepage.logOut(driver);
	  Reporter.log("LogOut is sucessful ",true);
  }

 

  @AfterClass
  public void CloseBrowser() 
  {
	
	  driver.close();
	  Reporter.log(" Browser Close succesfully",true);
  }

}
