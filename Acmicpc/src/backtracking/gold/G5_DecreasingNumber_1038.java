package backtracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class G5_DecreasingNumber_1038 {
    static int N;
    static ArrayList<Long> list = new ArrayList<>();  // 감소하는 수를 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(N);
        } else if (N > 1022) {  // 1022는 가능한 마지막 감소하는 수의 인덱스
            System.out.println(-1);
        } else {
            // 1자리수부터 10자리수까지 모든 감소하는 수 생성
            for (int i = 1; i <= 10; i++) {
                backtracking(0, 0, i);
            }

            // 정렬
            Collections.sort(list);

            // N번째 수 출력
            System.out.println(list.get(N-1));
        }
    }

    // digit: 현재 자릿수, number: 현재까지 만든 수, size: 목표 자릿수
    public static void backtracking(int digit, long number, int size) {
        if (digit == size) {
            list.add(number);
            return;
        }

        // 첫 번째 자리수라면 1~9까지 시작 가능
        // 그 외의 경우는 이전 숫자보다 작은 수만 가능
        for (int i = 0; i < 10; i++) {
            if (digit == 0 && i == 0) continue;  // 첫 자리는 0이 될 수 없음
            if (digit == 0 || (number % 10) > i) {
                backtracking(digit + 1, number * 10 + i, size);
            }
        }
    }
}