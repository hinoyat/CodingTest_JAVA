package dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_RGBDistance_17404 {
    static int rgb = 3;
    static int[][] rgbArray;
    static int[][] dpArray;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        rgbArray = new int[N][rgb];
        dpArray = new int[N][rgb];

        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < rgb; j ++) {
                int num = Integer.parseInt(st.nextToken());
                rgbArray[i][j] = num;
            }
        }
        
        
        // 1번집 채우기
        for (int i = 0; i < rgb; i++) {
            dpArray[0][i] = rgbArray[0][i];
        }

    }
}
