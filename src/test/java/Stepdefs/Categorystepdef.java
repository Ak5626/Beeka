package Stepdefs;

import Utils.Assertions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Categorypage;

public class Categorystepdef {

    Categorypage cp = new Categorypage();

    @When("Homepage gets loaded click on main category {string}")
    public void Homepagegetsloadedclickonmaincategory(String mainCat) {
        cp.chooseMainCat(mainCat);
    }

    @And("Choose any one product set {string}")
    public void chooseAnyOneProductSet(String product) {
        cp.chooseProduct(product);
    }

    @Then("Choose one category {string} and validate count between choosen one and product grid with index {string}")
    public void chooseSelectOneCategoryAndValidateCountBetweenChoosenOneAndProductGrid(String category, String index) {
        cp.chooseCategory(category);
        String totalCountInProduct = cp.checkCountInCategory(category, index);
        String totalCountInGrid = cp.checkCountInGrid();
        Assertions.booleanCheck(totalCountInGrid.contains(totalCountInProduct), "Count between selected category and count in product grid is not matched");

    }


    @Then("Remove filtered category and validate checkbox is unchecked {string}")
    public void removeFilteredCategoryAndValidateCheckboxIsUnchecked(String category) {
        cp.chooseCategory(category);
        Assertions.booleanCheck(cp.checkSelectedFilters(category), "Category is not still unchecked even filtered category removed");
    }

    @Then("Click on Remove filter button and validate checkbox is unchecked {string}")
    public void clickOnRemoveFilterButtonAndValidateCheckboxIsUnchecked(String category) {
        cp.chooseCategory(category);
        Assertions.booleanCheck(cp.resetFilter(category), "Category is not still unchecked even filtered category removed");

    }
}