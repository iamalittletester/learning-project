package pageobjects.seOO.listsAndFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.How.CSS;

public class ListsAndFindByPage {
    //define the webElements that represent each option in the dropdown
    @FindBy(how = CSS, using = "option") private List<WebElement> webElements;

    public List<String> getLabelsList() {
        //create an empty list in which the label texts will be stored
        List<String> labelsList = new ArrayList<>();
        //iterate through all the webElements
        for (WebElement webElement : webElements) {
            //add each webElements label to the labelsList
            labelsList.add(webElement.getText());
        }
        //return all the label texts that are visible in the dropdown
        return labelsList;
    }
}
