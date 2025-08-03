package sort.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_Scale_2437 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] things = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            things[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(solveDP(things));
        System.out.println(solveGreedy(things));
    }

    static int solveGreedy(Integer[] things) {
        Arrays.sort(things);
        int target = 1;

        for (int w : things) {
            if (w > target) break;
            target += w;
        }

        return target;
    }

    static int solveDP(Integer[] things) {
        Arrays.sort(things);

        int sum = 0;
        for (int w : things) sum += w;

        boolean[] visited = new boolean[sum + 2];
        visited[0] = true;

        for (int w : things) {
            for (int i = sum; i >= 0; i--) {
                if (visited[i]) visited[i + w] = true;
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) return i;
        }

        return sum + 1;
    }
}
