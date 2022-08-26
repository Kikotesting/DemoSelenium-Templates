package dynamicContent;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.DynamicControlsPage;
import pages.HomePage;

import java.time.Duration;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class DynamicControlsTest extends baseConfig {

    HomePage homePage;
    DynamicControlsPage dynamicControlsPage;

    @Test
    @DisplayName("Dynamic disappear element")
    void dynamicTest(){
        //Fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        homePage = new HomePage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);

        homePage.dynamicControlsPage.click();
        dynamicControlsPage.clickCheckbox();
        dynamicControlsPage.isSelected(dynamicControlsPage.checkBox);
        dynamicControlsPage.clickRemoveButton();

        WebElement finalMessage = wait.until(new Function<WebDriver,WebElement>(){
            public WebElement apply(WebDriver driver){
                return
                        driver.findElement(By.xpath("//*[@id=\"message\"]"));
            }
        });
        Assertions.assertEquals(finalMessage.getText(), dynamicControlsPage.getActualMessage().trim());
        System.out.println("First test passed");

        dynamicControlsPage.clickRemoveButton();
        WebElement finalTwoMessage = wait.until(new Function<WebDriver,WebElement>(){
            public WebElement apply(WebDriver driver){
                return
                        driver.findElement(By.xpath("//*[@id=\"message\"]"));
            }
        });
        Assertions.assertEquals(finalTwoMessage.getText(), dynamicControlsPage.getActualMessage().trim());

        WebElement checkedBoxAfter = wait.until(new Function<WebDriver,WebElement>(){
            public WebElement apply(WebDriver driver){
                return
                        driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input"));
            }
        });
        checkedBoxAfter.isDisplayed();
        checkedBoxAfter.isSelected();
        System.out.println("Second test passed");


    }
}
