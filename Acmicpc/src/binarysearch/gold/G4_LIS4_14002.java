//package binarysearch.gold;
//
//import java.io.*;
//import java.util.*;
//
//public class G4_LIS4_14002 {
//    static List<Integer> LIS = new ArrayList<>();
//    static int[] subsequence;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        subsequence = new int[N];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            int number = Integer.parseInt(st.nextToken());
//            subsequence[i] = number;
//        }
//
//        LIS.add(subsequence[0]);
//
//
//        for (int i = 1; i < N; i++) {
//            // 수열
//            int curNum = subsequence[i];
//            // LIS 마지막 값 가져오기
//            int index = LIS.size() - 1;
//            int lastNum = LIS.get(index);
//
//            if (curNum > lastNum) {
//                LIS.add(curNum);
//            } else {
//                int changeNumIndex = binarySearching(0, index, curNum);
//                LIS.set(changeNumIndex, curNum);
//            }
//
//
//        }
//
//        System.out.println(LIS.size());
//        for (int i = 0; i < LIS.size(); i++) {
//            if (i < LIS.size() - 1) {
//                System.out.print(LIS.get(i) + " ");
//            } else {
//                System.out.print(LIS.get(i));
//            }
//        }
//    }
//
//    static int binarySearching(int start, int end, int curNum) {
//        System.out.println(LIS);
//        while (start < end) {
//            int mid = (start + end) / 2;
//
//            int target = LIS.get(mid);
//
//            if (target >= curNum) {
//                end = mid;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return end;
//
//    }
//}

package binarysearch.gold;

import java.io.*;
import java.util.*;

public class G4_LIS4_14002 {
    static List<Integer> LIS = new ArrayList<>();
    static int[] subsequence;
    static int[] indexTracker;  // 각 위치에서의 LIS 인덱스를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        subsequence = new int[N];
        indexTracker = new int[N];  // 추가된 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            subsequence[i] = Integer.parseInt(st.nextToken());
        }

        LIS.add(subsequence[0]);
        indexTracker[0] = 0;

        for (int i = 1; i < N; i++) {
            int curNum = subsequence[i];
            int index = LIS.size() - 1;
            int lastNum = LIS.get(index);

            if (curNum > lastNum) {
                LIS.add(curNum);
                indexTracker[i] = LIS.size() - 1;
            } else {
                int changeNumIndex = binarySearching(0, index, curNum);
                LIS.set(changeNumIndex, curNum);
                indexTracker[i] = changeNumIndex;
            }
        }

        // 실제 LIS 찾기
        int lisSize = LIS.size();
        ArrayList<Integer> realLIS = new ArrayList<>();
        int currentIndex = lisSize - 1;

        // 뒤에서부터 실제 LIS 원소들을 찾음
        for (int i = N - 1; i >= 0; i--) {
            if (indexTracker[i] == currentIndex) {
                realLIS.add(subsequence[i]);
                currentIndex--;
            }
        }

        // 결과 출력
        System.out.println(lisSize);
        for (int i = realLIS.size() - 1; i >= 0; i--) {
            System.out.print(realLIS.get(i));
            if (i > 0) System.out.print(" ");
        }
    }

    static int binarySearching(int start, int end, int curNum) {
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