package Files;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPracLogin {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		//global wait- implicit wait 
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("#login > button")).click();
		
		
		// Check1 -one way to check if login was successful. flash message
					String loginStatus = driver.findElement(By.id("flash")).getAttribute("class");
					
					if (loginStatus.equals("flash success"))
					{
						System.out.println("Login Passed");
						
					}
					else
					{
						System.out.println("Login failed");
						
					}
					
					//Second way to check login status
					
					//check if logout link is present
					try {
						driver.findElement(By.partialLinkText("Logout"));
					}
					catch(NoSuchElementException e)
					{
						System.out.println("Login Failed.");
					}
	}


}
