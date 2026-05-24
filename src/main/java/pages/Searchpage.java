package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import utils.Waitutils;
import utils.utility;

import java.util.List;

import static utils.DriverFactory.driver;

public class Searchpage {

    private static final By searchField = By.xpath("//button[@data-modal-id='search-modal']");
    private static final By searchBar = By.xpath("//input[@type='search']");
    private static final By searchResults = By.xpath("//div[@class='search-results-wrapper']");

    public void searchProduct(String product){
        driver.findElement(searchField).click();
        List<WebElement> src = driver.findElements(searchBar);
        for(WebElement e: src){
            utility.action(e);
            utility.actionOnClick(e);
            utility.actionOnSendKeys(e,product);
            utility.actionOnKeys();
            break;
        }

    }

    public boolean searchResults(){
        return driver.findElements(searchResults).size() > 1;
    }
}
