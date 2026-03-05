package org.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class RegisterPage  {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToPage() {
        driver.get("https://nop-qa.portnov.com/");
    }

    public HashMap<String, String> registerUser() {
        if (driver.getTitle().equals("Your store. Home page title")) {
            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            email = "bobsmith" + now + "@gmail.com";
            password = "password123";
            //write code

            driver.findElement(By.cssSelector(".ico-register")).click();
            wait.until(ExpectedConditions.titleIs("Your store. Register"));
            driver.findElement(By.cssSelector("#FirstName")).sendKeys("Bob");
            driver.findElement(By.cssSelector("#LastName")).sendKeys("Smith");
            driver.findElement(By.cssSelector("#Email")).sendKeys(email);
            driver.findElement(By.cssSelector("#Password")).sendKeys(password);
            driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
            driver.findElement(By.cssSelector("#register-button")).click();
            return new HashMap<>(Map.of(email, password));
        } else {
            Assert.fail("We are not on the home page");
            return null;
        }
    }
//Overloading
    public HashMap<String, String> registerUser(String email, String password) {
        if (driver.getTitle().equals("Your store. Home page title")) {
            //write code
            this.email = email;
            this.password = password;
            driver.findElement(By.cssSelector(".ico-register")).click();
            wait.until(ExpectedConditions.titleIs("Your store. Register"));
            driver.findElement(By.cssSelector("#FirstName")).sendKeys("Bob");
            driver.findElement(By.cssSelector("#LastName")).sendKeys("Smith");
            driver.findElement(By.cssSelector("#Email")).sendKeys(email);
            driver.findElement(By.cssSelector("#Password")).sendKeys(password);
            driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
            driver.findElement(By.cssSelector("#register-button")).click();
            return new HashMap<>(Map.of(email, password));
        } else {
            Assert.fail("We are not on the home page");
            return null;
        }
    }

}
