package dfs.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_MuscleLoss_18429 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(N, K, arr));
    }

    static int solve(int N, int K, int[] arr) {
        boolean[] visited = new boolean[N];
        return dfs(500, 0, N, K, arr, visited);
    }

    static int dfs(int w, int day, int N, int K, int[] arr, boolean[] visited) {
        if (day == N) return 1;

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            int next = w - K + arr[i];
            if (next >= 500) {
                visited[i] = true;
                result += dfs(next, day + 1, N, K, arr, visited);
                visited[i] = false;
            }
        }
        return result;
    }
}
