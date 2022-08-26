package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class SliderPage {

    private WebDriver driver;
    private By sliderValue = By.id("range");
    private By slider = By.cssSelector(".sliderContainer input");

    public SliderPage (WebDriver driver){
        this.driver = driver;
    }


    public void setSliderValue(String value){
        while(!getSliderValue().equals(value)){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public String getSliderValue(){
        return driver.findElement(sliderValue).getText();
    }
/*    public void moveSlider(){
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(fromElement)
                        .moveToElement(toElement)
                                .release(toElement)
                                        .build();
        dragAndDrop.perform();
    }*/

}

