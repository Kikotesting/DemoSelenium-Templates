package login;

import base.BaseSetup;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseSetup {

    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();

        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        secureAreaPage.getAlert();
    }
}
