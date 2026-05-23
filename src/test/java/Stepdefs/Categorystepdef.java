package Stepdefs;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Categorypage;

public class Categorystepdef {

    Categorypage cp = new Categorypage();

    @When("Homepage gets loaded click on main category {string}")
        public void Homepagegetsloadedclickonmaincategory(String mainCat){
            cp.chooseMainCat(mainCat);
    }

    @And("Choose any one product set {string}")
    public void chooseAnyOneProductSet(String product) {

    }

    @Then("Choose select one category {string} and validate count between choosen one and product grid")
    public void chooseSelectOneCategoryAndValidateCountBetweenChoosenOneAndProductGrid(String arg0) {

    }


}
