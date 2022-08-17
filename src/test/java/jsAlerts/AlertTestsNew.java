package jsAlerts;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AlertsPage;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertTestsNew extends baseConfig {
    HomePage homePage;
    AlertsPage alertsPage;

    @Test
    @DisplayName("Trigger and Accept Alert")
    public void acceptAlert() {
        homePage = new HomePage(driver);
        alertsPage = new AlertsPage(driver);

        homePage.alertsPage.click();

        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfuly clicked an alert", "Results text incorrect");
    }

    @Test
    @DisplayName("Get text from Alert")
    public void getTextFromAlert() {
        homePage = new HomePage(driver);
        alertsPage = new AlertsPage(driver);

        homePage.alertsPage.click();
        alertsPage.triggerConfirm();

        String text = alertsPage.alert_getText();
        alertsPage.alert_clickDismiss();

        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    @DisplayName("Send input text on Alert")
    public void testSetInputInAlert(){
        homePage = new HomePage(driver);
        alertsPage = new AlertsPage(driver);

        homePage.alertsPage.click();
        alertsPage.triggerPrompt();

        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();

        assertEquals(alertsPage.getResult(), "You entered: " + text, "Results text incorrect");
    }


}
