package Files;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import utils.CaptureScreenShot;
import utils.openChromeBrowser;

public class Login {
	
static WebDriver driver;
	
	
	public static void main(String[] args) throws Exception {
		
			  
			openChromeBrowser ob = new openChromeBrowser();
			
			driver = ob.openChrome();
			
			driver.get("https://the-internet.herokuapp.com/login");
			
			driver.findElement(By.id("username")).sendKeys("tomsmith");
			driver.findElement(By.id("password")).sendKeys("SuperSecord!");
		
			driver.findElement(By.cssSelector("#login > button")).click();
			
			/*
			// Check1 -one way to check if login was successful. flash message
			String loginStatus = driver.findElement(By.id("flash")).getAttribute("class");
			
			/*
			
			if (loginStatus.equals("flash success"))
			{
				System.out.println("Login Passed");
				
			}
			else
			{
				System.out.println("Login failed");
				
			}
			*/	
		
			//Second way to check login status
			
			//check if logout link is present
			
			try {
				driver.findElement(By.partialLinkText("Logout"));
			}
			catch(NoSuchElementException e)
			{
				System.out.println("Login Failed.");
				CaptureScreenShot cs = new CaptureScreenShot();
				cs.takeSnapShot(driver, "C:\\Users\\Administrator\\Desktop\\scrrenshot.jpg");
			}
			
		
	}

}


