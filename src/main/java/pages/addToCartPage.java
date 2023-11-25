package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addToCartPage {
    public WebDriver driver;

    public addToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By itemTitle = By.xpath("//div[@class='mobile-product-details']/child::p");
    By itemPrice = By.cssSelector("price-offer price");
    By addToCartButton = By.xpath("//div[@class='cart-btns']/button[@class='add-to-cart']");


    public String getTitle() {
        String title = driver.findElement(itemTitle).getText();
        return title ;
    }
    public String getPrice() {
        String price = driver.findElement(itemPrice).getText();
        return price ;
    }

    public void addToCart() {

        driver.findElement(addToCartButton).click();

    }
}
