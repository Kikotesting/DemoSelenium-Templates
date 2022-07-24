package dropdown;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;
import pages.HomePage;

public class DropdownTests extends baseConfig {

    HomePage homePage;
    DropdownPage dropdownPage;

    @Test
    @DisplayName("Verify Select option")
    public void checkSelectedOption() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.dropdownPage.click();

        dropdownPage = new DropdownPage(driver);
        dropdownPage.clickSelectMenu();
        dropdownPage.selectOption();

        Assertions.assertTrue(dropdownPage.actualSelectedValue()
                .contains("Option 1"),
                "Is not the selected Option!");
    }

}
