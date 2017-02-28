package listsAndFindBy;

import browser.BrowserGetter;
import com.google.common.collect.ImmutableList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.seOO.listsAndFindBy.ListsAndFindByPage;

import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ListsAndFindByTest {
    //webDriver instance
    private WebDriver webDriver;
    //class used for initializing browser
    private BrowserGetter browserGetter = new BrowserGetter();
    //PageObject class for the dropdown
    private ListsAndFindByPage page;
    //the expected list of labels
    private List<String> expectedLabelsList = ImmutableList.of("Espresso", "Espresso with milk", "Latte",
            "Latte Caramel", "Capuccino");

    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        webDriver = browserGetter.getChromeDriver();
        //initiaze the PageObject class
        page = PageFactory.initElements(webDriver, ListsAndFindByPage.class);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void successfulTest() {
        //open the page on which the elements to test are displayed
        //this is a simple page with basic HTML stored in the code project under src/test/resources/htmls/forLists.html
        webDriver.get(new File("src/test/resources/htmls/forLists.html").getAbsolutePath());
        //compare the list of labels read from the open page with the expected list of labels
        assertEquals(page.getLabelsList(), expectedLabelsList);
    }
}
