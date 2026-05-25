package Stepdefs;

import Utils.Assertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;

import java.io.IOException;

public class ProductStepDef {

    ProductPage pg = new ProductPage();

    public ProductStepDef() throws IOException {
    }

    @When("Homepage loaded choose a product")
    public void homepageLoadedMovetoAProduct() {
        pg.moveToProduct();
    }

    @Then("Validate Product Image")
    public void validateProductImage() {
         boolean imageDisplayed = pg.productImage();
         Assertions.booleanCheck(imageDisplayed,"Image is not displayed");
    }

    @And("Validate Product name {string} price {string} and description {string}")
    public void validateProductNamePriceAndDescription(String prdName,String prdPrice,String prdDescp) {
        String title = pg.checkProductTitle();
        Assertions.comparisonCheck(title,prdName);
        String price = pg.checkPrice();
        Assertions.comparisonCheck(price,prdPrice);
        String actualDesc= pg.checkDescription();
        Assertions.booleanCheck(actualDesc.contains(prdDescp),"Keywords are missing in description");

    }


    @When("switch language and choose product")
    public void switchLanguage() {
      pg.switchLanguage();
    }

    @Then("Go to product page and validate price")
    public void goToProductPageAndValidatePrice() {
        String price = pg.checkPrice();
        Assertions.comparisonCheck(price,"€65,00");
    }




}
