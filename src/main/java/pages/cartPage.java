package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartPage {
    public WebDriver driver;

    public cartPage(WebDriver driver) {
        this.driver = driver;
    }
    By productName = By.className("cartProduct-name");
    By productPrice = By.className("cartProduct-price");



    public String productName(){
        String name = driver.findElement(productName).getText();
        return name;
    }
    public String productPrice(){
        String price = driver.findElement(productPrice).getText();
        return price;
    }

}
