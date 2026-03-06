package tests;

import base.Base;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OzzyTest extends Base {

    @Test
    public void loginTest()
    {
        goToPage("https://github.com/TroyHarding/selenium-testng-december");
        assertEquals(driver.getTitle(), "GitHub - TroyHarding/selenium-testng-december: test1 · GitHub");
    }
}
