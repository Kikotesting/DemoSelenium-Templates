package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

    private WebDriver driver;

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "file-upload") WebElement chooseFileButton;
    @FindBy(id = "file-submit") WebElement uploadButton;
    @FindBy(id = "uploaded-files") WebElement uploadedFiles;

    public void clickChooseFile(String absolutePathOfFile){
        chooseFileButton.sendKeys(absolutePathOfFile);
    }
    public void clickUploadButton(){
        uploadButton.click();
    }
    public String getUploadedFiles(){
        return uploadedFiles.getText();
    }


}
