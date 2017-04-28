package ntd17.objects;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Article {
    //the element on the top part
    private ClickableImage clickableImage;
    //the middle section
    private TagSection tagSection;
    //the below part
    private Link postLink;

    public Article(ClickableImage clickableImage, TagSection tagSection, Link postLink) {
        this.clickableImage = clickableImage;
        this.tagSection = tagSection;
        this.postLink = postLink;
    }

    public Article(WebElement imageElement, List<WebElement> tagElementList, WebElement postElement) {
        this.clickableImage = new ClickableImage(imageElement);
        this.tagSection = new TagSection(tagElementList);
        this.postLink = new Link(postElement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (clickableImage != null ? !clickableImage.equals(article.clickableImage) : article.clickableImage != null)
            return false;
        if (tagSection != null ? !tagSection.equals(article.tagSection) : article.tagSection != null) return false;
        return postLink != null ? postLink.equals(article.postLink) : article.postLink == null;
    }

    @Override
    public int hashCode() {
        int result = clickableImage != null ? clickableImage.hashCode() : 0;
        result = 31 * result + (tagSection != null ? tagSection.hashCode() : 0);
        result = 31 * result + (postLink != null ? postLink.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "clickableImage=" + clickableImage +
                ", tagSection=" + tagSection +
                ", postLink=" + postLink +
                '}';
    }
}
