package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    private WebDriver driver;

    public DynamicControlsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"checkbox\"]/input") public WebElement checkBox;
    @FindBy(xpath = "//*[@id=\"checkbox-example\"]/button") WebElement removeButton;
    @FindBy(xpath = "//*[@id=\"message\"]") WebElement dynamicMessage;

    public void clickCheckbox(){
        checkBox.click();
    }
    public boolean isSelected(WebElement element){
        return element.isSelected();
    }
    public void clickRemoveButton(){
        removeButton.click();
    }
    public String getActualMessage(){
        return dynamicMessage.getText();
    }

}
