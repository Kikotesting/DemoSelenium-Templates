/*
package dropdown;

import base.BaseSetup;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;
import pages.HomePage;

public class DropdownTests extends BaseSetup {

    @Test
    public void testSelectOption(){
        DropdownPage dropdownPage = new DropdownPage(driver);
        HomePage homePage1 = new HomePage(driver);
        homePage1.clickDropdown();

        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);

        var selectedOptions = dropdownPage.getSelectedOption();

        assertEquals(selectedOptions.size(),1,"Incorrect number of selections");
        assertTrue(selectedOptions.contains(option),"Option is not selected!");
    }
}
*/
