package login;

import base.baseConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends baseConfig {

    HomePage homePage;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;


    @Test
    @DisplayName("Valid login")
    public void testSuccessfulLogin(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        secureAreaPage = new SecureAreaPage(driver);

        homePage.clickMenu(homePage.formAuthenticationPage);
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();
        secureAreaPage.actualTextForLoggedUser();
    }

}
