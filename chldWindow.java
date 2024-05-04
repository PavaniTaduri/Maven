package Files;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chldWindow {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// To open browser
		driver = new ChromeDriver();
		// To maximize browser
		driver.manage().window().maximize();
		
		// To open Naukri website with multiple windows
		driver.get("https://demoqa.com/browser-windows");
		//Scroll down to make the button visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		driver.findElement(By.id("windowButton")).click();
		
		Thread.sleep(500);
		
		// It will return the parent window name as a String
		String mainWindow=driver.getWindowHandle();
		// It returns no. of windows opened by WebDriver and will return Set of Strings
		Set<String> set =driver.getWindowHandles();
		
		System.out.println(set.size());
		// Using Iterator to iterate with in windows
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();
			// Compare whether the main windows is not equal to child window. If not equal, we will close.
			if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				System.out.println("Child window content :" + driver.findElement(By.xpath("//h1")).getText());
				driver.close();
				//driver.quit() will close even the main window
			}
		}
		// This is to switch to the main window
		driver.switchTo().window(mainWindow);
	}
}


