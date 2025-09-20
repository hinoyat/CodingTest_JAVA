package math.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_GCD_2436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        long[] ans = solve(g, l);
        System.out.println(ans[0] + " " + ans[1]);
    }

    static long[] solve(int g, int l) {
        int k = l / g;
        long a = 0, b = 0;
        for (int x = 1; x * (long) x <= k; x++) {
            if (k % x != 0) continue;
            int y = k / x;
            if (gcd(x, y) == 1) {
                a = (long) x * g;
                b = (long) y * g;
            }
        }
        return new long[]{a, b};
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
