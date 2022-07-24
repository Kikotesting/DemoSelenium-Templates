package forgotpassword;

import base.baseConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;

public class ForgotPasswordTests extends baseConfig {
    HomePage homePage;
    ForgotPasswordPage forgotPasswordPage;

    @Test
    @DisplayName("Forgot password for account!")
    public void testForgotPasswordLink() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.forgotPasswordPage.click();

        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.setEmail("test@mail.bg");
        forgotPasswordPage.clickRetrievePasswordButton();
    }
}
