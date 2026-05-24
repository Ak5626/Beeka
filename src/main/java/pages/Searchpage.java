package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.DriverFactory.driver;

public class Searchpage {

    private static final By searchField = By.xpath("//button[@data-modal-id='search-modal']");
    private static final By searchBar = By.id("search");
    private static final By searchResults = By.xpath("//div[@class='search-results-wrapper']");

    public void searchProduct(String product){
        driver.findElement(searchField).click();
        List<WebElement> search = driver.findElements(searchBar);
        for(WebElement e : search){
            e.click();
            e.sendKeys(product);
            e.sendKeys(Keys.ENTER);
            break;
        }
    }

    public boolean searchResults(){
        return driver.findElements(searchResults).size() > 1;
    }
}
