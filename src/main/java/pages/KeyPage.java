package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KeyPage {
    private WebDriver driver;
    public KeyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "target") WebElement inputField;
    @FindBy(id = "result") WebElement resultText;

    public void enterText(String text){
        inputField.sendKeys(text);
    }
    public String getResult(){
        return resultText.getText();
    }
    public void enterPi(){
        enterText(Keys.chord(Keys.ALT,"p") + "=3.14");
    }


}
