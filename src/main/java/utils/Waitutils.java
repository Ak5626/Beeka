package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.utility.wait;

public class Waitutils {

    public static void waitCond(WebDriver driver, WebElement ele){

        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void waitCondForElementToClick(WebDriver driver, WebElement ele){

        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }
}
