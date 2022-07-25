package jsAlerts;

import base.baseConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.JSAlertPage;

public class JSAlertTests extends baseConfig {

    HomePage homePage;
    JSAlertPage jsAlertPage;


    @Test
    @DisplayName("Hover all menus on the page")
    public void verifyJavaScriptAlerts() throws InterruptedException {
        homePage = new HomePage(driver);
        jsAlertPage = new JSAlertPage(driver);

        homePage.JSAlertsPage.click();
        jsAlertPage.hoverElement(jsAlertPage.jsAlertBtn);
        Thread.sleep(1000);
        jsAlertPage.hoverElement(jsAlertPage.jsConfirmBtn);
        Thread.sleep(1000);
        jsAlertPage.hoverElement(jsAlertPage.jsAlertBtn);
        Thread.sleep(1000);
        jsAlertPage.hoverElement(jsAlertPage.jsPromptBtn);
        Thread.sleep(1000);
    }
}
