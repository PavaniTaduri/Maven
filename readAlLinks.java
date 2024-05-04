package Files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class readAlLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
         
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		java.util.List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		 
		System.out.println("No of links: " + allLinks.size() );
		for (WebElement l: allLinks) {
			 
			System.out.print(l.getText() + "***");
			
			System.out.println(l.getAttribute("href"));
			
			verifyLink(l.getAttribute("href"));
			
			//call a user defined function, pass the href value. Check for return code

	}

}
}
