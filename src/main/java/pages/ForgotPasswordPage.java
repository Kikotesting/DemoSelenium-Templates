package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    private WebDriver driver;
    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email") WebElement emailField;
    @FindBy(id = "form_submit") WebElement retrievePasswordButton;

    public void setEmail(String email){
        emailField.sendKeys(email);
    }
    public void clickRetrievePasswordButton(){
        retrievePasswordButton.click();
    }

}
