package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class base {


    //    public static WebDriver driver = new ChromeDriver();
    public static WebDriver driver = null;

    public static void openBrowser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Documents\\GitHub\\vodafoneAutomatioTask\\src\\browser\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://eshop.vodafone.com.eg/en/");
        Thread.sleep(5000);
    }

    public static void closeBrowser() {
        driver.quit();
//		chromeDriver.manage().timeouts().implicitlyWait(10sec)
    }

    public static void main(String[] args) throws InterruptedException {
        openBrowser();
    }

}

