package dp.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_SampleCorner_23029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(n, arr));
    }

    static long solve(int n, int[] arr) {
        long[][] dp = new long[n + 1][3];
        long result = 0;

        dp[1][0] = 0;
        dp[1][1] = arr[1];
        dp[1][2] = arr[1];
        result = Math.max(Math.max(dp[1][0], dp[1][1]), dp[1][2]);

        if (n >= 2) {
            dp[2][0] = arr[2];
            dp[2][1] = arr[1] + arr[2] / 2;
            dp[2][2] = arr[1];
            result = Math.max(result, Math.max(Math.max(dp[2][0], dp[2][1]), dp[2][2]));
        }

        for (int i = 3; i <= n; i++) {
            dp[i][0] = dp[i - 1][2] + arr[i];
            dp[i][1] = dp[i - 1][0] + arr[i] / 2;
            dp[i][2] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][0]);
            result = Math.max(result, Math.max(Math.max(dp[i][0], dp[i][1]), dp[i][2]));
        }

        return result;
    }
}
