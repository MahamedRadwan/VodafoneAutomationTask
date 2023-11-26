package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addToCartPage {
    public WebDriver driver;

    public addToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By buyNowButton = By.xpath("//div[@class='cart-btns']/button[@class='buy-now']");



    public void buyNow() {
        driver.findElement(buyNowButton).click();
    }
}
