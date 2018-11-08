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
    @FindBy(how = CSS, using = ".search-field") public WebElement searchField;

    //adding new elements to list elements
    @FindBy(how = CSS, using = "#addMe") public WebElement addMeField;
    @FindBy(how = CSS, using = ".w3-btn") public WebElement addMeButton;
    @FindBy(how = CSS, using = ".successMessage") public WebElement successMessage;
    @FindBy(how = CSS, using = ".addedItem") public WebElement addedElement;

    //checkbox element
    @FindBy(how = CSS, using = "#theCheckbox") public WebElement checkBoxElement;
    @FindBy(how = CSS, using = "#theText") public WebElement textElement;
}
