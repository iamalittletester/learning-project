package pageobjects.stpcon17;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.How.CSS;

public class ModulesPage {
    //reading module elements
    @FindBy(how = CSS, using = "#readingModule") public WebElement readingModuleElement;
    @FindBy(how = CSS, using = "#readingModuleImage") public WebElement readingModuleImageElement;
    @FindBy(how = CSS, using = "#readingModuleLink") public WebElement readingModuleLinkElement;

    //travel module elements
    @FindBy(how = CSS, using = "#travelModule") public WebElement travelModuleElement;
    @FindBy(how = CSS, using = "#travelModuleImage") public WebElement travelModuleImageElement;
    @FindBy(how = CSS, using = "#travelModuleLink") public WebElement travelModuleLinkElement;

    //photo module elements
    @FindBy(how = CSS, using ="#photoModule") public WebElement photoModuleElement;
    @FindBy(how = CSS, using ="#photoModuleImage") public WebElement photoModuleImageElement;
    @FindBy(how = CSS, using ="#photoModuleLink") public WebElement photoModuleLinkElement;

}
