package bruteforcing.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_RemoteControl_1107 {
    // 최대 채널
    static int maxChannel = 1000000;
    // 최소 누르는 횟수
    static int minPress;
    // 스위치 종류
    static int[] buttons = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    // 스위치 정상 여부
    static boolean[] brokenButtons = new boolean[10];
    // 스위치 시작
    static int startFloor = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 이돌하려는 채널
        int N = Integer.parseInt(br.readLine());
        // M 고장난 버튼의 개수
        int M = Integer.parseInt(br.readLine());

        // 고장난 버튼 체크
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int button = Integer.parseInt(st.nextToken());
                brokenButtons[button] = true;
            }
        }
        minPress = Math.abs(N - startFloor);

        for (int i = 0; i <= maxChannel; i++) {
            String channel = String.valueOf(i);
            boolean canPress = true;

            for (int j = 0; j < channel.length(); j++){
                if (brokenButtons[channel.charAt(j) - '0']) {
                canPress = false;
                break;

                }
            }
            if (canPress) {
                minPress = Math.min(minPress, channel.length() + Math.abs(i - N));
            }

        }
        System.out.println(minPress);


    }
}
