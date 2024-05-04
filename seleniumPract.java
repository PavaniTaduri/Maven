package Files;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumPract {
	static WebDriver driver;

	public static void main(String[] args) {
		
		// To open web page
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		
		// To find title of page
		
		String Actual_Title = driver.getTitle();
		System.out.println("title of page is : "+Actual_Title);
		String Expected_Title = "The Internet";
		
		//to check whether actual is equal to expected
		
		if (Actual_Title.equals(Expected_Title))
				{
			System.out.println("Title test case is passed");
				}
		else
		{
			System.out.println("Title test case is failed");
		}

		//check if Login button is present
		
		WebElement submitbtn = driver.findElement(By.cssSelector("#login > button"));
         String typeOfBtn = submitbtn.getAttribute("type");
		System.out.println("The type of button is " + typeOfBtn);
		
		//Check if password input is not exposing the typed passwords
		
		WebElement passwordtext = driver.findElement(By.id("password"));
	
		String typeOfText = passwordtext.getAttribute("type");
				
		System.out.println("Password field is of type " + typeOfText);
		
		//Check if footer has a link "Elemental Selenium"
				String expectedFooter = "Elemental Selenium";
				try {
				
					driver.findElement(By.partialLinkText("Elemental"));
					System.out.println("Link " + expectedFooter+ " present in page. Page fully loaded.");
					
				}
				catch (NoSuchElementException e)
				{
					System.out.println("Link " + expectedFooter+ " not present in page");
				}
				
			    driver.close();
			    

}
}
