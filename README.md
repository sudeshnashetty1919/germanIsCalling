Prerequisites:
  
  JDK (Java Development Kit) version 8 or later: Make sure you have Java installed.(I've utilized Java 21.)
  Make sure Apache Maven is installed in order to control the build lifecycle of the project.
  IDE (IntelliJ/Eclipse): For coding and testing, use an Integrated Development Environment (IDE) such as Eclipse or IntelliJ.(I've utilized Eclipse.)

 Technologies Used
   
    1. Java
    2. Selenium WebDriver
    3. Cucumber
    4. JUnit
    5. WebDriverManager
    6. Maven

Dependencies i used are 

These are defined in the pom.xml file:

 1. Selenium
 2. Cucumber-Java & Cucumber-Core
 3. JUnit
 4. Gherkin
 5. WebDriverManager

Import the project into your IDE:

If using Eclipse:
    
    Go to File -> Import -> select the gitHub respository and clone the repository

From the IDE
  
  Navigate to the TestRunnerForGermanIsCalling class and run it as a JUnit test.

Test Report
 
  After running the tests, a detailed HTML report is generated in the target/cucumber-reports directory. Open cucumber.html to view the test execution report.
