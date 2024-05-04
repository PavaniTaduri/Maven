package Files;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.openChromeBrowser;

public class BrokenLinkChecker {
	
	static WebDriver driver;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
		openChromeBrowser ob = new openChromeBrowser();
		
		driver = ob.openChrome();
		
		driver.get("https://the-internet.herokuapp.com/broken_images");
		
		java.util.List <WebElement> allLinks = driver.findElements(By.tagName("img"));
		 
		System.out.println("No of links: " + allLinks.size() );
		 
		for (WebElement l: allLinks) {
			 
		//	System.out.print(l.getText() + "***");
			
		//	System.out.println(l.getAttribute("href"));
			
			verifyLink(l.getAttribute("src"));
			
			//call a user defined function, pass the href value. Check for return code
		}
		
	}
			

	//The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
		public static void verifyLink(String urlLink) {
	     //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
	     try {
				//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
				URL link = new URL(urlLink);
				// Create a connection using URL object (i.e., link)
				HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
				//Set the timeout for 2 seconds
				httpConn.setConnectTimeout(2000);
				//connect using connect method
				httpConn.connect();
				//use getResponseCode() to get the response code. 
					if(httpConn.getResponseCode()== 200) {	
						System.out.println(urlLink+" - "+httpConn.getResponseMessage());
					}
					else
					{
						System.out.println(urlLink+" - "+httpConn.getResponseMessage());
							
					}
					
				}
				//getResponseCode method returns = IOException - if an error occurred connecting to the server. 
			catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
	 } 

}


