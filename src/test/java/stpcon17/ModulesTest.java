package stpcon17;

import browser.BrowserGetter;
import org.approvaltests.Approvals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.stpcon17.ModulesPage;

import java.io.File;

public class ModulesTest {
    //webDriver instance
    private WebDriver webDriver;
    //class used for initializing browser
    private BrowserGetter browserGetter = new BrowserGetter();
    //page object class
    private ModulesPage page;

    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        webDriver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(webDriver, ModulesPage.class);
        webDriver.get(new File("src/test/resources/htmls/stpcon17/fullPage.html").getAbsolutePath());
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void images() {
        Approvals.verifyAll("",
                new Image[]{
                        new Image(page.readingModuleImageElement),
                        new Image(page.travelModuleImageElement),
                        new Image(page.photoModuleImageElement),
                }
        );
    }

    @Test
    public void links() {
        Approvals.verifyAll("",
                new Link[]{
                        new Link(page.readingModuleLinkElement),
                        new Link(page.travelModuleLinkElement),
                        new Link(page.photoModuleLinkElement),
                }
        );
    }

    @Test
    public void modules() {
        Approvals.verifyAll("",
                new Module[]{
                        new Module(page.readingModuleElement),
                        new Module(page.travelModuleElement),
                        new Module(page.photoModuleElement),
                }
        );
    }
}
