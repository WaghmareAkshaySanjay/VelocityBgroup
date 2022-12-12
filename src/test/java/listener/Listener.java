package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.Base;
import neostoxPOM.Utility;



public class Listener extends Base  implements ITestListener
{
	public void onTestSuccess(ITestResult result)
	{
		String methodName = result.getName();
		Reporter.log("TC is"+methodName+" completed successfuly",true);
	
	}

	public void onTestSkipped(ITestResult result)
	{


		Reporter.log("TC is"+result.getName()+" Skipped please check agian",true);

	}

	public void onTestFailure(ITestResult result)
	{
		

		Reporter.log("TC is"+result.getName()+" failed",true);
		
		try 
		{
			Utility.screenshot(driver, result.getName());
		}
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
	}










}
