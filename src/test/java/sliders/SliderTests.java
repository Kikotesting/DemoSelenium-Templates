package sliders;

import base.baseConfig;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import pages.HomePage;
import pages.SliderPage;

public class SliderTests extends baseConfig {

    HomePage homePage;
    SliderPage sliderPage;

    @Test
    public void testSlideToWholeNumber() throws InterruptedException {
        homePage = new HomePage(driver);
        sliderPage  = new SliderPage(driver);

        homePage.sliderPage.click();
        sliderPage.moveSlider();


    }

}
