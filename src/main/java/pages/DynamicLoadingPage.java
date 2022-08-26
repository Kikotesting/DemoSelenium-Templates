package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void clickStartButtonTwo(){
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
    }

    public void clickExample2(){
        example2.click();
    }
    public boolean isStartButtonTwoDisplayed(){
        return startButton.isDisplayed();
    }

    public String actualTextForFoundText(WebElement element){
        return element.getText();
    }




}
