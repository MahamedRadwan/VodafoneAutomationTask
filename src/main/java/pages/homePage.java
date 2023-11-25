package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void navigateToAllTab() {
        if (driver.findElement(cookieAcceptAllButton).isDisplayed()) {
            driver.findElement(cookieAcceptAllButton).click();
        }
        driver.findElement(allTab).click();

    }

    public void openPhonesAccessoriesMenu() throws InterruptedException {
        driver.findElement(phonesAccessoriesTab).click();
        Thread.sleep(6000);
        driver.findElement(smartPhonesTab).click();
        Thread.sleep(6000);

    }

    public void selectItem(int x) throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='vf-grid-3']"+"["+x+"]")).click();
        Thread.sleep(6000);
    }


}
