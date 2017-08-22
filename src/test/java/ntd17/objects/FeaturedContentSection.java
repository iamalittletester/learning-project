package ntd17.objects;

import org.openqa.selenium.WebElement;

import java.util.List;

public class FeaturedContentSection {
    private Article article1;
    private Article article2;
    private Article article3;

    public FeaturedContentSection(Article article1, Article article2, Article article3) {
        this.article1 = article1;
        this.article2 = article2;
        this.article3 = article3;
    }

    public FeaturedContentSection(WebElement imageElement1, List<WebElement> tagElementList1,
                                  WebElement postElement1,
                                  WebElement imageElement2, List<WebElement> tagElementList2,
                                  WebElement postElement2,
                                  WebElement imageElement3, List<WebElement> tagElementList3,
                                  WebElement postElement3) {
        this.article1 = new Article(imageElement1, tagElementList1, postElement1);
        this.article2 = new Article(imageElement2, tagElementList2, postElement2);
        this.article3 = new Article(imageElement3, tagElementList3, postElement3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeaturedContentSection that = (FeaturedContentSection) o;

        if (article1 != null ? !article1.equals(that.article1) : that.article1 != null) return false;
        if (article2 != null ? !article2.equals(that.article2) : that.article2 != null) return false;
        return article3 != null ? article3.equals(that.article3) : that.article3 == null;
    }

    @Override
    public int hashCode() {
        int result = article1 != null ? article1.hashCode() : 0;
        result = 31 * result + (article2 != null ? article2.hashCode() : 0);
        result = 31 * result + (article3 != null ? article3.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeaturedContentSection{" +
                "article1=" + article1 +
                ", article2=" + article2 +
                ", article3=" + article3 +
                '}';
    }
}
