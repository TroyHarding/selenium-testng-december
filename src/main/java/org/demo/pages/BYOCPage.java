package org.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BYOCPage {

    @FindBy(css = "div[class='product-name'] h1")
    private WebElement headerElement;

    @FindBy(css = "#product_attribute_1")
    private WebElement processorElement;

    @FindBy(css = "#product_attribute_2")
    private WebElement RAMElement;

    @FindBy(xpath = "//dd[@id='product_attribute_input_3']//label")
    private List<WebElement> HDDElements;

    @FindBy(xpath = "//dd[@id='product_attribute_input_4']//label")
    private List<WebElement> OSElements;

    @FindBy(xpath = "//dd[@id='product_attribute_input_5']//label")
    private List<WebElement> softwareElements;

    @FindBy(css ="#add-to-cart-button-1")
    private WebElement addToCartElement;

    @FindBy(css ="#bar-notification")
    private WebElement notificationElement;

    @FindBy(css = "p[class='content'] a")
    private WebElement shoppingCart;

    WebDriver driver;
    WebDriverWait wait;

    public BYOCPage(WebDriver driver) {
        this.driver = driver;
//                               chromedriver ,  How long to wait for
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }


    public void byoc(){
        //        Select 2.2 GHz Processor
        Select processorSelect =  new Select(getProcessorElement());
        processorSelect.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
//        Select 8 Gigs of Ram
        Select RAMSelect =  new Select(getRAMElement());
        RAMSelect.selectByVisibleText("8GB [+$60.00]");
//        select HDD 400GM
        getHDDElements().getLast().click();
//        Select Vista Premium
        getOSElements().getLast().click();
//        Select ALL THE SOFTWARE!!!!!
        getSoftwareElements().get(1).click();
        getSoftwareElements().get(2).click();
        getAddToCartElement().click();
    }

    public void clickShoppingCart(){
        shoppingCart.click();
        wait.until(ExpectedConditions.invisibilityOf(shoppingCart));
    }


//    Getters

    public WebElement getHeaderElement() {
        return headerElement;
    }

    public WebElement getProcessorElement() {
        return processorElement;
    }

    public WebElement getRAMElement() {
        return RAMElement;
    }

    public List<WebElement> getHDDElements() {
        return HDDElements;
    }

    public List<WebElement> getOSElements() {
        return OSElements;
    }

    public List<WebElement> getSoftwareElements() {
        return softwareElements;
    }

    public WebElement getAddToCartElement() {
        return addToCartElement;
    }

    public WebElement getNotificationElement() {
        return notificationElement;
    }
}
