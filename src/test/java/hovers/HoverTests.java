package hovers;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.HoversPage;

public class HoverTests extends baseConfig {
    HomePage homePage;
    HoversPage hoversPage;


    @Test
    @DisplayName("Hovers elements")
    public void testHoverUser1() throws InterruptedException {
        homePage = new HomePage(driver);

        var caption = hoversPage.hoverOverFigure(1);

        homePage.hoversPage.click();


        Assertions.assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        Assertions.assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
        Assertions.assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
        Assertions.assertEquals(caption.getLink().endsWith("/users/1"), "Link incorrect");

    }

}
