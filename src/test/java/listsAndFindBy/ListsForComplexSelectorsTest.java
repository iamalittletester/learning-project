package listsAndFindBy;

import browser.BrowserGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.seOO.listsAndFindBy.ComplexSelectorsPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;
import static org.apache.commons.io.FileUtils.writeLines;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class ListsForComplexSelectorsTest {
    //webDriver instance
    private WebDriver webDriver;
    //class used for initializing browser
    private BrowserGetter browserGetter = new BrowserGetter();
    //the page object class used in tests
    private ComplexSelectorsPage page;

    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        webDriver = browserGetter.getChromeDriver();
        //initialize the page object class
        page = PageFactory.initElements(webDriver, ComplexSelectorsPage.class);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void getSpecifiedElementOfList() throws IOException, InterruptedException {
        //open the page on which you are looking for the element
        generateHTMLToBeOpenedAndOpenItInBrowser();
        //iterate through the list of similar elements, out of which one is the one you are interested in
        //you are looking for the element whose getText() results in "My favourite element"
        //once the element is found, print on which position in the list it is found
        //and print what random class was attached to its' HTML representation
        for (int i = 0; i < page.listElements.size(); i++) {
            if (page.listElements.get(i).getText().equals("My favourite element")) {
                System.out.println("Found the required element, it is in the list at index: " + i);
                System.out.println("The class attribute of the element is : " + page.listElements.get(i).getAttribute
                        ("class"));
            }
        }

    }

    private void generateHTMLToBeOpenedAndOpenItInBrowser() throws IOException {
        //generate an html file that only contains a list of elements (li)
        //to each element a randomly generated class is assigned
        //the elements are in random order
        //each time this html is generated it is totally random
        //the only constant thing is that one of the elements of the list, when using getText(),
        //returns the text "My favourite element"
        List<String> listOfItems = new ArrayList<>();
        System.out.println("The HTML code that opened in the browser is:");
        for (int i = 0; i < 10; i++) {
            listOfItems.add("<li class=\"" + randomAlphabetic(6) + "\"> This is some random text " + randomAlphabetic
                    (6) + "</li>");
        }
        listOfItems.add("<li class=\"" + randomAlphabetic(6) + "\"> My favourite element </li>");
        shuffle(listOfItems);
        System.out.println("listOfItems = " + listOfItems);
        System.out.println("\n");
        writeLines(new File("src\\test\\resources\\NewFile.html"), listOfItems);
        webDriver.get(new File("src\\test\\resources\\NewFile.html").getAbsolutePath());
    }
}
