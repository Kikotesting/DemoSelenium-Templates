package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollPage {
    private WebDriver driver;
    public ScrollPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username") private WebElement usernameField;
    @FindBy(id = "large-table") public WebElement table;


    // SCROLLING elements
    public void scrollToPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,arguments[0])",pixels);
    }
    public void scrollToWebElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void scrollEndPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }


}
