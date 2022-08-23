package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.NoSuchElementException;

public class InfinityScrollPage extends BasePage {
    public InfinityScrollPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class=\"jscroll-added\"][10]") WebElement kiko;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div") WebElement ends;
    public boolean isElementDisplayed(WebElement element) {

        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element has NOT displayed yet!");
        }
    }

    public void isElementFound() {
        while (isElementDisplayed(ends)){
            scrollEndPage();
            if (isElementDisplayed(kiko)){
                break;
            }
        }
/*        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(kiko));*/


    }
}
