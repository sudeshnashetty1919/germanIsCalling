package stepDefinitions;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseSetUpGermanIsCalling;
import pages.LoginPageForGermanIsCalling;

public class LoginStepDefinitionsForGermanCalling {
	
	WebDriver driver;
	
	LoginPageForGermanIsCalling logIn;

	
	@Given("user goes to login page")
	public void user_is_on_login_page() throws IOException {
		
		// Initialize the WebDriver
		driver = BaseSetUpGermanIsCalling.initializeWebDriver();
		
		//Set the driver variable
		driver = BaseSetUpGermanIsCalling.driver;
		 
		// Initialize the LoginPageForGermanIsCalling page object
		logIn = new LoginPageForGermanIsCalling(driver);
			
	}
	
	@When("^user enters (.*) and (.*)$")
	public void user_enters_user_name_and_password(String username, String password) throws InterruptedException  {
		
		Thread.sleep(5000);
		//calling function to type user name which takes email id as input 
		logIn.enterUserName(username);
		
		//calling a function to enter the password
		logIn.enterPassword(password);
	}
	
	@And("user clicks on login")
	public void user_clicks_on_login() {
		
		//calling function to click on login button
		logIn.clickOnLogin();
		
	}
	@Then("user is navigated to the home page")
	public void userIsNavigatedToHomePage() throws InterruptedException {
		
		//Message which is displayed on home page once user is logged in
		String expected ="Upload your CV, and we'll analyze it to provide a report on your profile's strength and insights into the German job market. Get started now";
		
		//getting the actual message after the user is logged in
		String actual = logIn.validateHomePage();
		
		//comparing the both expected message on the home page with actual message on the home page using assertEquals function
		Assert.assertEquals(actual, expected);
		
		//closing the driver
		BaseSetUpGermanIsCalling.quitDriver();
	}
	
	@Then("^an (.*) should be displayed$")
	public void validateErrorMessage(String message) throws InterruptedException {
		
		//expected error message that should be displayed for invalid credentials 
		String expected = message;
		
		//actual error message that is displayed for invalid credentials
		String actual = logIn.validateErrorMessage();
		
		//comparing the both expected error  message on the home page with actual error message using assertEquals function
		Assert.assertEquals(actual, expected);
		
		//closing the driver
		BaseSetUpGermanIsCalling.quitDriver();
		
	}
	
	@Then("^an (.*) and (.*) are displayed$")
    public void errorMessagesShouldBeDisplayed(String errorMessage1, String errorMessage2) throws InterruptedException {

        //since for the empty fields user get two error messages so we are storing the error message in array
		String[] expectedMessages = {errorMessage1, errorMessage2};
        
        //we are storing the actual error messages in an array
		String[] actualMessages = logIn.getErrorMessages();

		//comparing the error messages one against the another using assert equal fucntion
        for (int i = 0; i < expectedMessages.length; i++) {
            
        	Assert.assertEquals(expectedMessages[i], actualMessages[i]);
        }
        
        //closing the browser
        BaseSetUpGermanIsCalling.quitDriver();
    }
	

}
