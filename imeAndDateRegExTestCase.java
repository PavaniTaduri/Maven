package Files;

import java.time.Duration;
import java.util.regex.Pattern;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.openChromeBrowser;

public class imeAndDateRegExTestCase 
{
	static WebDriver driver;
	boolean res;
	
	@BeforeClass
	public static void openTheBrowser() 
	{
		// To open browser
		openChromeBrowser ob = new openChromeBrowser();
		driver=ob.openChrome();
		driver.get("https://www.timeanddate.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// To maximize browser
		driver.manage().window().maximize();
	
		
		// To open website with multiple windows
		
	}
	
	@AfterClass
	
	public static void closeall()
	{
		//driver.close();
	}
	
		
		@Test
		public void checkDateFormatTC()
		{
			
			regExpMatcher reg= new regExpMatcher();
			
			String actual_dateDisplayed=driver.findElement(By.id("ij2")).getText();
			
			System.out.println(actual_dateDisplayed);
			
			Pattern p = Pattern.compile("[0-9]{2} [A-Z,a-z]{3} [0-9]{4}");
			
			res = reg.patternMatch(actual_dateDisplayed, p);
		
			Assert.assertEquals(res,true);
			
		}
	
}


	