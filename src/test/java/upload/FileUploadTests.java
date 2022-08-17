package upload;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FileUploadPage;
import pages.HomePage;

public class FileUploadTests extends baseConfig {

    HomePage homePage;
    FileUploadPage fileUploadPage;

    @Test
    @DisplayName("File uploads and validated")
    void fileUpload(){
        fileUploadPage = new FileUploadPage(driver);
        homePage = new HomePage(driver);

        homePage.fileUploadPage.click();
        fileUploadPage.clickChooseFile("/home/sg-qa/Documents/WebUItesting/DemoProjectSelenium/pom.xml");
        fileUploadPage.clickUploadButton();
        String uploadedFileText = fileUploadPage.getUploadedFiles();
        Assertions.assertTrue(uploadedFileText
                        .contains("pom.xml"),
                "Is not the same!");
    }
}
