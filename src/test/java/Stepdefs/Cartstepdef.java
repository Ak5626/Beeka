package Stepdefs;

import Utils.Assertions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Cartpage;

public class Cartstepdef {

    Cartpage cart = new Cartpage();

        @When("Homepage gets loaded click on cart menu in the header")
         public void Homepagegetsloadedclickoncartmenuintheheader(){
                cart.clickCartOption();
        }

    @Then("Validate empty cart message")
    public void validateEmptyCartMessageAndClickOnConitnueShopping() {
        Assertions.comaprisonCheck(cart.checkCartMessage(),"Your cart is currently empty.");
    }


    @And("Click on continue shopping and check homepage is navigated back")
    public void clickOnContinueShoppingAndCheckHomepageIsNavigatedBack() {
       cart.continueShopping();
    }

    @When("Homepage gets loaded click cart option on any product {string} {string}")
    public void homepageGetsLoadedClickCartOptionOnAnyProduct(String product,String index) {
        cart.goToProduct(product,index);
    }

    @And("Validate option should be displayed for select diameters of products {string} and add to cart option should be shown")
    public void validateOptionShouldBeDisplayedForSelectDiametersOfProductsAndAddToCartOptionShouldBeShown(String input) {
        cart.selectDiameterAndClickQuickAddOption(input);
    }
}

