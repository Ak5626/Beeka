package Stepdefs;

import Utils.Assertions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.Productpage;

import static pages.DriverFactory.driver;

public class Productstepdef {

    Productpage pg = new Productpage();

    @When("Homepage loaded choose a product")
    public void homepageLoadedMovetoAProduct() {
        pg.moveToProduct();
    }

    @Then("Validate Product Image")
    public void validateProductImage() {
         boolean imageDisplayed = pg.productImage();
         Assertions.booleanCheck(imageDisplayed,"Image is not displayed");
    }

    @And("Validate Product name price and description")
    public void validateProductNamePriceAndDescription() {
        String title = pg.checkProductTitle();
        Assertions.comaprisonCheck(title,"CHEF FRYING PAN");
        String price = pg.checkPrice();
        Assertions.comaprisonCheck(price,"€65,00");
        String actualDesc= pg.checkDescription();
        Assertions.booleanCheck(actualDesc.contains("Sleek lines, ergonomic handles and high quality materials"),"Keywords are missing in description");
    }


    @When("switch language and choose product")
    public void switchLanguage() {
      pg.switchLanguage();
    }

    @Then("Go to product page and validate price")
    public void goToProductPageAndValidatePrice() {
        String price = pg.checkPrice();
        Assertions.comaprisonCheck(price,"€65,00");
    }
}
