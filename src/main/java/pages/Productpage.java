package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Waitutils;
import utils.utility;

import java.io.IOException;
import java.util.List;

import static pages.DriverFactory.driver;
import static pages.homepage.*;

public class Productpage {

    private static String prdName = utility.getValue("product_name");
    private static String prdTitleInDutch = utility.getValue("product_Title");
    private static final By product = By.xpath("//a[@class='product-item__url' and @aria-label='" + prdName + "']");
    private static final By productImage = By.xpath("//div[@data-index='0']/div/picture/img");
    private static final By productTitle = By.xpath("//h1[@class='product__title']");
    private static final By productPrice = By.xpath("//span[@class='js-product-price']");
    private static final By productDesc = By.xpath("//h3[@id='description']");
    private static final By productDescInDetail = By.xpath("//div[@class='rte accordion__content accordion__content--visible']");
    private static final By productTitleInD = By.xpath("//a[@aria-label='"+ prdTitleInDutch +"']");
    private static final By productPopUp = By.xpath("//div[@data-testid='modal-form-container']/button");

    public Productpage() throws IOException {
    }

    public void moveToProduct() {
        Waitutils.waitCond(driver, driver.findElement(productPopUp));
        driver.findElement(productPopUp).click();
        utility.jsExecutorForScrollUsingAxis(0,1500);
        Waitutils.waitCond(driver, driver.findElement(product));
        driver.findElement(product).click();

    }

    public boolean productImage() {
        return utility.ElePresent(driver.findElement(productImage));
    }

    public String checkProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public String checkPrice() {
        String Price = driver.findElement(productPrice).getText();
        return Price.trim();
    }

    public String checkDescription() {
        utility.jsExecutorForScroll(driver.findElement(productDesc));
        Waitutils.waitCond(driver, driver.findElement(productDesc));
        driver.findElement(productDesc).click();
        utility.jsExecutorForScroll(driver.findElement(productDescInDetail));
        String detailedDesc = driver.findElement(productDescInDetail).getText();
        return detailedDesc.trim();
    }

    public void switchLanguage() {
        Waitutils.waitCond(driver, driver.findElement(headerLangOpt));
        driver.findElement(headerLangOpt).click();
        if (langConfirmation.equalsIgnoreCase("eng")) {
            try {
                driver.findElement(changeOptToDutch).click();
                Waitutils.waitCond(driver, driver.findElement(dutchLang));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Page is already switched to another language");
        }
       utility.jsExecutorForScroll(driver.findElement(productTitleInD));
        driver.findElement(productTitleInD).click();
    }

    public String checkPriceInDlang(){
        String Price = driver.findElement(productPrice).getText();
        return Price.trim();
    }
}
