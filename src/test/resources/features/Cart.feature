Feature: Cart Page validation

  @Validate_CartPage_Scenario1
  Scenario: Choose Cart and validate product grid
    Given Navigate to homepage
    When  Homepage gets loaded click on cart menu in the header
    Then  Validate empty cart message
    And   Click on continue shopping and check homepage is navigated back


  @Validate_CartPage_Scenario2
  Scenario Outline: Choose Cart and unselect Cart
    Given Navigate to homepage
    When  Homepage gets loaded click on main Cart "<mainCart>"
    And   Choose any one product set "<product>"
    Then  Remove filtered Cart and validate checkbox is unchecked "<subCart>"
    Examples:
      |mainCart  |product|subCart|
      |Cookware|Frying pans|Frying pans|

  @Validate_CartPage_Scenario3
  Scenario Outline: Choose Cart and unselect Cart
    Given Navigate to homepage
    When  Homepage gets loaded click on main Cart "<mainCart>"
    And   Choose any one product set "<product>"
    Then  Click on Remove filter button and validate checkbox is unchecked "<subCart>"
    Examples:
      |mainCart  |product|subCart|
      |Cookware|Frying pans|Frying pans|

