package datastructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S3_WarLandConquest_1270 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            long[] arr = new long[t];
            for (int j = 0; j < t; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }
            System.out.println(solve(t, arr));
        }
    }

    static String solve(int t, long[] arr) {
        HashMap<Long, Integer> map = new HashMap<>();
        int max = 0;
        long idx = 0;

        for (long num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > max) {
                max = map.get(num);
                idx = num;
            }
        }

        if (max > t / 2) {
            return String.valueOf(idx);
        }
        return "SYJKGW";
    }
}
