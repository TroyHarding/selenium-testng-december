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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Click "Computers" from the LEFT Categories block (not the top menu)
        By computersLeftNav = By.xpath(
                "//div[contains(@class,'block-category-navigation')]//a[normalize-space()='Computers']"
        );
        wait.until(ExpectedConditions.elementToBeClickable(computersLeftNav)).click();

        // Click "Desktops"
        By desktops = By.xpath("//h2[@class='title']/a[normalize-space()='Desktops']");
        wait.until(ExpectedConditions.elementToBeClickable(desktops)).click();

        // Click product "Build your own computer"
        By byoc = By.xpath("//h2[@class='product-title']/a[normalize-space()='Build your own computer']");
        wait.until(ExpectedConditions.elementToBeClickable(byoc)).click();

        BYOCPage byocPage = new BYOCPage(driver);
        byocPage.byoc();

        // Go to cart
        By cart = By.cssSelector("a.ico-cart");
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();

        CartPage cartPage = new CartPage(driver);

        assertTrue(
                cartPage.getCartProductInfo("Build your own computer")
                        .contains("Build your own computer"),
                "Error"
        );
    }
}
