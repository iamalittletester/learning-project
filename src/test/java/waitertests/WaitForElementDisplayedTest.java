package waitertests;

import browser.BrowserGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.waiter.WaiterPage;
import waiter.Waiter;

public class WaitForElementDisplayedTest {
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

    @Test
    public void withDefaultTimeout() {
        waiter.get("https://imalittletester.com", driver);
        waiter.click(page.searchButton, driver);
        waiter.waitForElementToBeDisplayed(page.searchField, driver);
    }

    @Test
    public void withSpecifiedTimeoutOf10() {
        waiter.get("https://imalittletester.com", driver);
        waiter.click(page.searchButton, driver);
        waiter.waitForElementToBeDisplayed(page.searchField, driver, 10);
    }
}
