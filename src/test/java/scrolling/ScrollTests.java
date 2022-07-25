package scrolling;

import base.baseConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ScrollPage;


public class ScrollTests extends baseConfig {

    HomePage homePage;
    ScrollPage scrollPage;

    @Test
    @DisplayName("Scrolling functionality")
    public void executeScrolling() throws InterruptedException {
        homePage = new HomePage(driver);
        scrollPage = new ScrollPage(driver);

        homePage.infiniteScrollPage.click();
        scrollPage.scrollEndPage();
        Thread.sleep(2000);
        scrollPage.scrollToPixels(200);
        Thread.sleep(2000);
        scrollPage.scrollToPixels(400);
        Thread.sleep(2000);
        scrollPage.scrollEndPage();
    }

}
