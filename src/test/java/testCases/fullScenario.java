package testCases;

import base.base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.homePage;
import pages.addToCartPage;
import pages.loginPage;
import pages.cartPage;

public class fullScenario extends base {

    static homePage homepageobject;
    static addToCartPage addToCartPageObject;
    static loginPage loginPageObject;
    static cartPage cartPageObject;


    @BeforeMethod
    public void beforeMethodCases() throws InterruptedException {
        openBrowser();
        homepageobject = new homePage(driver);
        addToCartPageObject = new addToCartPage(driver);
        loginPageObject = new loginPage(driver);
        cartPageObject = new cartPage(driver);

    }

    /*
        @Test
        public void failedToAddToCart() throws InterruptedException {
            homepageobject.navigateToAllTab();
            homepageobject.openPhonesAccessoriesMenu();
            homepageobject.selectItem(2);

        }
    */
    @Test
    public void addToCart() throws InterruptedException {
        homepageobject.navigateToAllTab();
        homepageobject.openPhonesAccessoriesMenu();
        homepageobject.selectItem(4);

    }

    @Test
    public void testFullScenario() throws InterruptedException {

        addToCart(); // the above method
        String selectedItemTitle = addToCartPageObject.getTitle();
        Thread.sleep(1000);
        String selectedItemPrice = addToCartPageObject.getPrice();
        Thread.sleep(1000);
        addToCartPageObject.addToCart();
        Thread.sleep(1000);
        loginPageObject.login("01063284253", "Sa_5243052430");
        Thread.sleep(6000);
        cartPageObject.openCartPage();
        Thread.sleep(2000);
        String cartAddedItemTitle = cartPageObject.productName();
        String cartAddedItemPrice = cartPageObject.productPrice();

        Assert.assertEquals(selectedItemTitle,cartAddedItemTitle);
        Assert.assertEquals(selectedItemPrice,cartAddedItemPrice);


    }


    @AfterMethod
    public void AfterMethodCases() {
        closeBrowser();
    }

}
