package pages;

import org.openqa.selenium.By;
import utils.WaitUtils;
import utils.Utility;

import java.io.IOException;

import static utils.DriverFactory.driver;
import static pages.HomePage.*;

public class ProductPage {

    private static String prdName = Utility.getValue("product_name");
    private static String prdTitleInDutch = Utility.getValue("prdTitleInDutch");
    private static final By product = By.xpath("//a[@class='product-item__url' and @aria-label='" + prdName + "']");
    private static final By productImage = By.xpath("//div[@data-index='0']/div/picture/img");
    private static final By productTitle = By.xpath("//h1[@class='product__title']");
    private static final By productPrice = By.xpath("//span[@class='js-product-price']");
    private static final By productDesc = By.xpath("//h3[@id='description']");
    private static final By productDescInDetail = By.xpath("//div[@class='rte accordion__content accordion__content--visible']");
    private static final By productTitleInD = By.xpath("//a[@aria-label='"+ prdTitleInDutch +"']");
    private static final By productPopUp = By.xpath("//div[@data-testid='modal-form-container']/button");

    public ProductPage() throws IOException {
    }

    public void moveToProduct() {
        Utility.jsExecutorForScrollUsingAxis(0,1500);
        WaitUtils.waitCond(driver, driver.findElement(product));
        driver.findElement(product).click();

    }

    public boolean productImage() {
        return Utility.ElePresent(driver.findElement(productImage));
    }

    public String checkProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public String checkPrice() {
        String Price = driver.findElement(productPrice).getText();
        return Price.trim();
    }

    public String checkDescription() {
        Utility.jsExecutorForScroll(driver.findElement(productDesc));
        WaitUtils.waitCond(driver, driver.findElement(productDesc));
        driver.findElement(productDesc).click();
        Utility.jsExecutorForScroll(driver.findElement(productDescInDetail));
        String detailedDesc = driver.findElement(productDescInDetail).getText();
        return detailedDesc.trim();
    }

    public void switchLanguage() {
        WaitUtils.waitCond(driver, driver.findElement(headerLangOpt));
        driver.findElement(headerLangOpt).click();
        if (langConfirmation.equalsIgnoreCase("eng")) {
            try {
                driver.findElement(changeOptToDutch).click();
                WaitUtils.waitCond(driver, driver.findElement(dutchLang));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Page is already switched to another language");
        }
       Utility.jsExecutorForScroll(driver.findElement(productTitleInD));
        driver.findElement(productTitleInD).click();
    }

    public String checkPriceInDlang(){
        String Price = driver.findElement(productPrice).getText();
        return Price.trim();
    }
}
