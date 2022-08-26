package sliders;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SliderPage;

public class SliderTests extends baseConfig {

    HomePage homePage;
    SliderPage sliderPage;

    @Test
    void testSlideToWholeNumber() throws InterruptedException {
        homePage = new HomePage(driver);
        sliderPage  = new SliderPage(driver);

        String value = "4";
        homePage.sliderPage.click();
        sliderPage.setSliderValue(value);
        Assertions.assertEquals(sliderPage.getSliderValue(),value,"Slider value is incorrect");
    }

}
