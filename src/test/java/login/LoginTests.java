package login;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends baseConfig {

    HomePage homePage;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;


    @Test
    @DisplayName("Login with valid credentials!")
    public void testSuccessfulLogin(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        secureAreaPage = new SecureAreaPage(driver);

        homePage.clickMenu(homePage.formAuthenticationPage);
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        assertTrue(secureAreaPage.actualTextForLoggedUser()
                .contains("You logged into a secure area!"),
                "Alert text is incorrect.");
    }

}
