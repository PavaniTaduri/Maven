package Files;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class openBrowser {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		 
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\eclipse-workspace\\ustlearningmaven\\chromedriver-win64\\chromedriver.exe");
	
		ChromeOptions options = new ChromeOptions();
	    options.setBrowserVersion("124");
	    driver = new ChromeDriver(options);
	    
	  //global wait- implicit wait 
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.get("https://the-internet.herokuapp.com/login");
	    driver.get("file:///C:/Users/Administrator/Downloads/HTMLpage.html");
	    
	    String actual_title = driver.getTitle();
		String expected_title = "The Internet";
		
		if (actual_title.equals(expected_title))
		{
			System.out.println("Title test case Passed");
		}
		else
		{
			System.out.println("Failed");
		}	
	}

}
