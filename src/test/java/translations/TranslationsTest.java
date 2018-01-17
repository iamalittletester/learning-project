package translations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class TranslationsTest {

    @Test(dataProvider = "languages")
    public void readTesting(String language) throws IOException {
        System.out.println("Translation for key 'testing' in language '" + language + "' is : " +
                getTranslation("testing", language));
    }

    @Test(dataProvider = "languages")
    public void readSuperheroes(String language) throws IOException {
        System.out.println("For language '" + language + "' - superhero firstname and lastname: " +
                getTranslation("superhero.firstname", language) + " " + getTranslation
                ("superhero.lastname", language));
    }
    // getTranslation(key, language)

    protected String getTranslation(String key, String language) throws IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("src/main/resources/languages/" + language + ".properties");
        prop.load(new InputStreamReader(input, Charset.forName("UTF-8")));
        input.close();
        return prop.getProperty(key);
    }

    @DataProvider(name = "languages")
    public Object[][] languages() {
        return new Object[][]{
                {"en"},
                {"de"},
                {"es"},
                {"no"}
        };
    }
}
