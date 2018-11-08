package waitertests;

import browser.BrowserGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.waiter.WaiterPage;
import waiter.Waiter;

import java.io.File;

public class WaitForElementAttributeTest {

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

    @BeforeMethod
    public void beforeMethod() {
        waiter.get(new File("src/test/resources/htmls/waiter/checkbox.html").getAbsolutePath(), driver);

    }

    @Test
    public void waitForElementAttributeEqualsString() {
        checkTheCheckbox();
        waiter.waitForElementAttributeEqualsString(page.textElement,"style", "display: block; color: green;",
                driver);
        checkTheCheckbox();
        waiter.waitForElementAttributeEqualsString(page.textElement,"style", "display: block; color: red;",
                driver);
    }

    @Test
    public void waitForElementAttributeEqualsStringIgnoreCase() {
        checkTheCheckbox();
        waiter.waitForElementAttributeEqualsString_IgnoreCase(page.textElement,"style", "display: BLOCK; color: GREEN;",
                driver);
    }

    @Test
    public void waitForElementAttributeEqualsStringIgnoreWhitespaces() {
        checkTheCheckbox();
        waiter.waitForElementAttributeEqualsString_IgnoreWhitespaces(page.textElement,"style", "display:block;color:green;",
                driver);
    }

    @Test
    public void waitForElementAttributeContainsString() {
        checkTheCheckbox();
        waiter.waitForElementAttributeContainsString(page.textElement,"style", "color: green;",
                driver);
    }

    @Test
    public void waitForElementAttributeContainsStringIgnoreCase() {
        checkTheCheckbox();
        waiter.waitForElementAttributeContainsString_IgnoreCase(page.textElement,"style", "color: GREEN;",
                driver);
    }

    @Test
    public void waitForElementAttributeContainsStringIgnoreWhitespaces() {
        checkTheCheckbox();
        waiter.waitForElementAttributeContainsString_IgnoreWhitespaces(page.textElement,"style", "color:green;",
                driver);
    }

    @Test
    public void waitForElementAttributeEqualsStringTimeout10() {
        checkTheCheckbox();
        waiter.waitForElementAttributeEqualsString(page.textElement,"style", "display: block; color: green;",
                driver);
    }

    @Test
    public void waitForElementAttributeEqualsStringIgnoreCaseTimeout10() {
        checkTheCheckbox();
        waiter.waitForElementAttributeEqualsString_IgnoreCase(page.textElement,"style", "DISPLAY: block; color: green;",
                driver);
    }

    @Test
    public void waitForElementAttributeEqualsStringIgnoreWhitespacesTimeout10() {
        checkTheCheckbox();
        waiter.waitForElementAttributeEqualsString_IgnoreWhitespaces(page.textElement,"style", "display:             " +
                        "                          block; color: green;",
                driver);
    }

    @Test
    public void waitForElementAttributeContainsStringTimeout10() {
        checkTheCheckbox();
        waiter.waitForElementAttributeContainsString(page.textElement,"style", "color: green;",
                driver);
    }

    @Test
    public void waitForElementAttributeContainsStringIgnoreCaseTimeout10() {
        checkTheCheckbox();
        waiter.waitForElementAttributeContainsString_IgnoreCase(page.textElement,"style", "COLOR: green;",
                driver);
    }

    @Test
    public void waitForElementAttributeContainsStringIgnoreWhitespacesTimeout10() {
        checkTheCheckbox();
        waiter.waitForElementAttributeContainsString_IgnoreWhitespaces(page.textElement,"style", "color: green      ;",
                driver);
    }

    private void checkTheCheckbox() {
        page.checkBoxElement.click();
    }

}
