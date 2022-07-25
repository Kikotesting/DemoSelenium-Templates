package shifting;

import base.baseConfig;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class ShiftContent extends baseConfig {

    HomePage homePage;

    @Test
    public void performShiftingContent(){

        homePage = new HomePage(driver);
        homePage.shiftingPage.click();
    }

}
