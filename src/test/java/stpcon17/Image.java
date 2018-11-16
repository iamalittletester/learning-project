package stpcon17;

import org.openqa.selenium.WebElement;

public class Image {
    //image source location
    private String src;
    //image width as seen on the page
    private String width;
    //image height as seen on the page
    private String height;

    public Image(WebElement element) {
        this.src = element.getAttribute("src");
        this.width = element.getAttribute("width");
        this.height = element.getAttribute("height");
    }

    @Override
    public String toString() {
        return "Image{" +
                "src='" + src + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
