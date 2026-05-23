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

