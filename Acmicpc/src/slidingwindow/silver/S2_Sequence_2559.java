package slidingwindow.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_Sequence_2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(array, K - 1));
    }

    static int solve(int[] array, int K) {

        int maxValue = Integer.MIN_VALUE;

        int tempValue = 0;

        for (int i = 0; i <= K; i++) {
            tempValue += array[i];
        }
        maxValue = Math.max(maxValue, tempValue);
//        System.out.println("초기값" + maxValue);

        for (int i = 1; i + K < array.length; i++) {

            tempValue -= array[i - 1];
            tempValue += array[i + K];

            maxValue = Math.max(maxValue, tempValue);

//            System.out.println("i번째" + i + "maxValue = " + maxValue);
        }


        return maxValue;
    }
}
