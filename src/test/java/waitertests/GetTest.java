package waitertests;

import browser.BrowserGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.waiter.WaiterPage;
import waiter.Waiter;

public class GetTest {
    private Waiter waiter = new Waiter();
    private WaiterPage page;
    private WebDriver driver;
    private BrowserGetter browserGetter = new BrowserGetter();

    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(driver, WaiterPage.class);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    /**
     * A test that opens a page and waits for it to be fully loaded
     * Uses implicit timeout of 30 seconds which is set in the Waiter class
     */
    @Test
    public void getTest() {
        waiter.get("http://www.google.com", driver);
    }

    /**
     * A test that opens a page and waits for it to be fully loaded for 10 seconds
     */
    @Test
    public void getTestTimeout10Seconds() {
        waiter.get("http://www.google.com", driver, 10);
    }

    /**
     * A test that opens a page and waits for it to be fully loaded
     * Then it waits for a WebElement, declared in the WaiterPage class, to be displayed
     * Uses implicit timeout of 30 seconds which is set in the Waiter class
     */
    @Test
    public void getAndWaitForElementToBeDisplayedTest() {
        waiter.getAndWaitForElementToBeDisplayed("http://www.bing.com", page.bingSearchField, driver);
    }

    /**
     * A test that opens a page and waits for it to be fully loaded for 10 seconds
     * Then it waits for a WebElement, declared in the WaiterPage class, to be displayed, for 10 seconds
     */
    @Test
    public void getAndWaitForElementToBeDisplayedTestTimeout10Seconds() {
        waiter.getAndWaitForElementToBeDisplayed("http://www.bing.com", page.bingSearchField, driver, 10);
    }

    /**
     * A test that opens a URL in the browser, but waits for another URL to load.
     * This is useful when some redirects are being made and you are interested in landing on the second provided URL.
     * Also waits for the final URL's page to load completely, for the default timeout value of 30 seconds
     */
    @Test
    public void getUrlAndWaitForUrl() {
        waiter.getUrlAndWaitForUrl("http://imalittletester.com/", "https://imalittletester.com/", driver);
    }

    /**
     * A test that opens a URL in the browser, but waits for another URL to load.
     * This is useful when some redirects are being made and you are interested in landing on the second provided URL.
     * Also waits for the final URL's page to load completely, for the specified timeout of 5 seconds
     */
    @Test
    public void getUrlAndWaitForUrlTimeout5Seconds() {
        waiter.getUrlAndWaitForUrl("http://imalittletester.com/", "https://imalittletester.com/", driver, 5);
    }

    /**
     * This test illustrates how to use the waitForPageLoadComplete method on its own.
     * The test just opens a page, refreshes it, and waits for it to load completely after the refresh.
     * Uses the default timeout value from thewaiter library
     */
    @Test
    public void waitForPageLoadComplete() {
        waiter.get("http://www.google.com", driver);
        driver.navigate().refresh();
        waiter.waitForPageLoadComplete(driver);
    }

    /**
     * This test illustrates how to use the waitForPageLoadComplete method on its own.
     * The test just opens a page, refreshes it, and waits for it to load completely after the refresh.
     * Waits for 10 seconds for the page to load after the refresh
     */
    @Test
    public void waitForPageLoadCompleteTimeout10Seconds() {
        waiter.get("http://www.google.com", driver);
        driver.navigate().refresh();
        waiter.waitForPageLoadComplete(driver, 10);
    }
}
