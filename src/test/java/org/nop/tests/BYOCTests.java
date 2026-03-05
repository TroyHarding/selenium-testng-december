package org.nop.tests;

import org.nop.pages.BYOCPage;
import org.nop.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class BYOCTests extends Base {

    @Test
    public void displayTest() {
        goToPage("https://nop-qa.portnov.com/build-your-own-computer");
//        Create an instance of the page object
        BYOCPage byoc = new BYOCPage(driver);
//        Verify the Title
        assertEquals(driver.getTitle(), "Your store. Build your own computer");
//        Verify Header
        assertTrue( byoc.getHeaderElement().isDisplayed(), "Header is NOT displayed" );
//        Verify the Processor
        assertTrue( byoc.getProcessorElement().isDisplayed(), "Processor is NOT displayed"    );
//        Verify the RAM
        assertTrue( byoc.getRAMElement().isDisplayed(), "RAM is NOT displayed" );
//        Verify the HDD
        for (WebElement element : byoc.getHDDElements()) {
            assertTrue(element.isDisplayed(), "HDD Options is NOT displayed" );
        }
//        Verify the OS
        for (WebElement element : byoc.getOSElements()) {
            assertTrue(element.isDisplayed(), "OS Options is NOT displayed" );
        }
//        Verify the Software
        for ( WebElement w : byoc.getSoftwareElements()   ) {
            assertTrue(w.isDisplayed(), "Software Options is NOT displayed" );
        }
    }

    @Test
    public void addtoCartTest() {
//        Go to page
        goToPage("https://nop-qa.portnov.com/build-your-own-computer");
        BYOCPage byoc = new BYOCPage(driver);
//        Select 2.2 GHz Processor
        Select processorSelect =  new Select(byoc.getProcessorElement());
        processorSelect.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");
//        Select 8 Gigs of Ram
        Select RAMSelect =  new Select(byoc.getRAMElement());
        RAMSelect.selectByVisibleText("8GB [+$60.00]");
//        select HDD 400GM
        byoc.getHDDElements().getLast().click();
//        Select Vista Premium
        byoc.getOSElements().getLast().click();
//        Select ALL THE SOFTWARE!!!!!
        byoc.getSoftwareElements().get(1).click();
        byoc.getSoftwareElements().get(2).click();
//        for (WebElement w : byoc.getSoftwareElements() ) {
//            if (w.getTagName().isBlank()) {
//                w.click();
//            }
//        }
//        Add to cart
        byoc.getAddToCartElement().click();
//        Verify the success Message
        wait.until(ExpectedConditions.visibilityOf(byoc.getNotificationElement()));
        assertEquals( byoc.getNotificationElement().getText()    , "The product has been added to your shopping cart"  );

    }

    @Test
    public void addBYOCE2E() {
//        Start on Main page
//        Click on Computers
//        Click on Desktop
//        Select BYOC
        goToPage("https://nop-qa.portnov.com/build-your-own-computer");
//        Fill out with default
        BYOCPage byoc = new BYOCPage(driver);
        byoc.byoc();
        //Go to Cart
//        Fill out info
//        Click Purchase
//        Verify Purchase
    }

}
