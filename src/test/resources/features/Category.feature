Feature: Category Page validation

  @Validate_CategoryPage_Scenario1
  Scenario Outline: Choose category and validate product grid

    Given Navigate to homepage
    When  Homepage gets loaded click on main category "<maincategory>"
    And   Choose any one product set "<product>"
    Then  Choose select one category "<category>" and validate count between choosen one and product grid
    Examples:
      |maincategory  |product|category|
      |Cookware|€65,00|Sleek lines, ergonomic handles and high quality materials|

