package sort.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_Sort_1083 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());

        solve(arr, N, S);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 풀이 함수 - 코드 가독성
    static void solve(int[] arr, int N, int S) {
        for (int i = 0; i < N - 1 && S > 0; i++) {
            int maxIdx = findMaxIdx(arr, i, S);

            if (i == maxIdx) {
                continue;
            }
            sort(arr, i, maxIdx);

            S -= (maxIdx - i);
        }
    }

    // 최대인 값의 인덱스 찾기
    static int findMaxIdx(int[] arr, int start, int S) {
        int maxIdx = start;

        for (int i = start + 1; i < arr.length && i - start <= S; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    // 최댓값 앞으로 나머지 뒤로
    static void sort(int[] arr, int start, int maxIdx) {
        int tempValue = arr[maxIdx];
        for (int i = maxIdx; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = tempValue;
    }
}
