package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindowsPage {

    private WebDriver driver;

    public MultipleWindowsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Click Here") WebElement clickHereLink;

    public void clickHere(){
        clickHereLink.click();
    }


}
