package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeHeight_14510 {

    static int N;
    static int[] tress;
    static int target;
    static int sums;
    static int days;
    static void solution(int day, int sum) {
        if(sum ==0){
            days = day;
            sums = sum;
            return;
        }
        if(sum ==1){
            days = day +1;
            sums = sum;

            return;
        }
        if(sum ==2){
            days = day +2;
            sums = sum;
            return;
        }

        // 여기서부터 최소 남은 길이가  3 이상
        if(day % 2 ==0){
            solution(day+1, sum -2);
        } else {
            solution(day+1, sum -1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc =1; tc <= T; tc++){
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine());
            tress = new int[N];
            target = Integer.MIN_VALUE;
            days = 0;
            sums =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                tress[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(tress);
            target = tress[N-1];
            for(int i =0; i<N-1;i++){
                sums += target - tress[i];
            }

            solution(days, sums);

            sb.append(days).append("\n");

        }
        System.out.println(sb.toString().trim());
    }


}
