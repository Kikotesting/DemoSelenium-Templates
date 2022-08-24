package keypresses;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.KeyPage;

public class KeysTests extends baseConfig {

    HomePage homePage;
    KeyPage keyPressesPage;

    @Test
    public void testBackspace(){
        homePage = new HomePage(driver);
        keyPressesPage = new KeyPage(driver);

        homePage.keyPage.click();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        Assertions.assertEquals(keyPressesPage.getResult(),"You entered: BACK_SPACE");
    }
    @Test
    public void testPi() throws InterruptedException {
        homePage = new HomePage(driver);
        keyPressesPage = new KeyPage(driver);

        homePage.keyPage.click();
        keyPressesPage.enterPi();
        Thread.sleep(2000);
    }
}
