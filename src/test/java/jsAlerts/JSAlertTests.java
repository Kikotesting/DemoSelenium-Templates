package jsAlerts;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.JSAlertPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class JSAlertTests extends baseConfig {

    HomePage homePage;
    JSAlertPage jsAlertPage;


    @Test
    @DisplayName("Accept JS Alert")
    public void validatesJSAlert() throws InterruptedException {
        homePage = new HomePage(driver);
        jsAlertPage = new JSAlertPage(driver);

        homePage.JSAlertsPage.click();
        //Accept
        jsAlertPage.jsAlertBtn.click();
        Thread.sleep(1000);
        jsAlertPage.acceptAlert();
        Thread.sleep(1000);
        Assertions.assertTrue(jsAlertPage.getAlertedText(jsAlertPage.alertTextResult)
                .contains("You successfully clicked an alert"),
                "Alert message are canceled");
    }
    @Test
    @DisplayName("Cancel JS Alert")
    public void validatesJSConfirm() throws InterruptedException {
        homePage = new HomePage(driver);
        jsAlertPage = new JSAlertPage(driver);

        homePage.JSAlertsPage.click();
        //Cancel
        jsAlertPage.jsConfirmBtn.click();
        Thread.sleep(2000);
        jsAlertPage.dismissAlert();
        Thread.sleep(1000);
        Assertions.assertTrue(jsAlertPage.getAlertedText(jsAlertPage.confirmTextResult)
                        .contains("You clicked: Cancel"),
                "Another actions is marked!");
    }
    @Test
    @DisplayName("Escape JS Alert")
    public void escapeJSAlert() throws InterruptedException, AWTException {
        homePage = new HomePage(driver);
        jsAlertPage = new JSAlertPage(driver);

        homePage.JSAlertsPage.click();
        driver.switchTo().alert();
        jsAlertPage.AlertClick.click();
        jsAlertPage.newAction();



    }

    @Test
    @DisplayName("Send text on JS Alert")
    public void sendTextToJSAlert() throws InterruptedException {
        homePage = new HomePage(driver);
        jsAlertPage = new JSAlertPage(driver);

        homePage.JSAlertsPage.click();
        //Set text
        jsAlertPage.jsPromptBtn.click();
        Thread.sleep(2000);

        String setledMessage = "Kiko is here!";
        jsAlertPage.setText(setledMessage);
        Thread.sleep(2000);

        jsAlertPage.acceptAlert();
        Assertions.assertTrue(jsAlertPage.getValidatedMessage(jsAlertPage.promptTextResult)
                .contains("Kiko is here")
                ,"You entered: is prefix!");
    }
}
