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
    private By textBlocks = By.id("large-table");

    private int getNumberOfParagraphsPresent(){
        return driver.findElements(textBlocks).size();
    }
    public void scrollToParagraph(int index){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while(getNumberOfParagraphsPresent() < index){
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
    }

}
