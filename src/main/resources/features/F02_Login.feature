@smoke
Feature: F02_Login | users could use login functionality to use their accounts

  Scenario: user could login with valid email and password
  Given user go to login page
  When user login with valid email"testerAana@example.com"
  And user login with valid password"P@ssw0rd"
  And user press on login button
  Then user login to the system successfully

  Scenario: user could login with invalid email and password
  Given user go to login page
  When user login with invalid email"wrong@example.com"
  And user login with invalid password"P@ssw0rd"
  And user press on login button
  Then user could not login to the system




