package NavigationTests;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.DynamicLoadingPage;
import pages.HomePage;
import pages.MultipleWindowsPage;

public class NavigationTest extends baseConfig {

    HomePage homePage;
    DynamicLoadingPage dynamicLoadingPage;

    MultipleWindowsPage multipleWindowsPage;

    @Test
    public void testNavigator(){
        homePage = new HomePage(driver);
        homePage.dynamicLoadingPage.click();

        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.clickExample1();

        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");

    }

    @Test
    public void testSwitchedTabs(){
        homePage = new HomePage(driver);
        homePage.MultipleWindowsPage.click();

        multipleWindowsPage = new MultipleWindowsPage(driver);
        multipleWindowsPage.clickHere();
        getWindowManager().switchToTab("New Window");

        Assertions.assertTrue(driver.getTitle().contains("New Window"),"Wrong message !");

    }




}
