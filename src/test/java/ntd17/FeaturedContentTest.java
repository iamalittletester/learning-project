package ntd17;

import browser.BrowserGetter;
import ntd17.objects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.seOO.ntd17.ContentPage;

import static org.testng.Assert.assertEquals;

public class FeaturedContentTest {
    //images
    private ClickableImage image1 = new ClickableImage(
            "https://iamalittletester.wordpress" +
                    ".com/2016/02/02/how-to-identify-the-test-scenarios-you-have-to-automate/",
            "346", "192",
            "https://iamalittletester.files.wordpress.com/2016/01/24680224896_5c3e7335c5_o.jpg?w=672&h=372&crop=1");
    private ClickableImage image2 = new ClickableImage(
            "https://iamalittletester.wordpress.com/2015/04/03/working-with-cookies-in-selenium/", "346", "192",
            "https://iamalittletester.files.wordpress.com/2015/04/dsc_0882.jpg?w=672&h=372&crop=1");
    private ClickableImage image3 = new ClickableImage(
            "https://iamalittletester.wordpress" +
                    ".com/2014/05/05/useful-generating-random-strings-with-randomstringutils/",
            "346", "192", "https://iamalittletester.files.wordpress.com/2014/05/13643775275_e4d2dd2da3_o" +
            ".jpg?w=672&h=372&crop=1");

    //the tags
    private Link tagAutomation = new Link("https://iamalittletester.wordpress.com/category/automation/", "AUTOMATION");
    private Link tagCode = new Link("https://iamalittletester.wordpress.com/category/code/", "CODE");
    private Link tagTesting = new Link("https://iamalittletester.wordpress.com/category/testing/", "TESTING");
    private Link tagSelenium = new Link("https://iamalittletester.wordpress.com/category/selenium/", "SELENIUM");
    private Link tagFlavours = new Link("https://iamalittletester.wordpress.com/category/flavours/", "FLAVOURS");

    //below part of the article - the link to the post
    private Link postLink1 = new Link("https://iamalittletester.wordpress" +
            ".com/2016/02/02/how-to-identify-the-test-scenarios-you-have-to-automate/",
            "HOW TO IDENTIFY THE TEST SCENARIOS YOU HAVE TO AUTOMATE");
    private Link postLink2 = new Link("https://iamalittletester.wordpress" +
            ".com/2015/04/03/working-with-cookies-in-selenium/",
            "WORKING WITH COOKIES IN SELENIUM");
    private Link postLink3 = new Link("https://iamalittletester.wordpress" +
            ".com/2014/05/05/useful-generating-random-strings-with-randomstringutils/",
            "USEFUL: GENERATING RANDOM STRINGS WITH RANDOMSTRINGUTILS");

    //tag sections
    private TagSection tagSection1 = new TagSection(tagAutomation, tagCode, tagTesting);
    private TagSection tagSection2 = new TagSection(tagAutomation, tagSelenium, tagTesting);
    private TagSection tagSection3 = new TagSection(tagAutomation, tagFlavours, tagTesting);

    //articles
    private Article article1 = new Article(image1, tagSection1, postLink1);
    private Article article2 = new Article(image2, tagSection2, postLink2);
    private Article article3 = new Article(image3, tagSection3, postLink3);

    //the featured content section
    private FeaturedContentSection featuredContentSection = new FeaturedContentSection(article1, article2, article3);

    //webDriver instance
    private WebDriver webDriver;
    //class used for initializing browser
    private BrowserGetter browserGetter = new BrowserGetter();
    //page object class
    private ContentPage page = new ContentPage();

    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        webDriver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(webDriver, ContentPage.class);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }


    @Test
    public void demoForElements() {
        webDriver.get("https://iamalittletester.wordpress.com/");
        System.out.println(new ClickableImage(page.image1Element));
        System.out.println(new TagSection(page.tagList1Element));
        System.out.println(new Link(page.post1Element));

        System.out.println(new Article(new ClickableImage(page.image1Element),
                new TagSection(page.tagList1Element), new Link(page.post1Element)));
        System.out.println(new Article(new ClickableImage(page.image2Element),
                new TagSection(page.tagList2Element), new Link(page.post2Element)));
        System.out.println(new Article(new ClickableImage(page.image3Element),
                new TagSection(page.tagList3Element), new Link(page.post3Element)));
    }

    @Test
    public void theTest() {
        webDriver.get("https://iamalittletester.wordpress.com/");
        assertEquals(new FeaturedContentSection(page.image1Element, page.tagList1Element, page.post1Element,
                page.image2Element, page.tagList2Element, page.post2Element,
                page.image3Element, page.tagList3Element, page.post3Element), featuredContentSection);
    }
}
