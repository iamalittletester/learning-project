package replaceall;

import org.testng.annotations.Test;

public class ReplaceAllTest {

    @Test
    public void replaceAllExamples() {
        String complexString = "3ifhuq023hjk@jka$ksoap";
        String withWhiteSpacesString = "This is a string\n " +
                "that streches on several lines.\n" +
                "to demo how to remove whitespaces and newlines\n " +
                "from a\n" +
                "string\n";
        String phraseString = "This is just a phrase String.";
        //removing all alphabetical characters from a string
        System.out.println(complexString.replaceAll("\\D", ""));
        //removing all numeric characters from a string
        System.out.println(complexString.replaceAll("\\d", ""));

        //output of what the string with newlines looks like on the console
        System.out.println("String with new line characters before replace: " + withWhiteSpacesString);
        //removing the new lines from the string
        System.out.println("String with new line characters before replacing new lines: " + withWhiteSpacesString
                .replaceAll("\n", ""));
        //removing all whitespace characters from string (including new line, space)
        System.out.println("String with new line characters before replacing all white space: " + withWhiteSpacesString
                .replaceAll("\\s", ""));

        System.out.println("String whose small a letters became capital letter: " + phraseString.replaceAll
                ("a", "A"));
        System.out.println("String whose small a letters became capital letter: " + complexString.replaceAll
                ("\\d", " "));
        System.out.println(complexString.replaceAll("jk", "_"));
    }
}
