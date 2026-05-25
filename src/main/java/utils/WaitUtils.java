package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




public class WaitUtils {

    private static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    private static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(25));
    }

    public static void waitCond(WebDriver driver, WebElement ele){
        getWait().until(ExpectedConditions.visibilityOf(ele));
    }

    public static void waitCondForElementToClick(WebDriver driver, WebElement ele){

        getWait().until(ExpectedConditions.elementToBeClickable(ele));

    }

    public static void waitCondForInvisibleText(By locator,String text){

        getWait().until(ExpectedConditions.invisibilityOfElementWithText(locator, text));

    }

    public static void waitElementClickable(WebElement ele){

        getWait().until(ExpectedConditions.elementToBeClickable(ele));

    }

    public static void fluentWait(WebElement ele){
        FluentWait<WebDriver> flWait =
                new FluentWait<>(getDriver())
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
        flWait.until(driver -> ele);
    }

}
