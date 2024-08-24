package pages;

import java.time.Duration;
import java.util.List;


import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class LoginPageForGermanIsCalling {
	
	WebDriver driver;
	
	//webElemens and the xpath
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement logIn;
	
	@FindBy(xpath="//p[@id='card_text']")
	WebElement homePage;
	
	
	
	//initializing the WebDriver instance
	//PageFactory.initElements automatically initialize web elements
	public LoginPageForGermanIsCalling(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }
	
	
	//method to enter the user name using sendkeys
	public void enterUserName(String name) {
		
		userName.sendKeys(name);
		
	}
	
	//method to enter the password using sendkeys
	public void enterPassword(String Password) {
	
		
		password.sendKeys(Password);
	}
	
	//method to click on login button using sendkeys
	public void clickOnLogin() {
		
		logIn.click();
	}
	
	
	//getting the home page text message
	public String validateHomePage() {
		
		String text = homePage.getText();
		
		return text;
	}
	
	
	//getting the error messages
	public String validateErrorMessage() {
		
		String message = driver.findElement(By.xpath("//div[@class='alert alert-danger']//li")).getText();
		
		System.out.println(message);
		
		return message;
	}
	
	
	//getting the error message for empty fields and storing them in an array
	public String[] getErrorMessages() {
		
		List<WebElement> errorMessage = driver.findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		
		
		String[] message = new String[errorMessage.size()];
		
		for(int i=0; i<message.length;i++) {
			
			message[i]=errorMessage.get(i).getText();
			
		}
	
		
		return message;
		
	}
	
	

}

	


