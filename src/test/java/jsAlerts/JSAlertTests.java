package jsAlerts;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
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
    @Test
    @DisplayName("Accept/Dismiss JS Alert")
    public void validatesJSAlert() throws InterruptedException {
        homePage = new HomePage(driver);
        jsAlertPage = new JSAlertPage(driver);

        homePage.JSAlertsPage.click();

        //Escape
        jsAlertPage.jsAlertBtn.click();
        Thread.sleep(1000);
        jsAlertPage.escapeAlert();
        Thread.sleep(1000);

        //Accept
        jsAlertPage.jsAlertBtn.click();
        Thread.sleep(1000);
        jsAlertPage.acceptAlert();
        Thread.sleep(1000);
        Assertions.assertTrue(jsAlertPage.getAlertedText()
                .contains("You successfully clicked an alert"),
                "Alert message are canceled");
    }
}
