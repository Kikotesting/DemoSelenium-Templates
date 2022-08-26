package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    private WebDriver driver;

    public AlertsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private By alertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By confirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By promptButton = By.xpath(".//button[text()='Click for JS Prompt']");
    @FindBy(xpath = "//*[@id=\"result\"]") public WebElement confirmTextResult;

    private By results = By.id("result");

    public void triggerAlert(){
        driver.findElement(alertButton).click();
    }
    public void triggerConfirm(){
        driver.findElement(confirmButton).click();
    }
    public void triggerPrompt(){
        driver.findElement(promptButton).click();
    }


    public void alert_clickDismiss(){
        driver.switchTo().alert().dismiss();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }
    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public String getResult(){
        return driver.findElement(results).getText();
    }



}
