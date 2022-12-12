package listener;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MyTesting1
{
  @Test
  public void A() 
  {
	  Reporter.log("TC A is runing ", true);;
  }
  
  
  @Test(dependsOnMethods = "C")
  public void B() 
  {
	  Reporter.log("TC B is runing ", true);
  }
  
  @Test
  public void C() 
  {
	  Assert.fail();
	  Reporter.log("TC B is runing ", true);
  }
}
