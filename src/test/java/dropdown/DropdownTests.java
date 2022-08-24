package dropdown;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;
import pages.HomePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(dropdownPage.actualSelectedValue()
                .contains("Option 1"),
                "Is not the selected Option!");
    }
    @Test
    @DisplayName("From university code")
    public void testAddMultipleAttributeToDropdown() {

        homePage = new HomePage(driver);
        dropdownPage = new DropdownPage(driver);

        homePage.dropdownPage.click();
        dropdownPage.clickSelectMenu();
        dropdownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectFromDropDown);

        var selectedOptions = dropdownPage.getSelectedOptions();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
    }

}
