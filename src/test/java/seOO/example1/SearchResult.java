package seOO.example1;

import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;

public class SearchResult {
    /**
     * the first property of the search result - the first text line of the result
     */
    public String site;
    /**
     * the second property of the search result - the second text line of the result
     */
    public String url;
    /**
     * the third property of the search result - the third text line of the result
     */
    public String summary;

    /**
     * auto-generated constructor, the one for the 'expected' content
     */
    public SearchResult(String site, String url, String summary) {
        this.site = site;
        this.url = url;
        this.summary = summary;
    }

    /**
     * constructor for the 'actual' content
     */
    public SearchResult(WebElement webElement) {
        this.site = webElement.findElement(cssSelector(".r")).getText();
        this.url = webElement.findElement(cssSelector("cite")).getText();
        this.summary = webElement.findElement(cssSelector(".s span")).getText();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SearchResult that = (SearchResult) o;

        if (!site.equals(that.site))
            return false;
        if (!url.equals(that.url))
            return false;
        return summary.equals(that.summary);
    }

    @Override
    public int hashCode() {
        int result = site.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + summary.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "site='" + site + '\'' +
                ", url='" + url + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
