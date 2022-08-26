package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class JSAlertPage {
    private WebDriver driver;
    public JSAlertPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[1]/button") public WebElement jsAlertBtn;
    @FindBy(linkText = "Click for JS Alert") public WebElement AlertClick;

    @FindBy(id = "result") public WebElement alertTextResult;
    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/button") public WebElement jsConfirmBtn;
    @FindBy(xpath = "//*[@id=\"result\"]") public WebElement confirmTextResult;
    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[3]/button") public WebElement jsPromptBtn;
    @FindBy(xpath = "//*[@id=\"result\"]") public WebElement promptTextResult;


    private Actions actionElement(){
        return new Actions(driver);
    }
    public void hoverElement(WebElement element){
        actionElement().moveToElement(element).build().perform();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void newAction(){
        Actions actions = new Actions(driver);
       var kiko = driver.switchTo().alert();
       actions.sendKeys(Keys.ESCAPE);
       actions.build().perform();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getAlertedText(WebElement element){
        return element.getText();
    }
    public void setText(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public String getValidatedMessage(WebElement setMessage){
        return setMessage.getText();
    }

}
