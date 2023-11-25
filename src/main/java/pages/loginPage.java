package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    public WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userNameInput = By.id("username");
    By passwordInput = By.id("password");
    By loginButton = By.id("submitBtn");

    public void login(String userName, String password) throws InterruptedException {
        driver.findElement(userNameInput).sendKeys(userName);
        Thread.sleep(2000);
        driver.findElement(passwordInput).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(loginButton).click();
        Thread.sleep(2000);

    }

}
