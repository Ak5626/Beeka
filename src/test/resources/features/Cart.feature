Feature: Cart Page validation

  @Validate_CartPage_Scenario1
  Scenario: Validate cart page without adding product
    Given Navigate to homepage
    When  Homepage gets loaded click on cart menu in the header
    Then  Validate empty cart message
    And   Click on continue shopping and check homepage is navigated back


  @Validate_CartPage_Scenario2
  Scenario Outline: Validate adding product and cart option with different categories
    Given Navigate to homepage
    When  Homepage gets loaded click cart option on any product "<product>" "<indexforcartoption>"
    And   Validate option should be displayed for select diameters of products "<indexfordiameter>" and add to cart option should be shown
    Examples:
      |product|indexforcartoption|indexfordiameter|
      |Chef Frying pan|0|0                        |

  @Validate_CartPage_Scenario3
  Scenario Outline: Go to View cart page and validate product details
    Given Navigate to homepage
    When  Homepage gets loaded click cart option on any product "<product>" "<indexforcartoption>"
    And   Validate option should be displayed for select diameters of products "<indexfordiameter>" and add to cart option should be shown
    Then  Click on view cart option and validate product name "<productInCart>" quantity "<quantity>" variant "<variant>" and price "<price>"
    Examples:
      |product|indexforcartoption|indexfordiameter|quantity|variant|price|productInCart|
      |Chef Frying Pan|0|0|1                           |20 cm   | €65,00|Chef frying pan|

  @Validate_CartPage_Scenario4
  Scenario Outline: Validate product with multiple quantity
    Given Navigate to homepage
    When  Homepage gets loaded click cart option on any product "<product>" "<indexforcartoption>"
    And   Validate option should be displayed for select diameters of products "<indexfordiameter>" and add to cart option should be shown
    Then  Click on view cart option and validate product name "<productInCart>" quantity "<quantity>" variant "<variant>" and price "<price>"
    Then  Increase quantity in cart page and validate quantity value "<increaseQuantity>" and price "<increasePrice>"
    Examples:
      |product|indexforcartoption|indexfordiameter|quantity|variant|price|productInCart|increaseQuantity|increasePrice|
      |Chef Frying Pan|0|0|1                           |20 cm   | €65,00|Chef frying pan|  2         |€130,00      |

