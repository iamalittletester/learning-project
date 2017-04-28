package ntd17.objects;

import org.openqa.selenium.WebElement;

import java.util.List;

public class TagSection {

    private Link tag1;

    private Link tag2;

    private Link tag3;

    public TagSection(Link tag1, Link tag2, Link tag3) {
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
    }

    public TagSection(List<WebElement> elementList) {
        this.tag1 = new Link(elementList.get(0));
        this.tag2 = new Link(elementList.get(1));
        this.tag3 = new Link(elementList.get(2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagSection that = (TagSection) o;

        if (tag1 != null ? !tag1.equals(that.tag1) : that.tag1 != null) return false;
        if (tag2 != null ? !tag2.equals(that.tag2) : that.tag2 != null) return false;
        return tag3 != null ? tag3.equals(that.tag3) : that.tag3 == null;
    }

    @Override
    public int hashCode() {
        int result = tag1 != null ? tag1.hashCode() : 0;
        result = 31 * result + (tag2 != null ? tag2.hashCode() : 0);
        result = 31 * result + (tag3 != null ? tag3.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TagSection{" +
                "tag1=" + tag1 +
                ", tag2=" + tag2 +
                ", tag3=" + tag3 +
                '}';
    }
}
