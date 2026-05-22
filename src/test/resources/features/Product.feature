Feature: Product Page validation

  @Validate_ProductPage_Secnario1
  Scenario: Validate Product name, price & description

    Given Navigate to homepage
    When  Homepage loaded choose a product
    Then  Validate Product Image
    And   Validate Product name price and description

  @Validate_ProductPage_Secnario2
  Scenario: Validate lang switch and product price

    Given Navigate to homepage
    When  switch language and choose product
    Then  Go to product page and validate price


