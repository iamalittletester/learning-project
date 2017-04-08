package pageobjects.seOO.listsAndFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ComplexSelectorsPage {

    //a list of the webElements whose CSS identifier is a "li" element
    @FindBy(how = How.CSS, using = "li")
    public List<WebElement> listElements;
}
