package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class homePage {

    public WebDriver driver;
    By cookieAcceptAllButton = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    By allTab = By.xpath("//div[@class='menu-tabs']/button[1]");
    By phonesAccessoriesTab = By.xpath("//label[text()='Phones & Accessories']");
    By smartPhonesTab = By.xpath("//label[text()='Phones & Accessories']/following-sibling::div//child::div[@class='tab'][2]");

//    By item = ;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAllTab() throws InterruptedException {
        if (driver.findElement(cookieAcceptAllButton).isDisplayed()) {
            driver.findElement(cookieAcceptAllButton).click();
        }
        Thread.sleep(6000);
        driver.findElement(allTab).click();

    }

    public void openPhonesAccessoriesMenu() throws InterruptedException {
        driver.findElement(phonesAccessoriesTab).click();
        Thread.sleep(6000);
        driver.findElement(smartPhonesTab).click();
        Thread.sleep(6000);

    }

public void sortByName()
{
    By sortMenu = By.xpath("//select[@class='sort-btn ng-untouched ng-pristine ng-valid']");
    By sortName = By.xpath("//select[@class='sort-btn ng-untouched ng-pristine ng-valid']//child::option[2]");
    driver.findElement(sortMenu).click();
    driver.findElement(sortName).click();

}
    public void selectCategories() throws InterruptedException {
        By category = By.xpath("//div[@class='category-tabs-section']/child::div[text()=' Samsung ']");
        driver.findElement(category).click();
        Thread.sleep(5000);
    }



    public ArrayList<String> selectItem(int item) throws InterruptedException {
        ArrayList<String> values = new ArrayList<>();
        By wantedItem = By.xpath("//*[@class='vf-grid-3']" + "[" + item + "]");
        By wantedItemTitle = By.xpath("//*[@class='vf-grid-3']" + "["+item +"]//child::p[@id='mainText']");
        By wantedItemPrice = By.xpath("//*[@class='vf-grid-3']" + "["+item +"]//child::h5[@class='main-price']");
        String title = driver.findElement(wantedItemTitle).getText();
        String price = driver.findElement(wantedItemPrice).getText();
        driver.findElement(wantedItem).click();
        values.add(title);
        values.add(price);
        Thread.sleep(5000);

        return values ;
    }


}
