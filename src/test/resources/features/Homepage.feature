Feature: HomePage validation

  @Validate_Homepage
  Scenario: Validate Homepage,logo and titles
  Given Navigate to homepage
  Then  Validate HomePage logo in header
  Then  Validate switching language
  And   Validate Homepage logo in footer