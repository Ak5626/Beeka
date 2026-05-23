Feature: Category Page validation

  @Validate_CategoryPage_Scenario1
  Scenario Outline: Choose category and validate product grid
    Given Navigate to homepage
    When  Homepage gets loaded click on main category "<maincategory>"
    And   Choose any one product set "<product>"
    Then  Choose one category "<subCategory>" and validate count between choosen one and product grid with index "<indexForChoosingCount>"
    Examples:
      |maincategory  |product|subCategory|indexForChoosingCount|
      |Cookware|Frying pans|Frying pans|0                      |

  @Validate_CategoryPage_Scenario2
  Scenario Outline: Choose category and unselect category
    Given Navigate to homepage
    When  Homepage gets loaded click on main category "<maincategory>"
    And   Choose any one product set "<product>"
    Then  Remove filtered category and validate checkbox is unchecked "<subCategory>"
    Examples:
      |maincategory  |product|subCategory|
      |Cookware|Frying pans|Frying pans|

  @Validate_CategoryPage_Scenario3
  Scenario Outline: Choose category and unselect category
    Given Navigate to homepage
    When  Homepage gets loaded click on main category "<maincategory>"
    And   Choose any one product set "<product>"
    Then  Click on Remove filter button and validate checkbox is unchecked "<subCategory>"
    Examples:
      |maincategory  |product|subCategory|
      |Cookware|Frying pans|Frying pans|

