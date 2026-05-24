package Stepdefs;

import Utils.Assertions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Searchpage;

public class Searchstepdef {

    Searchpage sp = new Searchpage();

    @When("Homepage loaded click on search tab and search any valid product {string}")
    public void homepageLoadedClickOnSearchTabAndSearchAnyValidProduct(String product) {
        sp.searchProduct(product);
    }

    @Then("Validate product categories should be visible")
    public void validateProductCategoriesShouldBeVisible() {
        Assertions.booleanCheck(sp.searchResults(),"Product results are not displayed");
    }


    @Then("Validate product categories should not be visible {string}")
    public void validateProductCategoriesShouldNotBeVisible(String product) {
        Assertions.booleanCheck(sp.searchResultsNotFound(product),"Product results are displayed");

    }
}
