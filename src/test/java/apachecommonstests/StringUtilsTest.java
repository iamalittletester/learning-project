package apachecommonstests;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

/**
 * A class that exemplifies some of the most useful methods from StringUtils
 * Honorable mentions apart from methods below: join, split, replace
 */
public class StringUtilsTest {

    @Test
    public void substringBeforeTest() {
        String url = "http://iamalittletester.wordpress.com/";
        //substringBefore
        System.out.println("\nDemonstrating StringUtils -> substringBefore");
        System.out.println(StringUtils.substringBefore(url, "/"));
        System.out.println(StringUtils.substringBefore(url, "//"));
    }

    @Test
    public void substringBeforeLastTest() {
        String url = "http://iamalittletester.wordpress.com/";
        System.out.println("\nDemonstrating StringUtils -> substringBeforeLast");
        //substringBeforeLast
        System.out.println(StringUtils.substringBeforeLast(url, "/"));
    }

    @Test
    public void substringAfterTest() {
        String url = "http://iamalittletester.wordpress.com/";
        System.out.println("\nDemonstrating StringUtils -> substringAfter");
        //substringAfter
        System.out.println(StringUtils.substringAfter(url, "."));
    }

    @Test
    public void substringAfterLastTest() {
        String url = "http://iamalittletester.wordpress.com/";
        System.out.println("\nDemonstrating StringUtils -> substringAfterLast");
        //substringAfterLast
        System.out.println(StringUtils.substringAfterLast(url, "."));
    }

    @Test
    public void substringBetweenTest() {
        String url = "http://iamalittletester.wordpress.com/";
        System.out.println("\nDemonstrating StringUtils -> substringBetween");
        //substringBetween
        System.out.println(StringUtils.substringBetween(url, "//", "/"));
        System.out.println(StringUtils.substringBetween(url, ".", "."));
        System.out.println(StringUtils.substringBetween(url, "/", "/"));
    }

    @Test
    public void compareIgnoreCaseTest() {
        System.out.println("\nDemonstrating StringUtils -> compareIgnoreCase");
        System.out.println(StringUtils.compareIgnoreCase("This little text", "this LITTLE text"));
    }

    @Test
    public void containsIgnoreCaseTest() {
        System.out.println("\nDemonstrating StringUtils -> containsIgnoreCase");
        System.out.println(StringUtils.containsIgnoreCase("Maybe this little text contains", "this LITTLE text"));
    }

    @Test
    public void swapCaseTest() {
        System.out.println("\nDemonstrating StringUtils -> swapCase");
        System.out.println(StringUtils.swapCase("Maybe this LITTLE text contains"));
    }
}
