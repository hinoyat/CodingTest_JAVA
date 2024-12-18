package bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_MonkeyToHorse_1600 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] hx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] hy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] world = new int[H][W];

        for (int h = 0; h < H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < W; w++) {
                world[h][w] = Integer.parseInt(st.nextToken());
            }
        }

        int result = movingMonkey(k, W, H, world);

        System.out.println(result);
    }

    public static int movingMonkey(int k, int W, int H, int[][] world) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[k + 1][H][W];

        queue.offer(new int[] {0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int X = now[0];
            int Y = now[1];
            int horseMoving = now[2];
            int movingCount = now[3];

            if (X == H - 1 && Y == W - 1) {
                return movingCount;
            }

            for (int d = 0; d < dx.length; d++) {
                int nx = X + dx[d], ny =  Y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[horseMoving][nx][ny] && world[nx][ny] == 0) {
                    visited[horseMoving][nx][ny] = true;
                    queue.offer(new int[] {nx, ny, horseMoving, movingCount + 1});
                }
            }
            
            if (horseMoving + 1 <= k) {
                for (int d = 0; d < hx.length; d++) {
                    int nx = X + hx[d], ny =  Y + hy[d];

                    if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[horseMoving + 1][nx][ny] && world[nx][ny] == 0) {
                        visited[horseMoving + 1][nx][ny] = true;
                        queue.offer(new int[] {nx, ny, horseMoving + 1, movingCount + 1});
                    }
                }
            }

        }
    return -1;
    }
}
