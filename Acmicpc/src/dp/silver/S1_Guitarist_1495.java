package dp.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_Guitarist_1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(n, s, m, v));
    }

    static int solve(int n, int s, int m, int[] v) {
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][s] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j]) {
                    int up = j + v[i];
                    int down = j - v[i];

                    if (up <= m) dp[i][up] = true;
                    if (down >= 0) dp[i][down] = true;
                }
            }
        }

        int result = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                result = i;
                break;
            }
        }
        return result;
    }
}
