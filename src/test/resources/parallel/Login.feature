Feature: GitHub login page feature

  Scenario:  Navigate to login page
    Given User is on home page
    And Home Page title should be "GitHub: Where the world builds software · GitHub"
    Then User clicks the Sign in Link
    And Sign in Page title should be "Sign in to GitHub · GitHub"
    Then Forgot password link should be displayed
    Then Create an account link should be displayed
    When User enters username "lucian0127"
    And User enters password "Warlockmaster1!"
    Then User clicks on Sign in button
    And Account Dashboard Page will be displayed
    Then User close the browser