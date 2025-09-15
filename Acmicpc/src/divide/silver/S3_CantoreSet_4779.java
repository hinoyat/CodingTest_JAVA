package divide.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_CantoreSet_4779 {

    private static final char FILLED = '-';
    private static final char BLANK  = ' ';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int n = Integer.parseInt(line);
            System.out.println(solve(n));
        }
    }

    static String solve(int n) {
        int totalLength = pow3(n);
        char[] canvas = new char[totalLength];

        for (int i = 0; i < totalLength; i++) canvas[i] = FILLED;

        carve(0, totalLength, canvas);
        return new String(canvas);
    }

    static void carve(int start, int length, char[] canvas) {
        if (length == 1) return;
        int third = length / 3;

        for (int i = start + third; i < start + 2 * third; i++) {
            canvas[i] = BLANK;
        }

        carve(start, third, canvas);
        carve(start + 2 * third, third, canvas);
    }

    static int pow3(int n) {
        int v = 1;
        for (int i = 0; i < n; i++) v *= 3;
        return v;
    }
}
