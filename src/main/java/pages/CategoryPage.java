package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;
import utils.Utility;

import java.util.List;

import static utils.DriverFactory.driver;


public class CategoryPage {

    private static String mainCat = Utility.getValue("mainCat");
    private static String product = Utility.getValue("product");

    private static final By mainCategory = By.xpath("//a[contains(text(),'"+mainCat+"')]");
    private static final By product_name = By.xpath("//img[@alt='"+product+"']");
    private static final By selCategory = By.xpath( "//span[@class='facets__label-text']");
    private static final By totalCount = By.xpath( "//span[@class='facets__label-text']/following-sibling::span[1]");
    private static final By countInGridPage = By.xpath( "//span[@id='ProductCountDesktop']");
    private static final By rejectPopUp = By.xpath(  "//div[@data-testid='modal-form-container']/button[@tabindex='0']");
    private static final By subCatFilter = By.xpath("//a[@class='button--filter']");
    private static final By resetFilter = By.xpath("//a[@class='active-facets__button-remove' and @role='button']");

    public void chooseMainCat(String mainCat1){
        if(mainCat1.equalsIgnoreCase(mainCat)) {
            WaitUtils.waitCond(driver, driver.findElement(mainCategory));
            driver.findElement(mainCategory).click();
        }else{
            System.out.println("Category passed from example is not matched with config data");
        }
    }

    public void chooseProduct(String product1){
        if(product1.equalsIgnoreCase(product)) {
              WaitUtils.fluentWait(driver.findElement(product_name));
              Utility.jsExecutorForScroll(driver.findElement(product_name));
              driver.findElement(product_name).click();
        }else{
            System.out.println("Product passed from example is not matched with config data");
        }
    }

    public void chooseCategory(String category){
           driver.navigate().refresh();
           Utility.jsExecutorForScrollUsingAxis(0,600);
           List<WebElement> lst =  driver.findElements(selCategory);
           String actual = null;
           for(int i=0;i<lst.size();i++) {
               actual = lst.get(i).getText();
               actual = actual.trim();
               category = category.trim();
               if (actual.equalsIgnoreCase(category)) {
                   WaitUtils.waitCond(driver, lst.get(i));
                   lst.get(i).click();
                   break;
               }
           }

    }

    public String checkCountInCategory(String category,String index) {
        List<WebElement> lst = driver.findElements(selCategory);
        String totalCountInSuffix = null;
        for (WebElement categorylist : lst) {
            String actual = categorylist.getText();
            actual=actual.trim();
            category = category.trim();
            if (actual.equalsIgnoreCase(category)) {
                List<WebElement> counts = driver.findElements(totalCount);
                int i = Integer.parseInt(index);
                totalCountInSuffix = counts.get(i).getText();
                totalCountInSuffix = totalCountInSuffix.replaceAll("[()]", "");
            }
        }
        return totalCountInSuffix;

    }

    public String checkCountInGrid() {
        return driver.findElement(countInGridPage).getText();

    }

    public boolean checkSelectedFilters(String category){
        category = category.trim();
        for (WebElement filter : driver.findElements(subCatFilter)) {
            String actual = filter.getText().trim();
            if (actual.contains(category)) {
                WaitUtils.waitCond(driver, filter);
                filter.click();
                driver.navigate().refresh();
                for (WebElement categoryList :
                        driver.findElements(selCategory)) {
                    String actual1 =
                            categoryList.getText().trim();
                    if (actual1.equalsIgnoreCase(category)) {
                        WaitUtils.waitCond(driver, categoryList);
                        return !categoryList.isSelected();
                    }
                }

                break;
            }
        }
        return false;
    }


    public boolean resetFilter(String category){
        driver.navigate().refresh();
        List<WebElement> remove = driver.findElements(resetFilter);
        for(WebElement e : remove){
            e.click();
            break;
        }
        driver.navigate().refresh();
        List<WebElement> lst1 = driver.findElements(selCategory);
        boolean select=false;
        for (WebElement categorylist : lst1) {
            WaitUtils.waitCond(driver,categorylist);
            String actual1 = categorylist.getText();
            actual1 = actual1.trim();
            category = category.trim();
            if (actual1.equalsIgnoreCase(category)) {
                WaitUtils.waitCond(driver, categorylist);
                select = !categorylist.isSelected();
                break;
            }

        }
        return select;
    }

}
