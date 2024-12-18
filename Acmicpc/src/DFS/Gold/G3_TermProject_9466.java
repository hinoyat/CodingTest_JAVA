package DFS.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_TermProject_9466 {
    static int[] students;
    static boolean[] visited;    // 이번 탐색에서 방문한 노드
    static boolean[] finished;   // 탐색이 완전히 끝난 노드
    static int count;           // 팀을 이룬 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int N = Integer.parseInt(br.readLine());
            N += 1;  // 1번부터 시작하므로 크기 1 증가

            StringTokenizer st = new StringTokenizer(br.readLine());
            students = new int[N];
            visited = new boolean[N];
            finished = new boolean[N];
            count = 0;

            for (int n = 1; n < N; n++) {
                students[n] = Integer.parseInt(st.nextToken());
            }


            for (int i = 1; i < N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(N - 1 - count);
        }
    }

    public static void dfs(int now) {
        visited[now] = true;

        int next = students[now];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 이미 방문했지만 아직 탐색이 끝나지 않은 노드 = 사이클 발견
            // 사이클에 포함된 학생 수 세기
            for (int i = next; i != now; i = students[i]) {
                count++;
            }
            count++;  // 현재 노드도 포함
        }

        // 현재 노드 탐색 완료 처리
        finished[now] = true;
    }
}
