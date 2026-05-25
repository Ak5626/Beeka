package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;
import utils.Utility;

import java.util.List;

import static utils.DriverFactory.driver;

public class CartPage {

    private String beforeAddingQuantity=null;
    private String productName= null;
    private static String nameOfSelectOption = Utility.getValue("nameOfSelectOption");
    private static final By cartOption = By.xpath("//li[@class='aside-nav__list-item']/a[@data-modal-id='cart-modal']");
    private static final By cartMessage = By.xpath("//div[@id='cart-container']/p");
    private static final By continueShopping = By.xpath("//button[@class='button js-modal-close']");
    private static final By goToProduct = By.xpath("//div[@class='product-item__title h4']");
    private static final By clickCart = By.xpath("//button[@class='button button--upsell button--upsell-square | js-quick-add-trigger']");
    private static final By selectDiameter = By.id(nameOfSelectOption);
    private static final By quickAdd = By.xpath("//button[@type='submit']");
    private static final By rejectPopUp = By.xpath("//button[@aria-label='Close dialog']");
    private static final By viewCart = By.xpath("//a[@class='button button--underline button--font-weight-bold button--update-cart']");
    private static final By productInCart = By.xpath("//a[@class='cart__item-title']");
    private static final By productVariant = By.xpath("//span[@class='cart__item-variant-title']");
    private static final By productPriceInCart = By.xpath("//div[@class='cart__end']/div/strong");
    private static final By productQuantityInCart = By.xpath("//div[@class='cart__end']/div[2]/div/div/div/input");
    private static final By increaseQuantity = By.xpath("//div[@class='cart__end']/div[2]/div/div/div/button[2]");
    private static final By deleteProduct = By.xpath("//div[@class='hide large--show']/div/a/span");
    private static final By cartEmpty = By.xpath("//div[@class='container js-cart-container']/p[1]");

    public void clickCartOption(){
        WaitUtils.waitCond(driver,driver.findElement(cartOption));
        driver.findElement(cartOption).click();
    }

    public String checkCartMessage(){
        WaitUtils.waitCond(driver,driver.findElement(cartMessage));
        return driver.findElement(cartMessage).getText();
    }

    public void continueShopping(){
        driver.findElement(continueShopping).click();
    }

    public void goToProduct(String Product) {
        driver.navigate().refresh();
        Utility.jsExecutorForScrollUsingAxis(0, 1500);
        List<WebElement> products = driver.findElements(goToProduct);
        Product = Product.toLowerCase().trim().replaceAll(" ","");
        String actualPrd = null;
        for (WebElement prd : products) {
            actualPrd = prd.getText().toLowerCase().trim().replaceAll(" ","");
            if (Product.contains(actualPrd)) {
                Utility.action(prd);
                List<WebElement> carts = driver.findElements(clickCart);
                for (WebElement c : carts) {
                    c.click();
                    break;
                }
                break;
            }
        }
    }

        public void selectDiameterAndClickQuickAddOption(String index) {
                 Utility.selectOption(driver.findElement(selectDiameter),index);
                 List<WebElement> add = driver.findElements(quickAdd);
                 for(WebElement qcAdd : add){
                     qcAdd.click();
                     WaitUtils.waitCond(driver, driver.findElement(rejectPopUp));
                     driver.findElement(rejectPopUp).click();
                     break;
                 }
        }

        public void clickOnViewCart(){
              WaitUtils.waitCond(driver,driver.findElement(viewCart));
              driver.findElement(viewCart).click();
        }

        public String productName(){
              productName = driver.findElement(productInCart).getText();
             return driver.findElement(productInCart).getText();
        }

        public String productVariant(){
        return driver.findElement(productVariant).getText();
        }

        public String productPrice(){
        beforeAddingQuantity = driver.findElement(productPriceInCart).getText();
        return driver.findElement(productPriceInCart).getText();
        }

        public String productQuantity(){
        return driver.findElement(productQuantityInCart).getAttribute("value");
        }

        public void increaseQuantity(){
             driver.findElement(increaseQuantity).click();
             WaitUtils.waitCondForInvisibleText(productPriceInCart,beforeAddingQuantity);
        }

        public void deleteProduct() {
            driver.findElement(deleteProduct).click();
            try {
                if (driver.findElement(deleteProduct).isDisplayed()) {
                    driver.findElement(deleteProduct).click();

                }
            } catch (Exception e) {
                System.out.println("Proceed to next step");

            }
        }

        public String noProductShown(){
            driver.navigate().refresh();
            WaitUtils.waitCond(driver,driver.findElement(cartEmpty));
            return driver.findElement(cartEmpty).getText();
        }






}
