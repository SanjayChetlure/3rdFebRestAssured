package P8_ReportGenerationUsing_ExtentReporter;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(P8_ReportGenerationUsing_ExtentReporter.ExtentReportgeneration.class)
public class Sample2
{
  @Test
  public void TC1() 
  {
	  Assert.assertEquals("HI", "Hello", "Failed1: both resuts are diff");
  }
  
  @Test
  public void TC2() 
  {
	  Assert.assertEquals("Hello", "hi", "Failed2: both resuts are diff");
  }
  
  @Test
  public void TC3() 
  {
	  Assert.assertEquals("Hello", "hi", "Failed3: both resuts are diff");
  } 
}
