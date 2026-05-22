package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import static pages.DriverFactory.driver;

public class utility {
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static String getValue(String key) throws IOException {
        Properties prop = new Properties();
        FileReader f = new FileReader("./config.properties");
        prop.load(f);
        return prop.getProperty(key);
    }

    public static void waitCond(WebDriver driver,WebElement ele){

        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static boolean ElePresent(WebElement ele){
      try{
          return ele.isDisplayed();
      } catch (NoSuchElementException e) {
          return false;
      }
    }



}
