package pages;

import org.openqa.selenium.*;
import custom.Highlighter;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SliderPage {

    private WebDriver driver;
    @FindBy(css = ".sliderContainer input") public WebElement slider;

    public SliderPage (WebDriver driver){
        this.driver = driver;
    }

    public void moveSlider(){
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider,3,0).build();
        action.perform();
    }

}

