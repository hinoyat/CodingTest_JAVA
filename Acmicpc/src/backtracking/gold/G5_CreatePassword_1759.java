package backtracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_CreatePassword_1759 {
    static String[] words;
    static String[] result;

    static String[] checkList = {"a", "e", "i", "o", "u"};

    static int L;
    static int C;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        words = new String[C];
        result = new String[L];

        for (int i = 0; i < C; i++) {
            String word = st.nextToken();
            words[i] = word;
        }
        Arrays.sort(words);
        backtracking(0, 0);

        System.out.println(sb);



    }

    public static void backtracking(int level, int idx) {
        if (level == L) {
            if (checkWord(result)){
            for (int i = 0; i < L; i ++) {
                sb.append(result[i]);
                if (i != L - 1) {
                    sb.append("");
                }
            }
            sb.append('\n');

            }

            return;
        }

        for (int i = idx; i < C; i++) {
            result[level] = words[i];
            backtracking(level + 1, i + 1);
        }

    }

    public static boolean checkWord(String[] result) {
        int vowelCount = 0;
        int consonantCount = 0;


        for (String r:result) {
            boolean isVowel = false;
            for (String vowel : checkList) {
                if (r.equals(vowel)) {
                    vowelCount++;
                    isVowel = true;
                    break;
                }
            }

            if (!isVowel) {
                consonantCount++;
            }
        }

        if (vowelCount >=1 && consonantCount>=2) {
            return true;
        } else {
            return false;
        }


    }

}
