package Stepdefs;

import Utils.Assertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartStepDef {

    CartPage cart = new CartPage();

        @When("Homepage gets loaded click on cart menu in the header")
         public void Homepagegetsloadedclickoncartmenuintheheader(){
                cart.clickCartOption();
        }

    @Then("Validate empty cart message")
    public void validateEmptyCartMessageAndClickOnConitnueShopping() {
        Assertions.comparisonCheck(cart.checkCartMessage(),"Your cart is currently empty.");
    }


    @And("Click on continue shopping and check homepage is navigated back")
    public void clickOnContinueShoppingAndCheckHomepageIsNavigatedBack() {
       cart.continueShopping();
    }

    @When("Homepage gets loaded click cart option on any product {string} {string}")
    public void homepageGetsLoadedClickCartOptionOnAnyProduct(String product,String index) {
        cart.goToProduct(product);
    }

    @And("Validate option should be displayed for select diameters of products {string} and add to cart option should be shown")
    public void validateOptionShouldBeDisplayedForSelectDiametersOfProductsAndAddToCartOptionShouldBeShown(String input) {
        cart.selectDiameterAndClickQuickAddOption(input);
    }


    @Then("Click on view cart option and validate product name {string} quantity {string} variant {string} and price {string}")
    public void clickOnViewCartOptionAndValidateProductNameQuantityVariantAndPrice(String productName, String productQuan, String productVariant, String productPrice) {
        cart.clickOnViewCart();
        Assertions.comparisonCheck(cart.productName(),productName);
        Assertions.comparisonCheck(cart.productVariant(),productVariant);
        Assertions.comparisonCheck(cart.productQuantity(),productQuan);
        Assertions.booleanCheck(cart.productPrice().contains(productPrice),"Price is not matched with expected value");

        }

    @Then("Increase quantity in cart page and validate quantity value {string} and price {string}")
    public void increaseQuantityInCartPageAndValidateQuantityValueAndPrice(String increaseQuantity,String increasedPrice) {
        cart.increaseQuantity();
        Assertions.comparisonCheck(cart.productQuantity(),increaseQuantity);
        Assertions.booleanCheck(cart.productPrice().contains(increasedPrice),"Price is not matched with expected value");

    }

    @Then("select product {string} variant {string} and go to cart page")
    public void selectProductAndGoToCartPage(String product,String input) {
        cart.goToProduct(product);
        cart.selectDiameterAndClickQuickAddOption(input);
        cart.clickOnViewCart();

    }

    @And("Delete the product")
    public void deleteTheProduct() {
         cart.deleteProduct();

    }

    @Then("Validate product should be removed {string}")
    public void validateProductShouldBeRemoved(String message) {
       Assertions.comparisonCheck(cart.noProductShown(),message);
    }
}

