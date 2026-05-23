package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Waitutils;
import utils.utility;

import java.util.List;

import static pages.DriverFactory.driver;

public class Cartpage {

    private static String nameOfSelectOption = utility.getValue("nameOfSelectOption");
    private static final By cartOption = By.xpath("//li[@class='aside-nav__list-item']/a[@data-modal-id='cart-modal']");
    private static final By cartMessage = By.xpath("//div[@id='cart-container']/p");
    private static final By continueShopping = By.xpath("//button[@class='button js-modal-close']");
    private static final By goToProduct = By.xpath("//div[@class='product-item__title h4']");
    private static final By clickCart = By.xpath("//button[@class='button button--upsell button--upsell-square | js-quick-add-trigger']");
    private static final By selectDiameter = By.id(nameOfSelectOption);
    private static final By quickAdd = By.xpath("//button[@type='submit']");
    private static final By rejectPopUp = By.xpath("//button[@aria-label='Close dialog']");

    public void clickCartOption(){
        Waitutils.waitCond(driver,driver.findElement(cartOption));
        driver.findElement(cartOption).click();
    }

    public String checkCartMessage(){
        Waitutils.waitCond(driver,driver.findElement(cartMessage));
        return driver.findElement(cartMessage).getText();
    }

    public void continueShopping(){
        driver.findElement(continueShopping).click();
    }

    public void goToProduct(String Product,String index) {
        driver.navigate().refresh();
        utility.jsExecutorForScrollUsingAxis(0, 1500);
        int i = Integer.parseInt(index);
        List<WebElement> products = driver.findElements(goToProduct);
        Product = Product.toLowerCase().trim().replaceAll(" ","");
        String actualPrd = null;
        for (WebElement prd : products) {
            actualPrd = prd.getText().toLowerCase().trim().replaceAll(" ","");
            if (Product.contains(actualPrd)) {
                utility.action(prd);
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
                 utility.selectOption(driver.findElement(selectDiameter),index);
                 List<WebElement> add = driver.findElements(quickAdd);
                 for(WebElement qcAdd : add){
                     qcAdd.click();
                     Waitutils.waitCond(driver, driver.findElement(rejectPopUp));
                     driver.findElement(rejectPopUp).click();
                     break;
                 }
        }




}
