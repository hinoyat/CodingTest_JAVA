package dp.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S3_Handshake_8394 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    static int solve(int n) {
        int zero = 1;
        int one = 0;

        for (int i = 1; i < n; i++) {
            int nextOne = zero % 10;
            int nextZero = (zero + one) % 10;
            zero = nextZero;
            one = nextOne;
        }
        return (zero + one) % 10;
    }
}
