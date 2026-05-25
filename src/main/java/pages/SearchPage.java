package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;
import utils.WaitUtils;
import utils.Utility;

import java.util.List;


public class SearchPage {

    WebDriver driver = DriverFactory.getDriver();
    private static final By searchField = By.xpath("//button[@data-modal-id='search-modal']");
    private static final By searchBar = By.xpath("//input[@type='search']");
    private static final By searchResults = By.xpath("//div[@class='search-results-wrapper']");
    private static final By searchresultsNotFound=By.xpath("//div[@class='search-results-wrapper']/div/div/div/h2/a");

    public void searchProduct(String product){
        WaitUtils.waitElementClickable(driver.findElement(searchField));
        driver.findElement(searchField).click();
        List<WebElement> src = driver.findElements(searchBar);
        for(WebElement e: src){
            Utility.action(e);
            Utility.actionOnClick(e);
            Utility.actionOnSendKeys(e,product);
            Utility.actionOnKeys();
            break;
        }

    }

    public boolean searchResults(){
        return driver.findElements(searchResults).size() > 1;
    }

    public boolean searchResultsNotFound(String product){
        List<WebElement> search = driver.findElements(searchresultsNotFound);
        int textFound=0;
        int noText=0;
        for(WebElement e : search){
            if(e.getText().contains(product)){
                textFound++;
            }
            else{
                noText++;
            }
        }
        return textFound==0;
    }
}
