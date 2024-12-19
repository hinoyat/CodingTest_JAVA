package backtracking.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.StringWriter;
import java.io.BufferedWriter;

public class S3_NAndM3_15651 {
    static int N;
    static int M;

    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] array = new int[M]; // M 크기의 배열을 사용
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);

        // 백트래킹 시작
        backTracking(0, array, bw);

        bw.flush();
        System.out.print(sw.toString());
    }

    // backTracking에서 array 배열을 인자로 전달하고, 끝났을 때 바로 출력
    public static void backTracking(int level, int[] array, BufferedWriter bw) throws IOException {
        if (level == M) {
            // 순열이 완성되면 출력 (BufferedWriter를 사용하여 빠르게 출력)
            for (int i = 0; i < M; i++) {
                bw.write(array[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            array[level] = i; // 해당 level에 숫자 넣기
            backTracking(level + 1, array, bw); // 다음 단계로 재귀
        }
    }
}
