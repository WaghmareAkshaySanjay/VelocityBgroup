package neostoxPOM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;



public class Utility 
{
	//Excel, wait, screenshot, listener
	
	
	public static String readDatafromExcelSheet(int row ,int cell) throws EncryptedDocumentException, IOException 
	{
		File myfile=new File("E:\\java\\ExcelWorksheet1.xlsx");
		
		Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet6");
	
		String values = mysheet.getRow(row).getCell(cell).getStringCellValue();
	
		return values;
	}

	
	public static void wait(WebDriver driver,int waitTime) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		
	}
	
	public static void screenshot(WebDriver driver,String fileName) throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		File dest= new File("E:\\1.automation\\Selenium\\ScreenShot\\"+fileName+".png")	;	
	
	    FileHandler.copy(scr, dest);
		
		Reporter.log("to take a screensot ", true);
		
	}
	
	public static String readDatafromPropertyFile(String key) throws IOException 
	{
		    //create object of Properties class
		
			Properties prop=new Properties();
			
			//create object of FileInputStream
			
			FileInputStream myFile=new FileInputStream("C:\\Users\\DELL\\.eclipse\\selenium\\myproperties.properties");
		
			prop.load(myFile);
			
			String value = prop.getProperty(key);
	
			Reporter.log("reading value "+key+"of from properties file", true);
	
			return value;
	}
}










