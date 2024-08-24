package pages;

import java.io.IOException;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseSetUpGermanIsCalling {
	
	public static WebDriver driver;

    //method to  initialize the chrome browser
	public static WebDriver initializeWebDriver() throws IOException {  
		
    	driver = new ChromeDriver();
	
        // To maximize browser  
       driver.manage().window().maximize();  
      
        // Implicit wait  
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   
        driver.get("https://app.germanyiscalling.com/common/login/"); 
		 
        return driver;
    	
	}
	
	//method to close the browser
	 public static void quitDriver() throws InterruptedException {  
		
		Thread.sleep(5000);
		
		if (driver != null) {
            
			driver.quit();
            
			driver = null;
        } 
    }
	


}

