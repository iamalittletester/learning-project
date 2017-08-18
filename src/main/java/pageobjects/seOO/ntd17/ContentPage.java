package pageobjects.seOO.ntd17;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.How.CSS;

public class ContentPage {
    //elements for the first article
    @FindBy(how = CSS, using = "#post-564 a") public WebElement image1Element;
    @FindBy(how = CSS, using = "#post-564 header a") public List<WebElement> tagList1Element;
    @FindBy(how = CSS, using = "#post-564 h1 a") public WebElement post1Element;

    @FindBy(how = CSS, using = "#post-264 a") public WebElement image2Element;
    @FindBy(how = CSS, using = "#post-264 header a") public List<WebElement> tagList2Element;
    @FindBy(how = CSS, using = "#post-264 h1 a") public WebElement post2Element;

    @FindBy(how = CSS, using = "#post-158 a") public WebElement image3Element;
    @FindBy(how = CSS, using = "#post-158 header a") public List<WebElement> tagList3Element;
    @FindBy(how = CSS, using = "#post-158 h1 a") public WebElement post3Element;
}
