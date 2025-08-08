package sort.silver;

import java.io.*;
import java.util.*;

public class S5_Stella_15905 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int solved = Integer.parseInt(st.nextToken());
            int penalty = Integer.parseInt(st.nextToken());

            if (solved > 0) {
                arr.add(new int[]{solved, penalty});
            }
        }

        System.out.println(solve(arr));
    }

    static int solve(List<int[]> arr) {

        arr.sort((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]);
        });

        if (arr.size() < 5) return 0;

        int fifthSolved = arr.get(4)[0];
        int count = 0;

        for (int i = 5; i < arr.size(); i++) {
            if (arr.get(i)[0] == fifthSolved) count++;
            else break;
        }

        return count;
    }
}
