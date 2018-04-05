package pageobjects.waiter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WaiterPage {

    @FindBy(how = How.CSS, using = "input") public WebElement bingSearchField;
}
