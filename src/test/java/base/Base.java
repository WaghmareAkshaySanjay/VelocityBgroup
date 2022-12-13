package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import neostoxPOM.Utility;


public class Base
{
    protected static WebDriver driver;
	
	public void lunchChrome() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\java\\Chromedriver.exe");
		
	
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(Utility.readDatafromPropertyFile("url"));
		
		
		
		
		
		//chenges occure
		
		
	}
	public void Closebrowser(WebDriver driver) 
	{
		
		driver.close();
	}

}
