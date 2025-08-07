package slidingwindow.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_RotatingSushi_15961 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 접시
        int d = Integer.parseInt(st.nextToken());   // 초밥 종류
        int k = Integer.parseInt(st.nextToken());   // 연속 접시 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] belt = new int[N];  // 회전 초밥 벨트

        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(N, d, k, c, belt));
    }

    static int solve(int N, int d, int k, int c, int[] belt) throws IOException {

        int[] count = new int[d + 1]; // 초밥 번호가 1부터 d까지
        int kind = 0;
        int max = 0;

        // 초기
        for (int i = 0; i < k; i++) {
            int sushiType = belt[i];
            if (count[sushiType] == 0) {
                kind++;
            }
            count[sushiType]++;
        }

        max = (count[c] == 0) ? kind + 1 : kind;

        for (int i = 1; i < N; i++) {

            int remove = belt[(i - 1 + N) % N];
            count[remove]--;
            if (count[remove] == 0) {
                kind--;
            }

            int add = belt[(i + k - 1) % N];
            if (count[add] == 0) {
                kind++;
            }
            count[add]++;


            int temp;
            if (count[c] == 0) {
                temp = kind + 1;
            } else {
                temp = kind;
            }

            max = Math.max(max, temp);
        }

        return max;

    }

}
