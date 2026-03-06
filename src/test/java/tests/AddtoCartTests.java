package tests;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BYOCPage;
import pages.CartPage;

import java.time.Duration;

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

        By shoppingCartLink = By.xpath("//a[contains(@href,'/cart') and (contains(normalize-space(),'Shopping cart') or contains(@class,'ico-cart'))]");
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();

        CartPage cartPage = new CartPage(driver);

        assertTrue(
                cartPage.getCartProductInfo("Build your own computer").contains("Build your own computer"),
                "Error"
        );
    }
}
