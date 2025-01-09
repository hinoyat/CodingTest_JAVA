package binarysearch.gold;

import java.io.*;
import java.util.*;

public class G2_LIS3_12738 {
    static List<Integer> LIS = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] subsequence = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            subsequence[i] = number;
//            System.out.println(number);
        }
        
        // 초기값 세팅
        LIS.add(subsequence[0]);

        for (int i = 1; i < N; i++) {
            int curNum = subsequence[i];
            int index = LIS.size() - 1;
            int lastLISNum = LIS.get(index);

            // 비교
            if (curNum > lastLISNum) {
                LIS.add(curNum);
            } else {
                int targetIndex = binarySearch(0, index, curNum);
                LIS.set(targetIndex, curNum);
            }
        }
        System.out.println(LIS.size());

    }

    public static int binarySearch(int curStart, int curEnd, int curNum) {
        int start = curStart;
        int end = curEnd;

        while (start < end) {
            int mid = (start + end) / 2;

            // 비교할 값
            int target = LIS.get(mid);

            if (target >= curNum) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return end;

    }

}
