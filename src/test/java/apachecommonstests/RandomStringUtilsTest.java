package apachecommonstests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class RandomStringUtilsTest {

    @Test
    public void randomNumeric() {
        System.out.println(RandomStringUtils.randomNumeric(6));
    }

    @Test
    public void randomAlphabetic() {
        System.out.println(RandomStringUtils.randomAlphabetic(6));
    }

    @Test
    public void randomAlphaNumeric() {
        System.out.println(RandomStringUtils.randomAlphanumeric(20));
    }

    @Test
    public void randomSpecificCharacters() {
        System.out.println(RandomStringUtils.randomAlphanumeric(5, 15));
    }

    @Test
    public void randomOfSpecifiedCharacters() {
        System.out.println(RandomStringUtils.random(10, 'a', 'b', 'c'));

    }
}
