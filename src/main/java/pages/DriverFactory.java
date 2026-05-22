package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
   public static WebDriver driver ;

    public static WebDriver initDriver(String browser) {

            switch (browser.toLowerCase()) {

                case "chrome":
                    driver = new ChromeDriver();
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
