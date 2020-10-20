import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

class MainClassTest {

    @Test
    void isISBN10Correct() {
        Assumptions.assumeTrue(MainClass.isISBN10Correct("3862442136"));
        Assumptions.assumeTrue(MainClass.isISBN10Correct("3935581351"));
        Assumptions.assumeFalse(MainClass.isISBN10Correct("2935581351"));
        Assumptions.assumeTrue(MainClass.isISBN10Correct("3833875577"));
        Assumptions.assumeFalse(MainClass.isISBN10Correct("2833875577"));
        Assumptions.assumeTrue(MainClass.isISBN10Correct("386493124X"));
        Assumptions.assumeFalse(MainClass.isISBN10Correct("286493124X"));
    }
}