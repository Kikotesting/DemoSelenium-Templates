package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {

    private WebDriver driver;

    public FramesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "tinymce") WebElement textArea;
    @FindBy(id = "button[title='Increase indent']") WebElement decreaseIndentButton;


    private String editorIframeId = "mce_0_ifr";
    private void switchToEditArea(){
        // iframe id on html dom
        driver.switchTo().frame(editorIframeId);
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    public void clearTextArea(){
        switchToEditArea();
        textArea.clear();
        switchToMainArea();
    }
    public void setTextArea(String text){
        switchToEditArea();
        textArea.sendKeys(text);
        switchToMainArea();
    }
    public String getTextFromEditor(){
        switchToEditArea();
        String text = textArea.getText();
        switchToMainArea();
        return text;
    }





}
