package backtracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class G5_CuriousPrime_2023 {
    static int N;

    // 소수에는 0이 들어갈 수 없대요
    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    // 소수를 저장할 곳
    static StringBuilder sb = new StringBuilder();

    // 2번 저장소 리스트
    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        findCuriousPrime(0, "");

        // 정렬 후 출력
        Collections.sort(primeList);
        for (int prime : primeList) {
            System.out.println(prime);
        }

    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void findCuriousPrime(int level, String number) {
        if (level == N) {
            // 로ㅓ직 추가
            int num = Integer.parseInt(number);
            if (isPrime(num)) {
                primeList.add(num);
            }
            return;
        }

        for (int i:numbers) {
            String newNumber = number + i;
            int newNum = Integer.parseInt(newNumber);
            if (isPrime(newNum)) {
                findCuriousPrime(level + 1, newNumber);
            }
        }
    }
}
