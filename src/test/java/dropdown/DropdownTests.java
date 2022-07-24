package dropdown;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DropdownPage;
import pages.HomePage;

public class DropdownTests extends baseConfig {

    HomePage homePage;
    DropdownPage dropdownPage;


    @Test
    @DisplayName("Verify Select option")
    public void checkSelectedOption() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickMenu(homePage.dropdownPage);

        dropdownPage = new DropdownPage(driver);
        dropdownPage.clickSelectMenu();
        dropdownPage.selectOption();

        Assertions.assertTrue(dropdownPage.actualSelectedValue()
                .contains("Option 1"),
                "Is not the selected Option!");
    }

}
