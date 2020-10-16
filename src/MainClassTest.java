import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

class MainClassTest {

    @Test
    void pruefeIsbnFunktion() {
        Assumptions.assumeTrue(MainClass.pruefeIsbn10(new int[]{3,9,0,0,0,0,0,0,0,10}));
        Assumptions.assumeTrue(MainClass.pruefeIsbn10(new int[]{3,6,5,8,2,1,8,0,6,1}));
        Assumptions.assumeFalse(MainClass.pruefeIsbn10(new int[]{3,9,0,0,0,0,0,0,0,9}));
    }
}