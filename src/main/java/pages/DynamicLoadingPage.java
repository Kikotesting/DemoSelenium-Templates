package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {
    private WebDriver driver;

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Example 1: Element on page that is hidden") WebElement example1;
    @FindBy(id = "finish") public WebElement finishWord;
    @FindBy(xpath = "//*[@id=\"start\"]/button") WebElement startButton;
    @FindBy(linkText = "Example 2: Element rendered after the fact") WebElement example2;



    public void clickExample1(){
        example1.click();
    }
    public void clickStartButton(){
        startButton.click();
    }

    public void clickExample2(){
        example2.click();
    }

    public String actualTextForFoundText(WebElement element){
        return element.getText();
    }




}
