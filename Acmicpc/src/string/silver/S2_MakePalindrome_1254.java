package string.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_MakePalindrome_1254 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solve(s));
    }

    static int solve(String s) {
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (isPalindrome(s.substring(i))) {
                return len + i;
            }
        }

        return 2 * len - 1;
    }

    static boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
