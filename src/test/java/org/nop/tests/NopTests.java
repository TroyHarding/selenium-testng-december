package org.nop.tests;

import org.nop.base.Base;
import org.nop.pages.RegisterPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static org.testng.Assert.*;

public class NopTests extends Base {

    HashMap<String,String> credentials = new HashMap<>();
    private String email;
    private String password;

    @Test
    public void registerTest() {
        RegisterPage page = new RegisterPage(driver);
        page.goToPage();
        credentials = page.registerUser();

//        Getter Setter Way
        email = page.getEmail();
        password = page.getPassword();
        assertEquals(driver.findElement(By.cssSelector(".result")).getText(), "Your registration completed");
    }

    @Test
    public void registerWithUserTest() {
        RegisterPage page = new RegisterPage( driver);
        page.goToPage();
        String email = "robersmith" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + "@gmail.com";
        page.registerUser(email, "123password");
        assertEquals(driver.findElement(By.cssSelector(".result")).getText(), "Your registration completed");
    }



}
