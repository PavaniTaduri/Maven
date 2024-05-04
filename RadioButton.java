package Files;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton 
{
static WebDriver driver;
public static void main(String[] args) 
{
	driver = new ChromeDriver();
	
	// Put an Implicit wait, 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	// Launch the URL
	driver.get("file:///C:/Users/Administrator/Downloads/HTMLpage.html");
	
	List<WebElement> rdBtn_ans= driver.findElements(By.name("ans"));
	
	
	
	// Create a boolean variable which will hold the value (True/False)
	boolean bValue = false;
	
	// This statement will return True, in case of first Radio button is selected
	bValue = rdBtn_ans.get(0).isSelected();
	System.out.println(bValue);
	
	// This will check that if the bValue is True means if the first radio button is selected
	if(bValue == true){
		// This will select Second radio button, if the first radio button is selected by default
		rdBtn_ans.get(1).click();
	}else{
		// If the first radio button is not selected by default, the first will be selected
		rdBtn_ans.get(0).click();
	}
	
	

	}

}



