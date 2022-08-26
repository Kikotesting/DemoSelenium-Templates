package contextmenu;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;
import pages.HomePage;

public class ContextMenuTests extends baseConfig {
    HomePage homePage;
    ContextMenuPage contextMenuPage;

    @Test
    void testRightClick(){
        homePage = new HomePage(driver);
        contextMenuPage = new ContextMenuPage(driver);

        homePage.contextMenuPage.click();
        contextMenuPage.rightClickInBox();

        String message = contextMenuPage.getPopUpText();
        contextMenuPage.acceptPopUp();
        Assertions.assertEquals(message, "You selected a context menu", "Popup message incorrect");
    }

}
