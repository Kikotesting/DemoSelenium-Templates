package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.function.Function;

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
        driver.manage().deleteAllCookies();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterEach
    void afterEachTests(){
        driver.quit();
    }

    /**
     * Swipe,
     * @param startPercentage
     * @param endPercentage
     * @param anchorPercentage
     */
    /*public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        new TouchAction(driver)
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }
    public void swipeDownToUpFromWithinElement(MobileElement element) {
        TouchAction action = new TouchAction(driver);
        action.longPress(point(element.getCenter().getX(), element.getCenter().getY()))
                .moveTo(point(driver.manage().window().getSize().getWidth() / 2, 0))
                .release()
                .perform();
    }*/

    // Current screen contains text
/*    public boolean containsText(String text) {
        for (MobileElement el : driver.findElements(By.name("kiko"))) {
            if (el.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }*/
    // Wait until text disappear from scren, useful for loading dialogs
/*    public void waitUntilTextDisappear(final String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(new Function<WebDriver, Boolean>() {
            @Nullable
            public Boolean apply(@Nullable WebDriver webDriver) {
                return !containsText(text);
            }
        });
    }*/
/*    public void waitUntilTextDisappear(final String text, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(new Function<WebDriver, Boolean>() {
            @Nullable
            public Boolean apply(@Nullable WebDriver webDriver) {
                return !containsText(text);
            }
        });
    }*/

    // Wait until text in element is equal to text param
/*    public void waitUntilTextEquals(final String text, final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(new Function<WebDriver, Object>() {
            @Nullable
            public Object apply(@Nullable WebDriver webDriver) {
                return !element.getText().equals(text);
            }
        });
    }*/

    /**
     * Waits until element become clickable
     */
/*    public void waitForClickabilityOf(By locator, int timeOutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(locator))
        );
    }*/
/*    public void waitForClickabilityOf(By locator) {
        waitForClickabilityOf(locator, 90);
    }

    public void waitForClickabilityOf(WebElement element, int timeOutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element))
        );
    }
    public void waitForClickabilityOf(WebElement element) {
        waitForClickabilityOf(element, 90);
    }

    public void waitForInvisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForInvisibilityOf(String text, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='" + text + "']")));
    }

    public void waitForInvisibilityOf(By locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForInvisibilityOfText(String text, int timeOutInSeconds) {
        waitForInvisibilityOf(By.xpath("//*[@text='" + text + "']"), timeOutInSeconds);
    }

    public void waitForInvisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(CustomExpectedConditions.invisibilityOf(element));
    }

    public void waitForInvisibilityOf(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(1000));
        wait.until(CustomExpectedConditions.invisibilityOf(element));
    }

    public void waitForVisibilityOf(By locator, int timeOutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfElementLocated(locator))
        );
    }

    public void waitForVisibilityOf(By locator) {
        waitForVisibilityOf(locator, 90);
    }

    public void waitForVisibilityOf(WebElement element, int timeOutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(element))
        );
    }

    public void waitForVisibilityOf(WebElement element) {
        waitForVisibilityOf(element, 90);
    }
    public boolean isElementPresent(By by) {
        List<MobileElement> elements = driver.findElements(by);
        return !elements.isEmpty();
    }

    public static boolean isElementPresent(AppiumDriver aDriver, By by) {
        return !aDriver.findElements(by).isEmpty();
    }

    public static boolean isElementPresentInLayout(MobileElement layout, By by) {
        List<MobileElement> elements = layout.findElements(by);
        return !elements.isEmpty();
    }

    public static boolean isWebElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isChecked(WebElement element) {
        waitForVisibilityOf(element, 3);

        return Boolean.parseBoolean(element.getAttribute("checked"));
    }

    public boolean isEnabled(WebElement element) {
        waitForVisibilityOf(element, 3);

        return Boolean.parseBoolean(element.getAttribute("enabled"));
    }

    public boolean isSelected(WebElement element) {
        waitForVisibilityOf(element, 3);

        return Boolean.parseBoolean(element.getAttribute("selected"));
    }
    public String readFromToast() {
        return readFromToast(10);
    }

    public String readFromToast(int timeOutInSeconds) {
        WebDriverWait waitForToast = new WebDriverWait(driver, timeOutInSeconds);
        waitForToast.pollingEvery(Duration.ofMillis(100));

        return waitForToast.pollingEvery(Duration.ofMillis(100))
                .until(ExpectedConditions.presenceOfElementLocated(ANDROID_TOAST_BY))
                .getText();
    }

    public String readFromSnackBar() {
        return readFromSnackBar(10);
    }

    public String readFromSnackBar(int timeOutInSeconds) {
        WebDriverWait waitForSnackBar = new WebDriverWait(driver, timeOutInSeconds);
        waitForSnackBar.pollingEvery(Duration.ofMillis(100));

        return waitForSnackBar.pollingEvery(Duration.ofMillis(100))
                .until(ExpectedConditions.presenceOfElementLocated(SNACKBAR_TEXTVIEW_BY))
                .getText();
    }

    public boolean isElementWithTextPresent(String text) {
        try {
            driver.findElement(By.xpath("//*[@text='" + text + "']"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isElementContainingTextPresent(String text) {
        try {
            driver.findElement(By.xpath("//*[contains(@text,'" + text + "')]"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void longTapElement(WebElement element) {
        waitForVisibilityOf(element, 3);

        Point targetPoint = ElementUtils.getCenterOfElement(element);
        new TouchAction<>(driver)
                .longPress(PointOption.point(targetPoint))
                .release()
                .perform();
    }

    public void longTapElement(WebElement element, int durationInSeconds) {
        waitForVisibilityOf(element, 3);

        Point targetPoint = ElementUtils.getCenterOfElement(element);
        new TouchAction<>(driver)
                .longPress(PointOption.point(targetPoint))
                .waitAction(WaitOptions.waitOptions(ofSeconds(durationInSeconds)))
                .release()
                .perform();
    }

    public void tapOverElement(WebElement element) {
        Point elementsPoint = element.getLocation();
        TouchAction action = new TouchAction(driver);
        action.press(point(elementsPoint.x, elementsPoint.y))
                .release()
                .waitAction(waitOptions(Duration.ofSeconds(1)))
                .perform();
    }

    public void waitText(String textToBeDisplayed) {
        waitForVisibilityOf(By.xpath("//*[@text='" + textToBeDisplayed + "']"));
    }

    public void waitText(String textToBeDisplayed, int timeOutInSecond) {
        waitForVisibilityOf(By.xpath("//*[@text='" + textToBeDisplayed + "']"), timeOutInSecond);
    }

    public boolean isAndroidNavigationUpButtonPresent() {
        return !driver.findElements(By.xpath(ANDROID_NAVIGATION_UP_BUTTON)).isEmpty();
    }

    public boolean isElementEnabled(WebElement element) {
        return Boolean.parseBoolean(element.getAttribute("enabled"));
    }

    public boolean isElementChecked(WebElement element) {
        return Boolean.parseBoolean(element.getAttribute("checked"));
    }

    public void fillWithData(WebElement element, String data) {
        waitForClickabilityOf(element, 3);
        element.clear();
        waitForClickabilityOf(element, 3);
        element.sendKeys(data);
    }

    *//**
     * Click any element that has exact text
     * except input fields :)))
     * *//*
    public void clickOnElementWithText(String text) {
        click(By.xpath("//*[@text='" + text + "' " +
                "and not(contains(@class, 'EditText')) " +
                "and not(contains(@class, 'AutoCompleteTextView'))]"));
    }

    *//**
     * Click any element that contains text
     * except input fields :)))
     * *//*
    public void clickOnElementContainingText(String text) {
        click(By.xpath("//*[contains(@text, '" + text + "') " +
                "and not(contains(@class, 'EditText')) " +
                "and not(contains(@class, 'AutoCompleteTextView'))]"));
    }

    public void scrollVertically(ScrollingDirection scrollDirection) {
        TouchAction action = new TouchAction(driver);
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;

        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.30);

        switch (scrollDirection) {
            case UP:
                action.press(point(x, top_y))
                        .waitAction(waitOptions(ofMillis(1000)))
                        .moveTo(point(x, bottom_y)).release().perform();
                break;
            case DOWN:
                action.press(point(x, bottom_y))
                        .waitAction(waitOptions(ofMillis(1000)))
                        .moveTo(point(x, top_y)).release().perform();
                break;
        }
    }

    *//**
     * Tries to scroll to element with
     *
     * @param timesToScroll      attempts before stopping
     * @param element            target element
     * @param scrollingDirection UP - scroll to the bottom of the screen/ DOWN - to the top
     *//*
    public void scrollTo(WebElement element, ScrollingDirection scrollingDirection, int timesToScroll) {
        int i = 0;
        while (!isWebElementDisplayed(element) && i < timesToScroll) {
            scrollVertically(scrollingDirection);
            i++;
        }
    }

    *//**
     * Tries to scroll to element with
     *
     * @param timesToScroll      attempts before stopping
     * @param by                 target element locator
     * @param scrollingDirection UP - scroll to the bottom of the screen/ DOWN - to the top
     *//*
    public void scrollTo(By by, ScrollingDirection scrollingDirection, int timesToScroll) {
        int i = 0;
        while (!isElementPresent(by) && i < timesToScroll) {
            scrollVertically(scrollingDirection);
            i++;
        }
    }

    *//**
     * Tries to scroll to element with
     *
     * @param timesToScroll      attempts before stopping
     * @param text               target element with text
     * @param scrollingDirection UP - scroll to the bottom of the screen/ DOWN - to the top
     *//*
    public void scrollTo(String text, ScrollingDirection scrollingDirection, int timesToScroll) {
        scrollTo(By.xpath("//*[@text='" + text + "']"), scrollingDirection, timesToScroll);
    }

    public void click(WebElement element) {
        waitForClickabilityOf(element, 3);
        element.click();
    }

    public void click(By by) {
        waitForClickabilityOf(by, 3);
        driver.findElement(by).click();
    }

    public String readFrom(WebElement element) {
        waitForVisibilityOf(element, 3);

        return element.getText();
    }

    public List<String> readFrom(List<WebElement> elements) {
        return elements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void dragAndDrop(WebElement target, WebElement source) {
        Point targetPoint = ElementUtils.getCenterOfElement(target);
        Point sourcePoint = ElementUtils.getCenterOfElement(source);

        new TouchAction<>(driver).press(PointOption.point(targetPoint))
                .moveTo(PointOption.point(sourcePoint))
                .release()
                .perform();
    }

    public WebElement getProgressView() {
        return progressView;
    }

    public void slideElementFromLeftToRight(WebElement element) {
        Point sourcePoint = new Point(element.getLocation().getX(), element.getLocation().getY());
        Point targetPoint = new Point(element.getLocation().getX() + element.getSize().getWidth(), element.getLocation().getY());

        new TouchAction<>(driver).press(PointOption.point(sourcePoint))
                .moveTo(PointOption.point(targetPoint))
                .release()
                .perform();
    }

    public String getContentDesc(WebElement element) {
        return element.getAttribute("content-desc");
    }*/

/*    public class PriorityOnClassOrder implements IMethodInterceptor {

        *//**
         * Class used to sort test classes and methods.
         * Classes are sorted by the number of AppiumDriver fields declared in them.
         * The classes with most AppiumDriver fields are executed first.
         * Methods in those classes are sorted by priority.
         *
         * Exception are tests part of high_risk group. They are executed last.
         *//*

        private List<Class> testClassList;

        @Override
        public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
            List<IMethodInstance> result = new ArrayList<>();
            synchronized (this) {
                testClassList = getTestClassList(list);
                List<IMethodInstance> tempList = new ArrayList<>();
                for (Class clazz : testClassList) {
                    for (IMethodInstance instance : list) {
                        List<String> groups = Arrays.asList(instance.getMethod().getGroups());
                        if (instance.getMethod().getRealClass().getName().equals(clazz.getName())
                                && !groups.contains(HIGH_RISK)
                                && !groups.contains(SET_UP_TESTS)
                                && !groups.contains(STRESS_TESTS)
                                && !groups.contains(TEAR_DOWN_TESTS)) {
                            tempList.add(instance);
                        }
                    }
                    tempList.sort(Comparator.comparingInt(a -> a.getMethod().getPriority()));
                    result.addAll(tempList);
                    tempList.clear();
                }
                result.addAll(0, getSetupTestsList(list));
                result.addAll(getHighRiskTestsList(list));
                result.addAll(getStressTestsList(list));
                result.addAll(getTearDownTestsList(list));
            }
            return result;
        }

        private List<Class> getTestClassList(List<IMethodInstance> list) {
            List<Class> testClassList = new ArrayList<>();
            list.stream()
                    .filter(methodInstance -> !testClassList.contains(methodInstance.getMethod().getRealClass()))
                    .forEach(methodInstance -> testClassList.add(methodInstance.getMethod().getRealClass()));
            testClassList.sort(Comparator.comparing(a -> ((int) Arrays.stream(a.getDeclaredFields())
                    .filter(field -> field.getType().equals(AppiumDriver.class)).count()), Comparator.reverseOrder()));
            return testClassList;
        }

        private List<IMethodInstance> getHighRiskTestsList(List<IMethodInstance> list) {
            return getTestsInGroup(list, HIGH_RISK);
        }

        private List<IMethodInstance> getSetupTestsList(List<IMethodInstance> list) {
            return getTestsInGroup(list, SET_UP_TESTS);
        }

        private List<IMethodInstance> getTearDownTestsList(List<IMethodInstance> list) {
            return getTestsInGroup(list, TEAR_DOWN_TESTS);
        }

        private List<IMethodInstance> getStressTestsList(List<IMethodInstance> list) {
            return getTestsInGroup(list, STRESS_TESTS);
        }


        private List<IMethodInstance> getTestsInGroup(List<IMethodInstance> list, String testGroup) {
            List<IMethodInstance> testList = new ArrayList<>();
            List<IMethodInstance> tempTestList = new ArrayList<>();
            for (Class clazz : testClassList) {
                for (IMethodInstance instance : list) {
                    List<String> groups = Arrays.asList(instance.getMethod().getGroups());
                    if (instance.getMethod().getRealClass().getName().equals(clazz.getName()) && groups.contains(testGroup)) {
                        tempTestList.add(instance);
                    }
                }
                tempTestList.sort(Comparator.comparingInt(a -> a.getMethod().getPriority()));
                testList.addAll(tempTestList);
                tempTestList.clear();
            }
            return testList;
        }
    }*/

    public class TestGroups {
        public static final String SINGLE_DEVICE = "single_device";
        public static final String TWO_DEVICES = "two_devices";
        public static final String THREE_DEVICES = "three_devices";
        // four_devices group can only be used in combination with secure_os group due to the number of devices
        public static final String FOUR_DEVICES = "four_devices";
        public static final String FIVE_DEVICES = "five_devices";
        public static final String SIX_DEVICES = "six_devices";
        public static final String MOCK_TESTS = "mock_tests";
        public static final String TEAR_DOWN_TESTS = "tear_down_tests";
        public static final String SET_UP_TESTS = "set_up_tests";
        public static final String STRESS_TESTS = "stress_tests";
        public static final String SECURE_OS = "secure_os";
        public static final String SAMSUNG = "samsung";
        public static final String HIGH_RISK = "high_risk";
        public static final String EMULATORS = "emulators";
        public static final String NOT_IMPLEMENTED = "not_implemented";
    }


    /**
     * Selenium
     * guice
     * testing
     * reactivex
     * tess4j
     * retrofit
     * converter-gson
     * gson
     * logging-interceptor
     * rxjava
     * java-client
     * selenium-api
     * selenium-remote-driver
     * guava
     * mail.javax
     * josn
     * extentreports
     * rest-api client
     * jackson databind
     * jersey container servlet
     * jersey bean validation
     * cmmon lang3
     * system
     * pgplib
     * assertj-core
     * rest-assured
     */

}
