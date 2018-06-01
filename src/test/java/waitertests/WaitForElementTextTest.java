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

public class WaitForElementTextTest {

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
        waiter.get(new File("src/test/resources/htmls/waiter/addElementWithText.html").getAbsolutePath(), driver);
    }

    @Test
    public void waitForElementTextEqualsString() {
        addNewItemWithLabel("espresso");
        waiter.waitForElementTextEqualsString(page.addedElement, "espresso", driver);
    }

    @Test
    public void waitForElementTextEqualsStringIgnoreCase() {
        addNewItemWithLabel("EsPreSSo");
        waiter.waitForElementTextEqualsString_IgnoreCase(page.addedElement, "espresso", driver);
    }

    @Test
    public void waitForElementTextEqualsStringIgnoreWhitespaces() {
        addNewItemWithLabel("es pre sso");
        waiter.waitForElementTextEqualsString_IgnoreWhitespaces(page.addedElement, "espresso", driver);
    }

    @Test
    public void waitForElementTextContainsString() {
        addNewItemWithLabel("espresso with milk");
        waiter.waitForElementTextContainsString(page.addedElement, "espresso", driver);
    }

    @Test
    public void waitForElementTextContainsStringIgnoreCase() {
        addNewItemWithLabel("EsPreSSo With Milk");
        waiter.waitForElementTextContainsString_IgnoreCase(page.addedElement, "espresso", driver);
    }

    @Test
    public void waitForElementTextContainsStringIgnoreWhitespaces() {
        addNewItemWithLabel("es pre sso wi th mi lk");
        waiter.waitForElementTextContainsString_IgnoreWhitespaces(page.addedElement, "espresso", driver);
    }

    @Test
    public void waitForElementTextEqualsStringTimeout10() {
        addNewItemWithLabel("espresso");
        waiter.waitForElementTextEqualsString(page.addedElement, "espresso", driver, 10);
    }

    @Test
    public void waitForElementTextEqualsStringIgnoreCaseTimeout10() {
        addNewItemWithLabel("EsPreSSo");
        waiter.waitForElementTextEqualsString_IgnoreCase(page.addedElement, "espresso", driver, 10);
    }

    @Test
    public void waitForElementTextEqualsStringIgnoreWhitespacesTimeout10() {
        addNewItemWithLabel("es pre sso");
        waiter.waitForElementTextEqualsString_IgnoreWhitespaces(page.addedElement, "espresso", driver, 10);
    }

    @Test
    public void waitForElementTextContainsStringTimeout10() {
        addNewItemWithLabel("espresso with milk");
        waiter.waitForElementTextContainsString(page.addedElement, "espresso", driver, 10);
    }

    @Test
    public void waitForElementTextContainsStringIgnoreCaseTimeout10() {
        addNewItemWithLabel("EsPreSSo With Milk");
        waiter.waitForElementTextContainsString_IgnoreCase(page.addedElement, "espresso", driver, 10);
    }

    @Test
    public void waitForElementTextContainsStringIgnoreWhitespacesTimeout10() {
        addNewItemWithLabel("es pre sso wi th mi lk");
        waiter.waitForElementTextContainsString_IgnoreWhitespaces(page.addedElement, "espresso", driver, 10);
    }

    private void addNewItemWithLabel(String itemLabel) {
        page.addMeField.sendKeys(itemLabel);
        page.addMeButton.click();
        waiter.waitForElementTextEqualsString_IgnoreWhitespaces(page.successMessage, "Success!", driver);
    }


}
