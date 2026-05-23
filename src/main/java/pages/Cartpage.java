package pages;

import org.openqa.selenium.By;
import utils.Waitutils;

import static pages.DriverFactory.driver;

public class Cartpage {

    private static final By cartOption = By.xpath("//li[@class='aside-nav__list-item']/a[@data-modal-id='cart-modal']");
    private static final By cartMessage = By.xpath("//div[@id='cart-container']/p");
    private static final By continueShopping = By.xpath("//button[@class='button js-modal-close']");

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


}
