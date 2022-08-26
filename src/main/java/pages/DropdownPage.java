package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    @FindBy(id = "dropdown") WebElement dropdownMenu;
    private By dropdown = By.id("dropdown");
    @FindBy(xpath = "//*[@id=\"dropdown\"]/option[2]") WebElement selectOptionValueOne;
    public DropdownPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Select findSelectMenu(){
        return new Select (dropdownMenu);
    }

    public void clickSelectMenu(){
        dropdownMenu.click();
    }
    public void selectOption(){
        String optionOne = "Option 1";
        findSelectMenu().selectByVisibleText(optionOne);
    }
    public String actualSelectedValue(){
        return selectOptionValueOne.getText();
    }


    // Code from university

    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void addMultipleAttribute(){
        String script = "arguments[0].setAttribute('multiple','')";
        ((JavascriptExecutor)driver).executeScript(script, findDropDownElement());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }

}
