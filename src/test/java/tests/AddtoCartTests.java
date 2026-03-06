package tests;

import base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import pages.BYOCPage;
import pages.CartPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AddtoCartTests extends Base {

    @Test
    public void addToCart() {

        goToPage();
        logger.info("I AM LOG!!!!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        takeScreenshot("before_categories_click");

        By categoriesButton = By.xpath("//strong[text()='Categories']");
        wait.until(ExpectedConditions.elementToBeClickable(categoriesButton)).click();

        By computers = By.xpath("//a[contains(text(),'Computers')]");
        wait.until(ExpectedConditions.elementToBeClickable(computers)).click();

        By desktops = By.xpath("//a[contains(text(),'Desktops')]");
        wait.until(ExpectedConditions.elementToBeClickable(desktops)).click();
        
        By byoc = By.xpath("//h2[@class='product-title']/a[contains(text(),'Build your own computer')]");
        wait.until(ExpectedConditions.elementToBeClickable(byoc)).click();

        BYOCPage byocPage = new BYOCPage(driver);
        byocPage.byoc();

        By cart = By.cssSelector("a.ico-cart");
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();

        CartPage cartPage = new CartPage(driver);

        assertTrue(
                cartPage.getCartProductInfo("Build your own computer")
                        .contains("Build your own computer"),
                "Error"
        );
    }

    public void takeScreenshot(String name) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("target/" + name + ".png");

        try {
            FileHandler.copy(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
