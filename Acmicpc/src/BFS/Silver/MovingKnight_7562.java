package BFS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MovingKnight_7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Test_Case = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < Test_Case; tc ++) {
            
            // 3개씩 입력 받기
            int N = Integer.parseInt(br.readLine());

            // 시작 좌표
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int[] start_point = {startX, startY};

            // 목표 좌표
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int[] end_point = {endX, endY};

            int result = bfs(N, start_point, end_point);
            System.out.println(result);
        }
    }

    public static int bfs(int N, int[] start_point, int[] end_point) {


        boolean[][] visited = new boolean[N][N];

        Queue<int[]> queue = new LinkedList<>();

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        queue.offer(new int[] {start_point[0], start_point[1], 0});
        visited[start_point[0]][start_point[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];

            if (x == end_point[0] && y == end_point[1]) {
                return count;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, count + 1});
                }
            }

        }
    return 0;
    }
}
