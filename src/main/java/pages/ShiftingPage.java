package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShiftingPage {
    @FindBy(linkText = "Example 1: Menu Element") public WebElement shiftingPage_MenuElement;
    @FindBy(linkText = "Home")  public WebElement homeButton;
    @FindBy(linkText = "About")  public WebElement aboutButton;
    @FindBy(linkText = "Contact Us")  public WebElement contactUsButton;
    @FindBy(linkText = "Portfolio")  public WebElement portfolioButton;
    @FindBy(linkText = "Gallery")  public WebElement galleryButton;

    @FindBy(linkText = "Example 2: An image") public WebElement shiftingPage_MenuImage;
    @FindBy(linkText = "Example 3: List") public WebElement shiftingPage_ListDynamicContent;
    private WebDriver driver;
    public ShiftingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private Actions actionElement(){
        return new Actions(driver);
    }
    public void hoverButton(WebElement element){
        actionElement().moveToElement(element).build().perform();
    }

    public void scrollHorizontally(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
