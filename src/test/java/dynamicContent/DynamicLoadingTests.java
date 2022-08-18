package dynamicContent;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DynamicLoadingPage;
import pages.HomePage;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicLoadingTests extends baseConfig {
    HomePage homePage;
    DynamicLoadingPage dynamicLoadingPage;

    @Test
    @DisplayName("Dynamic loading element Explicit WAIT")
    void dynamicTest(){

        homePage = new HomePage(driver);
        dynamicLoadingPage = new DynamicLoadingPage(driver);

        homePage.dynamicLoadingPage.click();
        dynamicLoadingPage.clickExample1();
        dynamicLoadingPage.clickStartButton();

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.finishWord));

        // two different checks
        Assertions.assertEquals("Hello World!", dynamicLoadingPage.actualTextForFoundText(dynamicLoadingPage.finishWord));

    }
    @Test
    @DisplayName("Dynamic loading element Fluent WAIT")
    void dynamicTestTwo(){

        homePage = new HomePage(driver);
        dynamicLoadingPage = new DynamicLoadingPage(driver);

        homePage.dynamicLoadingPage.click();
        dynamicLoadingPage.clickExample1();
        dynamicLoadingPage.clickStartButton();

        // Fluent wait
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.finishWord));

        Assertions.assertTrue(dynamicLoadingPage.actualTextForFoundText(dynamicLoadingPage.finishWord)
                .contains("Hello World!"),
                "Is not the same message or element!");
    }
    @Test
    @DisplayName("Dynamic loading element example 2")
    void dynamicTestExample2(){

        homePage = new HomePage(driver);
        dynamicLoadingPage = new DynamicLoadingPage(driver);

        homePage.dynamicLoadingPage.click();
        dynamicLoadingPage.clickExample2();
        dynamicLoadingPage.isStartButtonTwoDisplayed();
        dynamicLoadingPage.clickStartButtonTwo();
        Assertions.assertEquals(dynamicLoadingPage.actualTextForFoundText(dynamicLoadingPage.finishWord), "Hello World!", "Loaded text incorrect");
    }

}
