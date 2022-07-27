package shifting;

import base.baseConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ShiftingPage;

public class ShiftContent extends baseConfig {

    HomePage homePage;
    ShiftingPage shiftingPage;

    @Test
    @DisplayName("Shifting text content in Menus")
    public void performShiftingContent() throws InterruptedException {

        homePage = new HomePage(driver);
        shiftingPage = new ShiftingPage(driver);

        homePage.shiftingPage.click();
        shiftingPage.shiftingPage_MenuElement.click();

        shiftingPage.hoverButton(shiftingPage.homeButton);
        Thread.sleep(1000);
        shiftingPage.hoverButton(shiftingPage.aboutButton);
        Thread.sleep(1000);
        shiftingPage.hoverButton(shiftingPage.contactUsButton);
        Thread.sleep(1000);
        driver.navigate().refresh();
        shiftingPage.scrollHorizontally(shiftingPage.portfolioButton);
        Thread.sleep(1000);
        shiftingPage.hoverButton(shiftingPage.portfolioButton);
        shiftingPage.hoverButton(shiftingPage.galleryButton);

    }

}
