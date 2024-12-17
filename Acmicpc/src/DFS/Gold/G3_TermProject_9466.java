package DFS.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_TermProject_9466 {
    static int[] students;
    public static void main(String[] args) throws IOException {
        /*
        * 학생들이(s1, s2, ..., sr)이라 할 때, r=1이고 s1이 s1을 선택하는 경우나, s1이 s2를 선택하고,
        *  s2가 s3를 선택하고,..., sr-1이 sr을 선택하고,
        * sr이 s1을 선택하는 경우에만 한 팀이 될 수 있다.
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            students = new int[N];

            for (int n = 0; n < N; n++) {
                int student = Integer.parseInt(st.nextToken());
                students[n] = student;
            }
        }
    }

    public static int termProject(int[] students, int N) {
        int number = 0;

        boolean[] visited = new boolean[N];



        return number;
    }
}
