package sliders;

import base.baseConfig;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SliderPage;

public class SliderTests extends baseConfig {

    HomePage homePage;
    SliderPage sliderPage;

    @Test
    public void testSlideToWholeNumber(){
        homePage = new HomePage(driver);
        sliderPage  = new SliderPage(driver);
        homePage.sliderPage.click();
        sliderPage.setSliderValue(4);
        // Assertions.assertEquals(sliderPage.getSliderValue(),4,"Slider value is incorrect");
    }

}
