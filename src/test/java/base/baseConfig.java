package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseConfig {
    public WebDriver driver;
    public JavascriptExecutor j = (JavascriptExecutor) driver;

    @BeforeAll
    static void beforeAllTests(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void beforeEachTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterEach
    void afterEachTests(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    // SCROLLING elements
    public void scrollToPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,arguments[0])",pixels);
    }
    public void scrollToWebElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void scrollEndPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}
