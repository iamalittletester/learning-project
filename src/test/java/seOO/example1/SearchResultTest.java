package seOO.example1;

import browser.BrowserGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.seOO.GoogleSearchPage;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class SearchResultTest {
    //the expected result
    private final SearchResult expectedSearchResult = new SearchResult("expectedSite", "expectedUrl",
            "expectedSummary");
    //webDriver instance
    private WebDriver webDriver;
    //class used for initializing browser
    private BrowserGetter browserGetter = new BrowserGetter();
    //declare the page object class
    private GoogleSearchPage page = new GoogleSearchPage();

    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        webDriver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(webDriver, GoogleSearchPage.class);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void checkTheFirstSearchResult() throws InterruptedException {
        //open google search page
        webDriver.get("https://www.google.com");
        //search for a keyword
        page.searchField.sendKeys("testListener");
        page.searchIcon.click();
        //wait for the results to be displayed
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement element = wait.until(presenceOfElementLocated(className("g")));
        //the checking part - check that the actual content (new SearchResult(element)) equals
        //the expectedSearchResult
        assertEquals(new SearchResult(element), expectedSearchResult);
    }
}
