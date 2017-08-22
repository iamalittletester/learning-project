package methods;

import org.testng.annotations.Test;

public class WithMethodsTest {

    @Test
    public void firstTest() {
        printMethod("This is the code from method 1");
    }

    @Test
    public void secondTest() {
        printMethod("This is the code from method 2");
    }

    @Test
    public void thirdTest() {
        printMethod("This is the code from method 3");
    }

    @Test
    public void fourthTest() {
        printMethod("This is the code from method 4");
    }

    @Test
    public void fifthTest() {
        printMethod("This is the code from method 5");
    }

    @Test
    public void sixthTest() {
        printMethod("This is the code from method 6");
    }

    @Test
    public void seventhTest() {
        printMethod("This is the code from method 7");
    }

    private void printMethod(String x6) {
        System.out.println("I want to show an example");
        System.out.println("Of how many test code lines");
        System.out.println("Can be improved");
        System.out.println("By using an approach");
        System.out.println("Based on methods");
        System.out.println(x6);
    }
}
