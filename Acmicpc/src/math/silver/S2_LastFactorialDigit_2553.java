package math.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_LastFactorialDigit_2553 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    static int solve(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
            while (res % 10 == 0) res /= 10;
            res %= 100_000_000L;
        }
        return (int)(res % 10);
    }
}
