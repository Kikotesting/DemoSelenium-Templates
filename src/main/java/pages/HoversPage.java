package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HoversPage {

    private WebDriver driver;
    public HoversPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigure(int index){
        WebElement figure = driver.findElements(By.className("figure")).get(index - 1);

        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(By.className("figcaption")));
    }
    public class FigureCaption {
        private WebElement caption;
        public FigureCaption(WebElement caption){
            this.caption = caption;
        }
        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }
        public String getTitle(){
            return caption.findElement(By.tagName("h5")).getText();
        }

        public String getLink(){
            return caption.findElement(By.tagName("a")).getAttribute("href");
        }
        public String getLinkText(){
            return caption.findElement(By.tagName("a")).getText();
        }
    }
}
