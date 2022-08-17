package dynamicContent;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DynamicLoadingPage;
import pages.HomePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicLoadingTests extends baseConfig {
    HomePage homePage;
    DynamicLoadingPage dynamicLoadingPage;

    @Test
    @DisplayName("Dynamic loading element")
    void dynamicTest(){
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        homePage.dynamicLoadingPage.click();

        dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.clickExample1();
        dynamicLoadingPage.clickStartButton();

        WebElement finishWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assertTrue(dynamicLoadingPage.actualTextForFoundText(finishWord)
                        .contains("Hello World!"),
                "Is not the same message!");

    }

}
