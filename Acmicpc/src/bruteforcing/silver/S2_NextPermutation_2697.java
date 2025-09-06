package bruteforcing.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_NextPermutation_2697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            String s = br.readLine();
            System.out.println(solve(s));
        }
    }

    static String solve(String s) {
        char[] a = s.toCharArray();
        int n = a.length;

        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return "BIGGEST";

        int j = n - 1;
        while (a[j] <= a[i]) j--;
        char tmp = a[i]; a[i] = a[j]; a[j] = tmp;

        int l = i + 1, r = n - 1;
        while (l < r) {
            char t = a[l]; a[l] = a[r]; a[r] = t;
            l++; r--;
        }
        return new String(a);
    }

}
