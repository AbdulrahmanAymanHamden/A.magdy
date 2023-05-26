@smoke
Feature: F07_followUs | users could open followUs links
  Scenario: user opens facebook link
  When user opens facebook link
  And "https://www.facebook.com/nopCommerce" is opened in new tab correctly

  Scenario: user opens twitter link
  When user opens twitter link
  And "https://twitter.com/nopCommerce" is opened in new tab correctly


  Scenario: user opens youtube link
  When user opens youtube link
  And "https://www.youtube.com/user/nopCommerce" is opened in new tab correctly

  Scenario: user opens rss link
  When user opens rss link
  And "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab correctly