package waitertests;

import browser.BrowserGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.waiter.WaiterPage;
import waiter.Waiter;

public class ClickTest {
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
    public void clickTest() {
        waiter.get("https://imalittletester.com", driver);
        waiter.click(page.searchButton, driver);
        waiter.click(page.menuLink, driver);
    }

    @Test
    public void clickTestSpecifiedTimeout() {
        waiter.get("https://imalittletester.com", driver);
        waiter.click(page.searchButton, driver, 5);
        waiter.click(page.menuLink, driver, 20);
    }
}
