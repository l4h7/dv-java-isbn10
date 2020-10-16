import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

class MainClassTest {

    @Test
    void pruefeIsbnFunktion() {
        Assumptions.assumeTrue(MainClass.pruefeIsbn10(new int[]{3,9,0,0,0,0,0,0,0,10}));
        Assumptions.assumeTrue(MainClass.pruefeIsbn10(new int[]{3,6,5,8,2,1,8,0,6,1}));
        Assumptions.assumeFalse(MainClass.pruefeIsbn10(new int[]{3,9,0,0,0,0,0,0,0,9}));
    }


    @Test
    void isbn10Format() {
        Assumptions.assumeTrue(MainClass.isbn10Format("0123456789"));
        Assumptions.assumeTrue(MainClass.isbn10Format("012345678x"));
        Assumptions.assumeTrue(MainClass.isbn10Format("012345678X"));
        Assumptions.assumeFalse(MainClass.isbn10Format("012345678c"));
        Assumptions.assumeFalse(MainClass.isbn10Format("012345678C"));
        Assumptions.assumeFalse(MainClass.isbn10Format("0d23456789"));
        Assumptions.assumeFalse(MainClass.isbn10Format("012345678"));
        Assumptions.assumeFalse(MainClass.isbn10Format("1234567X"));
        Assumptions.assumeFalse(MainClass.isbn10Format("1234567x"));
        Assumptions.assumeFalse(MainClass.isbn10Format("01234567890"));
        Assumptions.assumeFalse(MainClass.isbn10Format("0123456789X"));
    }
}