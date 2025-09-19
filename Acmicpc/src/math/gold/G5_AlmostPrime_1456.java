package math.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class G5_AlmostPrime_1456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        System.out.println(solve(min, max));
    }

    static long solve(long min, long max) {
        final int LIMIT = 10_000_000;
        boolean[] composite = new boolean[LIMIT + 1];
        for (int i = 2; i * (long)i <= LIMIT; i++) {
            if (!composite[i]) {
                for (int j = i + i; j <= LIMIT; j += i) composite[j] = true;
            }
        }

        long count = 0;
        for (int p = 2; p <= LIMIT; p++) {
            if (composite[p]) continue;

            if ((long)p > max / p) break;
            long val = (long)p * p;

            while (val <= max) {
                if (val >= min) count++;
                if (val > max / p) break;
                val *= p;
            }
        }
        return count;
    }
}
