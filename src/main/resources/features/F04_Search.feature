@smoke
Feature: User checks search functionality
  Scenario Outline: User search by product name
  When user could search using product name "<productName>"
  Then Check the URL contains search?q=
  Then search shows relevant results "<productName>"

  Examples:
    |productName|
    |book|
    |laptop|
    |nike|

  Scenario Outline: User search by product SKU
  When user could search for product using sku "<productSku>"
  And click on this product
  Then verify this sku "<productSku>" is the retrieved sku

  Examples:
    |productSku|
    |SCI_FAITH|
    |APPLE_CAM|
    |SF_PRO_11|