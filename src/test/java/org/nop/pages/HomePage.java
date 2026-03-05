package org.nop.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    @FindBy(css = ".cart-label")
    private WebElement shoppingCart;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver ) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://nop-qa.portnov.com/");
        wait.until(ExpectedConditions.titleIs("Your store. Home page title"));
    }

    //Create 3 methods: Click on a Category, click on Sub Category, Click on Product
    public void clickCategory(String category) {
        driver.findElement(By.linkText(category)).click();
        wait.until(ExpectedConditions.titleContains(category));
    }

    public void clickSubCategory(String subCategory) {
        driver.findElement(By.linkText(subCategory)).click();
        wait.until(ExpectedConditions.titleContains(subCategory));
    }

    public void clickProduct(String product) {
//        if (product.equalsIgnoreCase("BYOC")) {
//            driver.findElement(By.linkText("Build your own computer")).click();
//        } else {
//            driver.findElement(By.linkText(product)).click();
//        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", shoppingCart);
        driver.findElement(By.linkText(product)).click();
        wait.until(ExpectedConditions.titleContains(product));
    }

    public void clickShoppingCart() {
        shoppingCart.click();
        wait.until(ExpectedConditions.titleContains("Shopping Cart"));
    }



}
