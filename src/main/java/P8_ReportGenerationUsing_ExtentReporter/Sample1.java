package P8_ReportGenerationUsing_ExtentReporter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample1 
{
	
  @Test
  public void TC1() 
  {
	  Assert.assertEquals("HI", "HI", "Failed1: both resuts are diff");
  }
  
  @Test
  public void TC2() 
  {
	  Assert.assertEquals("Hello", "hi", "Failed2: both resuts are diff");
  }
  
  @Test
  public void TC3() 
  {
	  Assert.assertEquals("Hello", "Hello", "Failed3: both resuts are diff");
  }
  
  
}
