Feature: Search tab validation

  @Validate_Searchfield_Scenario1
  Scenario Outline: Validate cart page without adding product
    Given Navigate to homepage
    When  Homepage loaded click on search tab and search any valid product "<product>"
    Then  Validate product categories should be visible

   Examples:
      |product|
      |Chef Frying pan|