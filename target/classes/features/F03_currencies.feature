@smoke
Feature: F03_currencies | users could use currency functionality to view all product prices
  Scenario: user could change between products currencies
  When Select Euro currency from the dropdown list on the top left of home page
  Then verify Euro Symbol is shown on the products displayed in Home page