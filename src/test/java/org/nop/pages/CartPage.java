package org.nop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    @FindBy(css = ".cart")
    private WebElement table;

    @FindBy(css = "#termsofservice")
    private WebElement terms;

    @FindBy(css = "#checkout")
    private WebElement checkout;


    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver,Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getTableRow() {
        return table.findElements(By.cssSelector("tbody tr"));
    }

    public List<WebElement> getRowColumn(String productName) {
//        return getTableRow().getFirst().findElements(By.cssSelector("td"));
       List<WebElement> rows = getTableRow();
        for (WebElement r : rows) {
            if (r.getText().contains(productName)) {
                return r.findElements(By.cssSelector("td"));
            }
        }
        return null;
    }

    public String getCartProductInfo(String productName) {
       //return getRowColumn().get(2).getText();
        List<WebElement> tds = getRowColumn(productName);
        for (WebElement td : tds) {
            if(td.getAttribute("class").equals("product")) {
                return td.getText();
            }
        }
        return null;
    }

    public void clickCheckoutButton() {
        terms.click();
        checkout.click();
        wait.until(ExpectedConditions.invisibilityOf(checkout));
    }

}
