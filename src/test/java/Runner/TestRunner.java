package Runner;

import Utils.Assertions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.DriverFactory;
import utils.utility;

import java.time.Duration;

import static utils.DriverFactory.driver;



@CucumberOptions(
            features = "src/test/resources/features",
            glue = "Stepdefs",
            plugin = {"pretty", "html:target/cucumber-report.html"},

            tags= "@Validate_Searchfield_Scenario1 or @Validate_Searchfield_Scenario2")

public class TestRunner extends AbstractTestNGCucumberTests {


}
