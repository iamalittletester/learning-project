package stpcon17;

import org.openqa.selenium.WebElement;

public class Link {
    //what URL opens when link is clicked
    private String href;
    //what text the link displays
    private String label;
    //how does the URL open - same or new tab
    private String target;

    public Link(String href, String label, String target) {
        this.href = href;
        this.label = label;
        this.target = target;
    }

    public Link(WebElement element) {
        this.href = element.getAttribute("href");
        this.label = element.getText();
        this.target = element.getAttribute("target");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (href != null ? !href.equals(link.href) : link.href != null) return false;
        if (label != null ? !label.equals(link.label) : link.label != null) return false;
        return target != null ? target.equals(link.target) : link.target == null;
    }

    @Override
    public int hashCode() {
        int result = href != null ? href.hashCode() : 0;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        return result;
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
