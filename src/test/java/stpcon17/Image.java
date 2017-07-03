package stpcon17;

import org.openqa.selenium.WebElement;

public class Image {
    //image source location
    private String src;
    //image width as seen on the page
    private String width;
    //image height as seen on the page
    private String height;

    public Image(String src, String width, String height) {
        this.src = src;
        this.width = width;
        this.height = height;
    }

    public Image(WebElement element) {
        this.src = element.getAttribute("src");
        this.width = element.getAttribute("width");
        this.height = element.getAttribute("height");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (src != null ? !src.equals(image.src) : image.src != null) return false;
        if (width != null ? !width.equals(image.width) : image.width != null) return false;
        return height != null ? height.equals(image.height) : image.height == null;
    }

    @Override
    public int hashCode() {
        int result = src != null ? src.hashCode() : 0;
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
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
