package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage {

    private WebDriver driver;
    @FindBy(id = "range") WebElement sliderValue;
    @FindBy(id = "slider") WebElement slider;

    public SliderPage (WebDriver driver){
        this.driver = driver;
    }
    Dimension sliderSize = slider.getSize();
    int sliderWidth = sliderSize.getWidth();
    int xCoord = slider.getLocation().getX();

    public void setSliderValue(int value){
        Actions builder = new Actions(driver);
        builder.moveToElement(slider).click().dragAndDropBy(slider,xCoord + sliderWidth,0).build().perform();
    }
    public String getSliderValue(){
        return sliderValue.getText();
    }

}

