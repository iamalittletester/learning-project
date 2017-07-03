package stpcon17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Module {
    private Image image;
    private String h2Text;
    private Link link;

    public Module(Image image, String h2Text, Link link) {
        this.image = image;
        this.h2Text = h2Text;
        this.link = link;
    }

    public Module(WebElement element) {
        this.image = new Image(element.findElement(By.cssSelector("img")));
        this.h2Text = element.findElement(By.cssSelector("h2")).getText();
        this.link = new Link(element.findElement(By.cssSelector("a")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module module = (Module) o;

        if (image != null ? !image.equals(module.image) : module.image != null) return false;
        if (h2Text != null ? !h2Text.equals(module.h2Text) : module.h2Text != null) return false;
        return link != null ? link.equals(module.link) : module.link == null;
    }

    @Override
    public int hashCode() {
        int result = image != null ? image.hashCode() : 0;
        result = 31 * result + (h2Text != null ? h2Text.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Module{" +
                "image=" + image +
                ", h2Text='" + h2Text + '\'' +
                ", link=" + link +
                '}';
    }
}
