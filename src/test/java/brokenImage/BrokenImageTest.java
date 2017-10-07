package brokenImage;

import browser.BrowserGetter;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.apache.http.impl.client.HttpClients.createDefault;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BrokenImageTest {

    private WebDriver webDriver;
    //class used for initializing browser
    private BrowserGetter browserGetter = new BrowserGetter();
    //PageObject class for the dropdown

    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        webDriver = browserGetter.getChromeDriver();
        webDriver.get(new File("src/test/resources/htmls/brokenImage.html").getAbsolutePath());
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void correctlyDisplayedImage() throws IOException {
        String urlForCorrectImage = "https://c1.staticflickr.com/8/7494/27510788280_a9f43c3845_s.jpg";
        assertEquals(webDriver.findElement(By.cssSelector("#workingImage")).getAttribute("src"),
                urlForCorrectImage);
        checkImageDisplayedHttpClient(urlForCorrectImage);
    }

    @Test
    public void brokenImage() throws IOException {
        System.out.println(webDriver.findElement(By.cssSelector("#brokenImage")).getAttribute("src"));
        checkImageDisplayedHttpClient(webDriver.findElement(By.cssSelector("#brokenImage")).getAttribute("src"));
    }

    private void checkImageDisplayedHttpClient(String url) throws IOException {
        CloseableHttpClient httpclient = createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                System.out.println("Actual status code is: " + response.getStatusLine().getStatusCode());
                fail("The image is broken. The url for it is: " + url);
            }
        } finally {
            response.close();
        }
    }
}
