package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import static utils.DriverFactory.driver;

public class utility {
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static String getValue(String key) {
        Properties prop = new Properties();
        FileReader f = null;
        try {
             f =new FileReader("./config.properties");
            prop.load(f);
        }catch(Exception e){
            System.out.println("No File found");
        }

        return prop.getProperty(key);
    }

   public static void jsExecutorForScroll(WebElement element){

       js.executeScript("arguments[0].scrollIntoView();",element);
   }

    public static void jsExecutorForScrollUsingAxis(int x ,int y){

        js.executeScript("window.scrollBy(arguments[0], arguments[1])",x,y);
    }

    public static boolean ElePresent(WebElement ele){
      try{
          return ele.isDisplayed();
      } catch (NoSuchElementException e) {
          return false;
      }
    }

    public  static void action(WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    public  static void actionOnClick(WebElement element){
        Actions act = new Actions(driver);
        act.click(element).perform();
    }

    public  static void actionOnSendKeys(WebElement element,String text){
        Actions act = new Actions(driver);
        act.sendKeys(element,text).perform();
    }

    public  static void actionOnKeys(){
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
    }

    public static void selectOption(WebElement element,String index){
        Select select = new Select(element);
        select.selectByIndex(Integer.parseInt(index));
    }



}
