package iframes;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FramesPage;
import pages.HomePage;

public class FrameTests extends baseConfig {

        HomePage homePage;
        FramesPage framesPage;

        @Test
        void testingFrames() throws InterruptedException {

            homePage = new HomePage(driver);
            framesPage = new FramesPage(driver);
            String text1 = "Kiko";
            String text2 = "Kiko222222";

            homePage.framesPage.click();
            framesPage.clearTextArea();
            framesPage.setTextArea(text1);
            framesPage.getTextFromEditor();
            Thread.sleep(1000);
            Assertions.assertEquals(framesPage.getTextFromEditor(),text1,"Text from editor is incorrect");
            framesPage.clearTextArea();
            framesPage.setTextArea(text2);
            framesPage.getTextFromEditor();
            Assertions.assertEquals(framesPage.getTextFromEditor(),text2,"Text from editor is incorrect");

        }

}
