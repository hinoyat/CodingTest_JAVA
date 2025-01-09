package binarysearch.gold;

import java.io.*;
import java.util.*;

public class G4_LIS4_14002 {
    static List<Integer> LIS = new ArrayList<>();
    static int[] subsequence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        subsequence = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            subsequence[i] = number;
        }

        LIS.add(subsequence[0]);


        for (int i = 1; i < N; i++) {
            // 수열
            int curNum = subsequence[i];
            // LIS 마지막 값 가져오기
            int index = LIS.size() - 1;
            int lastNum = LIS.get(index);

            if (curNum > lastNum) {
                LIS.add(curNum);
            } else {
                int changeNumIndex = binarySearching(0, index, curNum);
                LIS.set(changeNumIndex, curNum);
            }
            
            
        }

        System.out.println(LIS.size());
        for (int i = 0; i < LIS.size(); i++) {
            if (i < LIS.size() - 1) {
                System.out.print(LIS.get(i) + " ");
            } else {
                System.out.print(LIS.get(i));
            }
        }
    }

    static int binarySearching(int start, int end, int curNum) {
        System.out.println(LIS);
        while (start < end) {
            int mid = (start + end) / 2;

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
