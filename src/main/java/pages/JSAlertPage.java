package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSAlertPage {
    private WebDriver driver;
    public JSAlertPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[1]/button") public WebElement jsAlertBtn;
    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/button") public WebElement jsConfirmBtn;
    @FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[3]/button") public WebElement jsPromptBtn;


    private Actions actionElement(){
        return new Actions(driver);
    }
    public void hoverElement(WebElement element){
        actionElement().moveToElement(element).build().perform();
    }

}
