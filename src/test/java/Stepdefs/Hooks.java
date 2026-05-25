package Stepdefs;

import Utils.Assertions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.Utility;

import java.time.Duration;

import static utils.DriverFactory.driver;

public class Hooks {

    @Before
    public void setup(Scenario scenario) throws Exception {
        System.out.println("Starting: " + scenario.getName());
        DriverFactory.initDriver("chrome");
        if(Utility.getValue("env").equalsIgnoreCase("prod")) {
            driver.get(Utility.getValue("eng_url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }else{
            System.out.println("No environment found");
        }

    }

    @After
    public void tearDown(){
        Assertions.assertAll();
        if (DriverFactory.driver != null) {
            driver.quit();
        }
    }
}
