package org.demo.tests;

import org.demo.pages.BYOCPage;
import org.demo.pages.Base;
import org.demo.pages.CartPage;
import org.demo.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddtoCartTests extends Base {

    @Test
    public void addToCart() {
//        1. Go to Nop
//        2. Click on Computers > Desktop > BYOC
//        3. Fill out info and add to cart
//        4. Go to cart
//        5. Verify All the info (Product, Price, QTY Total, Delete)
        goToPage();
        logger.info("I AM LOG!!!!");
        HomePage homePage = new HomePage(driver);
        homePage.clickCategory("Computers");
        homePage.clickSubCategory("Desktops");
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
