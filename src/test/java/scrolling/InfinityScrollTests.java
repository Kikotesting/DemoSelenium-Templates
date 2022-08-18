package scrolling;

import base.baseConfig;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.InfinityPageScroll;

public class InfinityScrollTests extends baseConfig {

    HomePage homePage;
    InfinityPageScroll infinityPageScroll;

    @Test
    void testScrollingToFifthParagraph() {
        homePage = new HomePage(driver);
        infinityPageScroll = new InfinityPageScroll(driver);

        homePage.infinityPage.click();
        infinityPageScroll.scrollToParagraph(5);
    }

}
