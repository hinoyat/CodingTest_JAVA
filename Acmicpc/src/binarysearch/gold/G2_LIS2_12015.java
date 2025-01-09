package binarysearch.gold;
import java.io.*;
import java.util.*;


public class G2_LIS2_12015 {
    static int[] subsequence;
    static List<Integer> LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 크기
        int N = Integer.parseInt(br.readLine());
//        System.out.println(N);
        // 수열, dp 초기화
        subsequence = new int[N];
        LIS = new ArrayList<>();

        // 수열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
//            System.out.println(number);
            subsequence[i] = number;
        }
        // 첫 번째 값 넣고 시작
        LIS.add(subsequence[0]);
//        System.out.println(LIS);
        /*
        sub 돌며 LIS 의 마지막 값보다 크면 추가
        작은 경우 적절한 공간을 찾아 갱신
        * */


        for (int i = 1; i < N; i++) {
            int curNumber = subsequence[i];

            // 클 때
            if (curNumber > LIS.get(LIS.size() - 1)) {
                LIS.add(curNumber);
            } else if (curNumber < LIS.get(LIS.size() - 1)) {
                int start = 0;
                int end = LIS.size() - 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    // 바꿀 값
                    int target = LIS.get(mid);
                    // target보다 curNumber 클 경우
                    // 작을 경우
                    // 같을 경우 - 이 경우에는 아무것도 안 하고 break
                    if (target >= curNumber) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                LIS.set(end, curNumber);
            }


        }
        System.out.println(LIS.size());
    }

}
