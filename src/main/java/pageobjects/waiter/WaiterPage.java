package pageobjects.waiter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;

public class WaiterPage {
    //for the Bing site
    @FindBy(how = CSS, using = "input")
    public WebElement bingSearchField;

    //for the blog
    @FindBy(how = CSS, using = ".search-toggle")
    public WebElement searchButton;
    @FindBy(how = CSS, using = "#primary-menu li:nth-child(2) a")
    public WebElement menuLink;

}
