package tests;

import pages.BYOCPage;
import base.Base;
import pages.CartPage;
import pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddtoCartTests extends Base {

    @Test
    public void addToCart() {
        goToPage();
        logger.info("I AM LOG!!!!");
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
        By computersTopMenu = By.xpath("//ul[contains(@class,'top-menu')]//a[normalize-space()='Computers']");
        wait.until(ExpectedConditions.elementToBeClickable(computersTopMenu)).click();
    
        wait.until(ExpectedConditions.urlContains("/computers"));
    
        By desktopsSubCategory = By.xpath("//h2[@class='title']/a[normalize-space()='Desktops']");
        wait.until(ExpectedConditions.elementToBeClickable(desktopsSubCategory)).click();
    
        By byocProduct = By.xpath("//h2[@class='product-title']/a[normalize-space()='Build your own computer']");
        wait.until(ExpectedConditions.elementToBeClickable(byocProduct)).click();
    
        BYOCPage byocPage = new BYOCPage(driver);
        byocPage.byoc();
    
        By shoppingCartLink = By.xpath("//a[contains(@href,'/cart') and (normalize-space()='Shopping cart' or @class='ico-cart')]");
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
    
        CartPage cartPage = new CartPage(driver);
    
        assertTrue(
            cartPage.getCartProductInfo("Build your own computer").contains("Build your own computer"),
            "Error"
        );
    }

//        Optional Create at test to Update the Cart/
//        Create Test to add 2 items, and delete one


}
