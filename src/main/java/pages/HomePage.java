package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Form Authentication") public WebElement formAuthenticationPage;
    @FindBy(linkText = "Dropdown") public WebElement dropdownPage;
    @FindBy(linkText = "Forgot Password") public WebElement forgotPasswordPage;
    @FindBy(linkText = "Infinite Scroll") public WebElement infiniteScrollPage;
    @FindBy(linkText = "JavaScript Alerts") public WebElement JSAlertsPage;
    @FindBy(linkText = "Shifting Content") public WebElement shiftingPage;
    @FindBy(linkText = "Hovers") public WebElement hoversPage;
    @FindBy(linkText = "Key Presses") public WebElement keyPage;
    @FindBy(linkText = "Horizontal Slider") public WebElement sliderPage;

    @FindBy(linkText = "Dynamic Loading") public WebElement dynamicLoadingPage;
    @FindBy(linkText = "Dynamic Controls") public WebElement dynamicControlsPage;


}