package procon_lib;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationTest {

    @ParameterizedTest
    @CsvSource({
            "-1, 0, 0",
            "0, -1, 0",
            "1, 2, 0",
            "0, 0, 1",
            "10, 10, 1",
            "10, 3, 120",
            "2147483647, 1, 2147483647",
            "100, 22, 180096962034591408",
    })
    public void test(int n, int k, long expected) {
        assertEquals(expected, Combination.combination(n, k));
    }
}
