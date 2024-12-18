package geometry.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수학 개념 참고 https://darkpgmr.tistory.com/86

public class G5_AreaOfPolygon_2166 {
    static int[] xPoints;
    static int[] yPoints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        xPoints = new int[N];
        yPoints = new int[N];

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xPoints[n] = x;
            yPoints[n] = y;
        }

        // 면적 구하기
        double result = cal(xPoints, yPoints, N);
        System.out.printf("%.1f\n", result);
    }

    public static double cal(int[] xPoints, int[] yPoints, int N) {
        double sum = 0.0;
        // 모든 점들에 대해 계산
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;  // 다음 점의 인덱스 (마지막 점의 경우 첫 점과 연결)
            sum += (double)(xPoints[i]) * yPoints[j];
            sum -= (double)(xPoints[j]) * yPoints[i];
        }

        // 절대값을 취하고 2로 나눔
        double area = Math.abs(sum) / 2.0;
        return area;
    }



}