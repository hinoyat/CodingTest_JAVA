package BFS.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_Fire_5427 {
    static int[][] building;
    static int[][] tempbuilding;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int[] startPoint = {0, 0};

            building = new int[h][w];
            // 빈 공간 . -> 0
            // 벽 # -> 1
            // 상근이 @ -> 2
            // 불 * -> 3
            // 빌딩 정보 입력 숫자로 바꾸는 이유는 더 빠르대
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    char b = line.charAt(j);
                    if (b == '.') {
                        building[i][j] = 0;
                    } else if (b == '#') {
                        building[i][j] = 1;
                    } else if (b == '@') {
                        building[i][j] = 0; // 상근이 뛰는 방향 여러개라 지움
                        startPoint[0] = i;
                        startPoint[1] = j;
                    } else {
                        building[i][j] = 3;
                    }
                }
            }
            int result = burningBuilding(building, startPoint, w, h);
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }

    }

    public static int burningBuilding(int[][] building,int[] startPoint, int w, int h) {
        boolean[][] visited = new boolean[h][w];

        // 상근이 큐
        // 처음에 그냥 상근이를 지워야겠음 - 좌표로 관리
        Queue<int[]> queue = new LinkedList<>();

        // 불 큐
        Queue<int[]> fireQueue = new LinkedList<>();

        // 상근이 담기
        int sX = startPoint[0];
        int sY = startPoint[1];
        queue.offer(new int[]{sX, sY, 0});
        visited[sX][sY] = true;

        // 초기 불 담기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (building[i][j] == 3) {
                    fireQueue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            // 불 퍼지기
            Queue<int[]> nFireQueue = new LinkedList<>();
            while (!fireQueue.isEmpty()) {
                int[] fire = fireQueue.poll();
                int fireX = fire[0];
                int fireY = fire[1];
                for (int f = 0; f < dx.length; f++) {
                    int nFireX = fireX + dx[f];
                    int nFireY = fireY + dy[f];

                    if (nFireY >= 0 && nFireX >= 0 && nFireX < h && nFireY < w && building[nFireX][nFireY] != 1 && !visited[nFireX][nFireY]) {
                        visited[nFireX][nFireY] = true;
                        nFireQueue.offer(new int[]{nFireX, nFireY});
                    }
                }
            }

            // 상근이 움직이기
            int qSize = queue.size();
            for (int q = 0; q < qSize; q++) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int moved = now[2];
            for (int n = 0; n < dx.length; n++) {
                int nX = x + dx[n];
                int nY = y + dy[n];
                if (nX >= h || nY >= w || nX < 0 || nY < 0) {
                    return moved + 1;
                }
                if (nX >= 0 && nY >= 0 && nX < h && nY < w && building[nX][nY] == 0 && !visited[nX][nY]) {
                    queue.offer(new int[]{nX, nY, moved + 1});
                    visited[nX][nY] = true;
                }
            }
            }

        fireQueue = nFireQueue;
        }
        // 탈출 불가능 할 떄
        return -1;

    }
}
