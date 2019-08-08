package procon_lib;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModInverseTest {

    private static final long mod = 1000000007;

    @ParameterizedTest
    @CsvSource({
            "1000000008, 1",
            "500000004, 2",
            "333333336, 3",
            "250000002, 4",
            "400000003, 5",
    })
    public void test1(long n, long expected) {
        assertEquals(expected, ModInverse.modinv(n, mod));
    }
}
