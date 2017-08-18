package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.System.setProperty;

public class BrowserGetter {

    public WebDriver getChromeDriver() {
        String osName = System.getProperty("os.name").toLowerCase();
        /**
         *          detect operating system
         *          if it is not one of the predefined ones, just throw exception
         *          only create a webDriver instance for a known operating system
         */

        if (!osName.contains("windows") && !osName.contains("linux") && !osName.contains("mac")) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
        if (osName.contains("windows")) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriver.exe");
        }
        if (osName.contains("linux")) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriver");
        }
        if (osName.contains("mac")) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriverMac");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
