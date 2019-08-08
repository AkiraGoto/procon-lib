package procon_lib;

public class Combination {

    public static long combination(int n, int k) {

        if (n < 0) return 0;
        if (k < 0 || n < k) return 0;
        if (k == 0) return 1;

        long result = 1;
        for (int i = 1; i <= k; i++) {
            result *= n--;
            result /= i;
        }
        return result;
    }

}
