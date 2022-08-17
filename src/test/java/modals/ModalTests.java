package modals;

import base.baseConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.ModalPage;

import java.time.Duration;
import java.util.function.Function;

public class ModalTests extends baseConfig{

    HomePage homePage;
    ModalPage modalPage;

    @Test
    void catchModals(){
        homePage = new HomePage(driver);
        modalPage = new ModalPage(driver);

        homePage.modalPage.click();

/*        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement footerCloseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//*[@id=\"modal\"]/div[2]/div[3]/p")));*/

        // Wait to let the modal box be visible
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("modal")));

        // to fetch the web element of the modal container
        WebElement modalContainer = driver.findElement(By.className("modal"));

        // code to fetch content of modal body and verify it
        WebElement modalContentTitle = modalContainer.findElement(By.className("modal-title"));
        WebElement modalContentBody = modalContainer.findElement(By.className("modal-body"));


        Assertions.assertEquals(modalContentTitle.getText(),
                "THIS IS A MODAL WINDOW", "Verify modal title message");
        Assertions.assertEquals(modalContentBody.getText(),
                "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).", "Verify modal body message");


        // code to click on accept modal button
        WebElement modalAcceptButton = modalContainer
                .findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p"));
        modalAcceptButton.click();


    }



}
