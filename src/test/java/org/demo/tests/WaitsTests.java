package org.demo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class WaitsTests {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        //Used for Init or setup
        System.out.println("Before Class");
        driver = new ChromeDriver();

        driver.navigate().refresh();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void aboutUsTest() {
        //                                          driver itself, amount of maximum time
//        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5) );

        driver.get("https://www.demoblaze.com/index.html");
        //step 2 click About us Tab
        driver.findElement(By.cssSelector("a[data-target='#videoModal']")).click();

        //        method > condition
        WebElement aboutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#videoModalLabel")));

        //Step 3 verify text about us
        //Chaining the method on the Asser Object (this is ok if its a one off)
//        Assert.assertEquals(driver.getTitle(), "Example Domain", "Page title must match");
        //          actual result ,         expected result ,  message
        assertEquals( aboutElement.getText(),"About us", "About us section text is wrong"        );
    }

    @Test
    public void contactUsTest() {
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.cssSelector("a[data-target='#exampleModal']")).click();
        WebElement newMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#exampleModalLabel")));
        assertEquals(newMessage.getText(), "New message", "The Message is WRONG!!!!!");
    }

    @Test
    public void clickEachCategoryTest() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        String[] categories = {"Home", "Contact", "About us", "Cart", "Log in", "Sign up"};
        for (String c : categories) {
            driver.findElement(By.partialLinkText(c)).click();




        }
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
        driver.quit();
    }


}
