package Stepdefs;

import Utils.Assertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomepageStepDef {

    HomePage hp = new HomePage();

    @Given("Navigate to homepage")
    public void navigate_to_homepage() {
      hp.validateHomepage();

    }

    @Then("Validate HomePage logo in header")
    public void validate_home_page_logo_in_header() {
       boolean logo = hp.validateLogoHeader();
       Assertions.booleanCheck(logo,"Header Logo is not visible");
    }

    @And("Validate Homepage logo in footer")
    public void validateHomepageLogoInFooter() {
        boolean footerLogo = hp.validateLogoFooter();
        Assertions.booleanCheck(footerLogo, "Footer Logo is not visible");
    }


    @Then("Validate switching language")
    public void validateSwitchingLanguage() {
       boolean switchVal = hp.validateSwitchLanguage();
       Assertions.booleanCheck(switchVal, "Error in Switching to different language");

    }
}
