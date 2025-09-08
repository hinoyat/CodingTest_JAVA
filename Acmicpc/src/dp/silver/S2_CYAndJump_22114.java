package dp.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 창영이와 점프
public class S2_CYAndJump_22114 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(n, k, arr));
    }

    static int solve(int n, int k, int[] arr) {
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] <= k) {
                dp[i + 1][0] = dp[i][0] + 1;
                dp[i + 1][1] = dp[i][1] + 1;
            } else {
                dp[i + 1][0] = 1;
                dp[i + 1][1] = dp[i][0] + 1;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i][0]);
            result = Math.max(result, dp[i][1]);
        }
        return result;
    }
}
