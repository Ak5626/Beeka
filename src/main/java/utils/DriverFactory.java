package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
   public static WebDriver driver ;

    public static WebDriver initDriver(String browser) {

        boolean headless = Boolean.parseBoolean(System.getProperty("headless", Utility.getValue("headless")));

            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    if(headless){
                        options.addArguments("--headless=new");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--window-size=1920,1080");
                        System.out.println("HEADLESS DRIVER ACTIVE");
                        System.out.println(options.asMap());
                    }
                        driver = new ChromeDriver(options);
                        break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                default:
                    System.out.println("No browser found");

            }

            return driver;
        }
}
