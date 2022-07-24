package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Form Authentication") public WebElement formAuthenticationPage;
    @FindBy(linkText = "Dropdown") public WebElement dropdownMenu;

    public void clickMenu(WebElement menu){
        menu.click();
    }


}