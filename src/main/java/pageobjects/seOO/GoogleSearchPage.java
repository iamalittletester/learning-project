package pageobjects.seOO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CLASS_NAME;
import static org.openqa.selenium.support.How.ID;

public class GoogleSearchPage {
    @FindBy(how = ID, using = "lst-ib") public WebElement searchField;
    @FindBy(how = CLASS_NAME, using = "sbico") public WebElement searchIcon;
}
