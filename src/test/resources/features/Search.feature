Feature: Search tab validation

  @Validate_Searchfield_Scenario1
  Scenario Outline: Search product and validate results
    Given Navigate to homepage
    When  Homepage loaded click on search tab and search any valid product "<product>"
    Then  Validate product categories should be visible

   Examples:
      |product|
      |Chef Frying pan|