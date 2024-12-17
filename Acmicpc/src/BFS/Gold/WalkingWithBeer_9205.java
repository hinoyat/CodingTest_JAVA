package BFS.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WalkingWithBeer_9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        
        // 테스트 케이스마다 입력 시작
        for (int tc = 0; tc < testCase; tc++) {
            // 편의점 수
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            // 상근이 집 좌표
            st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());

            // 편의점 좌표
            int[][] stores = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                stores[i][0] = Integer.parseInt(st.nextToken());
                stores[i][1] = Integer.parseInt(st.nextToken());
            }
            // 추제 좌표
            st = new StringTokenizer(br.readLine());
            int festivalX = Integer.parseInt(st.nextToken());
            int festivalY = Integer.parseInt(st.nextToken());

            boolean result = bfs(n, homeX, homeY, stores, festivalX, festivalY);

            if (result) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }
    }
    // BFS 로직
    public static boolean bfs(int n, int homeX, int homeY, int[][] stores, int festivalX, int festivalY) {
        boolean[] visited = new boolean[n];

        Queue<int[]> queue = new LinkedList<>();

        int maxDistance = 1000;

        queue.offer(new int[] {homeX, homeY});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int X = now[0];
            int Y = now[1];

            if (Math.abs(X - festivalX) + Math.abs(Y - festivalY) <= maxDistance) {
                return true;
            } else {
                for (int i=0; i < n; i++) {
                    int nX = stores[i][0];
                    int nY = stores[i][1];
                    if (!visited[i] && Math.abs(X - nX) + Math.abs(Y - nY) <= maxDistance) {
                        visited[i] = true;
                        queue.offer(new int[] {nX, nY});
                    }
                }
            }
        }
        return false;
    }

}
