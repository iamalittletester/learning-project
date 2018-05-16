package waitertests;

import browser.BrowserGetter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.waiter.WaiterPage;
import waiter.Waiter;

public class UrlTest {
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
    public void waitForUrlEqualsOrContains() {
        waiter.get("https://imalittletester.com", driver);

        waiter.click(page.searchButton, driver);
        page.searchField.sendKeys("checkstyle");
        page.searchField.sendKeys(Keys.ENTER);
        waiter.waitForUrl("https://imalittletester.com/?s=checkstyle", driver);

        waiter.click(page.searchButton, driver);
        page.searchField.clear();
        page.searchField.sendKeys("waiter");
        page.searchField.sendKeys(Keys.ENTER);
        waiter.waitForUrlContains("waiter", driver);

        waiter.click(page.searchButton, driver);
        page.searchField.clear();
        page.searchField.sendKeys("CheckStyle");
        page.searchField.sendKeys(Keys.ENTER);
        //the actual URL that will open here is: https://imalittletester.com/?s=checkstyle
        waiter.waitForUrl_IgnoreCase("https://imalittletester.com/?s=checkstyle", driver);

        waiter.click(page.searchButton, driver);
        page.searchField.clear();
        page.searchField.sendKeys("WAITER");
        page.searchField.sendKeys(Keys.ENTER);
        //the actual url that will open is: https://imalittletester.com/?s=WAITER
        waiter.waitForUrlContains_IgnoreCase("waiter", driver);

    }

    @Test
    public void urlStartsWith() {
        waiter.get("http://imalittletester.com", driver);
        waiter.waitForUrlStartsWith("https", driver);
    }

    @Test
    public void waitForUrlEqualsOrContainsWithSpecifiedTimeout() {
        waiter.get("https://imalittletester.com", driver);

        waiter.click(page.searchButton, driver);
        page.searchField.sendKeys("checkstyle");
        page.searchField.sendKeys(Keys.ENTER);
        waiter.waitForUrl("https://imalittletester.com/?s=checkstyle", driver, 15);

        waiter.click(page.searchButton, driver);
        page.searchField.clear();
        page.searchField.sendKeys("waiter");
        page.searchField.sendKeys(Keys.ENTER);
        waiter.waitForUrlContains("waiter", driver, 15);

        waiter.click(page.searchButton, driver);
        page.searchField.clear();
        page.searchField.sendKeys("CheckStyle");
        page.searchField.sendKeys(Keys.ENTER);
        //the actual URL that will open here is: https://imalittletester.com/?s=checkstyle
        waiter.waitForUrl_IgnoreCase("https://imalittletester.com/?s=checkstyle", driver, 15);

        waiter.click(page.searchButton, driver);
        page.searchField.clear();
        page.searchField.sendKeys("WAITER");
        page.searchField.sendKeys(Keys.ENTER);
        //the actual url that will open is: https://imalittletester.com/?s=WAITER
        waiter.waitForUrlContains_IgnoreCase("waiter", driver, 15);

    }

    @Test
    public void urlStartsWithAndSpecifiedTimeout() {
        waiter.get("http://imalittletester.com", driver);
        waiter.waitForUrlStartsWith("https", driver, 5);
    }
}
