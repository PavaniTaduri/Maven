package Files;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.openChromeBrowser;

public class selectBoxTestCase {

	static WebDriver driver;
	boolean res;
	
	@BeforeClass
	
	public static void openTheBrowser() {
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
		
		Select monthselect = new Select(driver.findElement(By.id("month")));
		
		List<WebElement> listmonths = monthselect.getOptions();
		
		System.out.println(listmonths.size());
		
		String exptext = "May";
		boolean found = false;
		
		for(int i =0;i<listmonths.size();i++)
		{
			System.out.println(listmonths.get(i).getAttribute("value"));
			if (listmonths.get(i).getText().equals(exptext))
			{
				System.out.println("Yes list has the item "+ exptext);
				found = true;
				break;
			}
							
		}
		System.out.println(found);
		
	}
}
	


