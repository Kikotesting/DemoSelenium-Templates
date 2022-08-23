package ScrollingTests;

import base.baseConfig;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.InfinityScrollPage;

public class InfinityScrollTests  extends baseConfig {
    HomePage homePage;
    InfinityScrollPage infinityScrollPage;

    @Test
    void testingScolling(){
        homePage = new HomePage(driver);
        infinityScrollPage = new InfinityScrollPage(driver);

        homePage.InfinityScrollPage.click();
        infinityScrollPage.isElementFound();



    }
}
