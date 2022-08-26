package scrolling;

import base.baseConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ScrollLargePage;
import pages.ScrollPage;


public class ScrollTests extends baseConfig {

    HomePage homePage;
    ScrollPage scrollPage;
    ScrollLargePage scrollLargePage;

    @Test
    @DisplayName("Scrolling functionality")
    public void executeScrolling() throws InterruptedException {
        homePage = new HomePage(driver);
        scrollPage = new ScrollPage(driver);

        // Test with Thread sleep for visual effect.. can be delete and add Explicit wait
        homePage.infiniteScrollPage.click();
        scrollPage.scrollEndPage();
        Thread.sleep(2000);
        scrollPage.scrollToPixels(200);
        Thread.sleep(2000);
        scrollPage.scrollToPixels(400);
        Thread.sleep(2000);
        scrollPage.scrollEndPage();
    }

    @Test
    @DisplayName("Scrolling horizontal")
    void testScrolling() throws InterruptedException {
        homePage = new HomePage(driver);
        scrollLargePage = new ScrollLargePage(driver);

        homePage.scrollPage.click();
        scrollLargePage.scrollToWebElement(scrollLargePage.table);
    }

}
