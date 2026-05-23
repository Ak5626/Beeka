@All
Feature: Product Page validation

  @Validate_ProductPage_Scenario1
  Scenario Outline: Validate Product name, price & description
    Given Navigate to homepage
    When  Homepage loaded choose a product
    Then  Validate Product Image
    And   Validate Product name "<prdName>" price "<prdPrice>" and description "<prdDescp>"
    Examples:
      |prdName  |prdPrice|prdDescp|
      |CHEF FRYING PAN|€65,00|Sleek lines, ergonomic handles and high quality materials|


  @Validate_ProductPage_Scenario2
  Scenario: Validate lang switch and product price
    Given Navigate to homepage
    When  switch language and choose product
    Then  Go to product page and validate price


