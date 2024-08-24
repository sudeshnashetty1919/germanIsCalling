Feature: Test login functionality

  Scenario Outline: Check login with valid credentials
    Given user goes to login page
    When user enters <user name> and <password>
    And user clicks on login
    Then user is navigated to the home page

    Examples: 
      | user name                    | password         |
      | sudeshnashetty2211@gmail.com | 9133690791Suddu@ |

  Scenario Outline: Check login with invalid credentials
    Given user goes to login page
    When user enters <user name> and <password>
    And user clicks on login
    Then an <errorMessage> should be displayed

    Examples: 
      | user name                    | password         | errorMessage                                                                               |
      | sudeshnashetty2211@gmail.com |       9133690791 | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | sudeshnashetty2211@gmail.com |                  | Password: This field is required.                                                          |
      | sudeshnashetty2211           | 9133690791Suddu@ | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | sudeshnashetty2211           |       9133960791 | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | sudeshnashetty2211           |                  | Password: This field is required.                                                          |
      |                              | 9133690791Suddu@ | Email: This field is required.                                                             |

  Scenario Outline: Check login with  empty emailId
    Given user goes to login page
    And user clicks on login
    Then an <errorMessage> and <errorMessage2> are displayed

    Examples: 
      | errorMessage                   | errorMessage2                     |
      | Email: This field is required. | Password: This field is required. |
