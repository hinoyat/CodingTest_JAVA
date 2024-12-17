package BFS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CityAndBTC_31575 {
    public static void main(String[] args) throws IOException {
       
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] array = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] start_point = {0, 0};

        int[] end_point = {M-1, N-1};

        boolean can_reached = false;
        can_reached = bfs(array, start_point, end_point);


        if (can_reached) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static boolean bfs(int[][] array, int[] start, int[] end){
        int M = array.length;
        int N = array[0].length;

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        boolean[][] visited = new boolean[M][N];

        Queue<int[]> queue = new LinkedList<>();

        // 시작 초기 세팅
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if (x == end[0] && y == end[1]) {
                return true;
            }

            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && array[nx][ny] == 1) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }
        return false;
    }
}
