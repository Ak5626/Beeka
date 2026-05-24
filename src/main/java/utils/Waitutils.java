package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static pages.DriverFactory.driver;
import static utils.utility.wait;

public class Waitutils {

    public static void waitCond(WebDriver driver, WebElement ele){

        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void waitCondForElementToClick(WebDriver driver, WebElement ele){

        wait.until(ExpectedConditions.elementToBeClickable(ele));

    }

    public static void waitCondForInvisibleText(By locator,String text){

        wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));

    }

    public static void fluentWait(WebElement ele){
        FluentWait<WebDriver> flWait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
        flWait.until(driver -> ele);
    }

}
