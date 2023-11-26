package testCases;

import base.base;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import pages.homePage;
import pages.addToCartPage;
import pages.loginPage;
import pages.cartPage;

import java.util.ArrayList;

public class fullScenario extends base {

    static homePage homepageobject;
    static addToCartPage addToCartPageObject;
    static loginPage loginPageObject;
    static cartPage cartPageObject;
    SoftAssert SoftAssert = new SoftAssert();


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
        homepageobject.selectCategories();
        homepageobject.sortByName();
    }
    @Test
    public void checkTitle_Price() throws InterruptedException {
        addToCart(); // the above method
        Thread.sleep(3000);
        ArrayList<String> result = homepageobject.selectItem(3);
        String selectedItemTitle = result.get(0);
        Thread.sleep(3000);
        String selectedItemPrice =result.get(1);
//        String selectedItemPrice = addToCartPageObject.getPrice();
        Thread.sleep(1000);

        System.out.println(" Title: "+selectedItemTitle+" price: "+selectedItemPrice);
    }



  @Test
  @Description("teeet")
  public void testFullScenario() throws InterruptedException {

        addToCart(); // the above method
      Thread.sleep(3000);
      ArrayList<String> result = homepageobject.selectItem(3);
        String selectedItemTitle = result.get(0);
        Thread.sleep(3000);
        String selectedItemPrice =result.get(1);
        Thread.sleep(1000);
        addToCartPageObject.buyNow();
        Thread.sleep(1000);
        loginPageObject.login("01063284253", "Sa_5243052430");
        Thread.sleep(6000);
        String cartAddedItemTitle = cartPageObject.productName();
        String cartAddedItemPrice = cartPageObject.productPrice();

      SoftAssert.assertEquals(selectedItemTitle,cartAddedItemTitle);
      SoftAssert.assertEquals(selectedItemPrice,cartAddedItemPrice);


    }


    @AfterMethod
    public void AfterMethodCases() {
        closeBrowser();
    }

}
