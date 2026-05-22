package Runner;

import Utils.Assertions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.DriverFactory;
import utils.utility;

import java.time.Duration;

import static pages.DriverFactory.driver;



@CucumberOptions(
            features = "src/test/resources/features",
            glue = "Stepdefs",
            plugin = {"pretty", "html:target/cucumber-report.html"},

            tags= "@Validate_ProductPage_Secnario2")

public class TestRunner extends AbstractTestNGCucumberTests {


    @BeforeTest
    public void setup() throws Exception {
        driver = DriverFactory.initDriver("chrome");
        driver.get(utility.getValue("eng_url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterTest
    public void tearDown(){
        Assertions.assertAll();
        driver.quit();
    }


}
