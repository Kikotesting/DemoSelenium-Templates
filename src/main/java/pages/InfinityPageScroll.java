package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfinityPageScroll {

    private WebDriver driver;
    public InfinityPageScroll(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By textBlocks = By.className("jscroll-added");



    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0,document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor) driver;

        while (getNumberOfParagraphsPresent() < index){
            jsExecutor.executeScript(script);
        }
    }
    private int getNumberOfParagraphsPresent(){
        return driver.findElements(textBlocks).size();
    }







}
