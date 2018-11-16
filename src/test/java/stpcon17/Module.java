package stpcon17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Module {
    private Image image;
    private String h2Text;
    private Link link;

    public Module(WebElement element) {
        this.image = new Image(element.findElement(By.cssSelector("img")));
        this.h2Text = element.findElement(By.cssSelector("h2")).getText();
        this.link = new Link(element.findElement(By.cssSelector("a")));
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
