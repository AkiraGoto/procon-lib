package procon_lib;

import java.util.BitSet;

public class ModInverse {

    public static long modinv(long num, long mod) {

        long result = 1;
        long n = mod - 2;
        BitSet bs = BitSet.valueOf(new long[]{n});
        for (int i = 0; i < bs.size(); i++) {
            if (bs.get(i)) {
                result = result * num % mod;
            }
            num = num * num % mod;
        }
        return result;
    }
}
