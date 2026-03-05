package org.nop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FirstTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        //Used for Init or setup
        System.out.println("Before Class");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        //Find Element
        driver.findElement(By.cssSelector("#firstName")).sendKeys("INFO");
        waitSeconds(5);
    }

    public void waitSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
        driver.quit();
    }


}
