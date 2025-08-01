package sort.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class G5_Ship_1092 {
    /*
    지민이는 항구에서 일한다. 그리고 화물을 배에 실어야 한다.
    모든 화물은 박스에 안에 넣어져 있다. 항구에는 크레인이 N대 있고, 1분에 박스를 하나씩 배에 실을 수 있다. 모든 크레인은 동시에 움직인다.

    각 크레인은 무게 제한이 있다. 이 무게 제한보다 무거운 박스는 크레인으로 움직일 수 없다.
    모든 박스를 배로 옮기는데 드는 시간의 최솟값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N이 주어진다. N은 50보다 작거나 같은 자연수이다.
    둘째 줄에는 각 크레인의 무게 제한이 주어진다. 이 값은 1,000,000보다 작거나 같다.
    셋째 줄에는 박스의 수 M이 주어진다. M은 10,000보다 작거나 같은 자연수이다.
    넷째 줄에는 각 박스의 무게가 주어진다. 이 값도 1,000,000보다 작거나 같은 자연수이다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] crane = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Integer[] boxes = new Integer[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(N, crane, M, boxes));

    }

    static int solve(int N, Integer[] crane, int M, Integer[] boxes) {
        int result = 0;

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());


        // 못 옮길 때
        if (crane[0] < boxes[0]) {
//            System.out.println("이거 못 옮겨요");
//            System.out.println(crane[0]);
//            System.out.println(boxes[0]);
            return -1;
        }

        for (int i = 0; i < M; i++) {
            if (boxes[i] > 0){
                result += moveBoxes(i, N, M, crane, boxes);
            }
        }

        return result;
    }

    static int moveBoxes(int startIdx, int maxMove, int maxIdx, Integer[] crane, Integer[] boxes) {

        // while vs for
        int idx = startIdx;
        int count = 0;

        while (idx < maxIdx) {

            if (crane[count] >= boxes[idx] && boxes[idx] > 0) {
                count ++;
                boxes[idx] = 0;
                if (count == maxMove) {break;}
            }
            idx++;

        }
        return 1;
    }


}
