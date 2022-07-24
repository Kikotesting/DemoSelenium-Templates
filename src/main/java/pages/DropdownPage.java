package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage {
    private WebDriver driver;
    @FindBy(id = "dropdown") WebElement dropdownMenu;
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
/*    public List<String>  getSelectedOption(){
        List<WebElement> selectedElements =
                findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }*/

}
