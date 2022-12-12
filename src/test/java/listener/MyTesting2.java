package listener;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MyTesting2 {
  @Test
  public void F()
  {
	  Reporter.log("TC F is Runing", true);
  }
  
  @Test(dependsOnMethods = "J")
  public void I() 
  {
	  Reporter.log("TC I is Running", true);
  }
  
  @Test
  public void J() 
  {
	  Assert.fail();
	  Reporter.log("TC J is failed", true);
  } 
}
