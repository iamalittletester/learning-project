package waitertests;

import browser.BrowserGetter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import waiter.Waiter;

public class WaiterTest {
    private Waiter waiter = new Waiter();
    private WebDriver webDriver;
    private BrowserGetter browserGetter = new BrowserGetter();

    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        webDriver = browserGetter.getChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void getTest() {
        waiter.get("http://www.google.com", webDriver);
    }
}
