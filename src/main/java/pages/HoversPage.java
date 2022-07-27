package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoversPage {

    private WebDriver driver;
    @FindBy(className = "figure") WebElement figureBox;
    @FindBy(className = "figcaption") WebElement boxCaption;
    public HoversPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    /**
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigure(int index){
        WebElement figure = driver.findElements((By) figureBox).get(index - 1);

        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement((By) boxCaption));
    }
    public void FigureCaption(WebElement caption){
        this.caption = caption;
    }

    public boolean isCaptionDisplayed(){
        return caption.isDisplayed();
    }

    public String getTitle(){
        return caption.findElement(header).getText();
    }

    public String getLink(){
        return caption.findElement(link).getAttribute("href");
    }

    public String getLinkText(){
        return caption.findElement(link).getText();
    }

}