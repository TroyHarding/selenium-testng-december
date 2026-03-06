package tests;

import pages.BYOCPage;
import base.Base;
import pages.CartPage;
import pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddtoCartTests extends Base {

    @Test
    public void addToCart() throws InterruptedException {
//        1. Go to Nop
//        2. Click on Computers > Desktop > BYOC
//        3. Fill out info and add to cart
//        4. Go to cart
//        5. Verify All the info (Product, Price, QTY Total, Delete)
        goToPage();
        logger.info("I AM LOG!!!!");
        HomePage homePage = new HomePage(driver);

        Thread.sleep(3000);
        homePage.clickCategory("Computers");

        Thread.sleep(3000);
        homePage.clickSubCategory("Desktops");

        Thread.sleep(3000);
        homePage.clickProduct("Build your own computer");
        BYOCPage byocPage = new BYOCPage(driver);
        byocPage.byoc();
        homePage.clickShoppingCart();
        CartPage cartPage = new CartPage(driver);
//        Verification 1
        assertTrue(cartPage.getCartProductInfo("Build your own computer").contains("Build your own computer"), "Error");
//        Validate the Rest

    }

//        Optional Create at test to Update the Cart/
//        Create Test to add 2 items, and delete one


}
