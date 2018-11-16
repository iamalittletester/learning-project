package stpcon17;

import org.openqa.selenium.WebElement;

public class Link {
    //what URL opens when link is clicked
    private String href;
    //what text the link displays
    private String label;
    //how does the URL open - same or new tab
    private String target;

    public Link(WebElement element) {
        this.href = element.getAttribute("href");
        this.label = element.getText();
        this.target = element.getAttribute("target");
    }

    @Override
    public String toString() {
        return "Link{" +
                "href='" + href + '\'' +
                ", label='" + label + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
